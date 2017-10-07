/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoxd;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Juegoxd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int x=leer.nextInt();
        int y=leer.nextInt();
        int armas=leer.nextInt();
        int vidas=leer.nextInt();
        int jugadores=leer.nextInt();
        Mapa map=new Mapa(x, y, armas, vidas, jugadores);
        char[][] mas=map.retornarMatriz();
        for (int i = 0; i < map.alto; i++) {
            for (int j = 0; j < map.ancho; j++) {
                System.out.print(mas[i][j]);
            }
            System.out.println("");
        }
    }
    
}
