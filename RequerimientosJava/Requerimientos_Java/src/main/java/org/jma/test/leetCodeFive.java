
package org.jma.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class leetCodeFive {
    
    /*
    
    The Fibonacci numbers, commonly denoted F(n) form a sequence,
    called the Fibonacci sequence, such that each number is the sum of 
    the two preceding ones, starting from 0 and 1. That is,
    
    
    F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
    
    Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    
    
    Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    
    Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
    
    */
    
    public static void main(String[] args) {
        
        int n= cargarNumero("Ingrese la longitud");
        
        System.out.println(resolucionCinco(n));
    }
    
    
    public static int resolucionCinco(int n){

        if (n == 0 || n == 1) {

            if (n == 0) {

                return 0;
            } else {
                return 1;
            }
        } else if (n > 1) {
            return resolucionCinco(n - 1) + resolucionCinco(n - 2);
        } //Por la recursividad evito el caso del valor negativo quitandolo de mi carga
        else {

            return -1;
        }
}
    
          public static int cargarNumero(String texto){
    
        int retorno=-1;
        Boolean ban =true;
        
        while(ban){
            try {
                
                 Scanner sn=new Scanner(System.in);
                 System.out.println(texto);
                 retorno=sn.nextInt();
                 return retorno;
                
            } catch (InputMismatchException e) {
                
                System.out.println("Ingreso erroneo");
                e.printStackTrace(System.out);
                
                
                
            }
        
        }
       
       
        
        return retorno;
    
    }
}
