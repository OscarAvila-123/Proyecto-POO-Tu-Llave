// Beneficio.java
// Esta interfaz define comportamientos adicionales que pueden tener diferentes servicios
// No depende de ninguna jerarquía de herencia, cualquier clase puede implementarla

public interface Beneficio {
    double aplicarDescuento(double montoBase);
    boolean validarSubsidio();
    String obtenerDescripcionBeneficio();
}