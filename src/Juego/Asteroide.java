package Juego;

import Ejecutable.Panel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Asteroide {
    //creo valibles de area
    Area asteroide,areaAst;
    //creo una nave
    Nave nave = new Nave();

    //Creo numero aleatorios
    public SecureRandom coordenadaAst1 = new SecureRandom();

    //los guardo en variable
    int coordenadaY1 = coordenadaAst1.nextInt(800);

    //defino las dimensiones del ateroide
    int anchoAst = 180;
    int alturaAst = 200;

    //deifno de donde saldra
    int x_inicial;
    int y_inicial;

    // variable auxiliar para mover
    int y_velocidad;

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
            y_velocidad = 2;
            //incrementar la y 
            y_inicial += y_velocidad;
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

    public int getY_velocidad() {
        return y_velocidad;
    }

    public void setY_velocidad(int y_velocidad) {
        this.y_velocidad = y_velocidad;
    }
    
    
    
    
    //metodo para crear un forma geometrica del asteroide y tener su area
    public Area getBounds(){
        Rectangle forma1 = new Rectangle(x_inicial,y_inicial,100,100);
        asteroide = new Area(forma1);
        areaAst = asteroide;
        areaAst.add(asteroide);
        
        
        return areaAst;
    }

   

}
