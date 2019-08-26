/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.letrasrepetidas;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *Esta clase compara los caracteres de la frase ingresada.
 * @author Duvan Poveda
 */
public class Frase {
    /**
    *Variable para el manejo de la entrada del teclado
    */
    private Scanner scanner = new Scanner(System.in);
    
    public Frase() {
    }
    /**
    *Este metodo se encarga de recibir la frase que el usuario ingresa
    * 
    */
    public void recibirFrase(){
        String frase;
        char[] caracteres= new char[50];
        System.out.println("Ingrese la frase: ");
        frase = scanner.nextLine();
        
        frase = frase.replace(" ","");
        caracteres = frase.toCharArray();
        char noSeRepite = caracteres[0];
        int indexNoSeRepite = 0;
        char[] noSeRepiten = new char[50];
        noSeRepiten[0] = noSeRepite;
        System.out.println("leyendo..." + caracteres[0]);
        System.out.println("La primera letra que no se repite es:" + caracteres[0]);
        dormir();
        compararLetras(caracteres,noSeRepite,noSeRepiten,indexNoSeRepite);
     
        
       
    }
    /**
    *Este metodo se encarga de comparar las letras y ver cuales no se repiten
    * @param caracteres array de los caracteres de la frase ingresada por el usuario
    * @param noSeRepite el char actual de la primera letra que no se repite
    * @param noSeRepiten array de chars de los caracteres que empezaron a repetirse
    * @param indexNoSeRepite posicion del array de chars de el caracter que no se repite actual
    */
    public void compararLetras(char[] caracteres,char noSeRepite,char[] noSeRepiten,int indexNoSeRepite){
            int error;
            for(int i=1; i<caracteres.length; i++){
                dormir();
                System.out.println("leyendo..." + caracteres[i]);
                if(caracteres[i] == noSeRepite||noSeRepite == '-'){
                    do{
                        error=0;
                        if(indexNoSeRepite == caracteres.length-1){
                             break;
                        }
                        if(indexNoSeRepite>=i){
                            System.out.println("No hay");
                            noSeRepite= '-';
                            indexNoSeRepite = i;
                            break;
                        }else{
                            noSeRepite = caracteres[indexNoSeRepite+1];
                            indexNoSeRepite = indexNoSeRepite+1;
                            for(int j=0; j<caracteres.length; j++){
                                if(noSeRepite == noSeRepiten[j]){
                                    error = 1;
                                }
                            }
                        }
                }while(error ==1);
            }
            noSeRepiten[i] = noSeRepite;
            System.out.println("la primera letra que no se repite es:" + noSeRepite);
        }
    }
    /**
    *Este metodo da un retraso de 2 segundos entre cada letra
    */
    public void dormir(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}