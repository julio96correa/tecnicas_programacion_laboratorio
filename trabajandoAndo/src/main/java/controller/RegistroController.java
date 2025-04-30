package controller;

import model.Empresa;
import model.Freelance;
import service.EmpresaService;
import service.FreelanceService;
import util.Leer;

public class RegistroController {
    private final EmpresaService empresaService = new EmpresaService();
    private final FreelanceService freelanceService = new FreelanceService();

    public void registrarEmpresa() {
        System.out.println("=== Registro de Empresa ===");
        String nombre = Leer.leerTexto("Nombre de la empresa");
        String email = Leer.leerTexto("Email");
        String password = Leer.leerTexto("Password");

        Empresa empresa = new Empresa(nombre, email, password);
        empresaService.registrarEmpresa(empresa);

        System.out.println("Empresa registrada correctamente.");
    }

    public void registrarFreelance() {
        System.out.println("=== Registro de Freelance ===");
        String nombre = Leer.leerTexto("Nombre");
        String email = Leer.leerTexto("Email");
        String password = Leer.leerTexto("Password");

        Freelance freelance = new Freelance(nombre, email, password);
        freelanceService.registrarFreelance(freelance);

        System.out.println("Freelance registrado correctamente.");
    }
}
