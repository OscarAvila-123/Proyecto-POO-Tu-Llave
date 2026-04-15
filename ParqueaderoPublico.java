// ParqueaderoPublico.java
// Esta clase representa un servicio de parqueadero público
// NO hereda de Tarjeta, pero implementa Beneficio para ofrecer descuentos
// Demuestra nuevamente que la interfaz Beneficio es reutilizable en diferentes contextos

public class ParqueaderoPublico implements Beneficio {
      // Atributos propios del parqueadero
    private String placa;
    @SuppressWarnings("unused")
    private int horas;
    private static final double TARIFA_HORA = 2000.0; //2.000 POR HORA
    private static final double DESCUENTO_VEHICULO_ELECTRICO = 0.30; // 30% descuento

    public ParqueaderoPublico(String placa) {
        this.placa = placa;  //Placa del vehículo, por ejemplo: "E1234" para eléctricos, "A5678" para no eléctricos
    }

    public void registrarEstadia(int horas) {
        this.horas = horas;
        double costoBase = horas * TARIFA_HORA;        
        double costoFinal = aplicarDescuento(costoBase);
        System.out.println("Estadía de " + horas + " hora(s). Costo original: $" + costoBase +
                           ", Con descuento: $" + costoFinal);
    }
// ========== IMPLEMENTACIÓN DE LA INTERFAZ Beneficio ==========

    @Override
    public double aplicarDescuento(double montoBase) {
        if (validarSubsidio())
            return montoBase * (1 - DESCUENTO_VEHICULO_ELECTRICO);
        return montoBase;
    }

    @Override
    public boolean validarSubsidio() {
        // Simula que el vehículo es eléctrico
        return placa.startsWith("E");
    }

    @Override
    public String obtenerDescripcionBeneficio() {
        return "Descuento del 30% para vehículos eléctricos en parqueaderos públicos.";
    }
}