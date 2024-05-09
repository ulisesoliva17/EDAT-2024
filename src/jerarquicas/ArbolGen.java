package jerarquicas;

/**
 *
 * @author ulise
 */
public class ArbolGen {
    private NodoGen raiz;
    
    public ArbolGen(){
        raiz=null;
    }
     //--------------------------------------------------------------------------------------------------
    public boolean insertar(Object elemNuevo, Object elemPadre){
        boolean rta=false;
        NodoGen nuevo= new NodoGen(elemNuevo, null,null);
        if(raiz==null){
            raiz= nuevo;
        }else{
            NodoGen padre= obtenerNodo(raiz,elemPadre);
            if(padre!=null){
                NodoGen hijo= padre.getHijoIzquierdo();
                if(hijo!=null){
                    while(hijo.getHermanoDerecho()!=null){
                        hijo= hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevo);
                    rta=true;
                }else{
                    padre.setHijoIzquierdo(nuevo);
                    rta=true;
                }
            }
        }
        return rta;
    }
    public NodoGen obtenerNodo(NodoGen aux, Object buscado){
        NodoGen retorno= null;
        if(aux!=null){
            if(aux.getElem().equals(buscado)){
                retorno= aux;
            }
            
            if(aux.getHijoIzquierdo()!=null && retorno==null){
                NodoGen hijo= aux.getHijoIzquierdo();
                while(hijo!=null && retorno==null){
                    retorno= obtenerNodo(hijo, buscado);
                    hijo= hijo.getHermanoDerecho();
                }
            }
        }
        return retorno;
    }
     //--------------------------------------------------------------------------------------------------
    public String toString(){
        return toStringAux(raiz);
    }
    
    private String toStringAux(NodoGen n){
        String s="";
        if(n!=null){
            s+=n.getElem().toString()+"--->";
            NodoGen hijo = n.getHijoIzquierdo();
            while(hijo!=null){
                s+=hijo.getElem().toString()+", ";
                hijo= hijo.getHermanoDerecho();
            }
            
            
            hijo= n.getHijoIzquierdo();
            while(hijo!=null){
                s+="\n"+toStringAux(hijo);
                hijo= hijo.getHermanoDerecho();
            }
        }
        return s;
    }
    //--------------------------------------------------------------------------------------------------
    public boolean pertenece(Object buscado){
        return perteneceAux(raiz,buscado);
    }
    private boolean perteneceAux(NodoGen aux, Object buscado){
        boolean retorno= false;
        if(aux!=null){
            if(aux.getElem().equals(buscado)){
                retorno= true;
            }
            
            //Llamado recursivo con el segundo hijo en adelante de aux
            if(aux.getHijoIzquierdo()!=null && !retorno){
                NodoGen hijo= aux.getHijoIzquierdo();
                while(hijo!=null && !retorno){
                    retorno= perteneceAux(hijo, buscado);
                    hijo= hijo.getHermanoDerecho();
                }
            }
        }
        return retorno;
    }
     //--------------------------------------------------------------------------------------------------
    
    public boolean esVacio(){
        return raiz==null;
    }
    
     //--------------------------------------------------------------------------------------------------
    public Object obtenerPadre(Object hijo){
        NodoGen padre = obtenerPadreAux(raiz, hijo);
        Object retorno = null;
        if(padre!=null){
            retorno = padre.getElem();
        }
        return retorno;
    }
    

   private NodoGen obtenerPadreAux(NodoGen aux, Object hijo){
    NodoGen retorno=null;
        if(aux!=null){
            NodoGen candidato = aux.getHijoIzquierdo();
            while(candidato!=null && retorno==null){
                if(candidato.getElem().equals(hijo)){
                    retorno= aux;
                }
                candidato= candidato.getHermanoDerecho();
            }
            
            
            candidato= aux.getHijoIzquierdo();
            while(candidato!=null && retorno==null){
                retorno=obtenerPadreAux(candidato, hijo);
                candidato= candidato.getHermanoDerecho();
            }
        }
        return retorno;
   }

    
     //--------------------------------------------------------------------------------------------------
 

    
     //--------------------------------------------------------------------------------------------------
}
