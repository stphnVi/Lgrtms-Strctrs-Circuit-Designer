package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Int {
    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Cero.png"));
    public int Entradas = 0;
    public int Salida = 0;

    public Int(){

    }

    public void Icono() {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");


    }


    public Image getImage() {
        return imagen;
    }
}





