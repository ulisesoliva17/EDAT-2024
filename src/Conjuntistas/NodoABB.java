/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conjuntistas;

/**
 *
 * @author ulise
 */
public class NodoABB {
     private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    public NodoABB(Comparable elemento, NodoABB izq, NodoABB der){
        elem= elemento;
        izquierdo= izq;
        derecho= der;
    }
     public Comparable getElem(){
        return elem;
    }
    
    public NodoABB getIzquierdo(){
        return izquierdo;
    }
    public NodoABB getDerecho(){
        return derecho;
    }
    public void setElemento(Comparable elemento){
        elem=elemento;
    }
    public void setIzquierdo(NodoABB izq){
        izquierdo=izq;
    }
      public void setDerecho(NodoABB der){
        derecho=der;
    }
}
