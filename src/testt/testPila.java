package testt;
/*Autores
Agustin Alonso FAI-2533
Matias Degl'innocenti FAI-3293
Oliva Ulises FAI-3296
*/
//import lineales.estaticas.Pila;
import lineales.dinamicas.Pila;

public class testPila {
    public static void main(String[] args){
        Pila p1 = new Pila();
        Pila clon = new Pila();

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(4);
        p1.apilar(5);
        p1.apilar(6);
        p1.apilar(7);
        p1.apilar(8);
        p1.apilar(9);
        p1.apilar(10);
     

        System.out.println("Muestra pila 1,2,3,4,5,6,7,8,9,10:"+"\t\t"+p1.toString());
        clon = p1.clone();
        System.out.println("Pila Clone 1,2,3,4,5,6,7,8,9,10"+"\t\t"+clon.toString());
        System.out.println("Desapila Pila original "+p1.desapilar());//desapila 1
        System.out.println("Desapila Pila original "+p1.desapilar());//desapila 2
        System.out.println("Desapila Pila original "+p1.desapilar());//desapila 3
        System.out.println("Tope pila Original 7: "+"\t\t"+p1.obtenerTope()); //1,2,3,4,5,6,7
        System.out.println("Tope pila Clone 10: "+"\t\t"+clon.obtenerTope()); // 1,2,3,4,5,6,7,8,9,10
        System.out.println("Desapilo Clone:"+clon.desapilar());
        System.out.println("Muestro Pila Original 1,2,3,4,5,6,7 :"+"\t\t"+p1.toString());
        System.out.println("Muestro Pila clone 1,2,3,4,5,6,7,8,9: "+"\t\t"+clon.toString());
        System.out.println("Vacio Pila Original");
        p1.vaciar();
        System.out.println("Pila original es Vacia true: "+"\t\t"+p1.esVacia());
        System.out.println("Pila Clone es Vacia false: "+"\t\t"+clon.esVacia());
        System.out.println("Apilo 10 en Clone, true :"+"\t\t"+clon.apilar(10));
        System.out.println("Apilo 20 en Clone, true(dinamica) / false(estatica): "+"\t\t"+clon.apilar(20));//dinamica(1,2,3,4,5,6,7,8,9,10,20) estatica(1,2,3,4,5,6,7,8,9,10)
        System.out.println("Apilo 23 en Pila true: "+p1.apilar(23));

        System.out.println("Muestro pila original 23: "+"\t\t"+p1.toString());
        System.out.println("Muestro Pila clone estatica(1,2,3,4,5,6,7,8,9,10)  / dinamica(1,2,3,4,5,6,7,8,9,10,20)"+"\t\t"+clon.toString());
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------
         Pila pila = new Pila();
        Pila pila2 = new Pila();
        pila.apilar('a');
        pila.apilar('b');
        pila.apilar('b');
        pila.apilar('a');
        pila2=pila.clone();
        Pila clon2= new Pila();
        clon2= pila.clone();
        Pila pila3= new Pila();
        pila3= pilaInvertida(clon2);
        if(verificarCapicua(pila2, pila3)){
            System.out.println("Es capicua");
        }else{
            System.out.println("No es capicua");
        }
        System.out.println(pila.toString());
    }
      public static Pila pilaInvertida(Pila clon){
        //Este metodo usa una pila auxiliar la cual queda cargada invertida a la original
        Pila pilita= new Pila();
        while(!clon.esVacia()){
            pilita.apilar(clon.obtenerTope());
            clon.desapilar();
        }
        return pilita;
    }
    
    public static boolean verificarCapicua(Pila pilita,Pila invertida){
        //Este metodo compara la invertida y la original
        //Si es capicua larga verdadero, y si en algun momento no es igual en el recorrido
        //Hace el corte por corto circuito.
        boolean exito=true;
        while(!pilita.esVacia() && exito==true){
            if(pilita.obtenerTope().equals(invertida.obtenerTope())){
                exito=true;
                pilita.desapilar();
                invertida.desapilar();
            }else{
                exito=false;
            }
        }
        return exito;
    }
}
