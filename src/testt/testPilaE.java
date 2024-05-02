
package testt;
import lineales.estaticas.Pila;


 // @author ulise
public class testPilaE {


    public static void main(String[] args) {
        // 
        Pila pila = new Pila();
        Pila pila2 = new Pila();
        pila.apilar('a');
        pila.apilar('b');
        pila.apilar('b');
        pila.apilar('a');
        pila2=pila.clone();
        Pila aaa= new Pila();
        aaa= pila.clone();
        Pila pila3= new Pila();
        pila3= pilaInvertida(aaa);
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
