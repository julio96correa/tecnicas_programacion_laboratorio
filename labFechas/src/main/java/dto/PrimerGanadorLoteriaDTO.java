package dto;

import model.Persona;

public class PrimerGanadorLoteriaDTO extends BaseDTO {
    private final Persona persona;

    public PrimerGanadorLoteriaDTO(boolean existe, Persona persona) {
        super(existe);
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }
}
