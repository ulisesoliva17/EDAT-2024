/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*Autores
Agustin Alonso FAI-2533
Matias Degl'innocenti FAI-3293
Oliva Ulises FAI-3296
*/
package testt;

/**
 *
 * @author ulise
 */
public class Alumno {
    private int dni;
    private String nombre;
    private int legajo;
    
    public Alumno(int unDni, String nom,int leg){
        dni= unDni;
        nombre= nom;
        legajo= leg;
    }
    
    public int getDni(){
        return dni;
    }
     public String getNombre(){
        return nombre;
    }
      public int getLegajo(){
        return legajo;
    }
      public String toString(){
          return dni + " , " + nombre + " , " +legajo+". ";
      }
    
    
}
