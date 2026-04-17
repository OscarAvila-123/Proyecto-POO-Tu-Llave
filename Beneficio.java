// Beneficio.java
// Esta interfaz define el contrato para cualquier clase que ofrezca beneficios
// (descuentos, subsidios, etc.) en el sistema Tu Llave.

public interface Beneficio {
    
    /**
     * Aplica un descuento o subsidio sobre un monto base.
     * @param montoBase Cantidad original antes del beneficio
     * @return Cantidad final después de aplicar el beneficio
     */
    double aplicarDescuento(double montoBase);
    
    /**
     * Verifica si el usuario o servicio cumple las condiciones para recibir el beneficio.
     * @return true si el beneficio está activo, false en caso contrario
     */
    boolean validarSubsidio();
    
    /**
     * Devuelve una descripción textual del beneficio.
     * @return Explicación del beneficio (ej. "10% de descuento en viajes")
     */
    String obtenerDescripcionBeneficio();
}