package Ejecutable;

import Menu.Menu;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        InicioJuego inicioJ = new InicioJuego();

        Menu menu = new Menu();
        //mientras la variable juga sea true
        while (menu.juga) {

            menu.setVisible(true);
            menu.setLocation(550, 150);
            /*
            
            Si la variable cambia a false quiere decir que se apretó el 
            boton para jugar
            
             */
            if (!menu.juga) {

                inicioJ.iniciar();
                menu.setVisible(false);
                menu.juga = false;

            }

        }

        //mientras la variable auxiliar sea true
        //significa que el juego termino
        while (inicioJ.nuevoFin) {

            int iniciar2 = JOptionPane.showConfirmDialog(null, "¿Desea jugar de nuevo?");
            if (iniciar2 == 0) {
                //cierro la ventana actual
                inicioJ.ventana.dispose();
                // cambio le valor de la variablea false 
                inicioJ.nuevoFin = false;
                // incio el juego de nuevo
                inicioJ.iniciar();

            } else if (iniciar2 == 1) {
                //cierro la ventana
                inicioJ.ventana.dispose();
                //Cambio el valor para un posble reinicio
                inicioJ.nuevoFin = false;
                //la variable juga cambia a true para mostrar el menu
                menu.juga = true;
                while (menu.juga) {

                    menu.setVisible(true);
                    menu.setLocation(550, 150);
                    //si la variable juga es false quiere decir que se inicio el juego
                    if (!menu.juga) {

                        inicioJ.iniciar();
                        menu.setVisible(false);
                        menu.juga = false;

                    }

                }

            }

        }

    }

}
