//INTEGRANTES DEL GRUPO: Viviana Davis | 3-750-919, Joana González | 3-750-2102, Luisa Zuluaga | 20-14-6063
import java.util.Vector;
import java.io.*;

public class SemestralGanador {
    

    public static void Vencedor(int gani, String nombis[]) {
        //Mensajes por si el ganador es el jug. 1

        if(gani == 1){
            System.out.println("\t\t\t\t\tEL GANADOR DE LA PARTIDA ES "+ nombis[gani-1]);
            System.out.println("\t\t\t\t\tFELICIDADES!!!!");

            SemestralPantalla.PantallaPausa();
            //llamada del feedback
            SemestralGanador.Feedback(nombis);

            System.out.println("Suerte para la proxima "+nombis[gani]+":(");

        }
        //Mensajes por si el ganador es el jug.2
        else{
            System.out.println("\t\t\t\t\tEL GANADOR DE LA PARTIDA ES "+ nombis[gani-1]);
            System.out.println("\t\t\t\t\tFELICIDADES!!!!");

            SemestralPantalla.PantallaPausa();
            //Lamada del feedback
            SemestralGanador.Feedback(nombis);

            System.out.println("\n\n\nSuerte para la proxima "+nombis[gani-2]+":(");
        }//fin de condiciones
        
        
    }//fin de metodo Vencedor

    public static void Feedback(String nomb[]) {
        //Declaracion de variables
        Vector movi = SemestralCombate.Movimientos;
        int x = SemestralCombate.move;

        System.out.println("FEEDBACK DE POSICIONES");
        System.out.println(nomb[0]+"\t\t\t"+nomb[1]);
       
        //IMPRESION DEL VECTOR
        if(x%2==1){
            
            for(int j=0;j<x;j=j+2){
                //Por si uno de los jugadores se sale abruptamente o coloca espacio o no coloca nada
                movi.insertElementAt("**", x);
                System.out.println("CB:"+movi.elementAt(j)+"\t\t\tCN:"+movi.elementAt(j+1));
            }
        }else{
           for(int j=0;j<x;j=j+2){
               System.out.println("CB:"+movi.elementAt(j)+"\t\t\tCN:"+movi.elementAt(j+1));
            } 
        }
        
    }//Fin de metodo Feedback

    public static char Reinicio () throws IOException{

        //Declaracion de variables
        String desi= " ";
        char desif = ' ';
        boolean condi = true;

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        //Condicion 
        while(condi){
        
            System.out.println("\n\nDesea regresar al menu?\n Ingrese x si desea salir\n Ingrese r si desea regresar al menu");
            desi = lector.readLine();
        
            
            if(desi.length() != 1){
                System.out.println("ERROR. Dato invalido");
                System.out.println("Intentelo nuevamente");
            }
            else if(desi.length()==1){
                desif = desi.charAt(0);

                if(desif != 'x' && desif != 'r' && desif!='X' && desif !='R'){
                    System.out.println("ERROR. Dato invalido");
                    System.out.println("Intentelo nuevamente"); 
                }
                else if(desif == 'x' || desif=='X'|| desif == 'r'|| desif =='R'){
                    condi = false;
                }
            }
        }//fin de while
        return desif;

    }//fin de metodo Reinicio
}//fin de clase
