package Ejecutable;



import Menu.Menu;
import javax.swing.JOptionPane;

public class Main{
    
    public static void main(String[] args) {
        
         InicioJuego inicioJ = new InicioJuego();
        
          //Muestro una pregunta para saber si desea jugar
     Menu menu = new Menu();
 

        while(menu.juga){
          
              menu.setVisible(true);
              
          
     
        if (!menu.juga) {
            
            inicioJ.iniciar();
            menu.setVisible(false);
            menu.juga= false;
       
        } 
       
        }
        
        
        //mienstras la variable auxiliar sea true
        //significa que el juego termino
        while (inicioJ.nuevoFin) {

            
            //pregunto si desea jugar de nuevo
            int iniciar2 = JOptionPane.showConfirmDialog(null, "¿Desar jugar de nuevoooo?");
            //si la respuesta es si
            if (iniciar2 == 0) {
                //cierro la ventana actual
                inicioJ.ventana.dispose();
                 // cambio le valor de la variablea false 
                inicioJ.nuevoFin = false;
                  // incio el juego de nuevo
                inicioJ.iniciar();

            } else if (iniciar2 == 1) {
                 inicioJ.ventana.dispose();
                  inicioJ.nuevoFin = false;
              
              
              
              menu.juga = true;
               while(menu.juga){
          
              menu.setVisible(true);
     
        if (!menu.juga) {
            
            inicioJ.iniciar();
            menu.setVisible(false);
            menu.juga= false;
       
        } 
       
        }
              
            }

        }
        
        
    }
    
    
}
