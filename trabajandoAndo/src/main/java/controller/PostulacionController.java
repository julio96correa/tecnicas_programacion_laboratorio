package controller;

import model.Postulacion;
import service.PostulacionService;
import util.Leer;

public class PostulacionController {
    private final PostulacionService postulacionService = new PostulacionService();

    public void registrarPostulacion() {
        System.out.println("=== Registrar Postulación ===");
        String idTrabajo = Leer.leerTexto("ID del trabajo");
        String idFreelance = Leer.leerTexto("ID del freelance");
        String descripcion = Leer.leerTexto("Descripción de la postulación");

        Postulacion postulacion = new Postulacion(idTrabajo, idFreelance, descripcion);
        postulacionService.registrarPostulacion(postulacion);

        System.out.println("Postulación registrada exitosamente.");
    }

    public void listarPostulaciones() {
        System.out.println("=== Lista de Postulaciones ===");
        postulacionService.listarPostulaciones()
                .forEach(System.out::println);
    }
}
