// TarjetaSubsidio.java
// Representa una tarjeta con subsidio del 50% en cada viaje
// Hereda de Tarjeta (clase abstracta) e implementa Beneficio (interfaz)
public class TarjetaSubsidio extends Tarjeta implements Beneficio {
    private static final double TARIFA_BASE = 2500.0;        // Tarifa base sin subsidio   
    private static final double SUBSIDIO_PORCENTAJE = 0.50; // 50% subsidio
    private boolean subsidioActivo;

    public TarjetaSubsidio(String idTarjeta, String usuario) {
        super(idTarjeta, usuario);
        this.subsidioActivo = true; // Por defecto activo
    }
 // ========== IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS DE Tarjeta ==========
    @Override
    public void recargar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            System.out.println("Recarga con subsidio: +$" + monto);
        } else {
            System.out.println("Monto inválido");
        }
    }
   // ========== IMPLEMENTACIÓN DE MÉTODOS DE LA INTERFAZ Beneficio ==========
    @Override
    public boolean pagarViaje() {
        double costoConSubsidio = aplicarDescuento(TARIFA_BASE);
        if (getSaldo() >= costoConSubsidio) {
            setSaldo(getSaldo() - costoConSubsidio);
            System.out.println("Viaje pagado con subsidio. Costo final: $" + costoConSubsidio);
            return true;
        } else {
            System.out.println("Saldo insuficiente para viaje (necesita $" + costoConSubsidio + ")");
            return false;
        }
    }

    // Métodos Beneficio
    @Override
    public double aplicarDescuento(double montoBase) {
        if (validarSubsidio())
            return montoBase * (1 - SUBSIDIO_PORCENTAJE);
        else
            return montoBase;  // Sin subsidio, paga el valor completo
    }

    @Override
    public boolean validarSubsidio() {
        return subsidioActivo;
    }

    public void setSubsidioActivo(boolean activo) {
        this.subsidioActivo = activo;
    }

    @Override
    public String obtenerDescripcionBeneficio() {
        return "Subsidio del " + (SUBSIDIO_PORCENTAJE * 100) + "% en el costo del viaje.";
    }
}