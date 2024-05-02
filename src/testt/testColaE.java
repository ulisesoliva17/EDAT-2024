
package testt;
import lineales.estaticas.Cola;


 // @author ulise
public class testColaE {


    public static void main(String[] args) {
        // 
        Cola cola = new Cola();
        cola.poner(1);
        cola.poner(2);
        cola.poner(3);
        cola.poner(4);
        cola.poner(5);
        
        Cola cola2 = new Cola();
        cola2= cola.clone();
        cola2.sacar();
        System.out.println(cola.toString());
        System.out.println(cola2.toString());
    }

}
