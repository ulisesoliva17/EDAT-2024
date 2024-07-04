
package testConjuntistas;
import Conjuntistas.ArbolBB;
import lineales.dinamicas.Lista;

import Conjuntistas.ArbolBB;


 // @author ulise
public class testABB {


    public static void main(String[] args) {
        // 
        ArbolBB arbol= new ArbolBB();
        arbol.insertar(16);
        arbol.insertar(9);
        arbol.insertar(4);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(14);
        arbol.insertar(50);
        arbol.insertar(24);
        arbol.insertar(17);
        arbol.insertar(27);
        arbol.insertar(57);
        arbol.insertar(53);
        arbol.insertar(67);
        System.out.println(arbol.toString());
        System.out.println(arbol.mejorCandidatoAgus(16));
       /* arbol.eliminar(9);
        System.out.println(arbol.toString());*/
        /*Lista lis = new Lista();
        lis= arbol.listarMayoresQue(6,9);
        System.out.println(lis.toString());*/
         /*ArbolBB arbol2= new ArbolBB();
        arbol2.insertar(15);
        arbol2.insertar(50);
        arbol2.insertar(10);
        arbol2.insertar(9);
        arbol2.insertar(4);
        arbol2.insertar(3);
        arbol2.insertar(7);
        arbol2.insertar(12);
        arbol2.insertar(14);
        arbol2.insertar(24);
        arbol2.insertar(27);
        arbol2.insertar(57);
        arbol2.insertar(53);
        arbol2.insertar(67);
        System.out.println(arbol.equals(arbol2));*/
        
        
    }

}
