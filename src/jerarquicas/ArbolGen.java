package jerarquicas;
import lineales.dinamicas.Lista;

/**
 *
 * @author ulise
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }
    //--------------------------------------------------------------------------------------------------

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        boolean rta = false;
        NodoGen nuevo = new NodoGen(elemNuevo, null, null);
        if (raiz == null)
        {
            raiz = nuevo;
        } else
        {
            NodoGen padre = obtenerNodo(raiz, elemPadre);
            if (padre != null)
            {
                NodoGen hijo = padre.getHijoIzquierdo();
                if (hijo != null)
                {
                    while (hijo.getHermanoDerecho() != null)
                    {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevo);
                    rta = true;
                } else
                {
                    padre.setHijoIzquierdo(nuevo);
                    rta = true;
                }
            }
        }
        return rta;
    }

    private NodoGen obtenerNodo(NodoGen aux, Object buscado) {
        NodoGen retorno = null;
        if (aux != null){
            if (aux.getElem().equals(buscado)){
                retorno = aux;
            }

            if (aux.getHijoIzquierdo() != null && retorno == null){
                NodoGen hijo = aux.getHijoIzquierdo();
                while (hijo != null && retorno == null){
                    retorno = obtenerNodo(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return retorno;
    }

    //--------------------------------------------------------------------------------------------------
    public boolean insertarEnPosicion(Object elemNuevo, int posPadre) {
        int[] arr;
        arr = new int[1];
        arr[0] = 1;
        boolean rta = false;
        NodoGen nuevo = new NodoGen(elemNuevo, null, null);
        if (raiz == null){
            raiz = nuevo;
            rta = true;
        } else{
            NodoGen padre = obtenerNodoPosicion(raiz, posPadre, arr);
            if (padre != null){
                if (padre.getHijoIzquierdo() == null){
                    padre.setHijoIzquierdo(nuevo);
                    rta = true;
                }else{
                    NodoGen hijo = padre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null){
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevo);
                    rta = true;
                }
            }
        }
        return rta;
    }

    private NodoGen obtenerNodoPosicion(NodoGen aux, int buscado, int[] contador) {
        NodoGen retorno = null;
        if (aux != null){
            if (buscado == contador[0]){
                retorno = aux;
            }

            if (aux.getHijoIzquierdo() != null && retorno == null){
                NodoGen hijo = aux.getHijoIzquierdo();
                while (hijo != null && retorno == null){
                    contador[0] = contador[0] + 1;
                    retorno = obtenerNodoPosicion(hijo, buscado, contador);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return retorno;
    }

    //--------------------------------------------------------------------------------------------------
    public String toString() {
        return toStringAux(raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null)
        {
            s += n.getElem().toString() + "--->";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null)
            {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            hijo = n.getHijoIzquierdo();
            while (hijo != null)
            {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    //--------------------------------------------------------------------------------------------------
    public boolean pertenece(Object buscado) {
        return perteneceAux(raiz, buscado);
    }

    private boolean perteneceAux(NodoGen aux, Object buscado) {
        boolean retorno = false;
        if (aux != null) {
            if (aux.getElem().equals(buscado)){
                retorno = true;
            }

            //Llamado recursivo con el segundo hijo en adelante de aux
            if (aux.getHijoIzquierdo() != null && !retorno){
                NodoGen hijo = aux.getHijoIzquierdo();
                while (hijo != null && !retorno){
                    retorno = perteneceAux(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return retorno;
    }
    //--------------------------------------------------------------------------------------------------

    public boolean esVacio() {
        return raiz == null;
    }

    //--------------------------------------------------------------------------------------------------
    public Object obtenerPadre(Object hijo) {
        NodoGen padre = obtenerPadreAux(raiz, hijo);
        Object retorno = null;
        if (padre != null)
        {
            retorno = padre.getElem();
        }
        return retorno;
    }

    private NodoGen obtenerPadreAux(NodoGen aux, Object hijo) {
        NodoGen retorno = null;
        if (aux != null) {
            NodoGen candidato = aux.getHijoIzquierdo();
            while (candidato != null && retorno == null){
                if (candidato.getElem().equals(hijo)){
                    retorno = aux;
                }
                candidato = candidato.getHermanoDerecho();
            }

            candidato = aux.getHijoIzquierdo();
            while (candidato != null && retorno == null){
                retorno = obtenerPadreAux(candidato, hijo);
                candidato = candidato.getHermanoDerecho();
            }
        }
        return retorno;
    }

    //Faltan :Clone, Altura, Ancestros,Nivel
    //--------------------------------------------------------------------------------------------------
    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        NodoGen raizClone = new NodoGen(raiz.getElem(), null, null);
        clon.raiz = raizClone;
        cloneAux(raiz, clon.raiz);
        return clon;
    }

    private void cloneAux(NodoGen original, NodoGen clon) {
        if (original != null && clon != null){
            if (original.getHijoIzquierdo() != null){
                clon.setHijoIzquierdo(new NodoGen(original.getHijoIzquierdo().getElem(), null, null));
            }
            if (original.getHermanoDerecho() != null){
                clon.setHermanoDerecho(new NodoGen(original.getHermanoDerecho().getElem(), null, null));
            }
            cloneAux(original.getHijoIzquierdo(), clon.getHijoIzquierdo());
            cloneAux(original.getHermanoDerecho(), clon.getHermanoDerecho());
        }
    }

    //------------------------------------------------------------------------------------------------------
    public void vaciar() {
        raiz = null;
    }
    //------------------------------------------------------------------------------------------------------

    public int altura() {
        return alturaAux(raiz);
    }

    private int alturaAux(NodoGen aux) {
        int alturaMaxima = 0;
        if (aux != null) {
            if (aux.getHijoIzquierdo() != null) {
                int alturaHijoIzq = alturaAux(aux.getHijoIzquierdo());
                NodoGen hijo = aux.getHijoIzquierdo();
                int alturaHerDer = 0;
                int alturaMaxHerDer = 0;
                while (hijo != null){

                    alturaHerDer = alturaAux(hijo);
                    //Nos quedamos con la altura del hermano derecho de mayor altura
                    if (alturaHerDer > alturaMaxHerDer){
                        alturaMaxHerDer = alturaHerDer;
                    }
                    hijo = hijo.getHermanoDerecho();
                }

                if (alturaHijoIzq > alturaMaxHerDer){
                    alturaMaxima = alturaHijoIzq + 1;
                } else{
                    alturaMaxima = alturaMaxHerDer+1;
                }
            } else{
                alturaMaxima = -1;
            }
        }
        return alturaMaxima;
    }
        //------------------------------------------------------------------------------------------------------
    public int gradoNodo(Object padre){
        NodoGen pa = obtenerNodo(raiz, padre);
        return gradoNodoAux(pa,0);
    }
    private int gradoNodoAux( NodoGen pa, int contador){
            NodoGen hijo= pa.getHijoIzquierdo();
            while(hijo!=null){
                contador++;
                hijo= hijo.getHermanoDerecho();
            }
            return contador;
    }
      //------------------------------------------------------------------------------------------------------
    public int gradoArbol(){
        int retorno = gradoArbolAux(raiz,0,0);
        return retorno;
    }
    private int gradoArbolAux(NodoGen aux, int contador, int gradoMax){
        if(aux!=null){
            
            NodoGen hijo= aux.getHijoIzquierdo();
            while(hijo!=null){
                contador++;
                hijo= hijo.getHermanoDerecho();
            }
            
            if(contador>gradoMax){
                gradoMax = contador;
            }
            
            hijo= aux.getHijoIzquierdo();
            while(hijo!=null){
                gradoMax=gradoArbolAux(hijo,0,gradoMax);
                hijo=hijo.getHermanoDerecho();
            }
        }
        return gradoMax;
    }
    
    public void insertarEnPosicionHijo(Object elem,Object padreElem,int pos){
        insertarEnPosicionAux(elem, padreElem, raiz, pos);
    }
    
    private void insertarEnPosicionAux(Object elem, Object padreElem, NodoGen padre,int pos){
        if(padre!=null){
            if(padre.getElem().equals(padreElem)){
                
                if(padre.getHijoIzquierdo()!=null){
                NodoGen hijo= padre.getHijoIzquierdo();
                NodoGen nuevo= new NodoGen(elem,null,null);
                int cantHijos=1;
                //While para contar la cantidad de hijos que tiene y saber las posiciones en las que nos manejariamos
                while(hijo!=null){
                    hijo= hijo.getHermanoDerecho();
                    cantHijos++;
                }
                    if(pos>=1 && pos<cantHijos){
                        hijo= padre.getHijoIzquierdo();
                            if(pos==1){
                            nuevo.setHermanoDerecho(hijo);
                            padre.setHijoIzquierdo(nuevo);

                            }else if(pos>1 && pos <cantHijos){
                                int contador=1;
                                while(contador!=(pos-1)){
                                    hijo=hijo.getHermanoDerecho();
                                    contador++;
                                }
                                nuevo.setHermanoDerecho(hijo.getHermanoDerecho());
                                hijo.setHermanoDerecho(nuevo);
                            }
                    }
                    else{
                        //Posicion invalida, debo agregar a la ultima posicion
                        hijo= padre.getHijoIzquierdo();
                        if(hijo!=null){
                            while(hijo.getHermanoDerecho()!=null){
                                hijo=hijo.getHermanoDerecho();
                            }
                            hijo.setHermanoDerecho(nuevo);
                        }else{
                            padre.setHijoIzquierdo(nuevo);
                        }
                    }
                }
                //no era el padre, asique debo seguir buscando el padre.
            }else{
            NodoGen hijo= padre.getHijoIzquierdo();
            while(hijo!=null){
                insertarEnPosicionAux(elem, padreElem, hijo, pos);
                hijo=hijo.getHermanoDerecho();
            }
          }
        }
    }
    public boolean esSobrino(Object sobrino, Object tio){
        return esSobrinoAux(raiz, sobrino, tio,false);
    }
    
    private boolean esSobrinoAux(NodoGen aux, Object sobrino, Object tio,boolean rta){
        if(aux!=null){
            if(aux.getElem().equals(tio)){
                if(aux.getHermanoDerecho()!=null){
                        NodoGen hermano= aux.getHermanoDerecho();
                        NodoGen candidatoSobrino= hermano.getHijoIzquierdo();
                        while(hermano!=null && !rta){
                               while(candidatoSobrino!=null && !rta){
                                   if(candidatoSobrino.getElem().equals(sobrino)){
                                       rta=true;
                                   }else{
                                       candidatoSobrino= candidatoSobrino.getHermanoDerecho();
                                   }
                               }
                               if(!rta){
                                   hermano=hermano.getHermanoDerecho();
                                   if (hermano != null) {
                                       //Reinicio a candidatoSobrino al primer hijo.
                                         candidatoSobrino = hermano.getHijoIzquierdo();
                                    }
                               }
                        }
                }
            }else{
                NodoGen hijo= aux.getHijoIzquierdo();
                while(hijo!=null && !rta){
                    rta=esSobrinoAux(hijo, sobrino, tio,rta);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
           return rta;
    }
    public boolean verificarCamino(Lista lis){
        boolean rta=false;
        if(raiz!=null && !lis.esVacia() && raiz.getElem().equals(lis.recuperar(1))){
            rta= verificarCaminoAux(raiz, lis, 2);
        }
        return rta;
    }
    private boolean verificarCaminoAux(NodoGen aux, Lista lis,int contador){
        boolean rta=false;
        if(aux.getElem().equals(lis.recuperar(contador))){
            NodoGen hijo= aux.getHijoIzquierdo();
            while(hijo!=null){
                rta= verificarCaminoAux(hijo, lis, contador+1);
            }
        }
        return rta;
    }
    public boolean eliminar(Object elem){
        boolean rta=false;
        if(raiz.getElem().equals(elem)){
            raiz=null;
            rta=true;
        }else{
            rta= eliminarAux(elem,raiz.getHijoIzquierdo(),raiz);
        }
        return rta;
    }
   private boolean eliminarAux(Object buscado, NodoGen nodo, NodoGen padre) {
                boolean rta = false;
                if (nodo != null) {
                    // Visita del nodo n
                    if (nodo.getElem().equals(buscado)) {
                                if (padre == null) {
                                        // Caso especial: eliminando la raíz del árbol
                                        nodo = null;
                                } else {
                                        // Enlazar el hermano derecho del nodo actual con el nodo anterior
                                        padre.setHijoIzquierdo(nodo.getHermanoDerecho());
                                }
                                        rta = true;
                    } else {
                                NodoGen hijo = nodo.getHijoIzquierdo();
                                NodoGen hermanoAnterior = null;
                                while (hijo != null && !rta) {
                                    //ahora nodo pasa a ser padre.
                                        rta = eliminarAux(buscado, hijo, nodo);
                                        if (!rta) {
                                            hermanoAnterior = hijo;
                                            hijo = hijo.getHermanoDerecho();
                                        }
                                }
                                if (rta && hermanoAnterior != null) {
                                    // Enlazar el hermano derecho del nodo eliminado con el nodo anterior
                                    hermanoAnterior.setHermanoDerecho(hijo);
                                }
                    }
                }
                return rta;
            }
 
}
