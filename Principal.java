
package com.mycompany.juegoahorcado;

import java.util.Scanner;

public class Principal {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        int opcion ; 
        String Aleatorio=Aleatorio();
        var palabrasgion = Contador(Aleatorio);
        boolean juegoterminado = false;
        try(Scanner leer = new Scanner(System.in)){//leer letra del teclado
        int intentos = 10;
        try{ 
           do{
            
                System.out.println("**AHORCADO**"
                                    +"\n1.Jugar"
                                    +"\n2.Salir");
                opcion = in.nextInt();
                switch(opcion){
                    case 1 -> {
                        do{
                            System.out.println("Tienes " + intentos + " intentos.");//mostrar la cantida de intentos
                            System.out.println(palabrasgion);//mostar palabra en giones
                            System.out.println("Ingresa una letra: ");
                            char letra = leer.next().charAt(0);//leer la primera posicion de palabra o letra ingresada
                            boolean acierto = false;
                            for(int i=0;i<Aleatorio.length();i++){
                                if(Aleatorio.charAt(i)== letra){//comparar letra de palabra secreta con letra ingresada por usuario
                                  palabrasgion[i]= letra;
                                  acierto = true;//verdadero si acierta la letra
                                }
                                
                            }
                            if(!acierto){//si no aciertas
                               System.out.println("No has acertado");
                               --intentos;
                            }
                            if(intentos ==5){
                                System.out.println("PISTA: La palabra comienza por: "+ Aleatorio.charAt(0));
                            }
                            if(intentos==0){
                                  System.out.println("Perdiste, No tiene mas intentos");
                                  juegoterminado = true;
                            }
                            else{
                               boolean finjuego = !Gion(palabrasgion);//si hay giones no has ganado
                               if(finjuego){
                                  System.out.println(palabrasgion);
                                  System.out.println("***Felicidades Ganaste***");
                                  juegoterminado = true;
                                }
                            }
                        }while(!juegoterminado);
                    } 
                }
        }while(opcion !=2);
           }catch(Exception e){
                System.out.println("Error");
                   }
        leer.close();
        }
    }
    
    
    static String Aleatorio(){//Método, Generar palabras Aleaotorias
        String [] palabras = {"ingenieria","informatica","estructuras","autonoma","corporacion","mecatronica","netbeans","programacion","condicionales","administracion"};
        int numero = (int) Math.floor(Math.random() * palabras.length+1);//Generar numeros aleatorios
        return palabras[numero];// Retorna la Palabra Aleatoria
    } 
    
    static char[] Contador(String palabras){//Método, Cambiar letras por giones
        int cantidadpalabras = palabras.length();//sacar letras de Palabra secreta
        char [] palabrasgion = new char [cantidadpalabras];//creacion de array de letras
        for(int i=0;i<palabrasgion.length;i++){//recorrer letra por letra y
            palabrasgion[i] = '-';//cambio de letra por gion
        }
        return palabrasgion;//Retorna Palabra en giones
    } 
    
    static boolean Gion(char[] array){//recorrer array para ver si hay giones
        for(char letra:array){
            if(letra=='-')return true;
        }
        return false;//retorna si hay o no giones
    }
}