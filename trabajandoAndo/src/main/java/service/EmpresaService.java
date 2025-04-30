package service;

import model.Empresa;
import util.DataStore;

import java.util.ArrayList;
import java.util.List;

public class EmpresaService {
    private final List<Empresa> empresas;
    private final String FILE_PATH = "data/empresas.json";

    public EmpresaService() {
        this.empresas = DataStore.load(FILE_PATH, Empresa[].class);
    }

    public void agregar(Empresa e) {
        empresas.add(e);
        guardar();
    }

    public List<Empresa> listar() {
        return empresas;
    }

    public Empresa buscarPorId(int id) {
        return empresas.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private void guardar() {
        DataStore.save(FILE_PATH, empresas);
    }
}
