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
        //creo la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
        //dibujo la imagen
        g.drawImage(imagenFondo.getImage(), x_inicial, y_inicial, ancho, alto, null);

    }

}
