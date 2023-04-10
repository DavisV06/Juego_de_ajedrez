//INTEGRANTES DEL GRUPO: Viviana Davis | 3-750-919, Joana González | 3-750-2102, Luisa Zuluaga | 20-14-6063

public class SemestralTablero {
    //Bloque de variables
    static String cabib = "[CB]";
    static String cabin = "[CN]";


    public static void IniciaTablero(String tabi[][]){
        //Asignacion de corchetes para cada posicion del arreglo
        for(int f = 0;  f < 10; f++){
            for(int c = 0; c < 10; c++){
              tabi[f][c] = "[  ]";
            }//fin de bucle que recorre la columnas de la matriz
        }//fin de bucle que recorre las filas de la matriz

        //Asignaciones puntuales de coordenadas
        tabi[0][0]= "   ";
        tabi[9][0]= "   ";
        tabi[0][1]= "[A ]";
        tabi[9][1]= "[A ]";
        tabi[0][2]= "[B ]";
        tabi[9][2]= "[B ]";
        tabi[0][3]= "[C ]";
        tabi[9][3]= "[C ]";
        tabi[0][4]= "[D ]";
        tabi[9][4]= "[D ]";
        tabi[0][5]= "[E ]";
        tabi[9][5]= "[E ]";
        tabi[0][6]= "[F ]";
        tabi[9][6]= "[F ]";
        tabi[0][7]= "[G ]";
        tabi[9][7]= "[G ]";
        tabi[0][8]= "[H ]";
        tabi[9][8]= "[H ]";
        tabi[0][9]= "   ";
        tabi[9][9]= "   ";
        tabi[1][0]= "[8]";
        tabi[1][9]= "[8]";
        tabi[2][0]= "[7]";
        tabi[2][9]= "[7]";
        tabi[3][0]= "[6]";
        tabi[3][9]= "[6]";
        tabi[4][0]= "[5]";
        tabi[4][9]= "[5]";
        tabi[5][0]= "[4]";
        tabi[5][9]= "[4]";
        tabi[6][0]= "[3]";
        tabi[6][9]= "[3]";
        tabi[7][0]= "[2]";
        tabi[7][9]= "[2]";
        tabi[8][0]= "[1]";
        tabi[8][9]= "[1]";
        tabi[1][7] = cabin;
        tabi[8][2] = cabib;

    }//Fin de metodo Tablero
    
    public static void ActTablero(String tabli[][]) {
        
        for(int f = 0; f < 10; f++){
            //System.out.println("\n");
            System.out.print("\t\t\t\t\t\t\t");
            for(int c = 0; c < 10; c++){
              System.out.print(tabli[f][c]+" ");
            }//fin de bucle que recorre la columnas de la matriz
            System.out.println("\n");
        }//fin de bucle que recorre las filas de la matriz
       
    }//Fin de metodo ActTablero
    
}//Fin de clase SEMESTRAL PARTIDA
