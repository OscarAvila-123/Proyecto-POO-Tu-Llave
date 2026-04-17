// TarjetaSubsidio.java
// Representa una tarjeta con subsidio estatal del 50% para personas de bajos recursos.
// Hereda de Tarjeta e implementa Beneficio.

public class TarjetaSubsidio extends Tarjeta implements Beneficio {
    
    private static final double SUBSIDIO = 0.50;          // 50% de subsidio
    private static final double TARIFA_SITP = 2950.0;     // Tarifa base del SITP
    private boolean subsidioActivo;                       // Controla si el subsidio está vigente

    /**
     * Constructor.
     * @param id      Identificador de la tarjeta
     * @param usuario Nombre del propietario
     */
    public TarjetaSubsidio(String id, String usuario) {
        super(id, usuario);
        this.subsidioActivo = true;   // Por defecto el subsidio está activo
    }

    // ========== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS DE Tarjeta ==========
    
    @Override
    public void recargar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            System.out.println("Recarga exitosa: +$" + monto);
        } else {
            System.out.println("Monto inválido.");
        }
    }
    
    /**
     * Paga un viaje aplicando el subsidio del 50% si está activo.
     * @return true si el pago fue exitoso, false si saldo insuficiente
     */
    @Override
    public boolean pagarViaje() {
        double costo = aplicarDescuento(TARIFA_SITP);
        if (getSaldo() >= costo) {
            setSaldo(getSaldo() - costo);
            System.out.println("Viaje pagado. Tarifa SITP: $" + TARIFA_SITP +
                               " | Con subsidio: $" + costo +
                               " | Ahorro: $" + (TARIFA_SITP - costo));
            return true;
        } else {
            System.out.println("Saldo insuficiente. Necesita: $" + costo);
            return false;
        }
    }

    // ========== IMPLEMENTACIÓN DE MÉTODOS DE LA INTERFAZ Beneficio ==========
    
    /**
     * Aplica el subsidio solo si está activo.
     * @param montoBase Monto original del viaje
     * @return Monto con subsidio (si aplica) o el mismo monto
     */
    @Override
    public double aplicarDescuento(double montoBase) {
        if (subsidioActivo) {
            return montoBase * (1 - SUBSIDIO);
        } else {
            return montoBase;   // Sin subsidio, paga tarifa completa
        }
    }
    
    @Override
    public boolean validarSubsidio() {
        return subsidioActivo;
    }
    
    /**
     * Permite activar o desactivar el subsidio externamente.
     * @param activo true para activar, false para desactivar
     */
    public void setSubsidioActivo(boolean activo) {
        this.subsidioActivo = activo;
        System.out.println("Subsidio " + (activo ? "activado" : "desactivado"));
    }
    
    @Override
    public String obtenerDescripcionBeneficio() {
        return "Subsidio del 50% en viajes SITP.";
    }
}