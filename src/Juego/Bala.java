package Juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class Bala {
    
    
    Area bala,areaBala;

    //Creo su ancho y largo de la bala
    int anchoBala = 200;
    int altoBala = 200;

    //variables de inicio, se definen en el ocntructor
    int x_inicio;
    int y_inicio;

    //variable auxiliar para mover
    int y_aux;

    /* le paso las coordenadas de la nave para crear la bala justo
    en el lugar en donde se encuentre la nave*/
    public Bala(int x_puntaNave, int y_puntaNave) {
       x_inicio = x_puntaNave;
       y_inicio = y_puntaNave;
    }

    public void paint(Graphics2D g) {
        //creo imagen para la bala
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/Bala.png"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicio, y_inicio, anchoBala, altoBala, null);
    }
    
 
    //metodo para crear un forma geometrica de la bala y tener su area   
    public Area getBounds(){
      Rectangle forma = new Rectangle(x_inicio,y_inicio,150,150);
      bala = new Area(forma);
      
      areaBala = bala;
      areaBala.add(bala);
      
      return areaBala;
      
  }

    public void mover() {
        y_aux = 10;
        y_inicio -= y_aux;
    }

    public int getAnchoBala() {
        return anchoBala;
    }

    public void setAnchoBala(int anchoBala) {
        this.anchoBala = anchoBala;
    }

    public int getAltoBala() {
        return altoBala;
    }

    public void setAltoBala(int altoBala) {
        this.altoBala = altoBala;
    }

    public int getX_inicio() {
        return x_inicio;
    }

    public void setX_inicio(int x_inicio) {
        this.x_inicio = x_inicio;
    }

    public int getY_inicio() {
        return y_inicio;
    }

    public void setY_inicio(int y_inicio) {
        this.y_inicio = y_inicio;
    }

}
