// Tarjeta.java
// Clase abstracta que sirve como base para todos los tipos de tarjetas del sistema.
// No se puede instanciar directamente; las subclases deben implementar sus métodos abstractos.

public abstract class Tarjeta {
    // Atributos privados (encapsulamiento)
    private String idTarjeta;   // Identificador único de la tarjeta
    private double saldo;       // Saldo disponible en pesos
    private String usuario;     // Nombre del propietario

    /**
     * Constructor de la tarjeta.
     * @param idTarjeta Identificador único
     * @param usuario   Nombre del usuario
     */
    public Tarjeta(String idTarjeta, String usuario) {
        this.idTarjeta = idTarjeta;
        this.usuario = usuario;
        this.saldo = 0.0;       // Saldo inicial cero
    }

    // ========== MÉTODOS ABSTRACTOS (deben ser implementados por las subclases) ==========
    
    /**
     * Realiza una recarga de saldo.
     * @param monto Cantidad a recargar (debe ser positiva)
     */
    public abstract void recargar(double monto);
    
    /**
     * Paga un viaje en el SITP.
     * @return true si el pago fue exitoso, false si saldo insuficiente
     */
    public abstract boolean pagarViaje();

    // ========== MÉTODOS CONCRETOS (compartidos por todas las tarjetas) ==========
    
    public String getIdTarjeta() { return idTarjeta; }
    
    public double getSaldo() { return saldo; }
    
    // Protected para que solo las subclases puedan modificar el saldo directamente
    protected void setSaldo(double saldo) { this.saldo = saldo; }
    
    public String getUsuario() { return usuario; }
    
    /**
     * Muestra en consola la información de la tarjeta y su saldo actual.
     */
    public void consultarSaldo() {
        System.out.println("Tarjeta: " + idTarjeta + " | Usuario: " + usuario + " | Saldo: $" + saldo);
    }
}