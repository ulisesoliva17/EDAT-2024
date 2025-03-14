package Conjuntistas;

/**
 *
 * @author ulise
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }
    //------------------------------------------------------------------------------------------

    private NodoAVL obtenerNodoAux(NodoAVL aux, Comparable buscado) {
        NodoAVL retorno = null;
        if (aux != null) {

            if (aux.getElem().compareTo(buscado) == 0) {
                retorno = aux;
            } else {
                retorno = obtenerNodoAux(aux.getIzquierdo(), buscado);
                if (retorno == null) {
                    retorno = obtenerNodoAux(aux.getDerecho(), buscado);
                }
            }
        }
        return retorno;
    }

    public Comparable obtenerNodo(Comparable buscado) {
        NodoAVL nodo = obtenerNodoAux(raiz, buscado);
        Comparable elemento;
        if (nodo.getElem() != null) {
            elemento = nodo.getElem();
        } else {
            elemento = null;
        }
        return elemento;
    }
//------------------------------------------------------------------------------------------

    public boolean pertenece(Comparable elem) {
        return perteneceAux(raiz, elem);
    }

    private boolean perteneceAux(NodoAVL aux, Comparable elem) {
        boolean rta = false;
        if (aux != null) {
            if ((elem.compareTo(aux.getElem())) == 0) {
                rta = true;
            } else if ((elem.compareTo(aux.getElem())) < 0) {
                if (aux.getIzquierdo() != null) {
                    rta = perteneceAux(aux.getIzquierdo(), elem);
                } else {
                    rta = false;
                }
            } else {
                if (aux.getDerecho() != null) {
                    rta = perteneceAux(aux.getDerecho(), elem);
                } else {
                    rta = false;
                }
            }
        }
        return rta;
    }

    //------------------------------------------------------------------------------------------
    public int altura() {
        return alturaAux(raiz);
    }

    private int alturaAux(NodoAVL aux) {
        int alturaMaxima = 0;
        if (aux != null) {

            int alturaHijoIzq = alturaAux(aux.getIzquierdo());
            int alturaHijoDer = alturaAux(aux.getDerecho());

            if (alturaHijoIzq > alturaHijoDer) {
                alturaMaxima = alturaHijoIzq + 1;
            } else {
                alturaMaxima = alturaHijoDer + 1;
            }
        } else {
            alturaMaxima = -1;
        }
        return alturaMaxima;
    }
    //------------------------------------------------------------------------------------------------

    public boolean insertar(Comparable elem) {
        boolean exito = true;
        if (raiz == null) {
            raiz = new NodoAVL(elem, null, null);
        } else {
            exito = insertarAux(raiz, elem);
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL aux, Comparable elem) {
        boolean rta = true;
        if ((elem.compareTo(aux.getElem())) == 0) {
            rta = false;
        } else if ((elem.compareTo(aux.getElem())) < 0) {
            if (aux.getIzquierdo() != null) {
                rta = insertarAux(aux.getIzquierdo(), elem);
            } else {
                aux.setIzquierdo(new NodoAVL(elem, null, null));
            }
        } else {
            if (aux.getDerecho() != null) {
                rta = insertarAux(aux.getDerecho(), elem);
            } else {
                aux.setDerecho(new NodoAVL(elem, null, null));
            }
        }
        if (rta) {
            //Como aux tiene un nuevo hijo, debo de recalcularle la altura
            aux.recalcularAltura();
            
        }
        return rta;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    public boolean eliminar(Comparable elemento) {
        boolean resultado = true;
        if (raiz != null) {
            //Arranco con raiz y padre de raiz que es null, luego el metodo lo buscara al nodo que quiera eliminar si no es la raiz
            resultado = eliminarAux(raiz, null, elemento);
        } else {
            resultado = false;
        }
        return resultado;
    }

    private boolean eliminarAux(NodoAVL hijo, NodoAVL padre, Comparable elemento) {
        boolean exito = false;
        if (hijo != null) {
            if ((elemento.compareTo(hijo.getElem())) == 0) {

                if (hijo.getIzquierdo() == null && hijo.getDerecho() == null) {
                    //son Hojas
                    eliminarHoja(hijo, padre, elemento);
                    exito = true;

                } else if ((hijo.getIzquierdo() != null && hijo.getDerecho() == null) || (hijo.getIzquierdo() == null && hijo.getDerecho() != null)) {
                    //si n tiene UN hijo
                    tieneUnHijo(hijo, padre, elemento);
                    exito = true;

                } else {
                    // si n tiene ambos hijos
                    //Le paso el hijo, el padre que en principio es null si hijo es la raiz, y le paso de nuevo el hijo
                    tieneDosHijos(hijo.getIzquierdo(),null,hijo);
                    exito = true;
                }

            } else {
                //Llamo con el hijo izquierdo, y si es el que busco, entonces el padre es el mismo nodo en el que ahora estoy parado
                if (elemento.compareTo(hijo.getElem()) < 0) {
                    eliminarAux(hijo.getIzquierdo(), hijo, elemento);
                }
                //LLamo con el derecho y sucede lo mismo, si es el hijo derecho el que busco, entonces el padre es el nodo en el que ahora estoy parado.
                if (elemento.compareTo(hijo.getElem()) > 0) {
                    eliminarAux(hijo.getDerecho(), hijo, elemento);
                }
            }
            if (exito) {

            }
        }
        return exito;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //Eliminar: Caso 1, donde el nodo es Hoja
    private void eliminarHoja(NodoAVL hijo, NodoAVL padre, Comparable buscado) {
        if (padre != null) {
            if (padre.getDerecho().getElem().compareTo(buscado) == 0 && hijo.getDerecho() == null && hijo.getIzquierdo() == null) {
                padre.setDerecho(null);
            } else if (padre.getIzquierdo().getElem().compareTo(buscado) == 0 && hijo.getDerecho() == null && hijo.getIzquierdo() == null) {
                padre.setIzquierdo(null);
            }
        } else {
            raiz = null;
        }
    }

    //Eliminar: Caso 2, donde el nodo tiene un solo hijo
    private void tieneUnHijo(NodoAVL hijo, NodoAVL padre, Comparable buscado) {
        if (padre != null) {
            if (padre.getIzquierdo().getElem().compareTo(buscado) == 0 && hijo.getIzquierdo() != null && hijo.getDerecho() == null) {
                padre.setIzquierdo(padre.getIzquierdo().getIzquierdo());
            }
            if (padre.getIzquierdo().getElem().compareTo(buscado) == 0 && hijo.getIzquierdo() == null && hijo.getDerecho() != null) {
                padre.setIzquierdo(padre.getIzquierdo().getDerecho());
            }
            if (padre.getDerecho().getElem().compareTo(buscado) == 0 && hijo.getIzquierdo() != null && hijo.getDerecho() == null) {
                padre.setDerecho(padre.getDerecho().getIzquierdo());
            }
            if (padre.getDerecho().getElem().compareTo(buscado) == 0 && hijo.getIzquierdo() == null && hijo.getDerecho() != null) {
                padre.setDerecho(padre.getDerecho().getDerecho());
            }
        } else {
            if (hijo.getIzquierdo() != null && hijo.getDerecho() == null) {
                raiz = hijo.getIzquierdo();
            }
            if (hijo.getIzquierdo() == null && hijo.getDerecho() != null) {
                raiz = hijo.getDerecho();
            }
        }
    }

    private void tieneDosHijos(NodoAVL nodoCandidato,NodoAVL padreCandidato,NodoAVL raiz) {
        if(nodoCandidato.getDerecho()!=null){
            tieneDosHijos(nodoCandidato.getDerecho(),nodoCandidato,raiz);
        }else{
            /*Si el hijo derecho de nodo es null, significa que ya estoy parado en el candidato
            por ende, seteo el elemento de la "raiz" que es el nodo que quiero eliminar,
            y luego al padre del candidato le seteo su hijo derecho con el hijo izquierdo 
            del nodo candidato*/
            raiz.setElemento(nodoCandidato.getElem());
            padreCandidato.setDerecho(nodoCandidato.getIzquierdo());
        }
    }
    //-----------------------------------------------------------------------------------------------
    //ROTACIONES SIMPLES
    private NodoAVL rotarIzquierda(NodoAVL r) {
        NodoAVL h = r.getDerecho();
        NodoAVL temp = h.getIzquierdo();
        h.setIzquierdo(r);
        r.setDerecho(temp);
        r.recalcularAltura();
        h.recalcularAltura();
        //RETORNA LA NUEVA RAIZ DEL SUBARBOL.
        return h;
    }

    private NodoAVL rotarDerecha(NodoAVL r) {
        NodoAVL h = r.getIzquierdo();
        NodoAVL temp = h.getDerecho();
        h.setDerecho(r);
        r.setIzquierdo(temp);
        r.recalcularAltura();
        h.recalcularAltura();
        //RETORNA LA NUEVA RAIZ DEL SUBARBOL.
        return h;
    }
    //ROTACIONES DOBLES.

    private NodoAVL rotarDerIzq(NodoAVL r) {
        //Rota el hijo derecho de r, para que se desbalance con el mismo signo
        r.setDerecho(rotarDerecha(r.getDerecho()));
        //Luego rota a izquierda para que quede el nodo balanceado.
        return rotarIzquierda(r);
    }

    private NodoAVL rotarIzqDer(NodoAVL r) {
        //Rota el hijo izquierdo de r, para que se desbalance con el mismo signo
        r.setIzquierdo(rotarIzquierda(r.getIzquierdo()));
        //Luego rota a derecha para que quede el nodo balanceado.
        return rotarDerecha(r);
    }

    private NodoAVL balancearAux(NodoAVL nodo) {
        NodoAVL aux = null;
        //Si el balance del padre es 2, solo nos fijamos en el hijo izquierdo
        if (balance(nodo) == 2) {
            if (balance(nodo.getIzquierdo()) >= 0) {
                aux = rotarDerecha(nodo);
            } else {
                aux = rotarIzqDer(nodo);
            }
        }
        //Si el balance del padre es -2, solo nos fijamos en el hijo derecho          
        if (balance(nodo) == -2) {
            if (balance(nodo.getDerecho()) <= 0) {
                aux = rotarIzquierda(nodo);
            } else {
                aux = rotarDerIzq(nodo);
            }
        }
        return aux;
    }
    /*el insertar no necesita revisar para arrriba, ya que siempre se insertar como hoja el nuevo elemento*/
    /*cada vez que insertas se balancean los hijos del nuevo nodo, entonces no necesito ir balanceando para arriba en el insertar, solo me preocupo por la raiz como caso especial, 
    y los hijos del nuevo nodo insertado*/

    private int balance(NodoAVL aux) {
        return alturaAux(aux.getIzquierdo()) - alturaAux(aux.getDerecho());
    }
}
