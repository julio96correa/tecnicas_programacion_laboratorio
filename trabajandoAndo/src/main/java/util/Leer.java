package util;

import java.util.Scanner;

public class Leer {

    private static final Scanner scanner = new Scanner(System.in);

    public static int entero(String mensaje) {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }

        return numero;
    }
}
