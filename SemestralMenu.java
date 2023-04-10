//INTEGRANTES DEL GRUPO: Viviana Davis | 3-750-919, Joana González | 3-750-2102, Luisa Zuluaga | 20-14-6063
import java.io.*;

public class SemestralMenu {
    //Declaracion de variables
    static int ganador = 0;
    static String ajedrez[][] = new String[10][10], jugad[]= new String[2];

    public static void main(String[] args) throws IOException {
        //Declaracion de variables
        int opcion;
        char opci=' ';
        boolean cond = true;
    
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        
        //TITULO DEL PROYECTO
        System.out.println("\t\t\t\t\t\t   ----------------------------------------------------");
        System.out.println("\t\t\t\t\t\t  |     Bienvenidos al juego Ajedrez: Only Horses      |");
        System.out.println("\t\t\t\t\t\t   ----------------------------------------------------\n");

        while(cond){
            try {
                //Ingreso de los nombres
                SemestralEncabezado.Nombres();

                //MENU
                System.out.println("Favor de indicar que desea hacer");
                System.out.println("1. Iniciar partida");
                System.out.println("2. leer las Reglas");
                System.out.println("3. Salir");
                opcion = Integer.parseInt(lector.readLine());

                //INICIO DE MENU A PARTIR DE SWITCH CASE
                switch(opcion){
                    case 1:
                        
                        //RECOPILACION DE LOS NOMBRES
                        SemestralCombate.Jugadores(jugad);
                        //LIMPIEZA DE LA PANTALLA
                        SemestralPantalla.PantallaLimpia();
                        System.out.println("\n\n\n\n\t\t\tLas creadoras de este juego, Viviana Davis, Joana Gonzalez y Luisa Zuluaga, les desean suerte!!");
                        SemestralPantalla.PantallaPausa();
                        SemestralPantalla.PantallaLimpia();
                        
                        //ASIGNACION DE METODO QUE CALCULA EL NUMERO DEL GANADOR: 1 O 2
                        ganador = SemestralCombate.Enfrentamiento();
                        
                        //IMPRESION DE LOS MENSAJES PARA EL GANADOR JUNTO AL FEEDBACK
                        SemestralGanador.Vencedor(ganador, jugad);
                        //FIN DE LA PARTIDA
                        System.out.println("Este juego ha terminado. ¡Fue un gusto! =)");
                        cond = false;
                    break;
                    case 2:
                        
                        //IMPRESION DE LAS REGLAS DEL JUEGO
                        SemestralCombate.ReglasDelJuego();
                        //METODO QUE SE ENCARGA DE REINICIAR O FINALIZAR EL PROYECTO
                        opci = SemestralGanador.Reinicio();

                        if(opci=='x' || opci=='X'){
                            System.out.println("Usted ha salido del juego. Bye!!");
                            cond = false;
                        }
                        
                    break;
                    case 3:
                        //OPCION PARA SALIR DEL PROYECTO
                        System.out.println("Usted ha salido del juego.\nEsperamos que regrese pronto =)");
                        cond = false;
                        break;
                    default:
                        System.out.println("ERROR. DATO INVALIDO");
                        SemestralPantalla.PantallaPausa();
                        SemestralPantalla.PantallaLimpia();
                        
                }  
                
            } catch (Exception m) {
                System.out.println("ERROR. DATO INVALIDO");
                SemestralPantalla.PantallaPausa();
                SemestralPantalla.PantallaLimpia();
            }//Fin de try-catch

        }//Fin de condicion que permite repeticion del programa
    }//fin de main
    
}//Fin de clase
