package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Nodo;

/**
 *
 * @author ulise
 */
public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        raiz = null;
    }

    public boolean insertar(Object elem, Object psdreObject, char pos) {
        boolean exito = false;

        if (raiz == null)
        {
            NodoArbol nuevo = new NodoArbol(elem, null, null);
            raiz = nuevo;
            exito = true;
        } else {
            NodoArbol padre = obtenerNodo(psdreObject, raiz);

            if (padre != null){
                if (pos == 'i') {
                    if (padre.getIzquierdo() == null){
                        NodoArbol nuevo2 = new NodoArbol(elem, null, null);
                        padre.setIzquierdo(nuevo2);
                        exito = true;
                    }
                } else if (pos == 'd') {
                    if (padre.getDerecho() == null) {
                        NodoArbol nuevo2 = new NodoArbol(elem, null, null);
                        padre.setDerecho(nuevo2);
                        exito = true;
                    }
                }
            }
        }
        return exito;
    }
        private NodoArbol obtenerNodo(Object elem, NodoArbol aux) {
        NodoArbol retorno = null;

        if (aux != null){
            if (aux.getElem().equals(elem)){
                retorno = aux;
            } else {
                retorno = obtenerNodo(elem, aux.getIzquierdo());
                if (retorno == null){
                    retorno = obtenerNodo(elem, aux.getDerecho());
                }
            }
        }
        return retorno;
    }
          //-----------------------------------------------------------------------------------------
    public boolean insertarPorPosicion(Object elem, int posPadre, char posHijo){
        int[] arr;
        arr = new int[1];
        arr[0]=1;
      boolean rta=false;
      
      NodoArbol padre= retornarNodoPosicion(raiz, posPadre, arr);
      
     if(padre!=null){
          
          if(padre.getIzquierdo()==null){
          NodoArbol nuevo2 = new NodoArbol(elem, null, null);
          padre.setIzquierdo(nuevo2);
          rta=true;
          
          }else if(padre.getDerecho()==null){
          NodoArbol nuevo2 = new NodoArbol(elem, null, null);
          padre.setDerecho(nuevo2);
          rta=true;
          }
      }
      
      return rta;
    }
    private NodoArbol retornarNodoPosicion(NodoArbol aux,int posPadre,int[] contador){
        NodoArbol retorno = null;
        if(aux!=null){
            if(posPadre == contador[0]){
            retorno=aux;
            }else{
                contador[0]++;
                retorno = retornarNodoPosicion(aux.getIzquierdo(), posPadre, contador);
                if (retorno == null){
                    retorno = retornarNodoPosicion(aux.getDerecho(),posPadre,contador);
                }
            }
        }
        return retorno;
    }
        //-----------------------------------------------------------------------------------------
    public int altura(){
        return alturaAux(raiz);
    }
    
    private int alturaAux(NodoArbol aux){
       int alturaMaxima=0;
       if(aux!=null){

           int alturaHijoIzq= alturaAux(aux.getIzquierdo());
           int alturaHijoDer= alturaAux(aux.getDerecho());
           
           if(alturaHijoIzq>alturaHijoDer){
               alturaMaxima= alturaHijoIzq+1;
           }else{
               alturaMaxima= alturaHijoDer+1;
           }
       }else{
           alturaMaxima=-1;
       }
        return alturaMaxima;
    }
    


    //-----------------------------------------------------------------------------------------
    public Lista listarPreOrden() {
        Lista lis = new Lista();
        listarPreOrdenAux(raiz, lis);
        return lis;
    }

    private void listarPreOrdenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null)
        {
            lis.insertar(lis.longitud() + 1, nodo.getElem());
            listarPreOrdenAux(nodo.getIzquierdo(), lis);
            listarPreOrdenAux(nodo.getDerecho(), lis);
        }
    }

    //-----------------------------------------------------------------------------------------
    public Lista listarInOrden() {
        Lista lis = new Lista();
        listarInOrdenAux(raiz, lis);
        return lis;
    }

    private void listarInOrdenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null){
            listarInOrdenAux(nodo.getIzquierdo(), lis);
            lis.insertar(lis.longitud() + 1, nodo.getElem());
            listarInOrdenAux(nodo.getDerecho(), lis);
        }
    }

    //-----------------------------------------------------------------------------------------
    public Lista listarPosOrden() {
        Lista lis = new Lista();
        listarPosOrdenAux(raiz, lis);
        return lis;
    }

    private void listarPosOrdenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null)
        {
            listarPosOrdenAux(nodo.getIzquierdo(), lis);
            lis.insertar(lis.longitud() + 1, nodo.getElem());
            listarPosOrdenAux(nodo.getDerecho(), lis);
        }
    }
    //-----------------------------------------------------------------------------------------

    public Lista listarPorNiveles() {
        Cola cola = new Cola();

        Lista lis = new Lista();

        cola.poner(raiz);

        while (!cola.esVacia())
        {

            NodoArbol aux = (NodoArbol) cola.obtenerFrente();

            cola.sacar();

            lis.insertar(lis.longitud() + 1, aux.getElem());

            if (aux.getIzquierdo() != null)
            {
                cola.poner(aux.getIzquierdo());
            }
            if (aux.getDerecho() != null)
            {
                cola.poner(aux.getDerecho());
            }
        }
        return lis;
    }

    //-----------------------------------------------------------------------------------------
    public boolean esVacio() {
        return raiz == null;
    }

    //-----------------------------------------------------------------------------------------
    public Object padre(Object hijo) {
        NodoArbol vuelto = padreAux(raiz, hijo);
        Object retorno = vuelto.getElem();
        return retorno;
    }

    private NodoArbol padreAux(NodoArbol aux, Object hijo) {
        //recibe la raiz este metodo y recorre completo
        NodoArbol aux2 = null;
        if (aux != null){
            
            if (aux.getIzquierdo() != null && aux.getIzquierdo().getElem().equals(hijo)){
                aux2 = aux;
            } 
            else if (aux.getDerecho() != null && aux.getDerecho().getElem().equals(hijo)){
                aux2 = aux;
            } else{
                aux2 = padreAux(aux.getIzquierdo(), hijo);
                
                if (aux2 == null){    
                    aux2 = padreAux(aux.getDerecho(), hijo);
                }
            }
        }
        return aux2;
    }

    //-----------------------------------------------------------------------------------------
    public ArbolBin clone() {
        ArbolBin nuevo = new ArbolBin();
        nuevo.raiz = new NodoArbol(raiz.getElem(), null, null);
        cloneAux(raiz, nuevo.raiz);
        return nuevo;
    }

    //-----------------------------------------------------------------------------------------
    private void cloneAux(NodoArbol aux, NodoArbol nuevo) {
        if (aux != null && nuevo != null){
            if (aux.getIzquierdo() != null){
                nuevo.setIzquierdo(new NodoArbol(aux.getIzquierdo().getElem(), null, null));
            }
            if (aux.getDerecho() != null){
                nuevo.setDerecho(new NodoArbol(aux.getDerecho().getElem(), null, null));
            }
            cloneAux(aux.getIzquierdo(), nuevo.getIzquierdo());
            cloneAux(aux.getDerecho(), nuevo.getDerecho());

        }
    }

    //-----------------------------------------------------------------------------------------

 public boolean cantidadApariciones(Object elem, int cant) {
    int contador=cantidadAparicionesAux(raiz, elem,cant);
    return contador==cant;
}

