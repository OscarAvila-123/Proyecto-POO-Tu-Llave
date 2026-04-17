// Representa un parqueadero público que ofrece descuento del 30% para vehículos eléctricos.
// Esta clase NO hereda de Tarjeta, pero implementa Beneficio.
// Demuestra reutilización de la interfaz en un contexto diferente.

import java.util.Scanner;

public class ParqueaderoPublico implements Beneficio {
    
    private static final double TARIFA_HORA = 2000.0;          // $2000 por hora
    private static final double DESCUENTO_ELECTRICO = 0.30;    // 30% descuento para eléctricos

    /**
     * Método interactivo para registrar una estadía en el parqueadero.
     * Solicita la placa y las horas, y aplica descuento si el vehículo es eléctrico.
     * @param scanner Objeto Scanner para leer entrada del usuario
     */
    public void estacionar(Scanner scanner) {
        System.out.print("Ingrese placa del vehículo: ");
        String placa = scanner.next();
        System.out.print("Ingrese horas de estacionamiento: ");
        int horas = scanner.nextInt();
        
        double costoBase = horas * TARIFA_HORA;
        double costoFinal = aplicarDescuento(costoBase, placa);   // Usa versión con placa
        double ahorro = costoBase - costoFinal;
        
        System.out.println("\n--- PARQUEADERO PÚBLICO ---");
        System.out.println("Placa: " + placa);
        System.out.println("Horas: " + horas);
        System.out.println("Costo base: $" + costoBase);
        
        if (esVehiculoElectrico(placa)) {
            System.out.println("Beneficio aplicado: " + obtenerDescripcionBeneficio());
            System.out.println("Descuento: $" + ahorro);
        }
        
        System.out.println("Total a pagar: $" + costoFinal);
        System.out.println("¡Gracias por usar nuestro parqueadero!\n");
    }
    
    /**
     * Determina si un vehículo es eléctrico según su placa.
     * En este ejemplo, se considera eléctrico si la placa comienza con 'E' o 'e'.
     * @param placa Placa del vehículo
     * @return true si es eléctrico, false en caso contrario
     */
    private boolean esVehiculoElectrico(String placa) {
        return placa.toUpperCase().startsWith("E");
    }
    
    /**
     * Versión de aplicarDescuento que toma en cuenta la placa para decidir el beneficio.
     * @param montoBase Costo base del estacionamiento
     * @param placa     Placa del vehículo
     * @return Costo final después de aplicar descuento si es eléctrico
     */
    private double aplicarDescuento(double montoBase, String placa) {
        if (esVehiculoElectrico(placa)) {
            return montoBase * (1 - DESCUENTO_ELECTRICO);
        }
        return montoBase;
    }
    
    // ========== IMPLEMENTACIÓN DE LA INTERFAZ Beneficio ==========
    // (Estos métodos se incluyen por requerimiento de la interfaz,
    //  aunque en el menú principal no se usan directamente porque usamos la versión con placa)
    
    /**
     * Implementación genérica (sin placa). No se usa en este contexto,
     * pero es necesaria por la interfaz.
     */
    @Override
    public double aplicarDescuento(double montoBase) {
        // Esta versión no aplica descuento porque no conocemos la placa.
        // En nuestro menú llamamos a la versión sobrecargada.
        return montoBase;
    }
    
    @Override
    public boolean validarSubsidio() {
        // No se usa directamente; la validación se hace con la placa.
        return false;
    }
    
    @Override
    public String obtenerDescripcionBeneficio() {
        return "Descuento del 30% para vehículos eléctricos.";
    }
}