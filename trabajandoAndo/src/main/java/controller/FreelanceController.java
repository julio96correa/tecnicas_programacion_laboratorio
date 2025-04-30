package controller;

import model.Freelance;
import service.FreelanceService;
import util.Leer;

import java.util.List;

public class FreelanceController {
    private final FreelanceService service = new FreelanceService();

    public void registrarFreelance() {
        System.out.println("== Registro de Freelance ==");

        int id = Leer.entero("ID:");
        String nombre = Leer.texto("Nombre:");
        int edad = Leer.entero("Edad:");
        String lenguaje = Leer.texto("Lenguaje:");
        int experiencia = Leer.entero("Años de experiencia:");
        String idioma = Leer.texto("Idioma:");
        int disponibilidad = Leer.entero("Disponibilidad semanal (horas):");
        double pagoEsperado = Leer.decimal("Pago esperado:");
        boolean negociable = Leer.booleano("¿Pago negociable? (true/false):");

        Freelance f = new Freelance(id, nombre, edad, lenguaje, experiencia, idioma, disponibilidad, pagoEsperado, negociable);
        service.agregar(f);
        System.out.println("Freelance registrado con éxito.");
    }

    public void listarFreelancers() {
        List<Freelance> lista = service.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay freelancers registrados.");
            return;
        }
        lista.forEach(System.out::println);
    }

    public Freelance buscarFreelancePorId(int id) {
        return service.buscarPorId(id);
    }
}
