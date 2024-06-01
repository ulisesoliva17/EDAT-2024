
package testJerarquicas;
import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

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
        arbolito.insertar(555, 3);
        arbolito.insertar(586, 3);
         arbolito.insertar(282, 4);
        arbolito.insertar(171, 4);
        arbolito.insertar(8, 6);
        arbolito.insertar(9, 8);
        arbolito.insertar(78, 8);
        arbolito.insertar(56, 8);
        arbolito.insertar(57, 8);
        arbolito.insertar(58, 8);
        System.out.println(arbolito.toString());
        arbolito.eliminar(78);
        System.out.println("----------------------------------------");
          System.out.println(arbolito.toString());
        //System.out.println(arbolito.esSobrino(171, 2));
        
        /*System.out.println(arbolito.toString());
        System.out.println("----------------------------------------");
        arbolito.insertarEnPosicionHijo(999, 1, 1);
        System.out.println(arbolito.toString());*/
        
        /*System.out.println(arbolito.toString());
         ArbolGen arbolito2= new ArbolGen();
         arbolito2 = arbolito.clone();
         System.out.println("----------------------------------------");
         System.out.println(arbolito.gradoArbol());*/
    }

}
