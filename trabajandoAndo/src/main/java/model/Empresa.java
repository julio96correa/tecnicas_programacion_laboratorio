package model;

import java.util.List;

public class Empresa {

    private String nombre;
    private String emailCorporativo;
    private int id;

    public Empresa(String nombre, String emailCorporativo, int id){
        this.nombre = nombre;
        this.emailCorporativo = emailCorporativo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
