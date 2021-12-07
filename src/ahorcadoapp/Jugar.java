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
public class Jugar {

    private int intentos = 5;
    Jugador j1, j2;

    public Jugar(Jugador j1, Jugador j2) {

        this.j1 = j1;
        this.j2 = j2;
    }

    public void empezarPartida() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Jugador " + j2.getNombre() + " Introduzca palabra a adivinar: ");
        String palabraSecreta = sc.nextLine();
        boolean acertado = false;

        char[] guionesPalabra = new char[palabraSecreta.length()];

        for (int i = 0; i < guionesPalabra.length; i++) {
            guionesPalabra[i] = '-';
        }

        //System.out.println(guionesPalabra);
        System.out.println("Jugador " + j1.getNombre() + " intente adivinar la palabra");

        while (!acertado && intentos > 0) {

            for (int i = 0; i < guionesPalabra.length; i++) {

                System.out.print(guionesPalabra[i]);
            }

            System.out.println(" ");

            System.out.println("Introduzca una letra");
            char letra = sc.next().charAt(0);
            boolean encontrado = false;
            for (int i = 0; i < guionesPalabra.length; i++) {

                if (palabraSecreta.charAt(i) == letra) {
                    guionesPalabra[i] = letra;
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("La palabra no contiene esa letra");
                intentos--;
                System.out.println("Te quedan " + intentos + " intentos");

            } else {

                boolean noGuiones = true;
                for (int i = 0; i < guionesPalabra.length; i++) {
                    if (guionesPalabra[i] == '-') {
                        noGuiones = false;
                    }
                }

                if (noGuiones) {
                    acertado = true;
                }
            }

        }

        if (acertado) {
            System.out.println("Acertaste la palabra");
            this.j1.setVictorias(this.j1.getVictorias() + 1);
        } else {
            System.out.println("Lo siento, has perdido");
            System.out.println("La palabra secreta era " + palabraSecreta);

            this.j2.setVictorias(this.j2.getVictorias() + 1);
        }

    }
}
