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
    int armaD;
    int armaC;
    int vida;
    int jugadores;
    int refugio;
    ArmaD claseArmaD;
    ArmaC claseArmaC;
    Limite claseLimite;
    Vida claseVida;
    Vacio claseVacio;
    Refugio claseRefugio;
    Jugadores claseJugadores;
    public Mapa(int x, int y, int armaD,int armaC,int refugio, int vida, int jugadores) {
        alto=x;
        ancho=y;
        this.jugadores=jugadores;
        claseVacio=new Vacio();
        claseArmaD=new ArmaD();
        claseArmaC=new ArmaC();
        claseLimite=new Limite();
        claseVida=new Vida();
        claseRefugio=new Refugio();
        claseJugadores=new Jugadores();
        this.armaD=armaD;
        this.armaC=armaC;
        this.vida=vida;
        this.refugio=refugio;
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
        for (int i = 0; i < this.armaD; i++) {
            
            int dato1=var.nextInt(alto-1);
            int dato2=var.nextInt(ancho-1);
            if(isVacio(dato1, dato2)){
                matriz[dato1][dato2]=claseArmaD.decir();
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
                if(i%2==0){
                matriz[dato1][dato2]= String.valueOf(i).charAt(0);
             }else{
                    matriz[dato1][dato2]= claseJugadores.decir();
                }
            }
            else{
                i--;
            }
        }
          Random vari=new Random();
        for (int i = 0; i < this.refugio; i++) {
            
            int dato1=vari.nextInt(alto-1);
            int dato2=vari.nextInt(ancho-1);
            if(isVacio(dato1, dato2)){
                matriz[dato1][dato2]=claseRefugio.decir();
            }
            else{
                i--;
            }
            
        }
        Random va=new Random();
        for (int i = 0; i < this.armaC; i++) {
            
            int dato1=va.nextInt(alto-1);
            int dato2=va.nextInt(ancho-1);
            if(isVacio(dato1, dato2)){
                matriz[dato1][dato2]=claseArmaC.decir();
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
