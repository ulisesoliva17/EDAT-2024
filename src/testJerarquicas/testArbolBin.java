
package testJerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;


 // @author ulise
public class testArbolBin {


    public static void main(String[] args) {
        // 
        ArbolBin arbolito = new ArbolBin();
        arbolito.insertar(1, 1, 'i');
        arbolito.insertar(2, 1, 'i');
        arbolito.insertar(3, 1, 'd');
        //arbolito.insertar(4, 2, 'i');
        arbolito.insertar(5, 2, 'd');
        arbolito.insertar(6, 3, 'i');
        arbolito.insertar(7, 3, 'd');
        //arbolito.insertar(3, 6, 'i');
        System.out.println(arbolito.toString());
        System.out.println(arbolito.menosdeCantApariciones(3, 2));
        
        
        
        
        
        //arbolito.completarHijos();
        //System.out.println(arbolito.toString());
         /*System.out.println(arbolito.listarPreOrden());
         ArbolBin arbolito2 = new ArbolBin();
         Lista lis= new Lista();
         lis= arbolito.armarListaInOrden(3);
         System.out.println(lis.toString());*/
       /* Lista lis= new Lista();
        lis.insertar(1, 1);
        lis.insertar(2, 3);
        lis.insertar(3, 7);
        lis.insertar(4, 5);
        
        System.out.println(arbolito.verificarCamino(lis));*/
           
        
        
    }

}
