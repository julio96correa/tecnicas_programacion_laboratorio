package service;

import model.Empresa;
import model.Trabajo;
import util.DataStore;

import java.util.ArrayList;
import java.util.List;

public class TrabajoService {
    private final List<Trabajo> trabajos;
    private final String FILE_PATH = "data/trabajos.json";

    public TrabajoService() {
        this.trabajos = DataStore.load(FILE_PATH, Trabajo[].class);
    }

    public void agregar(Trabajo trabajo) {
        trabajos.add(trabajo);
        guardar();
    }

    public List<Trabajo> listar() {
        return trabajos;
    }

    public List<Trabajo> listarPorEmpresa(Empresa empresa) {
        List<Trabajo> result = new ArrayList<>();
        for (Trabajo t : trabajos) {
            if (t.getEmpresa().getId() == empresa.getId()) {
                result.add(t);
            }
        }
        return result;
    }

    public Trabajo buscarPorIndice(int indice) {
        if (indice >= 0 && indice < trabajos.size()) {
            return trabajos.get(indice);
        }
        return null;
    }

    private void guardar() {
        DataStore.save(FILE_PATH, trabajos);
    }
}
