import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConexionAPI {
    private static final String API_KEY = "f2d02aec8e9a95a5aa3bad9e";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double  convertorDivisas(String from, String to) throws Exception {//Se usa un String from paraa que la api busque de esa variable y un to para el tipo de cambio

            String urlStr = API_URL + from;//Se agrega el from(divisa base) al finalizar el URL como aparece en Postman
            URL url = new URL(urlStr);//Se Guarda como el nuevo URL que vamos a estar usando
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();//Abre el URl
            connection.setRequestMethod("GET");//Solicitamos Datos con el método GET

            BufferedReader lector = new BufferedReader(new InputStreamReader(connection.getInputStream()));//getInputStream recibe bytes de la conexion, InputStreamReader permite leer bytes como caracteres y el BufferedReadder los concadena
            StringBuilder respuesta = new StringBuilder();//Se guarda la respuesta de la API en un StringModificable
            String linea;

            while ((linea = lector.readLine()) != null) {//Mientras que la linea no este vacia esta se fuardara en respuesta
                respuesta.append(linea);
            }

            lector.close();

            Gson gson = new Gson();//Utiliza gson de google para poder leer la API y extraer lo que queremos que es la tasa de cambio guardada en "conversion-rates"
            JsonObject jsonResponse = gson.fromJson(respuesta.toString(), JsonObject.class);//Convertimos la respuesta JSON a un objeto Json
            return jsonResponse.getAsJsonObject("conversion_rates").get(to).getAsDouble();//Aqui le decimos donde buscar y convertimos a Double el tipo de cambio

        }
    }


