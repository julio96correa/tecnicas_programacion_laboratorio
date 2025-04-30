package controller;

import model.Trabajo;
import service.TrabajoService;
import util.Leer;

public class TrabajoController {
    private final TrabajoService trabajoService = new TrabajoService();

    public void registrarTrabajo() {
        System.out.println("=== Registrar Trabajo ===");
        String titulo = Leer.leerTexto("Título del trabajo");
        String descripcion = Leer.leerTexto("Descripción");
        String idEmpresa = Leer.leerTexto("ID de la empresa");

        Trabajo trabajo = new Trabajo(titulo, descripcion, idEmpresa);
        trabajoService.registrarTrabajo(trabajo);

        System.out.println("Trabajo registrado exitosamente.");
    }

    public void listarTrabajos() {
        System.out.println("=== Lista de Trabajos ===");
        trabajoService.listarTrabajos()
                .forEach(System.out::println);
    }
}
