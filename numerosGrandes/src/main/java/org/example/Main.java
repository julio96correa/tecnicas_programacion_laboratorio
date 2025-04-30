package org.example;

import java.math.BigInteger;

public class Main {
    /**
     * Este metodo debe invocarse y tiene parámetros.
     * En este caso un vector llamado argumentos.
     */
    public static void main(String[] argumentos) {

        // Recibir los dos numeros
        // No vamos a realizar las validacion
        BigInteger numero1 = new BigInteger(argumentos[0]);
        BigInteger numero2 = new BigInteger(argumentos[1]);

        // Saber si son posibles primos
        System.out.println("El numero 1 = " + numero1 + " es primo? " + numero1.isProbablePrime(3));
        System.out.println("El numero 2 = " + numero2 + " es primo? " + numero2.isProbablePrime(3));

        // Sumar los dos numeros
        BigInteger numero3 = numero1.add(numero2);
        System.out.println("El numero 3 = " + numero3);
        System.out.println("El numero 3 = " + numero3 + " es primo? " + numero3.isProbablePrime(3));

        // Multiplicar los dos numeros
        numero3 = numero1.multiply(numero2);
        System.out.println("El numero 3 = " + numero3);
        System.out.println("El numero 3 = " + numero3 + " es primo? " + numero3.isProbablePrime(3));

        // Mostrar los resultados por pantalla

    }
}