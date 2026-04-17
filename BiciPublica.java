// BiciPublica.java
// Representa el servicio de bicicletas públicas.
// Esta clase NO hereda de Tarjeta, pero implementa Beneficio para ofrecer descuentos.
// Demuestra que la interfaz puede ser implementada por clases externas a la jerarquía.

import java.util.Scanner;

public class BiciPublica implements Beneficio {
    
    private String usuario;                              // Usuario que alquila la bici
    private static final double TARIFA_MINUTO = 100.0;   // Costo por minuto: $100
    private static final double DESCUENTO_MIEMBRO = 0.20; // 20% descuento para miembros

    /**
     * Constructor.
     * @param usuario Nombre del usuario (en un sistema real se validaría membresía)
     */
    public BiciPublica(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Método interactivo para realizar un alquiler de bicicleta.
     * Solicita los minutos de uso y aplica el descuento si corresponde.
     * @param scanner Objeto Scanner para leer entrada del usuario
     */
    public void alquilar(Scanner scanner) {
        System.out.print("Ingrese minutos de uso: ");
        int minutos = scanner.nextInt();
        
        double costoBase = minutos * TARIFA_MINUTO;               // Costo sin descuento
        double costoFinal = aplicarDescuento(costoBase);          // Aplica beneficio si corresponde
        double ahorro = costoBase - costoFinal;
        
        System.out.println("\n--- ALQUILER DE BICICLETA PÚBLICA ---");
        System.out.println("Usuario: " + usuario);
        System.out.println("Minutos: " + minutos);
        System.out.println("Costo base: $" + costoBase);
        
        if (validarSubsidio()) {   // Si el usuario tiene derecho a descuento
            System.out.println("Beneficio aplicado: " + obtenerDescripcionBeneficio());
            System.out.println("Descuento: $" + ahorro);
        }
        
        System.out.println("Total a pagar: $" + costoFinal);
        System.out.println("¡Disfruta tu paseo en bici!\n");
    }
    
    // ========== IMPLEMENTACIÓN DE LA INTERFAZ Beneficio ==========
    
    /**
     * Aplica el descuento del 20% si el usuario es miembro.
     * @param montoBase Costo base del alquiler
     * @return Costo final después del descuento (si aplica)
     */
    @Override
    public double aplicarDescuento(double montoBase) {
        if (validarSubsidio()) {
            return montoBase * (1 - DESCUENTO_MIEMBRO);
        }
        return montoBase;
    }
    
    /**
     * Verifica si el usuario tiene membresía activa.
     * En este ejemplo, siempre retorna true para simular que el usuario es miembro.
     * En un sistema real se consultaría una base de datos.
     * @return true (siempre, para este demo)
     */
    @Override
    public boolean validarSubsidio() {
        // Simulación: el usuario actual es miembro del sistema de bicicletas
        return true;
    }
    
    @Override
    public String obtenerDescripcionBeneficio() {
        return "Descuento del 20% para miembros del sistema de bicicletas.";
    }
}