// SistemaTransporte.java
// Clase principal del sistema Tu Llave.
// Implementa un menú interactivo en consola que permite:
// - Consultar saldo, recargar y pagar viajes con tarjetas.
// - Alquilar bicicletas públicas con descuento.
// - Pagar parqueadero con descuento para vehículos eléctricos.
// - Cambiar entre diferentes tarjetas.
// Demuestra el uso de la interfaz Beneficio y el polimorfismo.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaTransporte {
    
    // Lista de tarjetas disponibles en el sistema
    private static List<Tarjeta> tarjetas = new ArrayList<>();
    
    // Scanner para leer la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);
    
    // Tarjeta actualmente seleccionada para las operaciones
    private static Tarjeta tarjetaActiva = null;
    
    // Instancias de servicios externos (implementan Beneficio)
    private static BiciPublica bici = new BiciPublica("UsuarioDemo");
    private static ParqueaderoPublico parqueadero = new ParqueaderoPublico();

    /**
     * Punto de entrada principal del programa.
     * Inicializa las tarjetas de ejemplo, muestra el menú y procesa las opciones.
     */
    public static void main(String[] args) {
        // Crear dos tarjetas de ejemplo
        tarjetas.add(new TarjetaPersonalizada("TP1001", "Ana Gómez"));
        tarjetas.add(new TarjetaSubsidio("TS2002", "Carlos López"));
        
        // Seleccionar la primera tarjeta como activa por defecto
        tarjetaActiva = tarjetas.get(0);
        
        int opcion;
        do {
            mostrarMenu();                 // Muestra las opciones disponibles
            opcion = scanner.nextInt();    // Lee la opción del usuario
            scanner.nextLine();            // Limpia el buffer del teclado
            procesarOpcion(opcion);        // Ejecuta la acción correspondiente
        } while (opcion != 6);             // Salir cuando opción sea 6
        
        System.out.println("¡Gracias por usar el sistema Tu Llave!");
        scanner.close();   // Cierra el Scanner para liberar recursos
    }
    
    /**
     * Muestra el menú principal con todas las opciones.
     * Incluye la información de la tarjeta activa.
     */
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("   SISTEMA TU LLAVE - MENÚ PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("Tarjeta activa: " + tarjetaActiva.getIdTarjeta() +
                           " (" + tarjetaActiva.getUsuario() + ")");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Recargar saldo");
        System.out.println("3. Pagar viaje SITP (tarifa $2,950)");
        System.out.println("4. Alquilar bicicleta pública (con beneficio)");
        System.out.println("5. Pagar parqueadero público (descuento para eléctricos)");
        System.out.println("6. Salir");
        System.out.println("7. Cambiar de tarjeta");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Procesa la opción seleccionada por el usuario.
     * @param opcion Número de opción (1 a 7)
     */
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: // Consultar saldo
                tarjetaActiva.consultarSaldo();
                break;
                
            case 2: // Recargar saldo
                System.out.print("Ingrese monto a recargar: $");
                double monto = scanner.nextDouble();
                tarjetaActiva.recargar(monto);
                break;
                
            case 3: // Pagar viaje SITP
                tarjetaActiva.pagarViaje();
                break;
                
            case 4: // Alquilar bicicleta
                bici.alquilar(scanner);
                break;
                
            case 5: // Pagar parqueadero
                parqueadero.estacionar(scanner);
                break;
                
            case 6: // Salir
                // No se requiere acción adicional, el bucle principal terminará
                break;
                
            case 7: // Cambiar de tarjeta
                cambiarTarjeta();
                break;
                
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }
    
    /**
     * Permite al usuario seleccionar otra tarjeta de la lista.
     * Muestra todas las tarjetas disponibles con su saldo actual.
     */
    private static void cambiarTarjeta() {
        System.out.println("\n--- TARJETAS DISPONIBLES ---");
        // Recorre la lista y muestra cada tarjeta numerada
        for (int i = 0; i < tarjetas.size(); i++) {
            Tarjeta t = tarjetas.get(i);
            System.out.println((i+1) + ". " + t.getIdTarjeta() + " - " + t.getUsuario() +
                               " (Saldo: $" + t.getSaldo() + ")");
        }
        System.out.print("Seleccione número de tarjeta: ");
        int idx = scanner.nextInt() - 1;   // Convertir a índice de lista (0-based)
        
        if (idx >= 0 && idx < tarjetas.size()) {
            tarjetaActiva = tarjetas.get(idx);
            System.out.println("Tarjeta activa cambiada a: " + tarjetaActiva.getIdTarjeta());
        } else {
            System.out.println("Selección inválida.");
        }
    }
}