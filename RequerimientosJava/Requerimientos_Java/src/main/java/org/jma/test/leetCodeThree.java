
package org.jma.test;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class leetCodeThree {
    
    /*
    
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    
    Input: s = "anagram", t = "nagaram"
    Output: true
    
    Input: s = "rat", t = "car"
    Output: false
    
    
    */
    
    public static void main(String[] args) {
        

        
        boolean res=resolucionTres();
        
        System.out.println(res);
    }
    
    
    public static boolean resolucionTres(){
        
        String t=cargarString("Ingrese el primer texto a comparar");
        String s=cargarString("Ingrese el primer texto a comparar");
        
        
        Set<Character> listaA=new HashSet<>();
        Set<Character> listaB=new HashSet<>();
        
        agregarAColeccion(listaA,t);
        agregarAColeccion(listaB,s);
        
     
        return listaA.equals(listaB);
        
    
    };
    
    
    public static void agregarAColeccion(Set<Character> set,String a){
    
        String analizar=a.toLowerCase();
        int contador=0;
        for (int i = 0; i < a.length(); i++) {
            //Doy condicion para que no cuente los espacios pese a que solo se ingresan palabas en el ejemplo
            if (a.charAt(i)!=' ') {
                set.add(a.charAt(i));
            } else{
            
                contador++;
            }
            
        }
        //Aclaracion por lo dicho anteriormente 
        if (contador>0) {
            System.out.println("Revisar porque ingreso un espacio o un texto, no solo una palabra\n");
        } 
        
    
    }
    
    public static String cargarString(String texto){
    
        
        Scanner sn=new Scanner(System.in);
        System.out.println(texto);
        return sn.nextLine();
    }
}
