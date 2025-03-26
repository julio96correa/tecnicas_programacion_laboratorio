import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<Double> listaReales;
    Scanner entrada = new Scanner(System.in);  //refinable

    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Ingrese el número de la opción\n" +
                    "1. Ingresar datos. \n" +
                    "2. Borrar datos.\n" +
                    "3. Buscar datos.\n" +
                    "4. Imprimir.\n" +
                    "0. Salir.");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    ingresar();
                    break;
                case 2:
                    borrar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    imprimir();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }while(opcion!=0);
    }

    public void ingresar(){
        double dato;
        System.out.println("Ingrese el dato: ");
        dato = entrada.nextDouble();
        listaReales.add(dato);
    }

    public void borrar(){
        System.out.println("Ingrese el dato a borrar: ");
        double dato;
        dato = entrada.nextDouble();
        int indice;
        indice = listaReales.indexOf(dato);
        if (indice!=-1){
            System.out.println("Lo encontré en el indice " + indice);
            listaReales.remove(indice);
            System.out.println("Dato eliminado.");
        } else {
            System.out.println("No se puede borrar.");
        }

    }

    public void buscar(){
        System.out.println("Ingrese el dato a buscar");//Refactorizar
        double dato; //refactorizar
        dato = entrada.nextDouble();
        int indice;
        indice = listaReales.indexOf(dato);
        if(indice!=-1){
            System.out.println("Lo encontré en el indice " + indice);
        } else {
            System.out.println("No se encontró el dato");
        }
    }

    public void imprimir(){
        if (listaReales.isEmpty()){
            System.out.println("La lista está vacía: ");
        } else {
            System.out.println("Los datos del ArrayList son: ");
            for (Double dato : listaReales) {
                System.out.println(dato);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.listaReales = new ArrayList<>();
        main.menu();
    }
}