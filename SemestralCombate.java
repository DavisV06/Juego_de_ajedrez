//INTEGRANTES DEL GRUPO: Viviana Davis | 3-750-919, Joana González | 3-750-2102, Luisa Zuluaga | 20-14-6063
//IMPORTACION DE VARIABLES
import java.io.*;
import java.util.Vector;

public class SemestralCombate {
    //Declaracion de variables estaticas
    static int turno;
    static Vector Movimientos = new Vector(1,1); //Vector que se utiliza para el registro de movimientos
    static int move = 0; //controla al vector

    //METODO DE IMPRESION DE REGLAS
    public static void ReglasDelJuego() {
        System.out.println("\t\t\t\t\t\t\t\t\tREGLAS DEL JUEGO: ONLY HORSES\n\n");

        System.out.println("El juego consiste en un enfrentamiento entre los caballos de un juego de ajedrez.");
        System.out.println("\t\t\t\t\t\t\tPARAMETROS PRINCIPALES\n\n");
        System.out.println("1. Este juego esta desarrollado para que sea jugado entre DOS PERSONAS.");
        System.out.println("2. Los caballos estan representados de la forma: \n[CB]---> CABALLO BLANCO\n[CN]---> CABALLO NEGRO");
        System.out.println("3. Los caballos se mueven en forma de L. Esto NO quiere decir que hagan un recorrido de\ncasilla por casilla para completar la L, si no que, se mueven a los extremos de la misma.");
        System.out.println("4. Una vez iniciado el juego, el jugador puede salir en cualquier momento escribiendo: EXIT");
        System.out.println("5. Si uno de los jugadores abandona la partida, se declarara automaticamente a su contrincante\ncomo ganador\n\n");
    }//Fin de metodo ReglasDelJuego

    //METODO PARA INGRESO DE NOMBRES
    public static void Jugadores(String jugadores[]) throws IOException{
        //Declaracion de variables
        int i;
        //Creacion de objeto para BufferedReader
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        for(i = 0; i<2; i++){
            System.out.println("Ingrese el nombre del jugador no."+(i+1)+":");
            jugadores[i]= lector.readLine();
        }//Fin de for  
        System.out.println(jugadores[0]+" jugara con el caballlo blanco");
        System.out.println(jugadores[1]+ " jugara con el caballo negro");
        SemestralPantalla.PantallaPausa();
    }//Fin de metodo

    public static boolean ValidarDeseado(int COR1, int COR2, int CORA1,int CORA2){
        //Declaracion de variables
        boolean vald1;

        //Estas validaciones evaluaran si el movimiento de la ficha cumple con el de una L buscando la diferencia de distancia entre coordenadas
        if(COR1==CORA1&&COR2==CORA2){
            vald1=false;
        }else if(COR1>8||COR1<1||COR2>8||COR2<1){ //si se sale del tablero la coordenada
            vald1=false;
        }else if(((CORA1-COR1==1)&&(CORA2-COR2==2))||(CORA1-COR1==2)&&(CORA2-COR2==1)){
            vald1=true;
        }else if(((CORA1-COR1==2)&&(COR2-CORA2==1))||(CORA1-COR1==1)&&(COR2-CORA2==2)){
            vald1=true;
        }else if(((COR1-CORA1==1)&&(CORA2-COR2==2))||(COR1-CORA1==2)&&(CORA2-COR2==1)){
            vald1=true;
        }else if(((COR1-CORA1==2)&&(COR2-CORA2==1))||(COR1-CORA1==1)&&(COR2-CORA2==2)){
            vald1=true;
        }else{
            vald1=false;
        }
        return vald1;//Retorna true or false
    }//Fin de metodo ValidearDeseado

