package dao;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import model.Persona;

public class PersonaDAO {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String csvFile = "src/main/java/archivo/fechas.csv";

    public DateTimeFormatter getFORMATTER() {
        return FORMATTER;
    }
    public List<Persona> leerCSV(){
        List<Persona> personas = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null){
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",", -1);
                Persona persona = new Persona(
                        Long.parseLong(datos[0]),
                        datos[1],
                        parseFecha(datos[2]),
                        parseFecha(datos[3]),
                        parseFecha(datos[4]),
                        parseFecha(datos[5]),
                        parseFecha(datos[6])
                );
                personas.add(persona);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return personas;
    }

    public void sobrescribirCSV(List<Persona> personas) {
        String linea;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            bw.write("id,nombre,nacimiento,graduacion,matrimonio,muerte,loteria");
            bw.newLine();

            for (Persona persona : personas) {
                bw.write(persona.serializarPersona(FORMATTER));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LocalDate parseFecha(String valor) {
        if (valor == null || valor.trim().isEmpty() || valor.equalsIgnoreCase("null")) {
            return null;
        }
        return LocalDate.parse(valor.trim(), FORMATTER);    }
}
