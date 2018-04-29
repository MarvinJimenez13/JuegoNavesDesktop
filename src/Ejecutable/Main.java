package Ejecutable;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        
     
        InicioJuego inicioJ = new InicioJuego();
      
           //Muestro una pregunta para saber si desea jugar
        int iniciar = JOptionPane.showConfirmDialog(null, "¿Desar jugar?");
        //si la respuesta es si
        if (iniciar == 0) {
            //mando a llamar al metodo de InicioJuego para iniciarlo
            inicioJ.iniciar();
         //menu.jugarya();
        } else if (iniciar == 1) {
            System.exit(0);
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
                System.exit(0);
            }

        }

    }

}
