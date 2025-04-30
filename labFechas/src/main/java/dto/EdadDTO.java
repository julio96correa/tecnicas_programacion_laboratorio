package dto;

public class EdadDTO extends BaseDTO{
    private final String edad;

    public EdadDTO(boolean existe, String edad) {
        super(existe);
        this.edad = edad;
    }

 public String getEdad() {
        return edad;
    }
}