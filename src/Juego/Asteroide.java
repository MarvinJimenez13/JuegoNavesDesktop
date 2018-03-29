
package Juego;

import Ejecutable.Panel;
import java.awt.Graphics2D;
import java.security.SecureRandom;
import javax.swing.ImageIcon;

public class Asteroide {
    
    
  
    
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
   
   
   
   
   
   public Asteroide(int x, int y){
       this.x_inicial = x;
       this.y_inicial =y;
   }
   
     public void paint(Graphics2D g) {
            //creo imagen para el asteroide  
        ImageIcon auto =new ImageIcon(getClass().getResource("/Imagenes/Asteroide.gif"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicial, y_inicial,anchoAst,alturaAst,null);
    }
     
     
     public void moverAst(){
         // si mover es true
         if(mover){
             y_aux = 2;
             //incrementar la y 
            y_inicial += y_aux;
         }
         
        
     }
    
     public int getX(){
         return x_inicial;
     }
      public int getY(){
         return y_inicial;
     }
      public void setX(int x){
          x_inicial =x;
      }
      public void setY(int y){
          y_inicial =y;
      }
     
    
}
