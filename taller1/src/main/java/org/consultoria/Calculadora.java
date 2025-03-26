package org.consultoria;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que representa una calculadora básica con distintas operaciones.
 * Permite realizar operaciones aritméticas, relacionales, de bits, booleanas,
 * incrementales y evaluar la prioridad entre operadores.
 *
 * @author Julio Correa
 * @version 1.0
 */
public class Calculadora {
    /** Scanner para la entrada de datos del usuario. */
    private static final Scanner entrada = new Scanner(System.in);

    /**
     * Método principal que ejecuta el menú de la calculadora.
     * Permite al usuario elegir diferentes tipos de operaciones.
     */
    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = leerEntero();
            if (opcion == 7) break;
            procesarOpcion(opcion);
        }
        System.out.println("Chaito.");
    }

    /**
     * Muestra el menú de opciones disponibles en la calculadora.
     */
    private static void mostrarMenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Seleccione el tipo de operador:");
        System.out.println("1. Operadores Aritméticos");
        System.out.println("2. Operadores Relacionales");
        System.out.println("3. Operadores de Bits");
        System.out.println("4. Operadores Booleanos");
        System.out.println("5. Operadores Incrementales y Aritméticos combinados");
        System.out.println("6. Prioridad entre operadores");
        System.out.println("7. Salir");
    }

    /**
     * Lee un número entero ingresado por el usuario.
     *
     * @return El número entero ingresado.
     */
    private static int leerEntero() {
        int numero = 0;
        while (true) {
            try {
                numero = entrada.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese un número entero:");
                entrada.next();
            }
        }
        return numero;
    }

    /**
     * Lee un valor booleano ingresado por el usuario.
     *
     * @return El valor booleano ingresado.
     */
    private static boolean leerBooleano() {
        while (true) {
            try {
                return entrada.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese 'true' o 'false':");
                entrada.next();
            }
        }
    }

    /**
     * Procesa la opción seleccionada por el usuario y ejecuta la operación correspondiente.
     *
     * @param opcion La opción seleccionada en el menú.
     */
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: operadoresAritmeticos(); break;
            case 2: operadoresRelacionales(); break;
            case 3: operadoresBits(); break;
            case 4: operadoresBooleanos(); break;
            case 5: operadoresIncrementales(); break;
            case 6: prioridadOperadores(); break;
            default: System.out.println("Opción no válida");
        }
    }

    /**
     * Realiza operaciones aritméticas básicas entre dos números enteros.
     */
    private static void operadoresAritmeticos() {
        System.out.print("Ingrese dos números enteros: ");
        int a = leerEntero();
        int b = leerEntero();
        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicación: " + (a * b));
        System.out.println("División: " + (a / (double)b));
    }

    /**
     * Realiza comparaciones relacionales entre dos números enteros.
     */
    private static void operadoresRelacionales() {
        System.out.print("Ingrese dos números enteros: ");
        int a = leerEntero();
        int b = leerEntero();
        System.out.println("¿Es mayor " + a + " que " + b + " ? " +(a > b));
        System.out.println("¿Es menor " + a + " que " + b + " ? " + (a < b));
        System.out.println("¿Son iguales? " + (a == b));
    }

    /**
     * Realiza operaciones de bits entre dos números enteros.
     */
    private static void operadoresBits() {
        System.out.print("Ingrese dos números enteros: ");
        int a = leerEntero();
        int b = leerEntero();
        System.out.println("AND bit a bit: " + (a & b));
        System.out.println("OR bit a bit: " + (a | b));
        System.out.println("XOR bit a bit: " + (a ^ b));
        System.out.println("Desplazamiento izquierda a << 1: " + (a << 1));
        System.out.println("Desplazamiento derecha a >> 1: " + (a >> 1));
        System.out.println("Ejemplo de uso de XOR, se intercambiarán a y b");
        System.out.println("Los numeros son a=" + a + " y b=" + b);
        a = a ^ b;
        System.out.println("Se guarda el estado en a, a = a ^ b. Ahora a es " + a);
        b = a ^ b;
        System.out.println("Se recupera el valor de a y se guarda en b, b = a ^ b. Ahora b es " + b);
        a = a ^ b;
        System.out.println("Se recupera el valor del b inicial y se gurade en a,  a = a ^ b. Ahora a es " + a);
        System.out.println("Sirve solo para números enteros. No es necesario crear una tercera variable auxiliar. Puede usarse con más de dos variables");
    }

    /**
     * Realiza operaciones booleanas entre dos valores ingresados por el usuario.
     */
    private static void operadoresBooleanos() {
        System.out.print("Ingrese dos valores booleanos (true/false): ");
        boolean a = leerBooleano();
        boolean b = leerBooleano();
        System.out.println("AND lógico: " + (a && b));
        System.out.println("OR lógico: " + (a || b));
    }

    /**
     * Muestra ejemplos de operadores incrementales y combinados.
     */
    private static void operadoresIncrementales() {
        System.out.print("Ingrese un número: ");
        int a = leerEntero();
        System.out.println("Valor inicial: " + a);
        System.out.println("Post-incremento (a++): " + (a++));
        System.out.println("Después del incremento: " + a);
        System.out.println("Pre-incremento (++a): " + (++a));
        System.out.println("Suma acumulada (a += 5): " + (a += 5));
        System.out.println("El post-incrmento primero devuelve el valor actual y luego le suma 1");
        System.out.println("El pre-incremento suma 1 antes de devolver el valor.");
        System.out.println("Funciona de igual manera para a-- y --a, este decrementa una unidad");
        System.out.println("La suma acumulada a+=5 es lo mismo que decir a = a + 5");
    }

    /**
     * Muestra la prioridad entre operadores aritméticos.
     */
    private static void prioridadOperadores() {
        System.out.println("Ejemplo de prioridad de operadores aritméticos:");
        int total = 10 + 4 * 9 + 3;
        System.out.println("Se realizará: 10 + 4 * 9 + 3");
        System.out.println("Total: " + total);
        String[][] tabla = {
                {"Prioridad", "Operadores", "Asociatividad"},
                {"1 (Mayor)", "() (paréntesis), [] (arrays), . (acceso a miembros)", "Izquierda a derecha"},
                {"2", "++ (post-incremento), -- (post-decremento)", "Izquierda a derecha"},
                {"3", "++ (pre-incremento), -- (pre-decremento), + - (unarios), ~ (NOT bit a bit), ! (NOT lógico)", "Derecha a izquierda"},
                {"4", "* / % (multiplicación, división, módulo)", "Izquierda a derecha"},
                {"5", "+ - (suma y resta)", "Izquierda a derecha"},
                {"6", "<< >> >>> (desplazamiento de bits)", "Izquierda a derecha"},
                {"7", "< <= > >= (comparaciones)", "Izquierda a derecha"},
                {"8", "== != (igualdad y desigualdad)", "Izquierda a derecha"},
                {"9", "& (AND bit a bit)", "Izquierda a derecha"},
                {"10", "^ (XOR bit a bit)", "Izquierda a derecha"},
                {"11", "| (OR bit a bit)", "Izquierda a derecha"},
                {"12", "&& (AND lógico)", "Izquierda a derecha"},
                {"13", "|| (OR lógico)", "Izquierda a derecha"},
                {"14", "? : (operador ternario)", "Derecha a izquierda"},
                {"15", "= += -= *= /= %= &= |= ^= <<= >>= >>>= (asignaciones)", "Derecha a izquierda"},
                {"16 (Menor)", ", (coma, separador de expresiones)", "Izquierda a derecha"}
        };

        for (String[] fila : tabla) {
            System.out.printf("%-12s | %-60s | %-20s%n", fila[0], fila[1], fila[2]);
        }
    }
}
