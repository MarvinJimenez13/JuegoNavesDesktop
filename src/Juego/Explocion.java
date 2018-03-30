
package Juego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Explocion {
    
    
    int xExplo;
    int yExplo;
    
    
    int altoExplo=220;
    int anchoExplo=244;
    
    
    
    public Explocion(int xinicial, int yinicial){
        this.xExplo = xinicial;
        this.yExplo = yinicial;
    }
    
    
     public void paint(Graphics2D g) {
        //creo imagen para la bala
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/Explocion1.gif"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), xExplo, yExplo, anchoExplo, altoExplo, null);
    }
    
    
}
