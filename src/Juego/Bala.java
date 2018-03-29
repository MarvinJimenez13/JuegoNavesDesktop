
package Juego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Bala {
    
    int anchoBala=200;
    int altoBala=200;
    
    
    int x_inicio;
    int y_inicio;
    
    int y_aux;
    
    public Bala(int x_puntaNave, int y_puntaNave){
        this.x_inicio = x_puntaNave;
        this.y_inicio = y_puntaNave;
    }
    
    
       public void paint(Graphics2D g) {
            //creo imagen para el asteroide  
        ImageIcon auto =new ImageIcon(getClass().getResource("/Imagenes/Bala.png"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicio, y_inicio,anchoBala,altoBala,null);
    }
    
       public void mover(){
           y_aux=5;
           y_inicio -=y_aux;
       }
    
    
}
