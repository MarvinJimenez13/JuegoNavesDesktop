package Ejecutable;

import Juego.Asteroide;
import Juego.Bala;
import Juego.Fondo;
import Juego.Nave;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel {


    // public ArrayList listaAsteroides = new ArrayList();
    
    //Creo numero aleatorios
    public SecureRandom coordenadaAst1 = new SecureRandom();
    public SecureRandom coordenadaAst2 = new SecureRandom();
    //los guardo en variables
    int coordenadaY1 = coordenadaAst1.nextInt(800);
    int coordenadaY2 = coordenadaAst2.nextInt(800);

    //creo la nave y el fondo del juego
    Nave nave = new Nave();
    Fondo fondo = new Fondo();

    //creo dos asteroides
    Asteroide aste1 = new Asteroide(coordenadaY1, -10);
    Asteroide aste2 = new Asteroide(coordenadaY2, -10);

    boolean juegoFin = false;

    public Panel() {

        
        
        //metodos para obtener informacion del teclado
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                nave.keyPressed(e);

            }
        });
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        dibujar(g2);
        //si no lo pongo no se mueven
        mover();

    }

    public void dibujar(Graphics2D g) {
        //dibujo los componentes
        fondo.paint(g);
        nave.paint(g);
        nave.Bala();
        aste1.paint(g);
        aste2.paint(g);
       
        /* Creo un ciclo for para reccorer las balas creadas y poder
        pintarlas */
        
        for (int i = 0; i < nave.listaBalas.size(); i++) {
            Bala pintarBala = (Bala) nave.listaBalas.get(i);
            pintarBala.paint(g);
        }

        
         /*
        Creo un ciclo for para recorrer la lista de los objetos tipo
        Ateroide y poder pinat uno a uno
         */
        
        /* for (int i = 0; i < listaAsteroides.size(); i++) {
             Asteroide astpaint = (Asteroide)listaAsteroides.get(i);
             astpaint.paint(g);
         }*/
    }

    public void mover() {
        nave.moverNave();
     
        // crearAsteroides(aste1,aste2);
        aste1.moverAst();
        aste2.moverAst();
          
        /* Si las coordenadas y de ambos asteroides son 700,
        enotnces la reinicio a -10   y le doy un numero aleatorio
        en la coordenada x  */
        if (aste1.getY() == 700 && aste2.getY() == 700) {

                  //numeros aleatorios
            SecureRandom coordenada1 = new SecureRandom();
            int coordenada1Ast = coordenada1.nextInt(800);
            int coordenada2Ast = coordenada1.nextInt(800);
            //defino sus nuevas coordenadas
            aste1.setX(coordenada1Ast);
            aste1.setY(-10);
            aste2.setX(coordenada2Ast);
            aste2.setY(-10);
        }

    }

    /*
      public void crearAsteroides(Asteroide aste1,Asteroide aste2){
         
          
          
//añado los asteroides en el arreglo de objetos
          listaAsteroides.add(aste1);
          //mando mensaje para moverlos
          aste1.moverAst();
          listaAsteroides.add(aste2);
          aste2.moverAst();
         
          System.out.println(aste1.getY());
          
         
         
          
      }
     */
    public void finJuego() {
        juegoFin = true;
    }

}
