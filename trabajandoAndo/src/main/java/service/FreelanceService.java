package service;

import model.Freelance;
import util.DataStore;

import java.util.ArrayList;
import java.util.List;

public class FreelanceService {
    private final List<Freelance> freelances;
    private final String FILE_PATH = "data/freelances.json";

    public FreelanceService() {
        this.freelances = DataStore.load(FILE_PATH, Freelance[].class);
    }

    public void agregar(Freelance f) {
        freelances.add(f);
        guardar();
    }

    public List<Freelance> listar() {
        return freelances;
    }

    public Freelance buscarPorId(int id) {
        return freelances.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private void guardar() {
        DataStore.save(FILE_PATH, freelances);
    }
}
