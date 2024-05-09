package jerarquicas;

/**
 *
 * @author ulise
 */
public class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    public NodoGen(Object elemento, NodoGen Hizq, NodoGen Hder){
        elem= elemento;
        hijoIzquierdo= Hizq;
        hermanoDerecho= Hder;
    }
    public Object getElem(){
        return elem;
    }
    public NodoGen getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    public NodoGen getHermanoDerecho(){
        return hermanoDerecho;
    }
    public void setHijoIzquierdo(NodoGen Hiizq){
        hijoIzquierdo= Hiizq;
    }
    public void setHermanoDerecho(NodoGen HerDer){
        hermanoDerecho= HerDer;
    }
    
}
