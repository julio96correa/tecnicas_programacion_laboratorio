package service;

import model.Persona;
import dto.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FechaService {

    public EdadDTO calcularEdad(LocalDate fechaNacimiento) {
        String edad = String.valueOf(Period.between(fechaNacimiento, LocalDate.now()).getYears());
        return new EdadDTO(true, edad);
    }

    public boolean tieneNacimiento(LocalDate fechaNacimiento) {
        return fechaNacimiento != null;
    }

    //años casado
    public AnhosCasadoDTO calcularAnhosCasado(LocalDate fechaMatrimonio) {
        String anhos = String.valueOf(Period.between(fechaMatrimonio, LocalDate.now()).getYears());
        return new AnhosCasadoDTO(true, anhos);
    }

    //segundos vivo dsde loteria
    public SegundosLoteriaDTO calcularSegundosLoteria(LocalDate fechaLoteria) {
        String segundos = String.valueOf(Math.abs(Duration.between(fechaLoteria.atStartOfDay(), LocalDateTime.now()).getSeconds()));
        return new SegundosLoteriaDTO(true, segundos);
    }

    public static boolean haGanadoLoteria(LocalDate fechaLoteria) {
        return fechaLoteria != null;
    }

    //desde gradyacuib hasta matrimonio
    public GraduacionMatrimonioDTO calcularGraduacionaMatrimonio(LocalDate fechaGraduacion, LocalDate fechaMatrimonio) {
        String dias = String.valueOf(Math.abs(ChronoUnit.DAYS.between(fechaGraduacion, fechaMatrimonio)));
        return new GraduacionMatrimonioDTO(true, dias);
    }

    public boolean tieneGraduacion(LocalDate fechaGraduacion) {
        return fechaGraduacion != null;
    }

    public boolean tieneMatrimonio(LocalDate fechaMatrimonio) {
        return fechaMatrimonio != null;
    }

    //10 ado y 20 ago de los años bisiestos entre 1970 y 1985
    public NacidosBisiestoDTO obtenerNacidosBisiesto(List<Persona> personas) {
        int contador = 0;
        List<Persona> personasBisiesto = new ArrayList<>();
        for (Persona persona : personas) {
            if (!tieneNacimiento(persona.getNacimiento())){continue;}
            int anho = persona.getNacimiento().getYear();
            int mes = persona.getNacimiento().getMonthValue();
            int dia = persona.getNacimiento().getDayOfMonth();

            if ((anho == 1980 || anho == 1984) && mes == 8 && dia >= 10 && dia <= 20) {
                contador++;
                personasBisiesto.add(persona);
            }
        }
        if (personasBisiesto.size() == 0){return new NacidosBisiestoDTO(null, "No hay personas que hayan nacido entre el 10 y 20 de agosto de los años 1980 y 1984.");}
        return new NacidosBisiestoDTO(personas, String.valueOf(contador));
    }

    //mayor y menor loteria
    public MayorMenorLoteriaDTO mayorMenorLoteria(List<Persona> personas) {
        Persona mayor = null;
        Persona menor = null;

        for (Persona persona : personas) {

            if (persona.getLoteria() == null || !tieneNacimiento(persona.getNacimiento())) {
                continue;
            }

            if (FechaService.esMayor((Persona) persona, (Persona) mayor)) {
                mayor = persona;
            }

            if (FechaService.esMenor((Persona) persona, (Persona) menor)) {
                menor = persona;
            }
        }
        return new MayorMenorLoteriaDTO(menor, mayor);
    }

    public static boolean esMayor(Persona persona, Persona mayor) {
        if (mayor == null || persona.getNacimiento().isBefore(mayor.getNacimiento())) {
            return true;
        }
        return false;
    }

    public static boolean esMenor(Persona persona, Persona menor) {
        if (menor == null || persona.getNacimiento().isAfter(menor.getNacimiento())) {
            return true;
        }
        return false;
    }

    public PrimerUltimoLoteriaDTO minutosPrimerUltimoLoteria(List<Persona> personas) {

        Persona primero = FechaService.primerGanadorLoteria(personas).getPersona();
        Persona segundo = FechaService.ultimoGanadorLoteria(personas);
        long minutos = ChronoUnit.MINUTES.between(primero.getLoteria().atStartOfDay(), segundo.getLoteria().atStartOfDay());
        return new PrimerUltimoLoteriaDTO(primero, segundo, minutos);
    }

    public static PrimerGanadorLoteriaDTO primerGanadorLoteria(List<Persona> personas){
        Persona primero = null;
        for (Persona persona : personas) {
            if (!haGanadoLoteria(persona.getLoteria())){continue;}
            if (primero == null || persona.getLoteria().isBefore(primero.getLoteria())) {primero = persona;}
        }
        if (primero == null){return new PrimerGanadorLoteriaDTO(false, null);}
        return new PrimerGanadorLoteriaDTO(true, primero);
    }

    public static Persona ultimoGanadorLoteria(List<Persona> personas){
        Persona ultimo = null;
        for (Persona persona : personas) {
            if (persona.getLoteria() == null) {continue;}
            if (ultimo == null || persona.getLoteria().isAfter(ultimo.getLoteria())) {ultimo = persona;}
        }
        System.out.println("el ultimo es " + ultimo.toString());
        return ultimo;
    }
}