
package tests.lineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Lista;


 // @author ulise
public class MixLineales {
    
    public static Cola generarOtraCola(Cola c1){
        Pila pilita= new Pila();
        Cola nuevaCola= new Cola();
        Cola colaAux= new Cola();
        
        while(!c1.esVacia()){
            
            while(!c1.esVacia() && (char)c1.obtenerFrente()!='$'){
                pilita.apilar(c1.obtenerFrente());
                nuevaCola.poner(c1.obtenerFrente());
                colaAux.poner(c1.obtenerFrente());
                c1.sacar();
            }
            
            while(!pilita.esVacia()){
                nuevaCola.poner(pilita.obtenerTope());
                pilita.desapilar();
            }
            
            while(!colaAux.esVacia()){
                nuevaCola.poner(colaAux.obtenerFrente());
                colaAux.sacar();
            }
            
           
            if(!c1.esVacia()&& (char)c1.obtenerFrente()=='$'){
                nuevaCola.poner('$');
            }
             c1.sacar();
        }
        return nuevaCola;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    public static Cola generarSecuencia(Cola c1, int t){
        Pila pilita= new Pila();
        Cola retorno= new Cola();
        Cola aux= new Cola();
        int contador=0;
        while(!c1.esVacia()){
            
            while(!c1.esVacia() &&(contador!=t)){
                aux.poner(c1.obtenerFrente());
                pilita.apilar(c1.obtenerFrente());
                contador++;
                c1.sacar();
            }
            
            while(!pilita.esVacia()){
                retorno.poner(pilita.obtenerTope());
                pilita.desapilar();
            }
            
            while(!aux.esVacia()){
                retorno.poner(aux.obtenerFrente());
                aux.sacar();
            }
            
            if(!c1.esVacia()){
                retorno.poner('$');
            }
            contador=0;
        }
        return retorno;
    }
  
    public static boolean verificarBalanceo(Cola c1){
    boolean balanceado = true;
    Pila pilita = new Pila();
    while(!c1.esVacia() && balanceado){
                        
        char x = (char)c1.obtenerFrente();
        System.out.println("tope actual "+x);
        c1.sacar();
            if(x == '{' || x == '[' || x == '('){
                pilita.apilar(x);
            } else {
                if(!pilita.esVacia()){
                    char tope = (char)pilita.obtenerTope();
                      if(x == '}' || x == ']' || x == ')') {
                            if((x == '}' && tope == '{') || (x == ']' && tope == '[') || (x == ')' && tope == '(')){
                                pilita.desapilar();
                            }else{
                                balanceado=false;
                            }
                      }
                }
            }
        }
        if(pilita.esVacia()){
            balanceado = true;
        }
        return balanceado;
    }
    
 /*  public static int cuentaSecuencias(Cola c1){
        Pila pilita= new Pila();
        Cola aux= new Cola();
        boolean capicua= true;
        int contador=0;
        while(!c1.esVacia()){
            
                while(!c1.esVacia() && !c1.obtenerFrente().equals('$')){
                    pilita.apilar(c1.obtenerFrente());
                    aux.poner(c1.obtenerFrente());
                    c1.sacar();
                }
               
                while(!aux.esVacia() && !pilita.esVacia() && capicua){
                    if(pilita.obtenerTope().equals(aux.obtenerFrente())){
                        pilita.desapilar();
                        aux.sacar();
                    }else{
                        capicua=false;
                    }
                }
                
                if(capicua){
                    contador++;
                }
                
                if(!c1.esVacia()){
                    c1.sacar();
                }
                capicua=true;
        }
        return contador;
    }*/
    public static int cuentaSecuencias(Cola c1) {
    Pila pilita = new Pila();
    Cola aux = new Cola();
    boolean capicua = true;
    int contador = 0;
    
    while (!c1.esVacia()) {
        
        while (!c1.esVacia() && !c1.obtenerFrente().equals('$')) {
            pilita.apilar(c1.obtenerFrente());
            aux.poner(c1.obtenerFrente());
            c1.sacar();
        }
        
        while (!aux.esVacia() && !pilita.esVacia() && capicua) {
            if (pilita.obtenerTope().equals(aux.obtenerFrente())) {
                pilita.desapilar();
                aux.sacar();
            } else {
                capicua = false;
            }
        }
        
        if (pilita.esVacia() && aux.esVacia() && capicua) { // Verificar si la secuencia es capicúa
            contador++;
        }
        
        // Limpiar las estructuras para la próxima iteración
        while (!pilita.esVacia()) {
            pilita.desapilar();
        }
        while (!aux.esVacia()) {
            aux.sacar();
        }
        
        //Sacamos el '$'
        if (!c1.esVacia()) {
            c1.sacar();
        }
        capicua = true; // Reiniciar la bandera capicua para la próxima secuencia
    }
    
    return contador;
}
    
public static Lista invertirVocales(Cola c1){
    Pila pilita= new Pila();
    Lista lis= new Lista();
    Cola col=c1.clone();
    Cola colaAux= new Cola();
    boolean rta=false;
    while(!c1.esVacia()){
        //Este while verifica si en la primer secuencia hay vocales o no
            while(!col.esVacia() && !col.obtenerFrente().equals('#') && !rta){
                if(col.obtenerFrente().equals('a') || col.obtenerFrente().equals('e') || col.obtenerFrente().equals('i') || col.obtenerFrente().equals('o') || col.obtenerFrente().equals('u')  ){
                    rta=true;
                }else{
                    col.sacar();
                }
            }
            
            while(!c1.esVacia() && !c1.obtenerFrente().equals('#')){
                //Si hay vocales(rta), apilo para insertar la secuencia invertida
                  if(rta){
                        pilita.apilar(c1.obtenerFrente());
                        c1.sacar();
                  }else{
                //Si no hay vocales(!rta), lo pongo en un auxiliar como viene para despues insertarlo.
                        colaAux.poner(c1.obtenerFrente());
                        c1.sacar();
                  } 
            }
            
       
        //Si la pilita no es vacia, significa que hubo vocal, entonces pongo en la lista la secuencia invertida
        if(!pilita.esVacia()){
            while(!pilita.esVacia()){
                lis.insertar(lis.longitud()+1, pilita.obtenerTope());
                pilita.desapilar();
            }
        }
        //Si la auxiliar no es vacia, significa que no hubo vocal, por ende debe de poner sin invertir.
        if(!colaAux.esVacia()){
            while(!colaAux.esVacia()){
                lis.insertar(lis.longitud()+1, colaAux.obtenerFrente());
                colaAux.sacar();
            }
        }
        
        //Por si no tiene vocal, el col quedo con elementos, entonces debo eliminar hasta el #
        while(!col.esVacia() && !col.obtenerFrente().equals('#')){
            col.sacar();
        }
        
        //Eliminamos el # 
        col.sacar();
        
        //Sacamos el elemento # de la col
        if(!c1.esVacia()){
            c1.sacar();
        }
        
        if(!c1.esVacia()){
            lis.insertar(lis.longitud()+1, '#');
        }
        
        rta = false; // Restablecer rta para la próxima secuencia
    }
    return lis;
}

    
   public static void main(String[] args) {
        // 
        Cola c1= new Cola();
        /*c1.poner('{');
        c1.poner('1');
        c1.poner('[');
        c1.poner('1');
        c1.poner('(');
        c1.poner('{');
        c1.poner(')');
        c1.poner('1');
        c1.poner(']');
        c1.poner('1');
        c1.poner('}');*/
       /* c1.poner(0);
        c1.poner(1);
        c1.poner(2);
        c1.poner(3);
        c1.poner(4);
        c1.poner(5);
        c1.poner(6);
        c1.poner(7);
        c1.poner(8);
        c1.poner(9);*/
        c1.poner('a');
        c1.poner('b');
        c1.poner('c');
        c1.poner('#');
        c1.poner('c');
        c1.poner('d');
        c1.poner('#');
        c1.poner('f');
        c1.poner('a');
        c1.poner('d');
        c1.poner('#');
        c1.poner('j');
        c1.poner('r');
        c1.poner('d');
        c1.poner('#');
        c1.poner('e');
        c1.poner('h');
        c1.poner('y');
        System.out.println("Cola original "+c1.toString());
        Lista list= new Lista();
        list=invertirVocales(c1);
        System.out.println(list.toString());
    }
}
