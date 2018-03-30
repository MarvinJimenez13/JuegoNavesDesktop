package Ejecutable;

import Juego.Asteroide;
import Juego.Bala;
import Juego.Explocion;
import Juego.Fondo;
import Juego.Nave;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel {
    
    
   
    
        ArrayList asteroidesLista = new ArrayList();

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
    
      Explocion explocion1 = new Explocion(nave.getX_inicial(),nave.getY_inicial()-50);

    //creo dos asteroides
    public Asteroide aste1 = new Asteroide(coordenadaY1, -10);
    public Asteroide aste2 = new Asteroide(coordenadaY2, -10);
    
    

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
         
        
         if(colisionAst1()){
           System.out.println("Pego 1");
           SecureRandom coordenadaAst1 = new SecureRandom();
           int rango = coordenadaAst1.nextInt(850);
             int rango2 = coordenadaAst1.nextInt(850);
           aste1.setX(rango);
           //aste2.setX(rango2);
           aste1.setY(-10);
           //aste2.setY(-10);
       
           Explocion explocion = new Explocion(nave.getX_inicial(),nave.getY_inicial()-50);
          
                 explocion.paint(g);
            
          
       }
         
         if(colisionAst2()){
           System.out.println("Pego 2");
           SecureRandom coordenadaAst1 = new SecureRandom();
           int rango = coordenadaAst1.nextInt(850);
             int rango2 = coordenadaAst1.nextInt(850);
           //aste1.setX(rango);
           aste2.setX(rango2);
           //aste1.setY(-10);
           aste2.setY(-10);
           //aste1.moverAst();
           Explocion explocion = new Explocion(nave.getX_inicial(),nave.getY_inicial()-50);
          
                 explocion.paint(g);
            
          
       }
          
         
         
        
       
        /* Creo un ciclo for para reccorer las balas creadas y poder
        pintarlas */
        for (int i = 0; i < nave.listaBalas.size(); i++) {
            Bala pintarBala = (Bala) nave.listaBalas.get(i);
            pintarBala.paint(g);
           
        }

        /*
        Creo un ciclo for para recorrer la lista de los objetos tipo
        Ateroide y poder pinat uno a uno
         
 for (int i = 0; i < asteroidesLista.size(); i++) {
             Asteroide astpaint = (Asteroide)asteroidesLista.get(i);
             astpaint.paint(g);
         }*/
    }

    public void mover() {
        nave.moverNave();

        // crearAsteroides(aste1,aste2);
        aste1.moverAst();
        aste2.moverAst();
        
        asteroidesLista.add(aste1);
         asteroidesLista.add(aste2);
         
         

        /* Si las coordenadas y de ambos asteroides son 700,
        enotnces la reinicio a -10   y le doy un numero aleatorio
        en la coordenada x  */
        if (aste1.getY() == 800 ) {

            //numeros aleatorios
            SecureRandom coordenada1 = new SecureRandom();
            int coordenada1Ast = coordenada1.nextInt(800);
        
            //defino sus nuevas coordenadas
            aste1.setX(coordenada1Ast);
            aste1.setY(-10);
          
        }
        if(aste2.getY() == 800){
             SecureRandom coordenada1 = new SecureRandom();
                 int coordenada2Ast = coordenada1.nextInt(800);
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
   
        
         public boolean colisionAst1() {
                Area areaA = new Area(nave.getBounds());
		areaA.intersect(aste1.getBounds());
               
                return !areaA.isEmpty();
        }
          public boolean colisionAst2() {
                Area areaA = new Area(nave.getBounds());
		areaA.intersect(aste2.getBounds());
               
                return !areaA.isEmpty();
        }
        
    
    
    public void finJuego() {
        juegoFin = true;
    }

}
