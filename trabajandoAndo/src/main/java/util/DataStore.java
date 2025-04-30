package util;

import model.*;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataStore {
    public static List<Freelance> freelancers;
    public static List<Empresa> empresas;
    public static List<Trabajo> trabajos;
    public static List<Postulacion> postulaciones;

    private static int idGenerico = 1;

    public static int generarId() {
        return idGenerico++;
    }

    public static void cargarDatos() {
        Type tipoFreelance = new TypeToken<List<Freelance>>() {}.getType();
        Type tipoEmpresa = new TypeToken<List<Empresa>>() {}.getType();
        Type tipoTrabajo = new TypeToken<List<Trabajo>>() {}.getType();
        Type tipoPostulacion = new TypeToken<List<Postulacion>>() {}.getType();

        freelancers = JsonUtil.cargar("freelancers.json", tipoFreelance);
        empresas = JsonUtil.cargar("empresas.json", tipoEmpresa);
        trabajos = JsonUtil.cargar("trabajos.json", tipoTrabajo);
        postulaciones = JsonUtil.cargar("postulaciones.json", tipoPostulacion);
    }

    public static void guardarDatos() {
        JsonUtil.guardar("freelancers.json", freelancers);
        JsonUtil.guardar("empresas.json", empresas);
        JsonUtil.guardar("trabajos.json", trabajos);
        JsonUtil.guardar("postulaciones.json", postulaciones);
    }
}
