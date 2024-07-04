package Conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author ulise
 */
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        raiz = null;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = true;
        if (raiz == null) {
            raiz = new NodoABB(elem, null, null);
        } else {
            exito = insertarAux(raiz, elem);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB aux, Comparable elem) {
        boolean rta = true;
        if ((elem.compareTo(aux.getElem())) == 0) {
            rta = false;
        } else if ((elem.compareTo(aux.getElem())) < 0) {
            if (aux.getIzquierdo() != null) {
                rta = insertarAux(aux.getIzquierdo(), elem);
            } else {
                aux.setIzquierdo(new NodoABB(elem, null, null));
            }
        } else {
            if (aux.getDerecho() != null) {
                rta = insertarAux(aux.getDerecho(), elem);
            } else {
                aux.setDerecho(new NodoABB(elem, null, null));
            }
        }
        return rta;
    }

    //------------------------------------------------------------------------------------------
    private NodoABB obtenerNodoAux(NodoABB aux, Object buscado) {
        //recibe la raiz este metodo y recorre completo
        NodoABB aux2 = null;
        if (aux != null) {

            if (aux.getElem().compareTo(buscado) == 0) {
                aux2 = aux;
            } else {
                aux2 = obtenerNodoAux(aux.getIzquierdo(), buscado);
                if (aux2 == null) {
                    aux2 = obtenerNodoAux(aux.getDerecho(), buscado);
                }
            }
        }
        return aux2;
    }

    public Comparable obtenerNodo(Comparable buscado) {
        NodoABB nodo = obtenerNodoAux(raiz, buscado);
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

    private boolean perteneceAux(NodoABB aux, Comparable elem) {
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
    public boolean esVacio() {
        return raiz == null;
    }

    //------------------------------------------------------------------------------------------
    public Comparable minimoElem() {
        NodoABB aux = raiz;
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        Comparable max = aux.getElem();
        return max;
    }
    //------------------------------------------------------------------------------------------

    public Comparable maxElem() {
        NodoABB aux = raiz;
        while (aux.getDerecho() != null) {
            aux = aux.getDerecho();
        }
        Comparable max = aux.getElem();
        return max;
    }
    //------------------------------------------------------------------------------------------

    public Lista listar() {
        Lista lis = new Lista();
        listarAux(raiz, lis);
        return lis;
    }

    public void listarAux(NodoABB aux, Lista lis) {
        if (aux != null) {
            listarAux(aux.getIzquierdo(), lis);

            lis.insertar(lis.longitud() + 1, aux.getElem());

            listarAux(aux.getDerecho(), lis);

        }
    }

    //------------------------------------------------------------------------------------------
    public Lista listarRango(Comparable min, Comparable max) {
        Lista lis = new Lista();
        listarRangoAux(raiz, min, max, lis);
        return lis;
    }

    private void listarRangoAux(NodoABB aux, Comparable min, Comparable max, Lista lis) {
        if (aux != null) {

            //Si el minimo es menor que el elemento donde estoy parado, entonces bajo a izquierda
            if ((min.compareTo(aux.getElem()) < 0)) {
                listarRangoAux(aux.getIzquierdo(), min, max, lis);
            }

            //Si el elemento esta en el rango entre el min y el max, lo inserto en la lista
            if ((min.compareTo(aux.getElem()) <= 0) && (max.compareTo(aux.getElem()) >= 0)) {
                lis.insertar(lis.longitud() + 1, aux.getElem());
            }

            //Si el maximo es mayor que el elemento donde estoy parado, entonces bajo a derecha.
            if ((max.compareTo(aux.getElem()) > 0)) {
                listarRangoAux(aux.getDerecho(), min, max, lis);
            }

        }
    }

    //------------------------------------------------------------------------------------------
    public String toString() {
        String mensaje = " ";
        if (raiz == null) {
            mensaje = "Arbol Vacio";
        } else {
            mensaje = toStringAux(raiz);
        }
        return mensaje;
    }

    private String toStringAux(NodoABB nodo) {
        String mensaje = "";
        if (nodo != null) {
            mensaje = " \n " + " Nodo:  " + nodo.getElem() + mensaje + " \n ";
            if (nodo.getIzquierdo() != null) {
                mensaje = mensaje + (" HI: " + nodo.getIzquierdo().getElem());
            } else {
                mensaje = mensaje + " HI: - ";
            }
            if (nodo.getDerecho() != null) {
                mensaje = mensaje + (" HD: " + nodo.getDerecho().getElem());
            } else {
                mensaje = mensaje + " HD: - ";
            }
        }
        if (nodo.getIzquierdo() != null) {
            mensaje = mensaje + toStringAux(nodo.getIzquierdo());
        }
        if (nodo.getDerecho() != null) {
            mensaje = mensaje + toStringAux(nodo.getDerecho());
        }

        return mensaje;
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

    private boolean eliminarAux(NodoABB hijo, NodoABB padre, Comparable elemento) {
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
                    tieneDosHijos(hijo);
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

        }
        return exito;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //Eliminar: Caso 1, donde el nodo es Hoja
    private void eliminarHoja(NodoABB hijo, NodoABB padre, Comparable buscado) {
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
    private void tieneUnHijo(NodoABB hijo, NodoABB padre, Comparable buscado) {
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

    //Eliminar: Caso 3, donde el nodo tiene los dos hijos
    /*private void tieneDosHijos(NodoABB hijo,NodoABB padre, Comparable buscado){
              NodoABB aEliminar;
              NodoABB candidato;
              NodoABB padreCandidato;
              if(padre!=null){
                  //Caso derecho 
                    if(padre.getDerecho()!=null && buscado.compareTo(padre.getDerecho().getElem())==0 && hijo.getDerecho()!=null && hijo.getIzquierdo()!=null){
                        aEliminar= hijo;
                        candidato= aEliminar.getDerecho();
                        padreCandidato= hijo;
                        //Si el candidato tiene hijos
                        if(candidato.getIzquierdo()!=null && candidato.getDerecho()!=null){
                              while(candidato.getIzquierdo()!=null){
                                  padreCandidato = candidato;
                                  candidato = candidato.getIzquierdo();
                              }
                              aEliminar.setElemento(candidato.getElem());
                              padreCandidato.setIzquierdo(candidato.getDerecho());
                              //Si el candidato no tiene hijos
                        }else{
                              aEliminar.setElemento(candidato.getElem());
                              padreCandidato.setDerecho(null);
                        }

                           //Caso izquierdo
                    }else if(padre.getIzquierdo()!=null && buscado.compareTo(padre.getIzquierdo().getElem())==0 && padre.getDerecho()!=null && hijo.getDerecho()!=null){
                        aEliminar= padre.getIzquierdo();
                        candidato= aEliminar.getIzquierdo();
                        padreCandidato= hijo;
                        //Si el candidato tiene hijos
                        if(candidato.getDerecho()!=null && candidato.getIzquierdo()!=null){
                              while(candidato.getDerecho()!=null){
                                  padreCandidato= candidato;
                                  candidato=candidato.getDerecho();
                              }
                              aEliminar.setElemento(candidato.getElem());
                              padreCandidato.setDerecho(candidato.getIzquierdo());
                        //Si el candidato no tiene hijos
                        }else{
                              aEliminar.setElemento(candidato.getElem());
                              padreCandidato.setIzquierdo(null);
                        }
                    }
              }else{
                  //Caso de la raiz. Donde el padre es nulo
                aEliminar= hijo;
                candidato=hijo.getIzquierdo();
                padreCandidato=hijo;
                //Caso donde el candidato tiene hijos
                 if(candidato.getIzquierdo()!=null && candidato.getIzquierdo()!=null){
                          while(candidato.getDerecho()!=null){
                                  padreCandidato = candidato;
                                  candidato = candidato.getDerecho();
                            }
                           aEliminar.setElemento(candidato.getElem());
                           padreCandidato.setDerecho(candidato.getIzquierdo());
                           //Caso donde el candidato no tiene hijos
                  }else{
                           aEliminar.setElemento(candidato.getElem());
                           padreCandidato.setIzquierdo(null);
                        }
              }
    }*/
    private void tieneDosHijos(NodoABB hijo) {
        NodoABB aEliminar;
        NodoABB candidato;
        NodoABB padreCandidato;
        aEliminar = hijo;
        candidato = hijo.getIzquierdo();
        padreCandidato = hijo;
        if (candidato.getDerecho() != null) {
            while (candidato.getDerecho() != null) {
                padreCandidato = candidato;
                candidato = candidato.getDerecho();
            }
            aEliminar.setElemento(candidato.getElem());
            padreCandidato.setDerecho(candidato.getIzquierdo());
        } else {
            aEliminar.setElemento(candidato.getElem());
            aEliminar.setIzquierdo(aEliminar.getIzquierdo().getIzquierdo());
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------  

    private boolean equalsAux(NodoABB original, NodoABB copia) {
        boolean rta = true;
        if (original != null && copia != null) {
            if (original.getElem().compareTo(copia.getElem()) == 0) {
                rta = equalsAux(original.getIzquierdo(), copia.getIzquierdo());
                if (rta) {
                    rta = equalsAux(original.getDerecho(), copia.getDerecho());
                }
            } else {
                rta = false;
            }
        } else if (original == null && copia == null && rta) {
            rta = true;
        } else {
            rta = false;
        }
        return rta;
    }

    public boolean equals(ArbolBB otroArbol) {
        return equalsAux(raiz, otroArbol.raiz);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------

    public Lista listarMayoresQue(Comparable valor, Comparable raizElem) {
        Lista lis = new Lista();
        NodoABB aux = obtenerNodoAux(raiz, raizElem);
        listarMayoresQueAux(aux, valor, lis);
        return lis;
    }

    private void listarMayoresQueAux(NodoABB aux, Comparable valor, Lista lis) {
        if (aux != null) {
            if (aux.getElem().compareTo(valor) > 0) {
                listarMayoresQueAux(aux.getIzquierdo(), valor, lis);
            }

            if (aux.getElem().compareTo(valor) >= 0) {
                lis.insertar(lis.longitud() + 1, aux.getElem());
            }

            listarMayoresQueAux(aux.getDerecho(), valor, lis);

        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean eliminarAnterior(Comparable elem) {
        boolean rta = false;
        if (raiz != null) {
            rta = eliminarAnteriorAux(raiz, elem);
        }
        return rta;
    }

    private boolean eliminarAnteriorAux(NodoABB aux, Comparable elem) {
        boolean rta = false;
        if (aux != null) {
            if (aux.getElem().compareTo(elem) == 0) {
                if (aux.getIzquierdo() != null) {
                    NodoABB padreCandi = aux;
                    NodoABB candidato = aux.getIzquierdo();
                    if (candidato.getDerecho() != null) {
                        while (candidato.getDerecho() != null) {
                            padreCandi = candidato;
                            candidato = candidato.getDerecho();
                        }
                        padreCandi.setDerecho(candidato.getIzquierdo());
                        rta = true;
                    } else {
                        aux.setIzquierdo(aux.getIzquierdo().getIzquierdo());
                        rta = true;
                    }
                }
            } else {

                if (elem.compareTo(aux.getElem()) < 0 && !rta) {
                    rta = eliminarAnteriorAux(aux.getIzquierdo(), elem);
                }

                if (elem.compareTo(aux.getElem()) > 0 && !rta) {
                    rta = eliminarAnteriorAux(aux.getDerecho(), elem);
                }

            }
        }
        return rta;
    }

    private NodoABB obtenerNodoAux2(NodoABB aux, Comparable elem) {
        NodoABB retorno = null;
        if (aux != null) {
            if (elem.compareTo(aux.getElem()) == 0) {
                retorno = aux;
            } else {
                if (elem.compareTo(aux.getElem()) < 0) {
                    retorno = obtenerNodoAux(aux.getIzquierdo(), elem);
                }
                if (retorno == null) {
                    if (elem.compareTo(aux.getElem()) > 0) {
                        retorno = obtenerNodoAux(aux.getDerecho(), elem);
                    }
                }
            }
        }
        return retorno;
    }

    private void clonarInvertido(NodoABB original, NodoABB clon) {
        if (original != null && clon != null) {
            if (original.getIzquierdo() != null) {
                clon.setDerecho(new NodoABB(original.getIzquierdo().getElem(), null, null));
            }
            if (original.getDerecho() != null) {
                clon.setIzquierdo(new NodoABB(original.getDerecho().getElem(), null, null));
            }
            clonarInvertido(original.getIzquierdo(), clon.getDerecho());
            clonarInvertido(original.getDerecho(), clon.getIzquierdo());
        }
    }

    public ArbolBB clonarInvertidoPublico(Comparable elem) {
        NodoABB original = obtenerNodoAux2(raiz, elem);
        NodoABB raizClon = new NodoABB(elem, null, null);
        ArbolBB nuevo = new ArbolBB();
        nuevo.raiz = raizClon;
        clonarInvertido(original, nuevo.raiz);
        return nuevo;
    }

    public Comparable mejorCandidatoPublico(Comparable elem) {
        Comparable retorno = -1;
        NodoABB ret = mejorCandidato2(raiz, elem);
        if (ret == null) {
            retorno = 0;
        } else {
            retorno = ret.getElem();
        }
        return retorno;
    }

    private NodoABB mejorCandidato2(NodoABB aux, Comparable elem) {
        NodoABB mejorCandi = null;
        if (aux != null) {
            if (elem.compareTo(aux.getElem()) == 0) {
                if (aux.getIzquierdo() != null && aux.getDerecho() != null) {
                    NodoABB canIzq = aux.getIzquierdo();
                    NodoABB canDer = aux.getDerecho();
                    while (canIzq.getDerecho() != null) {
                        canIzq = canIzq.getDerecho();
                    }
                    while (canDer.getIzquierdo() != null) {
                        canDer = canDer.getIzquierdo();
                    }
                    Comparable canD = canDer.getElem();
                    Comparable canI = canIzq.getElem();
                    Comparable ele = aux.getElem();
                    //Diferencia entre canI y ele
                    int diffCanIEle = (int) ele - (int) canI;
                    //Diferencia entre canD y ele
                    int diffCanDEle = (int) canD - (int) ele;

                    if (diffCanIEle < diffCanDEle) {
                        System.out.println(diffCanIEle);
                        mejorCandi = canIzq;
                    } else {
                        System.out.println(diffCanDEle);
                        mejorCandi = canDer;
                    }
                } else if (aux.getIzquierdo() == null && aux.getDerecho() != null) {
                    NodoABB canDer = aux.getDerecho();
                    while (canDer.getIzquierdo() != null) {
                        canDer = canDer.getIzquierdo();
                    }
                    mejorCandi = canDer;
                } else {
                    NodoABB canIzq = aux.getIzquierdo();
                    while (canIzq.getDerecho() != null) {
                        canIzq = canIzq.getDerecho();
                    }
                    mejorCandi = canIzq;
                }

            } else {
                if (elem.compareTo(aux.getElem()) < 0) {
                    mejorCandi = mejorCandidato2(aux.getIzquierdo(), elem);
                }
                if (mejorCandi == null) {
                    if (elem.compareTo(aux.getElem()) > 0) {
                        mejorCandi = mejorCandidato2(aux.getDerecho(), elem);
                    }
                }
            }
        }
        return mejorCandi;
    }

    public Comparable mejorCandidato(Comparable elem) {
        Comparable aux = mejorCandidatoAux(raiz, elem);
        Comparable retorno;
        if (aux == null) {
            retorno = 0;
        } else {
            retorno = aux;
        }
        return retorno;
    }

    private Comparable mejorCandidatoAux(NodoABB aux, Comparable elem) {
        Comparable retorno = null;
        if (aux != null) {
            if (aux.getElem().compareTo(elem) == 0) {
                if (aux.getIzquierdo() != null && aux.getDerecho() != null) {
                    NodoABB candiIzq = aux.getIzquierdo();
                    NodoABB candiDer = aux.getDerecho();
                    while (candiIzq.getDerecho() != null) {
                        candiIzq = candiIzq.getDerecho();
                    }
                    while (candiDer.getIzquierdo() != null) {
                        candiDer = candiDer.getIzquierdo();
                    }
                    int compIzq = (int) candiIzq.getElem();
                    int compDer = (int) candiDer.getElem();
                    int compElem = (int) elem;

                    if ((compElem - compIzq) < (compDer - compElem)) {
                        retorno = candiIzq.getElem();
                    } else if ((compElem - compIzq) > (compDer - compElem)) {
                        retorno = candiDer.getElem();
                    }

                } else if (aux.getIzquierdo() != null && aux.getDerecho() == null) {
                    NodoABB candiIzq = aux.getIzquierdo();
                    while (candiIzq.getDerecho() != null) {
                        candiIzq = candiIzq.getDerecho();
                    }
                    retorno = candiIzq.getElem();
                } else if (aux.getIzquierdo() == null && aux.getDerecho() != null) {
                    NodoABB candiDer = aux.getDerecho();
                    while (candiDer.getIzquierdo() != null) {
                        candiDer = candiDer.getIzquierdo();
                    }
                    retorno = candiDer.getElem();
                } else if (aux.getIzquierdo() == null && aux.getDerecho() == null) {
                    retorno = -1;
                }
            } else {
                if (elem.compareTo(aux.getElem()) < 0) {
                    retorno = mejorCandidatoAux(aux.getIzquierdo(), elem);
                }
                if (retorno == null) {
                    if (elem.compareTo(aux.getElem()) > 0) {
                        retorno = mejorCandidatoAux(aux.getDerecho(), elem);
                    }
                }
            }
        }
        return retorno;
    }

    public int mejorCandidatoAgus(Comparable elem) {
        int rt;

        rt = existeElemento(this.raiz, elem);
        return rt;
    }

    private int existeElemento(NodoABB n, Comparable el) {
        int rt = -1;
        int candidato1;
        int candidato2;
        if (n != null) {
            if (n.getElem().compareTo(el) == 0) {
                if (n.getDerecho() == null && n.getIzquierdo() == null) {
                    rt = -1;
                } else if (n.getIzquierdo() != null && n.getDerecho() == null) {
                    rt = (int) candidatoIzq(n.getIzquierdo());
                } else if (n.getIzquierdo() == null && n.getDerecho() != null) {
                    rt = (int) candidatoDer(n.getDerecho());
                } else if (n.getIzquierdo() != null && n.getDerecho() != null) {
                    candidato1 = (int) candidatoIzq(n.getIzquierdo());
                    candidato2 = (int) candidatoDer(n.getDerecho());
                    int pad = (int) n.getElem();
                    if (pad - candidato1 < candidato2 - pad) {
                        rt = candidato1;
                    } else {
                        rt = candidato2;
                    }
                }
            } else if (el.compareTo(n.getElem()) < 0) {
                rt = existeElemento(n.getIzquierdo(), el);
            } else {
                rt = existeElemento(n.getDerecho(), el);
            }
        }
        return rt;
    }

    private Comparable candidatoIzq(NodoABB aux) {
        Comparable valorCandidato = -1;
        if (aux.getDerecho() != null) {
            aux = aux.getDerecho();
            while (aux != null) {
                aux = aux.getDerecho();
                if (aux != null) {
                    valorCandidato = aux.getElem();
                }

            }
        } else {
            valorCandidato = aux.getElem();
        }
        return valorCandidato;
    }

    private Comparable candidatoDer(NodoABB aux) {
        Comparable valorCandidato = aux.getElem();

        if (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
            while (aux != null) {
                aux = aux.getIzquierdo();
                if (aux != null) {
                    valorCandidato = aux.getElem();
                }
            }
        } else {
            valorCandidato = aux.getElem();
        }
        return valorCandidato;
    }
}
