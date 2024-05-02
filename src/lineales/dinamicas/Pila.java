/*Autores
Agustin Alonso FAI-2533
Matias Degl'innocenti FAI-3293
Oliva Ulises FAI-3296
*/
package lineales.dinamicas;

/**
 *
 * @author ulise
 */
public class Pila {
    private Nodo tope;
    public Pila(){
        tope=null;
    }
    public boolean apilar(Object nuevoElem){
        Nodo nuevo = new Nodo(nuevoElem,null);
        nuevo.setEnlace(tope);
        tope=nuevo;
        //Retorna true ya que no hay problema con apilar, puede apilar cualquier cantidad de nodos.
        return true;
    }
    
    public boolean desapilar(){
        boolean retorno=true;
        if(tope!=null){
            tope=tope.getEnlace();
        }else{
            retorno=false;
        }
        return retorno;
    }
    public void vaciar(){
        tope=null;
    }
    public boolean esVacia(){
        return tope==null;
    }
  public Object obtenerTope(){
        Object retorna=null;
        if (!esVacia()) {
            retorna = this.tope.getElem();
        }
        return retorna;
  }
   
    public Pila clone(){
        Pila pilaClone = new Pila();
        Nodo aux = this.tope;
        pilaClone.tope = new Nodo(aux.getElem(), null);
        Nodo auxC = pilaClone.tope;
        aux = aux.getEnlace();

        while (aux!=null) {
            Nodo col = new Nodo(aux.getElem(), null);
            auxC.setEnlace(col);
            auxC = auxC.getEnlace();
            aux = aux.getEnlace();
        }
        return pilaClone;
    }
    public String toString(){
        String s=" ";
        if (this.tope == null) {
            s = "Pila vacia";
        }else{
            Nodo aux = this.tope;
            s="[";
            while (aux != null) {
                s+= aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux!=null) {
                    s+= " ";
                }
            }
            s += "]";
        }
       return s;
    }
    public boolean equals(Pila p){
        Nodo aux=tope;
        Nodo aux2= p.tope;
        boolean rta=true;
        while(aux!=null && aux2!=null && rta){
            if(aux.getElem().equals(aux2.getElem())){
                aux=aux.getEnlace();
                aux2=aux2.getEnlace();
            }else{
                rta=false;
            }
        }
        return rta;
    }
}
