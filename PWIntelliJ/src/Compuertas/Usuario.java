package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Usuario extends Compuerta {

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/And.png"));



    public int Entradas = 0;
    public int Salida = 0;
    public Usuario(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Usuario");

    }

    @Override
    public void Operar(Lista x, int n) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");


    }

    public Image getImage() {
        //label.setGraphic(new ImageView(imagen));

        return imagen;
    }

}

