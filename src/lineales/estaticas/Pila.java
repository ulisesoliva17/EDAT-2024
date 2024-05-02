package lineales.estaticas;
import java.util.Arrays;
/*Autores
Agustin Alonso FAI-2533
Matias Degl'innocenti FAI-3293
Oliva Ulises FAI-3296
*/

public class Pila {
    private Object [] arreglo;
    private int tope;
    private static final int TAMANIO=10;
    
    
    
    //Constructor
    public Pila(){
        arreglo = new Object[TAMANIO];
        tope= -1;
    }
    
    public boolean apilar(Object elem){
        boolean exito;
        if(tope+1>=TAMANIO){
            //No hay mas lugar para apilar, el arreglo se lleno.
            exito=false;
        }else{
            tope++;
            arreglo[tope]=elem;
            exito=true;
        }
        return exito;
    }
    
    
    public boolean esVacia(){
        return tope==-1;
    }
    
    public Object obtenerTope(){
        Object objeto;
        if(tope==-1){
            objeto=null;
        }else{
            objeto= arreglo[tope];
        }
        return objeto;
    }
    
    public boolean desapilar(){
        boolean exito;
        if(tope==-1){
            exito=false;
        }else{
            arreglo[tope]=null;
            tope--;
            exito= true;
        }
        return exito;
    }
    
    public void vaciar(){
        while(tope!=-1){
            arreglo[tope]=null;
            tope--;
        }
    }
    
     public Pila clone(){
        Pila pilaClonada = new Pila();
        for (int i=0; i<=this.tope;i++){
            pilaClonada.arreglo[i]= this.arreglo[i];
        }
        pilaClonada.tope = tope;
        return pilaClonada;
 }
     
     public String toString(){
        String cadena = Arrays.toString(arreglo);
        return cadena;
    }
}
