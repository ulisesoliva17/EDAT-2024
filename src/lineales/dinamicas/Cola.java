/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

/**
 *
 * @author ulise
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        frente=null;
        fin=null;
    }
    public boolean esVacia(){
        return fin==null;
    }
    
    public boolean poner (Object nuevoElem){
        boolean exito=false;
        Nodo nuevo= new Nodo(nuevoElem, null);
        if(esVacia()){
            frente=nuevo;
            fin=nuevo;
            exito=true;
        }else{
            fin.setEnlace(nuevo);
            fin=nuevo;
            exito=true;
        }
        return exito;
    }
    
    public boolean sacar(){
        boolean exito=false;
        if(frente==null){
            exito=true;
        }else {
            frente=frente.getEnlace();
            if(frente==null){
                fin=null;
            }
        }
        return exito;
    }
    public Object obtenerFrente(){
       Object retorno = null;
       if(this.frente != null){
           retorno = this.frente.getElem();
       }
       return retorno;
   }
    
    public Cola clone(){
        Cola clon = new Cola();
        Nodo aux1=frente;
        clon.frente= new Nodo(aux1.getElem(),null);
        aux1=aux1.getEnlace();
        Nodo aux2= clon.frente;
        while(aux1!=null){
            aux2.setEnlace(new Nodo(aux1.getElem(),null));
            aux2=aux2.getEnlace();
            aux1=aux1.getEnlace();
            }
        //Este metodo hace que aux1 que recorre la cola original, vaya un nodo adelantado
        //Produciendo que lo que este en aux1, se pueda replicar en aux2.
        
        //Por ultimo debemos de decir cual es el fin de la cola clon, que es hasta donde llego el aux2
        clon.fin=aux2;
        return clon;
    }
     public String toString() {
               String cadena = "";
               Nodo temp = this.frente;
               while (temp != null) {
                   cadena = cadena + temp.getElem();
                   temp = temp.getEnlace();
               }
               cadena = cadena;
               return cadena;
           }

    public void vaciar() {
        frente=null;
    }
}
