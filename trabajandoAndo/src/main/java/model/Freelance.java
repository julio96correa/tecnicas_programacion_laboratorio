package model;

public class Freelance {
    private int id;
    private String nombre;
    private String email;
    private String[] lenguajes;
    private double precioHora;
    private int nivelAcademico;
    private int experiencia;
    private String[] idiomas;

    public Freelance(int id, String nombre, String email, String[] lenguajes, double precioHora, int nivelAcademico, int experiencia, String[] idiomas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.lenguajes = lenguajes;
        this.precioHora = precioHora;
        this.nivelAcademico = nivelAcademico;
        this.experiencia = experiencia;
        this.idiomas = idiomas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String[] lenguajes) {
        this.lenguajes = lenguajes;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public int getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(int nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }
}
