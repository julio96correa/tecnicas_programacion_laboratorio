package dto;

public class SegundosLoteriaDTO extends BaseDTO{
    private final String segundos;

    public SegundosLoteriaDTO(boolean existe, String segundos) {
        super(existe);
        this.segundos = segundos;
    }

    public String getSegundos() {
        return segundos;
    }
}
