package dto;

import model.Persona;

public class MayorMenorLoteriaDTO {
    private final Persona mayor;
    private final Persona menor;

    public MayorMenorLoteriaDTO(Persona menor, Persona mayor) {
        this.menor = menor;
        this.mayor = mayor;
    }

    public Persona getMayor() {
        return mayor;
    }

    public Persona getMenor() {
        return menor;
    }
}
