public class ConversionTasas {
    private final double cantidad;
    private final double tipoDeCambio;

    public ConversionTasas(double cantidad, double tipoDeCambio) {
        this.cantidad = cantidad;
        this.tipoDeCambio = tipoDeCambio;
    }

    public double cambio() {
        return cantidad * tipoDeCambio;
    }
}





