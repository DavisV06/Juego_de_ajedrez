//INTEGRANTES DEL GRUPO: Viviana Davis | 3-750-919, Joana González | 3-750-2102, Luisa Zuluaga | 20-14-6063
public class SemestralTraductores {

    public static int TraduceColumna(char cor1){
        //Declaracion de variables
        int cordenada;

        if(cor1=='a' || cor1 =='A'){
            cordenada=1;

        }
        else if(cor1=='b' || cor1 =='B'){
            cordenada=2;

        }
        else if(cor1=='c' || cor1 =='C'){
            cordenada=3;

        }
        else if(cor1=='d' || cor1 =='D'){
            cordenada=4;

        }
        else if(cor1=='e' || cor1 =='E'){
            cordenada=5;

        }
        else if(cor1=='f' || cor1 =='F'){
            cordenada=6;

        }
        else if(cor1=='g' || cor1 =='G'){
            cordenada=7;

        }
        else if(cor1=='h' || cor1 =='H'){
            cordenada=8;

        }
        else{
            cordenada=9;

        } 
        
        return cordenada;
    }//traduce la 1ra Coordenada

    public static int TraduceFila(char cor1){
        //Declaracion de variables
        int cordenada;

        switch(cor1){
            case '8' :
                cordenada=1;
            break;
            
            case '7' :
                cordenada=2;
            break;
            
            case '6' :
                cordenada=3;
            break;
            
            case '5' :
                cordenada=4;
            break;
            
            case '4' :
                cordenada=5;
            break;
            
            case '3' :
                cordenada=6;
            break;
            
            case '2' :
                cordenada=7;
            break;
            
            case '1' :
                cordenada=8;
            break;
            
            default:
                cordenada=9;
            break;
            
        }
        return cordenada;
    }//traduce la 2da coordenada
    
}//Fin de clase
