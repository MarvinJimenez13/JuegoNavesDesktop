
package Juego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Bala {
    
    //Creo su ancho y largo de la bala
    int anchoBala=200;
    int altoBala=200;
    
    //variables de inicio, se definen en el ocntructor
    int x_inicio;
    int y_inicio;
    
    //variable auxiliar para mover
    int y_aux;
    
    
    /* le paso las coordenadas de la nave para crear la bala justo
    en el lugar en donde se encuentre la nave*/
    public Bala(int x_puntaNave, int y_puntaNave){
        this.x_inicio = x_puntaNave;
        this.y_inicio = y_puntaNave;
    }
    
    
       public void paint(Graphics2D g) {
            //creo imagen para la bala
        ImageIcon auto =new ImageIcon(getClass().getResource("/Imagenes/Bala.png"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicio, y_inicio,anchoBala,altoBala,null);
    }
    
       public void mover(){
           y_aux=5;
           y_inicio -=y_aux;
       }
     
       
    
}
