package controller;

import model.Empresa;
import service.EmpresaService;
import util.Leer;

import java.util.List;

public class EmpresaController {
    private final EmpresaService service = new EmpresaService();

    public void registrarEmpresa() {
        System.out.println("== Registro de Empresa ==");

        int id = Leer.entero("ID:");
        String nombre = Leer.texto("Nombre:");
        int edad = Leer.entero("Años en el mercado:");
        String sector = Leer.texto("Sector o rubro:");
        String ubicacion = Leer.texto("Ubicación:");
        String idioma = Leer.texto("Idioma:");
        String contacto = Leer.texto("Correo de contacto:");

        Empresa e = new Empresa(id, nombre, edad, sector, ubicacion, idioma, contacto);
        service.agregar(e);
        System.out.println("Empresa registrada con éxito.");
    }

    public void listarEmpresas() {
        List<Empresa> lista = service.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay empresas registradas.");
            return;
        }
        lista.forEach(System.out::println);
    }

    public Empresa buscarEmpresaPorId(int id) {
        return service.buscarPorId(id);
    }
}
