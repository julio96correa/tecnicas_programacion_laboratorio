package dto;

public class AnhosCasadoDTO extends BaseDTO {
    private final String anhos;

    public AnhosCasadoDTO(boolean existe, String anhos) {
        super(existe);
        this.anhos = anhos;
    }

    public String getAnhos() {
        return anhos;
    }
}