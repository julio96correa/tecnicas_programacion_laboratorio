package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    private long id;
    private String nombre;
    private LocalDate nacimiento;
    private LocalDate graduacion;
    private LocalDate matrimonio;
    private LocalDate muerte;
    private LocalDate loteria;

    public Persona(long id, String nombre, LocalDate nacimiento, LocalDate graduacion, LocalDate matrimonio, LocalDate muerte, LocalDate loteria) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.graduacion = graduacion;
        this.matrimonio = matrimonio;
        this.muerte = muerte;
        this.loteria = loteria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public LocalDate getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(LocalDate graduacion) {
        this.graduacion = graduacion;
    }

    public LocalDate getMatrimonio() {
        return matrimonio;
    }

    public void setMatrimonio(LocalDate matrimonio) {
        this.matrimonio = matrimonio;
    }

    public LocalDate getMuerte() {
        return muerte;
    }

    public void setMuerte(LocalDate muerte) {
        this.muerte = muerte;
    }

    public LocalDate getLoteria() {
        return loteria;
    }

    public void setLoteria(LocalDate loteria) {
        this.loteria = loteria;
    }
    @Override
    public String toString() {
        return "Persona {" +
                "ID = " + id +
                ", Nombre = '" + nombre + '\'' +
                ", Nacimiento = " + formatDate(nacimiento) +
                ", Graduación = " + formatDate(graduacion) +
                ", Matrimonio = " + formatDate(matrimonio) +
                ", Muerte = " + formatDate(muerte) +
                ", Lotería = " + formatDate(loteria) +
                '}';
    }


    private String formatDate(LocalDate fecha) {
        return (fecha != null) ? fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
    }

    public String serializarPersona(DateTimeFormatter FORMATTER){
        return String.format(
                "%d, %s, %s, %s, %s, %s, %s",
                this.getId(),
                this.getNombre(),
                this.getNacimiento().format(FORMATTER),
                this.getGraduacion() != null ? this.getGraduacion().format(FORMATTER) : "",
                this.getMatrimonio() != null ? this.getMatrimonio().format(FORMATTER) : "",
                this.getMuerte() != null ? this.getMuerte().format(FORMATTER) : "",
                this.getLoteria() != null ? this.getLoteria().format(FORMATTER) : ""
        );

    }
}