private int cantidadAparicionesAux(NodoArbol aux, Object elem,int cant) {
    int contador=0;
    if (aux != null){
        if (aux.getElem().equals(elem)){
            contador = contador + 1;
        }
        if(contador<=cant)
          contador = contador + cantidadAparicionesAux(aux.getIzquierdo(), elem,cant);
         if(contador<=cant)
          contador = contador + cantidadAparicionesAux(aux.getDerecho(), elem,cant);
        
    }
    return contador;

}
    //-----------------------------------------------------------------------------------------

public Lista frontera (){
    Lista lis= new Lista();
    //Este metodo solo modifica la lista lis y la devuelve modificada.
     fronteraAux(lis, raiz);
     return lis;
}

private void fronteraAux(Lista lis, NodoArbol nodo){
    if(nodo!=null){
        if(nodo.getDerecho()==null && nodo.getIzquierdo()==null){
            lis.insertar(lis.longitud()+1, nodo.getElem());
        }
        fronteraAux(lis, nodo.getIzquierdo());
        fronteraAux(lis, nodo.getDerecho());
    }
}
  //-----------------------------------------------------------------------------------------
    public boolean verificarCamino(Lista lis){
        return verificarCaminoAux(raiz,lis,1);
    }
   private boolean verificarCaminoAux(NodoArbol nodo,Lista lis,int contador){
        boolean rta=false;
        if(nodo!=null){
            if(nodo.getElem().equals(lis.recuperar(contador))){
                        if(contador<lis.longitud()){
                                rta= verificarCaminoAux(nodo.getIzquierdo(), lis, contador+1);
                                 if(!rta){
                                     rta= verificarCaminoAux(nodo.getDerecho(), lis, contador+1);
                                }
                        }else{
                            //Significa que ya termino el camino y se encontro.
                            rta=true;
                        }
            
            }else{
                rta=false;
            }
            
        }
        return rta;
    }
   
   public ArbolBin clonarA(){
       NodoArbol clon = new NodoArbol(raiz.getElem(),null,null);
       ArbolBin nuevo= new ArbolBin();
       nuevo.raiz=clon;
       clonarAuxa(raiz,nuevo.raiz);
       return nuevo;
   }
   public void clonarAuxa(NodoArbol original, NodoArbol clon){
       if(original!=null && clon!=null){
           if(original.getIzquierdo()!=null){
               clon.setIzquierdo(new NodoArbol(original.getIzquierdo().getElem(),null,null));
           }
           if(original.getDerecho()!=null){
               clon.setDerecho(new NodoArbol(original.getDerecho().getElem(),null,null));
           }
           
             if(original.getIzquierdo()!=null)
           clonarAuxa(original.getIzquierdo(), clon.getIzquierdo());
               if(original.getDerecho()!=null)
           clonarAuxa(original.getDerecho(), clon.getDerecho());
               
       }
   }
   
   public Lista armarListaInOrden(Object x){
       NodoArbol buscado= obtenerNodito(raiz, x);
       Lista lis= new Lista();
        inOrdenAAAux(buscado,lis);
        return lis;
   }
   private void inOrdenAAAux(NodoArbol aux,Lista lis){
       if(aux!=null){
           inOrdenAAAux(aux.getIzquierdo(), lis);
            lis.insertar(lis.longitud()+1, aux.getElem());
           inOrdenAAAux(aux.getDerecho(), lis);
       }
   }
   
   private NodoArbol obtenerNodito(NodoArbol aux,Object x){
       NodoArbol retorno=null;
       if(aux!=null){
           if(aux.getElem().equals(x)){
               retorno = aux;
           }else{
               retorno= obtenerNodito(aux.getIzquierdo(), x);
               if(retorno==null)
               retorno= obtenerNodito(aux.getDerecho(), x);
           }
       }
       return retorno;
   }
   public String toString() {
        String mensaje=" ";
        if(raiz==null){    
            mensaje="Arbol Vacio";
        }else{
            mensaje= toStringAux(raiz);
        }
        return mensaje;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    private String toStringAux(NodoArbol nodo) {
        String mensaje = "";
        if (nodo != null) {
            mensaje =  " \n "+" Nodo:  "+ nodo.getElem() +mensaje + " \n " ;
            if (nodo.getIzquierdo() != null) {
                mensaje = mensaje + (" HI: "+nodo.getIzquierdo().getElem());
            } else {
                mensaje = mensaje +" HI: - " ;
            }
            if (nodo.getDerecho() != null) {
                mensaje = mensaje + (" HD: "+nodo.getDerecho().getElem());
            } else {
                mensaje = mensaje+" HD: - ";
            }
        }
        if(nodo.getIzquierdo()!=null){
            mensaje= mensaje+ toStringAux(nodo.getIzquierdo());
        }
        if(nodo.getDerecho()!=null){
            mensaje= mensaje+ toStringAux(nodo.getDerecho());
        }
        
        return mensaje;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    public void completarHijos(){
        completarAux(raiz);
    }
    private void completarAux(NodoArbol aux){
        if(aux!=null){
            if(aux.getIzquierdo()==null && aux.getDerecho()!=null){
                aux.setIzquierdo(new NodoArbol (aux.getDerecho().getElem(),null,null));
            }
            if(aux.getDerecho()==null && aux.getIzquierdo()!=null){
                aux.setDerecho(new NodoArbol (aux.getIzquierdo().getElem(),null,null));
            }
            completarAux(aux.getIzquierdo());
            completarAux(aux.getDerecho());
        }
    }
    public boolean menosdeCantApariciones(Object elem, int cant){
        int contador= menosCantAux(elem,cant,raiz,0);
        boolean rta=false;
        if(contador<cant){
            rta=true;
        }
        //Testeo
        System.out.println(contador);
        return rta;
    }
    private int menosCantAux(Object elem, int cant, NodoArbol aux, int contador){
        if(aux!=null){
            if(aux.getElem().equals(elem)){
                contador=contador+1;
            }
            if(contador<cant){
                contador=menosCantAux(elem,cant,aux.getIzquierdo(),contador);
            }
            if(contador<cant){
                contador=menosCantAux(elem,cant,aux.getDerecho(),contador);
            }
        }
        return contador;
    }
}
