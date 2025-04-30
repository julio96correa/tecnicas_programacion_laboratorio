package dto;

public class GraduacionMatrimonioDTO extends BaseDTO {
    private final String dias;

    public GraduacionMatrimonioDTO(boolean existe, String dias) {
        super(existe);
        this.dias = dias;
    }

    public String getDias() {
        return dias;
    }
}