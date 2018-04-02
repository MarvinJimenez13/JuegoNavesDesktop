package Juego;

import Ejecutable.Panel;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Fondo {
    
    
  

    //indico las dimensiones del fondo
    int ancho = 1000;
    int alto = 800;

    //indico desde donde empezará
    int x_inicial = 0;
    int y_inicial = 0;

    public Fondo() {

    }

    public void paint(Graphics2D g) {
        
        
        /*  
        
        Depende del nivel del juego se pintará
        un nuefo fondo
        
        */
        
        
        if(Panel.nivel == 1){
            //creo la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo1.gif"));
          //dibujo la imagen
        g.drawImage(imagenFondo.getImage(), x_inicial, y_inicial, ancho, alto, null);
        }
       if(Panel.nivel == 2){
           //creo la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo2.gif"));
          //dibujo la imagen
        g.drawImage(imagenFondo.getImage(), x_inicial, y_inicial, ancho, alto, null);
        }
        if(Panel.nivel == 3){
           //creo la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo3.gif"));
          //dibujo la imagen
        g.drawImage(imagenFondo.getImage(), x_inicial, y_inicial, ancho, alto, null);
        }
         if(Panel.nivel == 4){
           //creo la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo4.gif"));
          //dibujo la imagen
        g.drawImage(imagenFondo.getImage(), x_inicial, y_inicial, ancho, alto, null);
        }

    }

}
