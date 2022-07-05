
package org.jma.test;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class leetCodeTwo {
    /*
    
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    
    Input: nums = [3,3], target = 6
    Output: [0,1]
    */
    public static void main(String[] args) {
        
//        Caso de querer probar de  manera dinamica
//        int cantidadElementos=cargarNumero("Ingrese la longitud que quiere para su array");
//        
//        int[] arrayGenerico=new int[cantidadElementos];
//        
//        cargarArray(arrayGenerico);
//          int target=cargarNumero("Ingrese un numero para el target");  
//          int[] devolucion=resolucionDos(arrayGenerico,target);  
//            for (int i = 0; i < devolucion.length; i++) {
//                
//                    int j=devolucion[i];
//                    System.out.println(j);
//            
//        }
        
//        Ejemplo estatico pero dejo codigo por si quieren cargar un array para mas pruebas 
        int[] agregar={5,2,1,4,3};
        int[] respuesta=resolucionDos(agregar,8);
        
        for (int i = 0; i < respuesta.length; i++) {
            int j = respuesta[i];
            
            
            System.out.println("Posicion de la solucion:"+j);}
        

        
    }
    
    public static int[] resolucionDos(int[] array, int target) 
    {
        int[] retorno=new int[2];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<array.length;i++)
        {
            if(hm.containsKey(target-array[i]))
            {
                
                retorno[0]=i;
                retorno[1]=hm.get(target-array[i]);
                return retorno;
            }
            hm.put(array[i],i);
        }
        return retorno;
    }
    

      public static int cargarNumero(String texto){
    
        int retorno=-1;
        Boolean ban =true;
        
        while(ban){
            try {
                
                 Scanner sn=new Scanner(System.in);
                 System.out.println(texto);
                 retorno=sn.nextInt();
                 //Agrego condicion para que siempre cargue un array con determinada cantidad de elementos
                 //Asi como tambien para no pasar un target negativo
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
      
   
      public static void cargarArray(int[] array){
          
          for (int i = 0; i < array.length; i++) {
              String texto="Ingrese el numero que desea alojar en la posicion("+i+"):";
              array[i]=cargarNumero(texto);
              
          }
      
      
      }
    
}
