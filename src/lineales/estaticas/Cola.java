package lineales.estaticas;

/**
 *
 * @author ulise
 */
public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO=10;
    
    public Cola(){
        arreglo= new Object[TAMANIO];
        frente=0;
        fin=0;
    }
    public boolean esVacia(){
        return frente==fin;
    }
    public boolean poner(Object nuevoElem){
        boolean exito=true;
        if(! ( ((fin+1)%TAMANIO)==frente) ){
            arreglo[fin]=nuevoElem;
            fin= (fin+1)%TAMANIO;
        }else{
            exito=false;
        }
        return exito;
    }
    
    public boolean sacar(){
        boolean exito=true;
        if(esVacia()){
            //No puede sacar, ya que es vacia. Devuelve Falso.
            exito=false;
        }else{
            arreglo[frente]=null;
            frente= (frente+1)%TAMANIO;
        }
        return exito;
    }
    public Object obtenerFrente(){
        Object elem;
        if(!esVacia()){
            elem= arreglo[frente];
        }else{
            elem=null;
        }
        return elem;
    }
    public boolean estaLlena(){
        return ((fin+1)%TAMANIO)==frente;
    }
     
    public Cola clone(){
        Cola clon= new Cola();
        if(!esVacia()){
            int i= frente;
            while(i!=fin){
                clon.arreglo[i]=arreglo[i];
                i=(i+1)%TAMANIO;
            }
        }
            clon.frente=frente;
            clon.fin=fin;
        return clon;
    }
      public String toString() {
            int i = this.frente;
            String cadena ="[| ";
            while (i != fin) {
                cadena = cadena + this.arreglo[i] + " | ";
                i=(i+1)%TAMANIO;
            }
            cadena = cadena + " ]";
            return cadena;
        }
}
