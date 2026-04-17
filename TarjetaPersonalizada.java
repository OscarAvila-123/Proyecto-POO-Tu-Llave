// TarjetaPersonalizada.java
// Representa una tarjeta con descuento comercial del 10% en cada viaje.
// Hereda de Tarjeta (clase abstracta) e implementa la interfaz Beneficio.

public class TarjetaPersonalizada extends Tarjeta implements Beneficio {
    
    // Constantes propias de este tipo de tarjeta
    private static final double DESCUENTO = 0.10;          // 10% de descuento
    private static final double TARIFA_SITP = 2950.0;      // Tarifa actual del SITP (año 2025)

    /**
     * Constructor.
     * @param id      Identificador de la tarjeta
     * @param usuario Nombre del propietario
     */
    public TarjetaPersonalizada(String id, String usuario) {
        super(id, usuario);   // Llama al constructor de la clase padre Tarjeta
    }

    // ========== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS DE Tarjeta ==========
    
    /**
     * Recarga saldo en la tarjeta.
     * @param monto Cantidad a recargar (debe ser positiva)
     */
    @Override
    public void recargar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            System.out.println("Recarga exitosa: +$" + monto);
        } else {
            System.out.println("Monto inválido. La recarga debe ser mayor a cero.");
        }
    }
    
    /**
     * Paga un viaje aplicando el descuento del 10% sobre la tarifa SITP.
     * @return true si el saldo era suficiente, false en caso contrario
     */
    @Override
    public boolean pagarViaje() {
        double costo = aplicarDescuento(TARIFA_SITP);   // Calcula el costo con descuento
        if (getSaldo() >= costo) {
            setSaldo(getSaldo() - costo);
            System.out.println("Viaje pagado. Tarifa SITP: $" + TARIFA_SITP +
                               " | Con descuento: $" + costo +
                               " | Ahorro: $" + (TARIFA_SITP - costo));
            return true;
        } else {
            System.out.println("Saldo insuficiente. Necesita: $" + costo);
            return false;
        }
    }

    // ========== IMPLEMENTACIÓN DE MÉTODOS DE LA INTERFAZ Beneficio ==========
    
    /**
     * Aplica el descuento del 10% al monto base.
     * @param montoBase Monto original (tarifa del viaje)
     * @return Monto después del descuento
     */
    @Override
    public double aplicarDescuento(double montoBase) {
        return montoBase * (1 - DESCUENTO);
    }
    
    /**
     * Las tarjetas personalizadas no tienen subsidio estatal.
     * @return false (no hay subsidio)
     */
    @Override
    public boolean validarSubsidio() {
        return false;
    }
    
    /**
     * Descripción textual del beneficio.
     * @return Texto explicativo
     */
    @Override
    public String obtenerDescripcionBeneficio() {
        return "Descuento del 10% en cada viaje SITP.";
    }
}