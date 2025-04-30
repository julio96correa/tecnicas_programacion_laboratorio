package dto;

import model.Persona;

public class PrimerUltimoLoteriaDTO {
    private final Persona primero;
    private final Persona segundo;
    private final long minutos;

    public PrimerUltimoLoteriaDTO(Persona primero, Persona segundo, long minutos) {
        this.primero = primero;
        this.segundo = segundo;
        this.minutos = minutos;
    }

    public Persona getPrimero() {
        return primero;
    }

    public Persona getSegundo() {
        return segundo;
    }

    public long getMinutos() {
        return minutos;
    }
}
