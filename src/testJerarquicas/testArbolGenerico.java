
package testJerarquicas;
import jerarquicas.ArbolGen;

public class testArbolGenerico {


    public static void main(String[] args) {
        
        // 
        ArbolGen arbolito= new ArbolGen();
        arbolito.insertar(1, 1);
        arbolito.insertar(2, 1);
        arbolito.insertar(3, 1);
        arbolito.insertar(4, 1);
        arbolito.insertar(5, 2);
        arbolito.insertar(6, 2);
        arbolito.insertar(7, 2);
        arbolito.insertar(8, 3);
        System.out.println(arbolito.toString());
        System.out.println(arbolito.obtenerPadre(4));
    }

}
