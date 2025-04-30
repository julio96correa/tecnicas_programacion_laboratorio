import controller.PersonaController;
import service.FechaService;
import service.PersonaService;
import model.Persona;
import dao.PersonaDAO;
import view.PersonaView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        PersonaDAO personaDAO = new PersonaDAO();
        FechaService fechaService = new FechaService();
        PersonaService personaService = new PersonaService((PersonaDAO) personaDAO, (FechaService) fechaService);
        PersonaView personaView = new PersonaView();
        PersonaController personaController = new PersonaController(personaView, personaService);

        System.out.println("hola");
        System.out.println(personaService.buscarPorId(3));
        System.out.println(personaController.obtenerEdad(1).getEdad());
        System.out.println(personaService.buscarPorId(4));
        System.out.println("casado" + personaController.obtenerAnhosCasado(2).getAnhos());
        System.out.println(personaService.buscarPorId(6));
        System.out.println("loteria" + personaController.obtenerSegundosLoteria(12).getSegundos());
        System.out.println(personaService.buscarPorId(5));
        System.out.println("grad matr" + personaController.obtenerGraduacionaMatrimonio(15).getDias());
        System.out.println("bisiestos" + personaController.obtenerNacidosBisiesto().getContador());
        System.out.println(personaController.obtenerMayorMenorLoteria().getMayor().toString() + personaController.obtenerMayorMenorLoteria().getMenor().toString());
        System.out.println(FechaService.ultimoGanadorLoteria(personaService.getPersonas()));
        System.out.println("minutos 1 y ult " + personaController.obtenerPrimerUltimoLoteria().getMinutos());
        System.out.println("primero " + personaController.obtenerPrimerGanadorLoteria().getPersona().getLoteria());

    }
}
