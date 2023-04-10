//INTEGRANTES DEL GRUPO: Viviana Davis | 3-750-919, Joana González | 3-750-2102, Luisa Zuluaga | 20-14-6063
import java.util.*;

public class SemestralPantalla { 
  public static void PantallaLimpia(){  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }//Fin de metodo PantallaLimpia    

  static public void PantallaPausa(){ 
    //Declaracion de variables 
    String seguir;
    Scanner teclado = new Scanner(System.in);
    
    System.out.println("Press Enter key to continue...");
      
    try{
      seguir = teclado.nextLine();
    }   
    catch(Exception e){

    }  
  }//fin de metodo PantallaPausa
    
}
