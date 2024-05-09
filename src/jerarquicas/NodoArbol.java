package jerarquicas;

/**
 *
 * @author ulise
 */
public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol(Object elemento, NodoArbol izq, NodoArbol der){
        elem= elemento;
        izquierdo= izq;
        derecho= der;
    }
     public Object getElem(){
        return elem;
    }
    
    public NodoArbol getIzquierdo(){
        return izquierdo;
    }
    public NodoArbol getDerecho(){
        return derecho;
    }
    public void setElemento(Object elemento){
        elem=elemento;
    }
    public void setIzquierdo(NodoArbol izq){
        izquierdo=izq;
    }
      public void setDerecho(NodoArbol der){
        derecho=der;
    }
}
