/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadoapp;

import java.util.Scanner;

/**
 *
 * @author miria
 */
public class AhorcadoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Ahorcado 2 jugadores
        Scanner s = new Scanner(System.in);
        

        System.out.println("Introduce nombre jugador 1: ");
        String n1 = s.nextLine();
        Jugador j1 = new Jugador(n1);

        System.out.println("Introduce nombre jugador 2: ");
        String n2 = s.nextLine();
        Jugador j2 = new Jugador(n2);

        // Al mejor de 4 partidas.
        // Primera partida
        // j1 empieza a jugar, j2 elige palabra a adivinar.
        Jugar partida1 = new Jugar(j1, j2);
        partida1.empezarPartida();
        // Segunda partida
        Jugar partida2 = new Jugar(j2, j1);
        partida2.empezarPartida();
        // Tercera partida
        Jugar partida3 = new Jugar(j1, j2);
        partida3.empezarPartida();
        // Cuarta partida
        Jugar partida4 = new Jugar(j2, j1);
        partida4.empezarPartida();
        
        // Resultados y ganador.
        if (j1.getVictorias() > j2.getVictorias()) {
            System.out.println("Ha ganado jugador " + j1.getNombre() + " con " + j1.getVictorias() + " victorias");

        } else if (j1.getVictorias() < j2.getVictorias()) {
            System.out.println("Ha ganado jugador " + j2.getNombre() + " con " + j2.getVictorias() + " victorias");

        }else{
            System.out.println("Empate");
        }
            

    }

}
