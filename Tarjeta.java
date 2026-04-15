// Tarjeta.java
// Clase abstracta que sirve como base para todos los tipos de tarjetas del sistema
// No se puede instanciar directamente, solo sirve para que otras clases hereden de ella
public abstract class Tarjeta {
       // Atributos privados (encapsulamiento - no accesibles directamente desde fuera)
    private String idTarjeta;   
    private double saldo;
    private String usuario;

    public Tarjeta(String idTarjeta, String usuario) {
        this.idTarjeta = idTarjeta;
        this.usuario = usuario;
        this.saldo = 0.0;
    }
    // ========== MÉTODOS ABSTRACTOS ==========
    // Estos métodos NO tienen implementación aquí
    // Las clases hijas están OBLIGADAS a implementarlos

    public abstract void recargar(double monto);
    public abstract boolean pagarViaje();

    // Métodos concretos (encapsulamiento)
    // Estos métodos ya están implementados y son heredados por las clases hijas
    public String getIdTarjeta() { return idTarjeta; }
    public double getSaldo() { return saldo; }
    protected void setSaldo(double saldo) { this.saldo = saldo; }
    public String getUsuario() { return usuario; }

    public void consultarSaldo() {
        System.out.println("Saldo de " + usuario + " (" + idTarjeta + "): $" + saldo);
    }
}