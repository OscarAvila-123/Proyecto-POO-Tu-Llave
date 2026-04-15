// BiciPublica.java
// Esta clase representa un servicio de bicicletas compartidas
// NO hereda de Tarjeta, pero implementa Beneficio para ofrecer descuentos
// Esto demuestra que la interfaz Beneficio es independiente de la jerarquía de Tarjeta
public class BiciPublica implements Beneficio {
     // Atributos propios del servicio de bicicletas
    private String usuario;
    private int minutosUso;
    private static final double TARIFA_BASE_POR_MINUTO = 100.0;//100 por minuto sin descuento 
    private static final double DESCUENTO_MEMBRESIA = 0.20; // 20% para miembros

    public BiciPublica(String usuario) {
        this.usuario = usuario;
        this.minutosUso = 0;
    }

    public void usarBici(int minutos) {
        this.minutosUso = minutos;
        double costo = aplicarDescuento(minutos * TARIFA_BASE_POR_MINUTO);
        System.out.println("Uso de bici por " + minutos + " min. Costo con descuento: $" + costo);
    }
 // ========== IMPLEMENTACIÓN DE LA INTERFAZ Beneficio ==========
    @Override
    public double aplicarDescuento(double montoBase) {
        // Simula descuento por membresía
        if (validarSubsidio())
            return montoBase * (1 - DESCUENTO_MEMBRESIA);
        return montoBase;
    }

    @Override
    public boolean validarSubsidio() {
        // Por ejemplo, si el usuario tiene membresía activa
        return true; // Simplificado
    }

    @Override
    public String obtenerDescripcionBeneficio() {
        return "Descuento del 20% en alquiler de bicicletas públicas para miembros.";
    }
}