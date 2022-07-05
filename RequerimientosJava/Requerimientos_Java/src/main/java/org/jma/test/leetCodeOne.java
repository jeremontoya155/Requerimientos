
package org.jma.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class leetCodeOne {
    
    /*
    
    Given an integer n, return a string array answer (1-indexed) where:
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
    
    
    Input: n = 3
    Output: ["1","2","Fizz"]
    
    Input: n = 5
    Output: ["1","2","Fizz","4","Buzz"]
    */
    
    public static void main(String[] args) {
        
        //Almaceno el resultado pero previamente lo muestro para cualquier uso
        List<String> retorno=controlIngreso();
        
    }
    
    
    public static List<String> controlIngreso(){
    
        int numero=cargarNumero("Ingrese el numero para el tamaño de la lista que se devolvera");
        List<String> lista= new ArrayList<>();
        
        //Los ejemplos inician del uno por eso respeto eso para el indice
        for (int i = 1; i <numero ; i++) {
            
            if (((i%3)==0) && (i%5)==0) {
                
                lista.add("FizzBuzz");
                
            }else if(((i%3)==0) && (i%5)!=0){
            
                lista.add("Fizz");
            
            }else if(((i%3)!=0) && (i%5)==0){
            
                lista.add("Buzz");
            
            }else{
            
                
                lista.add(String.valueOf(i));
            
            }
            
        }
        
        lista.forEach(System.out::println);
        
        return lista;
    
    }
    
        public static int cargarNumero(String texto){
    
        int retorno=-1;
        Boolean ban =true;
        
        while(ban){
            try {
                
                 Scanner sn=new Scanner(System.in);
                 System.out.println(texto);
                 retorno=sn.nextInt();
                 //Agrego condicion porque no vi caso donde no cargaran nada
                 if (retorno>-1) {
                     return retorno;
                }else{
                     System.out.println("Numero ingresado valor negativo");}
                 
                
            } catch (InputMismatchException e) {
                
                System.out.println("Ingreso erroneo");
                e.printStackTrace(System.out);
                
                
                
            }
        
        }
       
       
        
        return retorno;
    
    }
    
}

