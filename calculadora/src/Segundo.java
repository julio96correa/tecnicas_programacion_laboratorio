import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Segundo {

    static int[] seguidores = {100, 100, 100, 100};
    static String[] bandas = {"Alcolirykoz", "MBZ", "V. del verso", "Original Juan"};

    public static void sumar(int i){
        seguidores[i]++;
    }

    public static void restar(int i){
        seguidores[i]--;
    }

    public static int leerInt(){
        int dato = 0;
        Scanner teclado= new Scanner(System.in);
        try
        {
            System.out.println ("ingrese un número entre 1 y 3");
            dato = teclado.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.err.println("Error al leer  el dato " + e.getMessage());
        }

        return dato;
    }

    public static String leerString(){
        String dato = "";
        Scanner teclado= new Scanner(System.in);
        try
        {
            dato = teclado.nextLine();
        }
        catch(InputMismatchException e)
        {
            System.err.println("Error al leer  el dato " + e.getMessage());
        }

        return dato;
    }

    public static double leerDouble(String mensaje){
        double dato = 0.0;
        Scanner teclado= new Scanner(System.in);
        try
        {
            System.out.println (mensaje);
            dato = teclado.nextDouble();
        }
        catch(InputMismatchException e) {
            System.err.println("Error al leer  el dato " + e.getMessage());
        }
        return dato;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
        System.out.println("¿Cuál es tu banda favorita: ");
        String favorita = "";
        System.out.println(Arrays.toString(bandas));
        favorita = leerString();
        System.out.println("Mi banda es " + favorita);
        System.out.println("------------------------");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Sumar seguidores");
        System.out.println("2. Restar seguidores");
        System.out.println("3. Salir");
        int opcion = 0;
        opcion = leerInt();

//        if (opcion == 1){
//            sumar(leerDouble("Ingrese la cantidad de seguidores a sumar: "));
//        }
//        if (opcion == 2){
//            restar(leerDouble("Ingrese la cantidad de seguidores a restar: "));
//        }
    }

}
