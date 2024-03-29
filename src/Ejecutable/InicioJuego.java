package Ejecutable;

import Juego.BalaEnemiga;
import java.awt.Color;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class InicioJuego {

    

    public JFrame ventana = new JFrame("Juego Nave");
    
    Panel panel = new Panel();
    //variable auxiliar
    public boolean nuevoFin = true;
    //nuevos numeros para setear en los nuevo asteroides
    int aste1,aste2,aste3,aste4;

    public void iniciar() {
     
        //a la venta le agrego el panel
        ventana.add(panel);
      
        ventana.setSize(1300, 830);

        ventana.setLocation(150, 5);

        ventana.setVisible(true);
        //metodo al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //le asigno un color de fondo
        panel.setBackground(Color.BLACK);
       
        
        /*
        La condicion siguiente es para saber cuando el juego acabó 
        y se debe volver a reniciar las variables del juego
        */
        
        if (!nuevoFin) {
            panel.setPuntos(0);
            panel.setVidas(5);
            panel.setContadorChoquesAst(0);
            panel.setContadorChoqueBalaNaveE(0);
            panel.setContadorNuevo(0);
            panel.setNivel(1);
            SecureRandom coordenadaAst = new SecureRandom();
            aste1 = coordenadaAst.nextInt(800);
            aste2 = coordenadaAst.nextInt(800);
            aste3 = coordenadaAst.nextInt(800);
            aste4 = coordenadaAst.nextInt(800);
            
            //asigno nuevas coordenadas a los asteroides
            panel.aste1.setX(aste1);
            panel.aste1.setY(-10);
            
            panel.aste2.setX(aste2);
            panel.aste2.setY(-10);

            panel.aste3.setX(aste3);
            panel.aste3.setY(-200);

            panel.aste4.setX(aste4);
            panel.aste4.setY(-200);        
            
            /*
            
            Creo un bucle while por que un for me da problemas
            a la hora de recorrer la lista e ir removiendo las balas
            
            */
            
            //contador auxiliar
            int contador =0;
            //mientras que la lista sea diferente de cero o no este vacia
            while(!panel.naveEnemiga.listaBalaEnemiga.isEmpty()){
                /*
                
                Creo el objeto con la referencia en el inidice cero siempre
                por que cuando se remueva el siguiente objeto toma el mismo
                indice inmediatamente
                
                */
                BalaEnemiga removeB = (BalaEnemiga)panel.naveEnemiga.listaBalaEnemiga.get(contador);
                //remuevo la bala
                panel.naveEnemiga.listaBalaEnemiga.remove(removeB);
              
            }
            //renicio la nave debajo de la pantalla
            panel.naveEnemiga.setY_inicial(2000);
        

            //asigno nuevoas valores a las variables para reiniciar el while de  abajo
            panel.juegoFin = true;
            nuevoFin = true;
        }
        
        /*
        
        Condicion que sirve para saber en que momento termina el juego,
        termina cuando hay 3 choques de asteroides con la nave
        
        Cambia el valor de las variables a false para que no entre en el bucle
        while de abajo
        
        Cuando entra el if de arriba cambia el valor de los chocques y
        eso hace que no entre a cambiar variables el siguiente if.
        
        */
        if (panel.vidas < 1) {
            panel.juegoFin = false;
            nuevoFin = panel.juegoFin;

        }

        //mientras el juego siga
        while (panel.juegoFin) {
        
            panel.repaint();
            //un try para recoger exepciones
            try {
                //cada 10 tiempos 
                   Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(InicioJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

            panel.repaint();
               //imprimo para ayudarme a ver cómo se comporta
            System.out.println("Puntos:" + panel.getPuntos());
            System.out.println(" Vidas: " + panel.getVidas());
            System.out.println("Choques: " + panel.getContadorChoquesAst());
        }

    }

}
