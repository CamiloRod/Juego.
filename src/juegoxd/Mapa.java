/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegoxd;

import java.util.Random;

/**
 *
 * @Camilo Rodríguez
 */
public class Mapa {
    char[][] matriz;
    int alto;
    int ancho;
    int armas;
    int vida;
    int jugadores;
    Arma claseArma;
    Limite claseLimite;
    Vida claseVida;
    Vacio claseVacio;
    public Mapa(int x, int y, int armas, int vida, int jugadores) {
        alto=x;
        ancho=y;
        this.jugadores=jugadores;
        claseVacio=new Vacio();
        claseArma=new Arma();
        claseLimite=new Limite();
        claseVida=new Vida();
        this.armas=armas;
        this.vida=vida;
        matriz=new char[x][y];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if(j==0 || i==0 || j==y-1 || i==x-1){
                    matriz[i][j]=claseLimite.decir();
                }
                else{
                    matriz[i][j]=claseVacio.decir();
                }
                
            }
        }
        Random var=new Random();
        for (int i = 0; i < this.armas; i++) {
            
            int dato1=var.nextInt(alto-1);
            int dato2=var.nextInt(ancho-1);
            if(isVacio(dato1, dato2)){
                matriz[dato1][dato2]=claseArma.decir();
            }
            else{
                i--;
            }
            
        }
        
        for (int i = 0; i < this.vida; i++) {
            
            int dato1=var.nextInt(alto-1);
            int dato2=var.nextInt(ancho-1);
            if(isVacio(dato1, dato2)){
                matriz[dato1][dato2]=claseVida.decir();
            }
            else{
                i--;
            }
        }
       
        for (int i = 1; i < this.jugadores+1; i++) {
            
            int dato1=var.nextInt(alto-1);
            int dato2=var.nextInt(ancho-1);
            if(isVacio(dato1, dato2)){
                matriz[dato1][dato2]= String.valueOf(i).charAt(0);
            }
            else{
                i--;
            }
        }
        
    }
    public boolean isVacio(int x, int y){
        if(matriz[x][y] == ' '){
            return true;
        }
        else{
            return false;
        }
    }
    public char[][] retornarMatriz(){
    
    
    return matriz;}    
}