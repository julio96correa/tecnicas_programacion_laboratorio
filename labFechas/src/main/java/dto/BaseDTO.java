package dto;

public class BaseDTO {
    private final boolean existe;

    public BaseDTO(boolean existe) {
        this.existe = existe;
    }

    public boolean isExiste() {
        return existe;
    }
}
