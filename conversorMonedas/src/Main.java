
import java.util.Scanner;

public class Main {
    private static final Scanner lectura = new Scanner(System.in);
    private static final ConexionAPI conectarAPI = new ConexionAPI();
    private static final Scanner base = new Scanner(System.in);
    private static final Scanner moneda = new Scanner(System.in);


    public static void main(String[] args) {

        while (true) {

            menu();

            int opcion = lectura.nextInt();
            if (opcion == 10) {
                System.out.println("Saliendo....");
                break;
            }
            if (opcion < 1 || opcion > 10) {
                System.out.println("Opción no válida. Por favor, elija una opción del 1 al 10.");
                continue;
            }

            System.out.print("Ingrese la cantidad que desea convertir: ");
            double cantidad = lectura.nextDouble();

            switch (opcion) {
                case 1:
                    convertorDivisas("USD", "EUR", cantidad);
                    break;
                case 2:
                    convertorDivisas("USD", "JPY", cantidad);
                    break;
                case 3:
                    convertorDivisas("USD", "GBP", cantidad);
                    break;
                case 4:
                    convertorDivisas("USD", "CHF", cantidad);
                    break;
                case 5:
                    convertorDivisas("USD", "MXN", cantidad);
                    break;
                case 6:
                    convertorDivisas("USD", "BRL", cantidad);
                    break;
                case 7:
                    convertorDivisas("USD", "CNY", cantidad);
                    break;
                case 8:
                    convertorDivisas("USD", "AED", cantidad);
                    break;
                case 9:
                    System.out.println("Ingrese la abreviacion de la divisa base  (En mayusculas como: USD) ");
                    String divisaBase = base.nextLine();
                    System.out.println("Ingrese la abreviacion de la divisa a convertir (En mayusculas como: USD ");
                    String divisaConvertir = moneda.nextLine();
                    convertorDivisas(divisaBase, divisaConvertir,cantidad);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 10 o 'salir'.");
            }


        }
        lectura.close();
    }

    private static void menu() {
        System.out.print("Elija una opción de conversión (1-9): ");
        System.out.println("\n1. De Dolar Americano a Euro ");//EUR
        System.out.println("2. De Dolar Americano a Yen Japonés ");//JPY
        System.out.println("3. De Dolar Americano a Libra Esterlina ");//GBP
        System.out.println("4. De Dolar Americano a Franco Suizo");//CHF
        System.out.println("5. De Dolar Americano a Peso Mexicano");//MXN
        System.out.println("6. De Dolar Americano a Real Brasileño");//BRL
        System.out.println("7. De Dolar Americano a Yuan Chino");//CNY
        System.out.println("8. De Dolar Americano a Dírhams");//AED
        System.out.println("9. Escribe tus Divisas");//Deja que el usuario eliga la divisa que el quiera
        System.out.println("10. Salir");

    }

    private static void convertorDivisas(String from, String to, double cantidad) {
        try {
            double tipoDeCambio = conectarAPI.convertorDivisas(from, to);
            ConversionTasas conversion = new ConversionTasas(cantidad, tipoDeCambio);
            double tasaConvertida = conversion.cambio();
            System.out.printf("%.2f %s son %.2f %s%n", cantidad, from, tasaConvertida, to);//"%.2f %s son %.2f %s%n" sirve para mostrar solo dos decimaless

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}




