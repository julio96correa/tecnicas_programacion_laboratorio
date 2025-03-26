/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author EstudianteLIS
 */
    import javax.sound.midi.Soundbank;
    import java.util.Scanner;

public class JavaApplication3 {

    public static int aleatorio(){
        return (int) (Math.random() * 11);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String[] equipo1 = new String[5];
        String[] equipo2 = new String[5];
        Scanner entrada = new Scanner(System.in);
        int contador1 = 0;
        int contador2 =0;
        int contadorDias1 = 0;
        int contadorDias2 = 0;
        
        for (int i=0; i<5; i++){
            System.out.println("Equipo 1");
            System.out.println("Ingrese el nombre: ");
            equipo1[i] = entrada.nextLine();
        }
        
         for (int i=0; i<5; i++){
            System.out.println("Equipo 2");
            System.out.println("Ingrese el nombre: ");
            equipo2[i] = entrada.nextLine();
        }

           int ataque1;
        int ataque2;
        //Pelear
        for (int j=0; j<7; j++) {
            System.out.printf("------ Día " + (j + 1) + " ------");
            for (int i = 0; i < 5; i++) {
                System.out.println(equipo1[i] + " VS " + equipo2[i]);
                ataque1 = aleatorio();
                ataque2 = aleatorio();

                System.out.println(equipo1[i] + " ataca con " + ataque1 + ", mientras que " + equipo2[i] + "ataca con " + ataque2);
                if (ataque1 == ataque2) {
                    System.out.println("Empate. 0 Puntos para c/u");
                } else if (ataque1 > ataque2) {
                    System.out.println("Gana " + equipo1[i] + " " + ataque1 + " puntos");
                    contador1 += ataque1;
                } else {
                    System.out.println("Gana " + equipo2[i] + " " + ataque2 + " puntos");
                    contador2 += ataque2;
                }
                System.out.println("-------------------");
            }

            System.out.println("-------------------------");
            if (contador1 == contador2) {
                System.out.println("La pelea ha finalizado en empate.");
            } else if (contador1 > contador2) {
                System.out.println("Gana el equipo 1");
                contadorDias1++;     //toString
            } else {
                System.out.println("Gana el equipo 2");
                //tostring
                contadorDias2++;
            }
            System.out.println("-------------------------");
            System.out.println("Resultados de la semana");
            System.out.println("El equipo 1 ha ganado " + contadorDias1 + " batalla(s)" );
            System.out.println("El equipo 2 ha ganado " + contadorDias2 + " batalla(s)" );

        }
    }
}