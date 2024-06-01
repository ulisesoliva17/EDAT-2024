package Conjuntistas;

/**
 *
 * @author ulise
 */
public class HeapMin {
    private Comparable[] heap;
    private int ultimo;
    private int TAMANIO=20;
    
    public HeapMin(){
        heap= new Comparable[TAMANIO];
        ultimo= 0; //La posicion 0 nunca es utilizada
    }
    public boolean eliminarCima(){
        boolean exito;
        if(ultimo == 0){
            //Estructura vacia
            exito=false;
        }else{
            heap[1]= heap[ultimo];
            ultimo --;
            hacerBajar(1);
            exito=true;
        }
        return exito;
    }
    private void hacerBajar(int posPadre){
        int posHijo;
        Comparable temp= heap[posPadre];
        boolean salir=false;
        while(!salir){
            posHijo= posPadre *2;
            if(posHijo<= ultimo){
                //Temp tiene al menos un hijo izq y lo considera menor
                    if(posHijo < ultimo){
                        //Hijomenor tiene hermano derecho
                        if(heap[posHijo+1].compareTo(heap[posHijo])<0){
                            //el hijo derecho es el menor de los dos
                            posHijo++;
                        }
                    }
                    //Compara al hijo menor con el padre
                    if(heap[posHijo].compareTo(temp)<0){
                        //el hijo es menor que el padre, los intercambia
                        heap[posPadre]= heap[posHijo];
                        heap[posHijo]= temp;
                        posPadre= posHijo;
                    }else{
                        //el padre es menor que sus hijos, esta bien ubicado
                        salir=true;
                    }
            }else{
                //El temp es hoja, esta bien ubicado
                salir=true;
            }
        }
    }
     public boolean insertar(Comparable elem) {
        // Inserta un elemento en el árbol.
        boolean exito = false;
        if (this.TAMANIO > this.ultimo + 1) {
            this.heap[this.ultimo + 1] = elem;
            this.ultimo++;
            hacerSubir(ultimo);
            exito = true;
        }
        return exito;
    }
    private void hacerSubir(int posHijo) {
        int posPadre;
        Comparable temp = this.heap[posHijo];
        boolean salir = false;
        while (!salir) {
            //Este while hace que el elemento en posHIjo suba hasta su debida posicion.
            posPadre = posHijo / 2;
            //Compara si la raiz es igual que hijo
            if (this.heap[1].compareTo(this.heap[posHijo]) == 0) {
                salir = true;
                //Compara si hijo es mayor que el padre
            } else if (this.heap[posHijo].compareTo(this.heap[posPadre]) > 0) {
                salir = true;
                //Si hijo es menor que padre, entonces hace subir al hijo.
            } else {
                temp = this.heap[posPadre];
                this.heap[posPadre] = this.heap[posHijo];
                this.heap[posHijo] = temp;
                posHijo = posHijo / 2;
            }
        }
    }
     //------------------------------------------------------------------------------------------------------
         public Comparable recuperarCima() {
        // Recupera el elemento de la cima del árbol.
        Comparable exito = null;
        if (!esVacio()) {
            exito = this.heap[1];
        }
        return exito;
    }

    public boolean esVacio() {
        // Indica si el árbol está vacío.
        return this.ultimo == 0;
    }

    public void vaciar() {
        // Vacía el árbol.
        this.ultimo = 0;
    }
     //-------------------------------------------------------------------------------------------------------

    public String toString() {
        String cadena = "ESTRUCTURA VACIA";
        if (!esVacio()) {
            cadena = "";
            for (int i = 1; i <= this.ultimo; i++) {
                cadena += this.heap[i] + "\t-->";
                if (i * 2 < this.ultimo) {
                    // hay hijo izquierdo
                    cadena += "HI: " + this.heap[2 * i];
                    if (i * 2 + 1 < this.ultimo) {
                        // hay hijo derecho
                        cadena += "\tHD: " + this.heap[(2 * i) + 1] + "\n";
                    } else {
                        // no hay hijo derecho
                        cadena += "\n";
                    }
                } else {
                    // no hay hijo izquierdo
                    cadena += "\n";
                }
            }
        }
        return cadena;
    }
      
    
}
