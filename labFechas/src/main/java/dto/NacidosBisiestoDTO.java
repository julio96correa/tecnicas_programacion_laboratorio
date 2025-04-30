package dto;

import model.Persona;
import java.util.List;

public class NacidosBisiestoDTO {
    private final List<Persona> personas;
    private final String contador;

    public NacidosBisiestoDTO(List<Persona> personas, String contador) {
        this.personas = personas;
        this.contador = contador;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public String getContador() {
        return contador;
    }

}
