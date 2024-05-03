
package testt;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Lista;


 // @author ulise
public class testLista {


    public static void main(String[] args) {
        // 
        Lista lista1= new Lista();
        lista1.insertar(1, 'a');
        lista1.insertar(2,'b');
        lista1.insertar(3, 'c');
        lista1.insertar(4, 'b');
        lista1.insertar(5, 'a');
         
        System.out.println(lista1.toString());
        System.out.println(lista1.esCapicua());


        
    }

}
