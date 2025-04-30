package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new Gson();

    public static <T> void guardar(String archivo, List<T> lista) {
        try (Writer writer = new FileWriter("data/" + archivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar " + archivo + ": " + e.getMessage());
        }
    }

    public static <T> List<T> cargar(String archivo, Type tipo) {
        try (Reader reader = new FileReader("data/" + archivo)) {
            return gson.fromJson(reader, tipo);
        } catch (IOException e) {
            System.out.println("Archivo " + archivo + " no encontrado o vacío.");
            return new java.util.ArrayList<>();
        }
    }
}
