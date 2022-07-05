
package org.jma.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class leetCodeFour {
    
    /*
    
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    
    Input: nums = [1,2,3,1]
Output: true
    
    Input: nums = [1,2,3,4]
Output: false
    
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
    
    */
    
    public static void main(String[] args) {
        
        System.out.println(resolucionCuatro());
    }
    
    public static boolean resolucionCuatro(){
    
        //DEJO COMENTADO CASO PARA ERROR O PRUEBA DINAMICA
        //int[] array=cargarArray();
        
        //int[] array={1,2,3,4,5,6,5,6,7};
        
        int[] array={1,2,3,4,5,6};
        boolean ban=true;
        int cont=0;
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            for (int k = 0; k < array.length; k++) {
                //Si llega a este punto es porque encuentra una concidencia
                if (j==array[k]) {
                    cont++;
                    //Reviso que el contador sea mayor a uno porque si o si una coincidencia va a tener debido a que se encuetra una vez a el mismo
                    if (cont>1) {
                        
                        return false;
                    }
                    }
                    
                }
            //reinicio el contador
            cont=0;
                
            }
        
        return ban;
        }
        
        
    


    
    public static int[] cargarArray(){
    
        int cantidad=cargarNumero("Ingrese el numero que desee para el largo del array");
        String texto;
        int[] array=new int[cantidad];
        
        for (int i = 0; i < array.length; i++) {
            texto="Ingrese el numero que desea para la posicion:"+i;
            array[i]=cargarNumero(texto);
            
        }
        
        return array;
        
    
    }   
    
      public static int cargarNumero(String texto){
    
        int retorno=-1;
        Boolean ban =true;
        
        while(ban){
            try {
                
                 Scanner sn=new Scanner(System.in);
                 System.out.println(texto);
                 retorno=sn.nextInt();
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

