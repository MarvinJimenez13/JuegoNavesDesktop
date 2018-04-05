package Ejecutable;

import Juego.Asteroide;
import Juego.Bala;
import Juego.BalaEnemiga;
import Juego.CampoDeFuerza;
import Juego.Explocion;
import Juego.Fondo;
import Juego.Nave;
import Juego.NaveEnemiga;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel {

    //Variable boolean para saber si el juego sigue
    boolean juegoFin = true;
    //VARIABLE NIVEL
    public static int nivel = 1;
    //puntos en 0 y vidas en 3
    int puntos;
    int vidas = 3;
    //defino variables para el sonido
    URL direccionSonidoDisparo, direccionSonidoChoque;
    AudioClip sonidoChoque, sonidoDisparo;

    //Creo numero aleatorios
    public SecureRandom coordenada = new SecureRandom();
    //los guardo en variables
    int coordenadaY1 = coordenada.nextInt(800);
    int coordenadaY2 = coordenada.nextInt(800);
    int coordenadaY3 = coordenada.nextInt(800);
    int coordenadaY4 = coordenada.nextInt(800);
    int coorNaveEnemiga = coordenada.nextInt(800);
    int binarioIzqDer = coordenada.nextInt(2);
    //creo la nave 
    Nave nave = new Nave();
    //creo la nave Enemiga
    public NaveEnemiga naveEnemiga = new NaveEnemiga(coorNaveEnemiga,-300, binarioIzqDer);
    //creo el fondo
    Fondo fondo = new Fondo();
    
    CampoDeFuerza verC = new CampoDeFuerza(nave.getX_inicial(), nave.getY_inicial());

    //creo asteroides
    public Asteroide aste1 = new Asteroide(coordenadaY1, -10);
    public Asteroide aste2 = new Asteroide(coordenadaY2, -10);
    public Asteroide aste3 = new Asteroide(coordenadaY3, -200);
     public Asteroide aste4 = new Asteroide(coordenadaY4, -200);
    //contador de los choques con nave-aste
    int contadorChoquesAst;
    //contador de los choques de la bala-naveEnemiga
    int contadorChoqueBalaNaveE;
    //contador aux
    int contadorNuevo;

    public Panel() {

        //defino la URL del sonido
        direccionSonidoChoque = getClass().getResource("/Sonidos/choque.wav");
        //añado el clip
        sonidoChoque = Applet.newAudioClip(direccionSonidoChoque);
        //defino la URL del sonido
        direccionSonidoDisparo = getClass().getResource("/Sonidos/Disparo2.m4a");
        //añado el clip
        sonidoDisparo = Applet.newAudioClip(direccionSonidoChoque);

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
    //metodo para dibujar en pantalla
    public void dibujarPuntaje(Graphics2D g) {

        Graphics2D g1 = g, g2 = g, g3 = g;
        //defino un tipo de fuente
        Font score = new Font("Arial", Font.BOLD, 35);
        //a los graficos les añado el tipo de fuente
        g.setFont(score);
        //color
        g.setColor(Color.blue);
        //lo dibujo
        g.drawString("Puntaje:  " + puntos, 1020, 50);

        //color
        g.setColor(Color.yellow);
        //Dibujo el nivel
        g2.drawString("NIVEL " + nivel, 1050, 300);

        //Dibujo las vidas
        g.setColor(Color.red);
        g.drawString("VIdas: " + vidas, 1030, 120);

        //DIbujo que perdio la partida
        if (contadorChoquesAst > 2) {
            Font score2 = new Font("Arial", Font.BOLD, 70);
            g3.setFont(score2);
            g3.setColor(Color.WHITE);
            g3.drawString("YOU LOSE PRRO :V", 185, 400);
        }

    }

    public void dibujar(Graphics2D g) {
        //dibujo los componentes
        fondo.paint(g);
        nave.paint(g);
        nave.Bala();
        aste1.paint(g);
        aste2.paint(g);
        //se pintan muy lejos :v
        aste3.paint(g);
        aste4.paint(g);
        naveEnemiga.paint(g);
        //dibujo el puntaje
        dibujarPuntaje(g);

        /* coloco estas condiciones quí por que necesito que se pinten las explosiones
        y en este metodo estan los graficos en 2D*/
        //si la colision en el asteroide1 con la nave es true
        if (colisionAst1()) {
            //activo el sonido se choque
            sonidoChoque.play();
            //reduzco las vidas
            vidas--;
            //aumento en 1 el choque
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
            //si el  contador de los choques es mayor a dos el juego termina
            if (contadorChoquesAst > 2) {
                juegoFin = false;
            }

        }
        //si la colision en el asteroide2 con la nave es true
        if (colisionAst2()) {
            //activo el sonido de choque   
            sonidoChoque.play();
            //reduzco las vidas
            vidas--;
            //aumento el contador de choques
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
            //si el  contador de los choques es mayor a dos el juego termina
            if (contadorChoquesAst > 2) {
                juegoFin = false;
            }

        }

        /* Creo un ciclo for para reccorer las balas creadas y poder
        pintarlas */
        for (int i = 0; i < nave.listaBalas.size(); i++) {
            Bala pintarBala = (Bala) nave.listaBalas.get(i);
            Bala sonidoB = (Bala) nave.listaBalas.get(i);
            //si la bala es mayor o igual que los 400px
            if (pintarBala.getY_inicio() == 400) {
                //activo sonido de bala
                sonidoDisparo.play();
            }
            //pinto la bala
            pintarBala.paint(g);

        }
        
        /*
        Creo un for para recorrer la lista de las balas nemigas
        y poder pintarlas
        
        */
        for (int i = 0; i < naveEnemiga.listaBalaEnemiga.size(); i++) {
            BalaEnemiga balaE =(BalaEnemiga) naveEnemiga.listaBalaEnemiga.get(i);
            balaE.paint(g);
        }

        /*
        Creo un for para recorrer la lista de los campos de Fuerza
        y poder pintarlos
        
        */
        for (int i = 0; i < nave.campoDeFuerza.size(); i++) {
            CampoDeFuerza pintarC = (CampoDeFuerza)nave.campoDeFuerza.get(i);
            pintarC.paint(g);
            /*
            Si la coordenada x del campo de fuerza es diferente a la coordenada x
            de la nave (quiere decir que la nave se movio), entonces remuevo
            el campo pintado
            */
            if(pintarC.getX_inicial() != nave.getX_inicial()){
                nave.campoDeFuerza.remove(pintarC);
            }
        }
      
    }

    public void mover(Graphics2D g) {
        //muevo la nave
        nave.moverNave();

        //muevo los asteroides
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

        //Creo un ciclo for para recorrer la lista de balas y ver colisiones
        for (int i = 0; i < nave.listaBalas.size(); i++) {
            //creo los obejtos de tipo bala
            Bala balaCol = (Bala) nave.listaBalas.get(i);

            //si la oclision bala contra el asteroide1 es true
            if (colisionBalaAst1(balaCol)) {
                //aumento los puntos
                puntos++;

                //creo una explocion
                Explocion explocion = new Explocion(aste1.getX(), aste1.getY());
                //pinto la explocion
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
                //aumento los puntos
                puntos++;

                //creo una explocion
                Explocion explocion = new Explocion(aste2.getX(), aste2.getY());
                //pinto la explocion
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
                //elimino la bala que colisiona del arreglo
                nave.listaBalas.remove(balaCol);

            }
           //si la colison bala con asteroide3 es true
            if ((colisionBalaAst3(balaCol))) {
                //aumento los puntos
                puntos++;

                //creo una explocion
                Explocion explocion = new Explocion(aste3.getX(), aste3.getY());
                //pinto la explocion
                explocion.paint(g);

                //imprimo para comporbar
                System.out.println("Pego bala en 3");
                SecureRandom coordenadaAst1 = new SecureRandom();
                //creo numero aleatorio
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas cooredenas para el asteroide3
                aste3.setX(rango2);
                //si el nivel es 3 o 4 aparce ya en el juego
                if(nivel == 3 || nivel == 4){
                aste3.setY(-10);
                }
                //elimino la bala que colisiona del arreglo
                nave.listaBalas.remove(balaCol);

            }
            //si la colison bala con asteroide4 es true
            if ((colisionBalaAst4(balaCol))) {
                //aumento los puntos
                puntos++;

                //creo una explocion
                Explocion explocion = new Explocion(aste4.getX(), aste4.getY());
                //pinto la explocion
                explocion.paint(g);

                //imprimo para comporbar
                System.out.println("Pego bala en 4");
                SecureRandom coordenadaAst1 = new SecureRandom();
                //creo numero aleatorio
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas cooredenas para el asteroide4
                aste4.setX(rango2);
                //si el nivel es 4 aparece en el juego
                if( nivel == 4){
                aste4.setY(-10);
                }
                //elimino la bala que colisiona del arreglo
                nave.listaBalas.remove(balaCol);

            }
            //si la colision bala con la nave enemiga es true
            if(colisionBalaNaveEnemiga(balaCol)){
                
                  //creo una explocion
                Explocion explocion = new Explocion(naveEnemiga.getX_inicial(), naveEnemiga.getY_inicial());
                //pinto la explocion
                explocion.paint(g);
                
                //imprimo para comprobar
                 System.out.println("Pego bala en Nave Enemiga");
                 //remuevo la bala
                 nave.listaBalas.remove(balaCol);
                 //invremento el contador
                 contadorChoqueBalaNaveE++;
                 
                 //si hay 20 choques
                 if(contadorChoqueBalaNaveE == 20){
                     //pinto explocion
                     explocion.paint(g);
                     //muevo la nave a otro lado
                     naveEnemiga.setX_inicial(-1000);
                     naveEnemiga.setY_inicial(-1000);
                 }
            }
            

        }
        
        /*
        Creo for para recorrer la lista d elas balas enemigas
        y ver las colisiones con la nave y con el campo
        */
        for (int i = 0; i < naveEnemiga.listaBalaEnemiga.size(); i++) {
            // creo el objeto de la referencia d ela lista
            BalaEnemiga colBalaEne = (BalaEnemiga)naveEnemiga.listaBalaEnemiga.get(i);
             //si la colisoion de la bala enemiga con la nave es true
           if(colisionBalaEnemigaNave(colBalaEne)){
                //reduzco las vidas
                vidas--;
                /*
                Cre este if por que me daba problemas y aparecian vidad negativas
                así si hay vidas negativas las devuelvo a 0
                */
                if(vidas < 0){
                    vidas =0;
                }
                  //creo una explocion
                Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial());
                //pinto la explocion
                explocion.paint(g);
                //imprimo para comprobar
                 System.out.println("Pego bala Enemiga en Nave ");
                 
                 //aumento el contador auxiliar
                 contadorNuevo++;
                 //si el contador auxiliar es igual a alguno de esos valores
                 if(contadorNuevo == 1 || contadorNuevo == 50 || contadorNuevo == 100){
                     /*
                     Aumento el choque de asteroides, hago esto para que una serie de balas valga como un
                     choque más de asteroides, ya que cuando hay 3 choques el juego termina y las vidas son 0 
                     tambien.
                     */
                     contadorChoquesAst++;
                 }
                 
                 //si el contador de choques es mayor a 2
                 if(contadorChoquesAst > 2){
                     //termina el juego
                     juegoFin = false;
                 } 
                 
                 
            }
           //si la colison de la bala enemiga con el campo es true
           if(colisionBalaEnemigaCampo(colBalaEne)){
               //remuevo la bala y no le pasa nada a la nave
               naveEnemiga.listaBalaEnemiga.remove(colBalaEne);
               System.out.println("Bala enemiga pego en campo");
               
           }
            
        }
                

        
        
        //NIVELES
        if (puntos > 5 && puntos < 10) {
            nivel = 2;
            //aumento la velocidad
            aste1.setY_velocidad(10);
            aste2.setY_velocidad(10);
            //el aste3 todavia no debe verse
            aste3.setY(-200);
        }
        if (puntos > 10 && puntos < 15) {
            nivel = 3;
            //aumento la velocidad
            aste1.setY_velocidad(15);
            aste2.setY_velocidad(15);

            //COONDICONES PARA EL NUEVO ASTEROIDE3
            
            //lo muevo
              aste3.moverAst();
              //le doy velocidad
            aste3.setY_velocidad(15);
            //condicion para reiniciar su ciclo
            if (aste3.getY() == 800) {
                //numeros aleatorios
                SecureRandom coordenada1 = new SecureRandom();
                int coordenada2Ast = coordenada1.nextInt(800);
                //defino sus nuevas coordenadas
                aste3.setX(coordenada2Ast);
                aste3.setY(-10);
            }
             //VER SI COLISIONO CON LA NAVE
            if (colisionAst3()) {
                //activo el sonido de choque   
                sonidoChoque.play();
                //reduzco las vidas
                vidas--;
                //aumento el contador de choques
                contadorChoquesAst += 1;
                //imprimo para comprobar que sirva
                System.out.println("Pego 3");
                //creo numero aleatorio
                SecureRandom coordenadaAst1 = new SecureRandom();
                //los guardo en varuiables
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas coordenadas para asteroide3
                aste3.setX(rango2);
                aste3.setY(-10);
                //creo un explosion
                Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
                //la pinto
                explocion.paint(g);
                //si el  contador de los choques es mayor a dos el juego termina
                if (contadorChoquesAst > 2) {
                    juegoFin = false;
                }

            }

        }
        if (puntos > 15 && puntos < 20 ) {
            nivel = 4;
           // aste3.setY(-200);         
            //aumento la velocidad
            aste1.setY_velocidad(20);
            aste2.setY_velocidad(20);

            //COONDICONES PARA EL NUEVO ASTEROIDE3
            
            
            //lo muevo
              aste3.moverAst();
              //le doy velocidad
            aste3.setY_velocidad(20);
            
            //condicion para reiniciar el ciclo
            if (aste3.getY() == 800) {
                //numeros aleatorios
                SecureRandom coordenada1 = new SecureRandom();
                int coordenada2Ast = coordenada1.nextInt(800);
                //defino sus nuevas coordenadas
                aste3.setX(coordenada2Ast);
                aste3.setY(-10);
            }
             
            
            
            // VER SI COLISIONO CON LA NAVE
            if (colisionAst3()) {
                //activo el sonido de choque   
                sonidoChoque.play();
                //reduzco las vidas
                vidas--;
                //aumento el contador de choques
                contadorChoquesAst += 1;
                //imprimo para comprobar que sirva
                System.out.println("Pego 3");
                //creo numero aleatorio
                SecureRandom coordenadaAst1 = new SecureRandom();
                //los guardo en varuiables
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas coordenadas para asteroide3
                aste3.setX(rango2);
                aste3.setY(-10);
                //creo un explosion
                Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
                //la pinto
                explocion.paint(g);
                //si el  contador de los choques es mayor a dos el juego termina
                if (contadorChoquesAst > 2) {
                    juegoFin = false;
                }

            }
            
            
            
             //COONDICONES PARA EL NUEVO ASTEROIDE 4
            //LO MUEVO
              aste4.moverAst();
              //le doy velocidad
            aste4.setY_velocidad(20);
            //condicion para reinicar el ciclo
            if (aste4.getY() == 800) {
                //numeros aleatorios
                SecureRandom coordenada1 = new SecureRandom();
                int coordenada2Ast = coordenada1.nextInt(800);
                //defino sus nuevas coordenadas
                aste4.setX(coordenada2Ast);
                aste4.setY(-10);
            }
             //ver si colisiona con la nave
            if (colisionAst4()) {
                //activo el sonido de choque   
                sonidoChoque.play();
                //reduzco las vidas
                vidas--;
                //aumento el contador de choques
                contadorChoquesAst += 1;
                //imprimo para comprobar que sirva
                System.out.println("Pego 4");
                //creo numero aleatorio
                SecureRandom coordenadaAst1 = new SecureRandom();
                //los guardo en varuiables
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas coordenadas para asteroide4
                aste4.setX(rango2);
                aste4.setY(-10);
                //creo un explosion
                Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
                //la pinto
                explocion.paint(g);
                //si el  contador de los choques es mayor a dos el juego termina
                if (contadorChoquesAst > 2) {
                    juegoFin = false;
                }

            }
        }if(puntos > 20){
            nivel =5;
            //muestro la nave enemiga
          naveEnemiga.setY_inicial(10);
          //la muevo
          naveEnemiga.mover();
          
             //aumento la velocidad de aste1 y 2
            aste1.setY_velocidad(30);
            aste2.setY_velocidad(30);

            //COONDICONES PARA EL NUEVO ASTEROIDE3
            
            
            //lo muevo
              aste3.moverAst();
              //le doy velocidad
            aste3.setY_velocidad(20);
            
            //condicion para reiniciar el ciclo
            if (aste3.getY() == 800) {
                //numeros aleatorios
                SecureRandom coordenada1 = new SecureRandom();
                int coordenada2Ast = coordenada1.nextInt(800);
                //defino sus nuevas coordenadas
                aste3.setX(coordenada2Ast);
                aste3.setY(-10);
            }
             
            
            
            // VER SI COLISIONO CON LA NAVE
            if (colisionAst3()) {
                //activo el sonido de choque   
                sonidoChoque.play();
                //reduzco las vidas
                vidas--;
                //aumento el contador de choques
                contadorChoquesAst += 1;
                //imprimo para comprobar que sirva
                System.out.println("Pego 3");
                //creo numero aleatorio
                SecureRandom coordenadaAst1 = new SecureRandom();
                //los guardo en varuiables
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas coordenadas para asteroide3
                aste3.setX(rango2);
                aste3.setY(-10);
                //creo un explosion
                Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
                //la pinto
                explocion.paint(g);
                //si el  contador de los choques es mayor a dos el juego termina
                if (contadorChoquesAst > 2) {
                    juegoFin = false;
                }

            }
            
            
            
             //COONDICONES PARA EL NUEVO ASTEROIDE 4
            //LO MUEVO
              aste4.moverAst();
              //le doy velocidad
            aste4.setY_velocidad(20);
            //condicion para reinicar el ciclo
            if (aste4.getY() == 800) {
                //numeros aleatorios
                SecureRandom coordenada1 = new SecureRandom();
                int coordenada2Ast = coordenada1.nextInt(800);
                //defino sus nuevas coordenadas
                aste4.setX(coordenada2Ast);
                aste4.setY(-10);
            }
             //ver si colisiona con la nave
            if (colisionAst4()) {
                //activo el sonido de choque   
                sonidoChoque.play();
                //reduzco las vidas
                vidas--;
                //aumento el contador de choques
                contadorChoquesAst += 1;
                //imprimo para comprobar que sirva
                System.out.println("Pego 4");
                //creo numero aleatorio
                SecureRandom coordenadaAst1 = new SecureRandom();
                //los guardo en varuiables
                int rango = coordenadaAst1.nextInt(850);
                int rango2 = coordenadaAst1.nextInt(850);
                //creo nuevas coordenadas para asteroide4
                aste4.setX(rango2);
                aste4.setY(-10);
                //creo un explosion
                Explocion explocion = new Explocion(nave.getX_inicial(), nave.getY_inicial() - 50);
                //la pinto
                explocion.paint(g);
                //si el  contador de los choques es mayor a dos el juego termina
                if (contadorChoquesAst > 2) {
                    juegoFin = false;
                }
            
            
            
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

    public boolean colisionAst3() {
        Area areaA = new Area(nave.getBounds());
        areaA.intersect(aste3.getBounds());

        return !areaA.isEmpty();
    }
      public boolean colisionAst4() {
        Area areaA = new Area(nave.getBounds());
        areaA.intersect(aste4.getBounds());

        return !areaA.isEmpty();
    }

    public boolean colisionBalaAst1(Bala bala) {
        Area areaA = new Area(bala.getBounds());
        areaA.intersect(aste1.getBounds());

        return !areaA.isEmpty();

    }
    
    public boolean colisionBalaEnemigaNave(BalaEnemiga bala){
         Area areaA = new Area(bala.getBounds());
        areaA.intersect(nave.getBounds());

        return !areaA.isEmpty();
    }
    public boolean colisionBalaNaveEnemiga(Bala bala){
         Area areaA = new Area(bala.getBounds());
        areaA.intersect(naveEnemiga.getBounds());

        return !areaA.isEmpty();
    }

    public boolean colisionBalaAst2(Bala bala) {
        Area areaA = new Area(bala.getBounds());
        areaA.intersect(aste2.getBounds());

        return !areaA.isEmpty();
    }

    public boolean colisionBalaAst3(Bala bala) {
        Area areaA = new Area(bala.getBounds());
        areaA.intersect(aste3.getBounds());

        return !areaA.isEmpty();
    }
    
     public boolean colisionBalaAst4(Bala bala) {
        Area areaA = new Area(bala.getBounds());
        areaA.intersect(aste4.getBounds());

        return !areaA.isEmpty();
    }
     
     public boolean colisionBalaEnemigaCampo(BalaEnemiga balas){
           Area areaA = new Area(balas.getBounds());
        areaA.intersect(verC.getBounds());

        return !areaA.isEmpty();
     }
     
     
     //METODOS PARA RESETEAR VALORES EN LA CLASE InicioJuego

      public static int getNivel() {
        return nivel;
    }

    public static void setNivel(int nivel) {
        Panel.nivel = nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getContadorChoquesAst() {
        return contadorChoquesAst;
    }

    public void setContadorChoquesAst(int contadorChoquesAst) {
        this.contadorChoquesAst = contadorChoquesAst;
    }
     
     

}
