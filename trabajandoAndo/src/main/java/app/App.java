package app;

import controller.PostulacionController;
import controller.RegistroController;
import controller.TrabajoController;
import util.Leer;

public class App {
    public static void run() {
        RegistroController registroController = new RegistroController();
        TrabajoController trabajoController = new TrabajoController();
        PostulacionController postulacionController = new PostulacionController();

        while (true) {
            System.out.println("=== TrabajandoAndo ===");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar trabajo");
            System.out.println("3. Postular a trabajo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int opcion = Leer.entero("Introduzca el numero: ");

            switch (opcion) {
                case 1 -> registroController.registrarPersona();
                case 2 -> trabajoController.registrarTrabajo();
                case 3 -> postulacionController.postular();
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
