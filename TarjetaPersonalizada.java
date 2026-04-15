// TarjetaPersonalizada.java
// Representa una tarjeta con descuento del 10% en cada viaje
// Hereda de Tarjeta (clase abstracta) e implementa Beneficio (interfaz)
public class TarjetaPersonalizada extends Tarjeta implements Beneficio {
    private static final double DESCUENTO_PORCENTAJE = 0.10; // 10% descuento
    private static final double TARIFA_BASE = 2500.0;

    public TarjetaPersonalizada(String idTarjeta, String usuario) {
        super(idTarjeta, usuario);
    }
// ========== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS DE Tarjeta ==========
    @Override
    public void recargar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            System.out.println("Recarga exitosa: +$" + monto);
        } else {
            System.out.println("Monto inválido");
        }
    }

    @Override
    public boolean pagarViaje() {
        double costoConDescuento = aplicarDescuento(TARIFA_BASE);
        if (getSaldo() >= costoConDescuento) {
            setSaldo(getSaldo() - costoConDescuento);
            System.out.println("Viaje pagado. Costo real: $" + TARIFA_BASE +
                               ", Descuento aplicado: $" + (TARIFA_BASE - costoConDescuento));
            return true;
        } else {
            System.out.println("Saldo insuficiente para viaje (necesita $" + costoConDescuento + ")");
            return false;
        }
    }

    // Métodos de la interfaz Beneficio
        // ========== IMPLEMENTACIÓN DE MÉTODOS DE LA INTERFAZ Beneficio ==========
    @Override
    public double aplicarDescuento(double montoBase) {
        return montoBase * (1 - DESCUENTO_PORCENTAJE);
    }

    @Override
    public boolean validarSubsidio() {
        // Las tarjetas personalizadas no tienen subsidio estatal, pero sí descuento comercial
        return false; // No tiene subsidio, solo descuento comercial
    }

    @Override
    public String obtenerDescripcionBeneficio() {
        return "Descuento del " + (DESCUENTO_PORCENTAJE * 100) + "% en cada viaje.";
    }
}