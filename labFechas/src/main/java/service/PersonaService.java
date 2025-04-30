package service;
import dto.*;
import model.Persona;
import dao.PersonaDAO;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;


public class PersonaService {

    private final PersonaDAO personaDAO;
    private final FechaService fechaService;
    private List<Persona> personas;

    public PersonaService(PersonaDAO personaDAO, FechaService fechaService) {
        this.personaDAO = personaDAO;
        this.fechaService = fechaService;
        this.personas = personaDAO.leerCSV();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void agregarPersona(Persona persona) {

        for (Persona p : personas) {
            if (p.getId() == persona.getId()) {
                persona.setId(persona.getId() + 1);
            }
        }

        personas.add(persona);
        personaDAO.sobrescribirCSV(personas);
    }

    public Persona buscarPorId(long id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    public void eliminarPorId(long id) {
        Iterator<Persona> iterator = personas.iterator();

        while (iterator.hasNext()) {
            Persona p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                break;
            }
        }

    }

    //eadd
    public EdadDTO obtenerEdad(long id) {
        Persona persona = buscarPorId(id);
        if (persona == null){return new EdadDTO(false, "ID no encontrado");}
        if (!fechaService.tieneNacimiento(persona.getNacimiento())){return new EdadDTO(true, "No se ha encontrado fecha de nacimiento");}
        return fechaService.calcularEdad(persona.getNacimiento());
    }

    //años casado
    public AnhosCasadoDTO obtenerAnhosCasado(long id) {
        Persona persona = buscarPorId(id);
        if (persona == null){return new AnhosCasadoDTO(false, "ID no encontrado");}
        if (!fechaService.tieneMatrimonio(persona.getMatrimonio())){return new AnhosCasadoDTO(true, "No se ha casado");}
        return fechaService.calcularAnhosCasado(persona.getMatrimonio());
    }

    //segundos vivo dsde loteria
    public SegundosLoteriaDTO obtenerSegundosLoteria(long id) {
        Persona persona = buscarPorId(id);
        if (persona == null){return new SegundosLoteriaDTO(false, "ID no encontrado");}
        if (!fechaService.haGanadoLoteria(persona.getLoteria())){return new SegundosLoteriaDTO(true, "No ha ganado la loteria");}
        return fechaService.calcularSegundosLoteria(persona.getLoteria());
    }

    //desde gradyacuib hasta matrimonio
    public GraduacionMatrimonioDTO obtenerGraduacionaMatrimonio(long id) {
        Persona persona = buscarPorId(id);
        if (persona == null){return new GraduacionMatrimonioDTO(false, "ID no encontrado");}
        if (!fechaService.tieneGraduacion(persona.getGraduacion())){return new GraduacionMatrimonioDTO(true, "No se ha graduado");}
        if (!fechaService.tieneMatrimonio(persona.getMatrimonio())){return new GraduacionMatrimonioDTO(true, "No se ha casado");}
        return fechaService.calcularGraduacionaMatrimonio(persona.getGraduacion(), persona.getMatrimonio());

    }

    //10 ado y 20 ago de los años bisiestos entre 1970 y 1985
    public NacidosBisiestoDTO obtenerNacidosBisiesto() {
        return fechaService.obtenerNacidosBisiesto(personas);
    }

    //menor mayor loteria
    public MayorMenorLoteriaDTO obtenerMayorMenorLoteria() {
        return fechaService.mayorMenorLoteria(personas);
    }

    //primer y ultimo loteria y minutos
    public PrimerUltimoLoteriaDTO obtenerPrimerUltimoLoteria() {
        return fechaService.minutosPrimerUltimoLoteria(personas);
    }

    public PrimerGanadorLoteriaDTO obtenerPrimerGanadorLoteria() {
        return fechaService.primerGanadorLoteria(personas);
    }
}
