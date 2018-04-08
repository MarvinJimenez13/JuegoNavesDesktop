
package Juego;

import Ejecutable.Panel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class CampoDeFuerza {
    //area del campo
    Area campo, areaCampo;
    //valores de inicio
    int x_inicial;
    int y_inicial;
    //valores de tamaño
    int anchoCampo = 200;
    int altoCampo = 200;
    
    public CampoDeFuerza(int x, int y){
        this.x_inicial = x;
        this.y_inicial = y;
    }
    
     public void paint(Graphics2D g) {
        //creo imagen para el asteroide  
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/Campo.png"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicial, y_inicial, anchoCampo, altoCampo, null);
        }
     //metodo para sacar el area para colison
      public Area getBounds(){
        Rectangle forma1 = new Rectangle(x_inicial-50,y_inicial-50,200,200);
        campo = new Area(forma1);
        areaCampo = campo;
        areaCampo.add(campo);
        
        
        return areaCampo;
    }

      //GETTERS Y SETTERS PARA VALORES
    public int getX_inicial() {
        return x_inicial;
    }

    public void setX_inicial(int x_inicial) {
        this.x_inicial = x_inicial;
    }

    public int getY_inicial() {
        return y_inicial;
    }

    public void setY_inicial(int y_inicial) {
        this.y_inicial = y_inicial;
    }
    
     
     
}