    public static int Enfrentamiento() throws IOException{
        
        //Declaracion de variables
        boolean cond = true, coordenada;
        int gand = SemestralMenu.ganador, D1=0, D2=0, AC1=8, AC2=2, CB1=8, CB2=2, CN1=1, CN2=7;
        String tabli[][] = SemestralMenu.ajedrez, jug[] = SemestralMenu.jugad, deseado,PCB = "B1", PCN= "G8";
        char x = ' ';
        char y=' ';
        turno = 1;

        Movimientos.insertElementAt(PCB, move);
        move++;
        Movimientos.insertElementAt(PCN, move);
        move++;


        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        //INICIALIZACION DEL TABLERO
        SemestralTablero.IniciaTablero(tabli);
        
        //INICIO DEL ENFRENTAMIENTO HASTA TENER GANADOR 
        while(gand==0){
            cond = true;
            do{
                //LIMPIEZA DE LA PANTALLA
                SemestralPantalla.PantallaLimpia();
                
                //IMPRESION DEL TURNO
                System.out.println("\t\t\t\t\t\t   ----------------------------------------------------");
                System.out.println("\t\t\t\t\t\t                  Turno de:"+jug[turno - 1]+"         ");
                System.out.println("\t\t\t\t\t\t   ----------------------------------------------------\n");
                //IMPRESION DEL TABLERO INICIALIZADO
                SemestralTablero.ActTablero(tabli);
                //VALIDACION PARA IMPRIMIR LA FICHA CORRECTA
                if(turno ==1){
                    System.out.println("Posicion actual de CB = "+PCB);
                    System.out.print("[CB] ");
                }
                else{
                    System.out.println("Posicion actual de CN = "+PCN);
                    System.out.print("[CN] ");
                }
                //INGRESO DE LA COORDENADA DESEADA
                System.out.println("--- Ingrese la posicion donde desea moverse: ");
                deseado = lector.readLine();
                
                //VALIDACIONES PARA DESCARTAR POSIBLES ERRORES O SALIDAS
                if(deseado.equals("EXIT") || deseado.equals("exit") || deseado.equals("Exit")){
                    if(turno ==1){
                        turno = 2;
                        gand = turno;

                        System.out.println("El jugador "+jug[0]+ " ha abandonado la partida =(");

                        cond = false;
                        return gand;
                    }
                    else{
                        turno = 1;
                        gand = turno;

                        System.out.println("El jugador "+jug[1]+ " ha abandonado la partida =(");

                        cond = false;
                        return gand;
                    }
                }
                //Condicion que invalida cadenas con una longitud mayor a 2
                else if(deseado.length()!= 2){
                    System.out.println("ERROR. OPCION INVALIDA");
                    System.out.println("Ingrese nuevamente su coordenada.");

                    SemestralPantalla.PantallaPausa();
                }
                else{
                    //Validacion para evaluar cadenas con longitud de par
                    if(deseado.length()==2){
                        x = deseado.charAt(1);
                        y = deseado.charAt(0);
                    }
                    if(!Character.isDigit(x) || !Character.isLetter(y)){
                        System.out.println("ERROR. Recuerde que las coordenadas se ingresan de forma A1");
                        SemestralPantalla.PantallaPausa();
                    }//Verificacion de orden de coordenada
                    else{
                        D1 = SemestralTraductores.TraduceFila(x);
                        D2 = SemestralTraductores.TraduceColumna(y);

                        if(D1 == 9 || D2 == 9){//toda coordenada que no cumpla las validaciones se convertira en 9
                            System.out.println("ERROR. Esta coordenada no es valida.");
                            System.out.println("Intentelo nuevamente");
                            SemestralPantalla.PantallaPausa();
                        }
                        else{
                            coordenada = ValidarDeseado(D1, D2, AC1, AC2);
                            
                            if(coordenada == true){
                                Movimientos.insertElementAt(deseado, move);//Guarda el movimiento correcto
                                move++;
                                cond = false;
                            }
                            else{
                                System.out.println("ERROR. MOVIMIENTO INVALIDO");
                                System.out.println("Intentelo nuevamente. Le recomendamos leer las reglas en todo caso :(");
    
                                SemestralPantalla.PantallaPausa();
                            }//Fin de condiciones para coordenadas que si estan en orden
                        }//Fin de condiciones para coordenadas que entran a validarse
                    }//Fin de condiciones para coordenadas que si cumplen con longitud
                    
                }//Fin de condiciones en general
            }while(cond);

            if(tabli[D1][D2].equals("[CB]") || tabli[D1][D2].equals("[CN]")){//EN CASO DE QUE LA COORDENADA DESEA COINCIDA CON EL CONTRINCANTE
                gand = turno;//cambio de valor para conocer ganador en turno
                tabli[D1][D2]= tabli[AC1][AC2];//Reemplazo del contrincante por el gandor
                tabli[AC1][AC2]="[  ]";            //Limpieza de la posicion vieja
            }else{//al contrario si no habia nada que reemplazar, solo se movia
                tabli[D1][D2]= tabli[AC1][AC2];
                tabli[AC1][AC2]="[  ]";  
                if(turno == 1){
                    turno = 2;//paso del turno entre jugadores
                    CB1 = D1; //Asignacion de la nueva posicion del caballo en x
                    CB2 = D2; //Asignacion de la nueva posicion del caballo en y
                    AC1 = CN1; //Cambio de valor para empezar a evaluar al otro jugador
                    AC2 = CN2;
                    PCB = deseado; //Actualizacion de feedback

                }
                else if(turno==2){
                    turno = 1;//paso de turno entre jugadores

                    CN1 = D1;
                    CN2 = D2;
                    AC1 = CB1;
                    AC2 = CB2;
                    PCN = deseado;//Actualizacion de feedback

                }
               cond = true;//reinicia la variable de validacion para el siguiente movimiento
            }
            SemestralPantalla.PantallaPausa();
            
        }
        if(gand != 0){
            SemestralPantalla.PantallaLimpia();
            SemestralTablero.ActTablero(tabli);

        }//fin de validacion que permitira la limpieza de la pantalla e impresion del tablero auna vez que haya ganador
        
        return gand;
    }//Fin de metodo Enfrentamiento
}//Fin de clase 
