
package Juego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Explocion {
    
    //defino las variables de inicio de la explosion
    int xExplo;
    int yExplo;
    
    //defino el tamaño
    int altoExplo=220;
    int anchoExplo=244;
    
    
    //el contructor pedira la svariables de inicio
    public Explocion(int xinicial, int yinicial){
        xExplo = xinicial;
        yExplo = yinicial;
    }
    
    
     public void paint(Graphics2D g) {
        //creo imagen para la explosion
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/explosionA.gif"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), xExplo, yExplo, anchoExplo, altoExplo, null);
    }
    
    
}
