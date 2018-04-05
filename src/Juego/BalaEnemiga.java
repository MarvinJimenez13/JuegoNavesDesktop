
package Juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class BalaEnemiga {
    //area de la bala
    Area bala,areaBala;
    //valores de inicio
    int x_inicio;
    int y_inicio;
    
    //valores de tamaño
    int anchoBala =30;
    int altoBala = 30;
    //auxiliar
    int movimiento;
    
    
    public BalaEnemiga(int xinicio, int yinicio){
        this.x_inicio = xinicio;
        this.y_inicio = yinicio;
    }
    
     public void paint(Graphics2D g) {
        //creo imagen para la bala
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/blue.png"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicio, y_inicio, anchoBala, altoBala, null);
    }
    
    
     //movimiento y velocidad
     public void moverBalaEnemiga(){
         movimiento =2;
         y_inicio += movimiento;

         
     }
     
     
     //metodo para sacar su area para colision
      public Area getBounds(){
      Rectangle forma = new Rectangle(x_inicio,y_inicio,30,30);
      bala = new Area(forma);
      
      areaBala = bala;
      areaBala.add(bala);
      
      return areaBala;
      
  }
     
     
     
    
}
