package Ejecutable;


import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InicioJuego {

    public static void main(String[] args) {
        //creo un JFrame
        JFrame ventana = new JFrame("Juego Nave");
        //creo un objeto panel
        Panel panel = new Panel();
        //a la venta le agrego el panel
        ventana.add(panel);
        //creo su ancho y alto
        ventana.setSize(1250, 800);
        //le pongo su localizacion en la pantalla
        ventana.setLocation(70, 40);
        //la hago visible
        ventana.setVisible(true);
        //metodo al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        panel.setBackground(Color.BLACK);
        
          if(panel.contadorChoquesAst > 2 ){
          panel.juegoFin = false;

       
                  
        }

        //mientras el juego siga
        while (panel.juegoFin) {
            //pinto el panel de nuevo
            panel.repaint();
            //un try para recoger exepciones
            try {
                //cada 10 tiempos :v
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(InicioJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            panel.repaint();
        }

    }

}
