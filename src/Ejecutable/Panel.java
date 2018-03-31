package Ejecutable;

import Juego.Asteroide;
import Juego.Bala;
import Juego.Explocion;
import Juego.Fondo;
import Juego.Nave;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel {
    
       
            boolean juegoFin = true;
            
            int puntos;
            int vidas =3;
            
            
              URL direccionSonidoDisparo,direccionSonidoChoque;
    AudioClip sonidoChoque,sonidoDisparo;  

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
    public Asteroide aste1 = new Asteroide(coordenadaY1, -10);
    public Asteroide aste2 = new Asteroide(coordenadaY2, -10);
    
    
    int contadorChoquesAst;

   

    Explocion ex = new Explocion(nave.getX_inicial(), nave.getY_inicial());

    public Panel() {
        
         direccionSonidoChoque=getClass().getResource("/Sonidos/choque.wav");
        sonidoChoque=Applet.newAudioClip(direccionSonidoChoque);
        
       direccionSonidoDisparo=getClass().getResource("/Sonidos/Disparo.wav");
        sonidoDisparo=Applet.newAudioClip(direccionSonidoChoque);
        

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
        mover(g2);
     
        

    }
    
      public void dibujarPuntaje(Graphics2D g) {
        
        Graphics2D g1 = g, g2 = g,g3 =g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        g.setColor(Color.blue);
        g1.drawString("Puntaje:  "+puntos, 1000, 50);
        
       
            g2.setColor(Color.red);
            g2.drawString("VIdas: \n" + vidas, 1000 , 120);
            
            
          if(contadorChoquesAst > 2 ){
              Font score2 = new Font("Arial", Font.BOLD, 70);
              g.setFont(score2);
         g3.setColor(Color.WHITE);
         g3.drawString("YOU LOSE PRRO :V", 185,400 );
        }
       
    }

    public void dibujar(Graphics2D g) {
        //dibujo los componentes
        fondo.paint(g);
        nave.paint(g);
        nave.Bala();
        aste1.paint(g);
        aste2.paint(g);
         dibujarPuntaje(g);

        /* coloco estas condiciones quí por que necesito que se pinten las explosiones
        y en este metodo estan los graficos en 2D*/
        //si la colision en el asteroide1 con la nave es true
        if (colisionAst1()) {
            
            sonidoChoque.play();
            
            vidas--;
            contadorChoquesAst += 1;
            //imprimo para comprobar que sirva
            System.out.println("Pego 1");
            //creo numero aleatorio
            SecureRandom coordenadaAst1 = new SecureRandom();
            //los guardo en varuiables
            int rango = coordenadaAst1.nextInt(850);
            int rango2 = coordenadaAst1.nextInt(850);

            //creo nuevas coordenadas para asteroide1
            aste1.setX(rango);
            aste1.setY(-10);
            //creo un explosion
            Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
            //la pinto
            explocion.paint(g);
            
             
             
             if(contadorChoquesAst > 2){
                 juegoFin = false;
             }
            
            
            

        }
        //si la colision en el asteroide2 con la nave es true
        if (colisionAst2()) {
            
            
            sonidoChoque.play();
            vidas--;
            contadorChoquesAst += 1;
            //imprimo para comprobar que sirva
            System.out.println("Pego 2");
            //creo numero aleatorio
            SecureRandom coordenadaAst1 = new SecureRandom();
            //los guardo en varuiables
            int rango = coordenadaAst1.nextInt(850);
            int rango2 = coordenadaAst1.nextInt(850);
            //creo nuevas coordenadas para asteroide2
            aste2.setX(rango2);
            aste2.setY(-10);
            //creo un explosion
            Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
            //la pinto
            explocion.paint(g);
         
             
             if(contadorChoquesAst > 2){
                 juegoFin = false;
             }

        }
        
      

        /* Creo un ciclo for para reccorer las balas creadas y poder
        pintarlas */
        for (int i = 0; i < nave.listaBalas.size(); i++) {
            Bala pintarBala = (Bala) nave.listaBalas.get(i);
            Bala sonidoB = (Bala)nave.listaBalas.get(i);
            
            
            if(pintarBala.getY_inicio() >= 400){
            sonidoDisparo.play();
        }
            
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

    public void mover(Graphics2D g) {
        nave.moverNave();

        // crearAsteroides(aste1,aste2);
        aste1.moverAst();
        aste2.moverAst();

        /* Si las coordenadas y de ambos asteroides son 800,
        enotnces la reinicio a -10   y le doy un numero aleatorio
        en la coordenada x  */
        if (aste1.getY() == 800) {

            //numeros aleatorios
            SecureRandom coordenada1 = new SecureRandom();
            int coordenada1Ast = coordenada1.nextInt(800);
            //defino sus nuevas coordenadas
            aste1.setX(coordenada1Ast);
            aste1.setY(-10);

        }
        if (aste2.getY() == 800) {
            //numeros aleatorios
            SecureRandom coordenada1 = new SecureRandom();
            int coordenada2Ast = coordenada1.nextInt(800);
            //defino sus nuevas coordenadas
            aste2.setX(coordenada2Ast);
            aste2.setY(-10);
        }

        //Creo un ciclo for para recorrer la lista de balas
        for (int i = 0; i < nave.listaBalas.size(); i++) {
            //creo los obejtos de tipo bala
            Bala balaCol = (Bala) nave.listaBalas.get(i);

            //si la oclision bala contr el asteroide1 es true
            if (colisionBalaAst1(balaCol)) {
                
                
                puntos++;
                
                        Explocion explocion = new Explocion(aste1.getX() ,aste1.getY() );
                        explocion.paint(g);
                
                //imprimo para comporbar
                System.out.println("Pego bala en 1");
                //creo numero aleatorio
                SecureRandom coordenadaAst1 = new SecureRandom();
                //lo guardo en variables
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas cooredenas para el asteroide1
         
                
                aste1.setX(rango);
                aste1.setY(-10);
               
                //elimino la bala que colisiona del arreglo
                nave.listaBalas.remove(balaCol);

            }
            //si la oclision bala contr el asteroide2 es true
            if ((colisionBalaAst2(balaCol))) {
                
                
                puntos++;
                
                 Explocion explocion = new Explocion(aste1.getX() ,aste1.getY() );
                        explocion.paint(g);
                
                
                //imprimo para comporbar
                System.out.println("Pego bala en 2");
                SecureRandom coordenadaAst1 = new SecureRandom();
                //creo numero aleatorio
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas cooredenas para el asteroide2
                aste2.setX(rango2);
                aste2.setY(-10);
                Explocion explocion1 = new Explocion(aste2.getX(), aste2.getY());
                //elimino la bala que colisiona del arreglo
                nave.listaBalas.remove(balaCol);

            }

        }

    }

    /*  

    Metodos para colisionar asteroide-nave
    Metodos para colisionar bala-asteroide
    
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

    public boolean colisionBalaAst1(Bala bala) {
        Area areaA = new Area(bala.getBounds());
        areaA.intersect(aste1.getBounds());

        return !areaA.isEmpty();
        
        
   
    }

    public boolean colisionBalaAst2(Bala bala) {
        Area areaA = new Area(bala.getBounds());
        areaA.intersect(aste2.getBounds());

        return !areaA.isEmpty();
    }

    public void finJuego() {
        
        
    }

}
