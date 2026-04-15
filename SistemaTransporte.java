// SistemaTransporte.java
// CLASE PRINCIPAL - MODIFICADA del taller anterior
// Demuestra el uso de la clase abstracta Tarjeta, la interfaz Beneficio,
// y cómo objetos de diferentes jerarquías pueden tratarse de manera uniforme
import java.util.ArrayList;
import java.util.List;

public class SistemaTransporte {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA TU LLAVE - DEMOSTRACIÓN ===");

        // 1. Crear objetos de tarjetas (jerarquía Tarjeta)
        TarjetaPersonalizada tarjetaPersonal = new TarjetaPersonalizada("TP1001", "Ana Gómez");
        TarjetaSubsidio tarjetaSubsidio = new TarjetaSubsidio("TS2002", "Carlos López");

        // 2. Crear objetos externos que implementan Beneficio
        BiciPublica bici = new BiciPublica("Ana Gómez");
        ParqueaderoPublico parqueadero = new ParqueaderoPublico("E123ABC"); // eléctrico

        // 3. Demostrar operaciones propias de Tarjeta
        System.out.println("\n--- Operaciones con Tarjetas ---");
        tarjetaPersonal.recargar(10000);
        tarjetaPersonal.consultarSaldo();
        tarjetaPersonal.pagarViaje();
        tarjetaPersonal.consultarSaldo();

        tarjetaSubsidio.recargar(5000);
        tarjetaSubsidio.consultarSaldo();
        tarjetaSubsidio.pagarViaje();
        tarjetaSubsidio.consultarSaldo();

        // 4. Demostrar uso uniforme de la interfaz Beneficio
        System.out.println("\n--- Beneficios aplicados mediante interfaz ---");
        List<Beneficio> beneficios = new ArrayList<>();
        beneficios.add(tarjetaPersonal);
        beneficios.add(tarjetaSubsidio);
        beneficios.add(bici);
        beneficios.add(parqueadero);

        double costoBaseEjemplo = 5000.0; // costo de referencia
        for (Beneficio b : beneficios) {
            System.out.println("\nObjeto: " + b.getClass().getSimpleName());
            System.out.println("  Descripción: " + b.obtenerDescripcionBeneficio());
            System.out.println("  ¿Subsidio válido? " + b.validarSubsidio());
            double costoFinal = b.aplicarDescuento(costoBaseEjemplo);
            System.out.println("  Descuento aplicado sobre $" + costoBaseEjemplo + " -> $" + costoFinal);
        }

        // 5. Demostrar servicios externos con sus propios métodos
        System.out.println("\n--- Servicios externos ---");
        bici.usarBici(30);
        parqueadero.registrarEstadia(3);
    }
}