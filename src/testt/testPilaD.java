
package testt;
/*Autores
Agustin Alonso FAI-2533
Matias Degl'innocenti FAI-3293
Oliva Ulises FAI-3296
*/
import lineales.dinamicas.Pila;


 // @author ulise
public class testPilaD {


    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(3);
        Pila pila2 = new Pila();
        pila2.apilar(1);
        pila2.apilar(2);
        
        pila2.apilar(4);
        System.out.println(pila.equals(pila2));
        
    }

}
