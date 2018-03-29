package Juego;

import Ejecutable.Panel;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Nave {
    
    
    //creo una lista de las balas que se van a crear
      public ArrayList listaBalas = new ArrayList();

    //creo las dimensuiones de la nave
    int anchoNave = 202;
    int alturaNave = 158;

    //indico las variabes de posicion de inicio
    int x_inicial = 380;
    int y_inicial = 590;

    //creo variable auxiliar para mover la nave
    int x_aux;

    //creo dos banderas boolean para ver a que direccion se mueve
    boolean derecha = false;
    boolean izquierda = false;

    Panel pane;

    public Nave() {

    }

    public void paint(Graphics2D g) {
        //creo imagen para la nave    
        ImageIcon auto = new ImageIcon(getClass().getResource("/Imagenes/naveJuego.png"));
        //dibujo la imagen
        g.drawImage(auto.getImage(), x_inicial, y_inicial, anchoNave, alturaNave, null);
    }

    public void Bala() {
      
        /* creo un ciclo for para recorrer la lista de balas
        y mandarle mensaje de que se muevan */
        
        for (int i = 0; i < listaBalas.size(); i++) {
            Bala nuevaBala = (Bala)listaBalas.get(i);
            nuevaBala.mover();
        }
        
        
        
    }

    public void moverNave() {
        //si derecha es true
        if (derecha == true) {
            x_aux = 20;
            //aumentra x en 10
            x_inicial += x_aux;
            derecha = false;
        }
        //si izquierda es true
        if (izquierda == true) {

            x_aux = -20;
            //disminuir x en 10
            x_inicial += x_aux;
            izquierda = false;
        }

    }
    //metodo para poder mover mediante teclado

    public void keyPressed(KeyEvent e) {
        // si el codigo del teclado es de la tecla d
        if (e.getKeyCode() == KeyEvent.VK_D) {
            derecha = true;
            izquierda = false;
        }
        //si el codigo del teclado es de la tecla a
        if (e.getKeyCode() == KeyEvent.VK_A) {
            izquierda = true;
            derecha = false;
        }
        /*  si el codigo del teclado es igual al de la tecla s
        entonces creo una nueva bala con las coordenadas de  el lugar
        en donde se encuentra la nave*/
        if(e.getKeyCode() == KeyEvent.VK_S){
            Bala bala = new Bala(x_inicial,y_inicial);
            //añado la bala a la lista de balas
            listaBalas.add(bala);
        }
    }

}
