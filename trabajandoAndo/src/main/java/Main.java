import app.App;
import util.DataStore;

public class Main {
    public static void main(String[] args) {
        DataStore.cargarDatos();
        new App().run();
        DataStore.guardarDatos();
    }
}
