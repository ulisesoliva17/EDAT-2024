
package testt;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Lista;


 // @author ulise
public class testLista {


    public static void main(String[] args) {
        // 
        Lista lista1= new Lista();
        lista1.insertar(1, 10);
        lista1.insertar(2,11);
        lista1.insertar(3, 12);
        lista1.insertar(4, 13);
        lista1.insertar(5, 14);
        lista1.insertar(6, 15);
        lista1.insertar(7, 16);
        lista1.insertar(8, 17);
        lista1.insertar(9, 18);
        lista1.insertar(10, 19);
        System.out.println(lista1.toString());
        lista1.cambiarPosiciones(5, 1);
        System.out.println(lista1.toString());


        
    }

}
