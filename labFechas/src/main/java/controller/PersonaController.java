package controller;

import model.Persona;
import service.PersonaService;
import view.PersonaView;
import dto.*;

public class PersonaController {

    private final PersonaView personaView;
    private final PersonaService personaService;

    public PersonaController(PersonaView personaView, PersonaService personaService) {
        this.personaView = personaView;
        this.personaService = personaService;
        run();
    }

    public EdadDTO obtenerEdad(long id){
        return personaService.obtenerEdad(id);
    }

    public AnhosCasadoDTO obtenerAnhosCasado(long id){
        return personaService.obtenerAnhosCasado(id);
    }

    public SegundosLoteriaDTO obtenerSegundosLoteria(long id){
        return personaService.obtenerSegundosLoteria(id);
    }
    public GraduacionMatrimonioDTO obtenerGraduacionaMatrimonio(long id) {
        return personaService.obtenerGraduacionaMatrimonio(id);
    }

    public NacidosBisiestoDTO obtenerNacidosBisiesto(){
        return personaService.obtenerNacidosBisiesto();
    }

    public MayorMenorLoteriaDTO obtenerMayorMenorLoteria(){
        return personaService.obtenerMayorMenorLoteria();
    }

    public PrimerUltimoLoteriaDTO obtenerPrimerUltimoLoteria(){
        return personaService.obtenerPrimerUltimoLoteria();
    }

    public PrimerGanadorLoteriaDTO obtenerPrimerGanadorLoteria(){
        return personaService.obtenerPrimerGanadorLoteria();
    }

    private void run() {

    }
}
