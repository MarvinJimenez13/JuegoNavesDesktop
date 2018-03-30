package Juego;

import Ejecutable.Panel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Asteroide {
    
    Area asteroide,areaAst;
    
    Nave nave = new Nave();
   
   


    //Creo numero aleatorios
    public SecureRandom coordenadaAst1 = new SecureRandom();

    //los guardo en variable
    int coordenadaY1 = coordenadaAst1.nextInt(800);

    //defino las dimensiones del ateroide
    int anchoAst = 217;
    int alturaAst = 230;

    //deifno de donde saldra
    int x_inicial;
    int y_inicial;

    // variable auxiliar para mover
    int y_aux;

    //variable auxiliar
    boolean mover = true;

    // al crear un objeto asteroide pediran coordenadas iniciales
    public Asteroide(int x, int y) {
        this.x_inicial = x;
        this.y_inicial = y;
    }

    public void paint(Graphics2D g) {
        //creo imagen para el asteroide  
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/Asteroide.gif"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicial, y_inicial, anchoAst, alturaAst, null);
    }

    public void moverAst() {
        // si mover es true
        if (mover) {
            y_aux = 5;
            //incrementar la y 
            y_inicial += y_aux;
        }
      
        
        
        
    }

    //creo getters y setters para poder obrtener las coordenadas
    public int getX() {
        return x_inicial;
    }

    public int getY() {
        return y_inicial;
    }

    public void setX(int x) {
        x_inicial = x;
    }

    public void setY(int y) {
        y_inicial = y;
    }

    public int getAlturaAst() {
        return alturaAst;
    }

    public void setAlturaAst(int alturaAst) {
        this.alturaAst = alturaAst;
    }

    public int getAnchoAst() {
        return anchoAst;
    }

    public void setAnchoAst(int anchoAst) {
        this.anchoAst = anchoAst;
    }
    
     
    public boolean colision() {
                Area areaA = new Area(nave.getBounds());
		areaA.intersect(getBounds());
                return !areaA.isEmpty();
        }
    
    public Area getBounds(){
        Rectangle forma1 = new Rectangle(x_inicial,y_inicial,100,100);
        asteroide = new Area(forma1);
        areaAst = asteroide;
        areaAst.add(asteroide);
        
        
        return areaAst;
    }

   

}
