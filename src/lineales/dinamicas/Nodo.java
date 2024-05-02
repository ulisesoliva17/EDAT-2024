/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

/**
 *
 * @author ulise
 */
public class Nodo {
    private Object elem;
    private Nodo enlace;
    
    public Nodo(Object elemen, Nodo enla){
        elem= elemen;
        enlace=enla;
    }
    public void setElem(Object elemen){
        elem=elemen;
    }
    public void setEnlace(Nodo enla){
        enlace=enla;
    }
    public Object getElem(){
        return elem;
    }
    public Nodo getEnlace(){
        return enlace;
    }
}
