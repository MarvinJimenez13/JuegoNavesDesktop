
package Juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class NaveEnemiga {
    
    //Creo una lista para la sbalas enemigas
    public ArrayList listaBalaEnemiga = new ArrayList();
    //area d ela nave enemiga
   Area nave,areaNave;
    //valores iniciales
    int x_inicial;
    int y_inicial;
        //defino el tamaño
    int anchoNave = 450;
    int alturaNave =280;
//auxiliar
    int movimiento;
    
    // binario para saber si se mueve a izq o der
     int binarioIzqDer;
    
     //el contructor pedira los valore siniciales y el binario para saber a donde se mueve
    public NaveEnemiga (int xinicial, int yinicial, int binarioIzqDer){
        this.x_inicial = xinicial;
        this.y_inicial = yinicial;
        this.binarioIzqDer = binarioIzqDer;
    }
    
    //constructor para solo indicar donde crear la nave sin moverla
    public NaveEnemiga(int xinicial, int yinicial){
         this.x_inicial = xinicial;
        this.y_inicial = yinicial;
    }
    

    public void paint(Graphics2D g) {
        //creo imagen para la nave    
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/Boss.gif"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicial, y_inicial, anchoNave, alturaNave, null);
    }
    
    //mover l anave
    public void mover(){
        //velocidad
     movimiento =1;
     //si el binario es 0 (izquierda)
      if(binarioIzqDer == 0){
          //a la x inicial se disminuye
            x_inicial -=movimiento;
            //si la x es menor a 1
            if(x_inicial < 1){
                //activo la bandera para ir a la derecha
                binarioIzqDer = 1;
            }
           
        }
       //si el binario es 1 (derecha)
        if(binarioIzqDer == 1){
              //a la x inicial se aumenta
            x_inicial += movimiento;
              //si la x es meyor a 550
             if(x_inicial > 550){
                 //activo la bandera para ir a la izquierda
                 binarioIzqDer =0;
                
            }
 
        }
       
//en todo el movimieto dispara
    disparar();
    }
    
    
    //metodo para disparar
    public void disparar(){
        // Si la coordenada x es cualquira de los sigueintes valores
         if(x_inicial  == 30 || x_inicial  ==  60|| x_inicial  == 90 || x_inicial  == 120 || x_inicial  == 150 ||
                x_inicial  == 180 || x_inicial  == 210 || x_inicial  == 240 || x_inicial  == 270 || x_inicial  == 300
                || x_inicial  == 330 || x_inicial  == 360 || x_inicial  == 390 || x_inicial  == 420 || x_inicial  == 450 ||
                x_inicial  == 480 || x_inicial  == 500){
             // creo una nueva bala enemiga y la ajusto para que se vea bonito
             BalaEnemiga balaE = new BalaEnemiga(x_inicial+200, y_inicial+180);
             //añado a la lista
              listaBalaEnemiga.add(balaE);
        }
        
        //creo un un for para recorrer la lista de balas enemigas y moverlas
         for (int i = 0; i < listaBalaEnemiga.size(); i++) {
             //creo el objeto d la referncia de la lista
                BalaEnemiga balaE = (BalaEnemiga)listaBalaEnemiga.get(i);
                //la muevo
                balaE.moverBalaEnemiga();
            }
        
    }
    //metodo para colison mediante el area
     public Area getBounds(){
        Rectangle forma1 = new Rectangle(x_inicial,y_inicial,400,200);
        nave = new Area(forma1);
        
        areaNave = nave;
        areaNave.add(nave);
        return areaNave;
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
