package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Usuario implements Compuerta {

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/And.png"));
    public Label label = new Label();


    public int Entradas = 0;
    public int Salida = 0;


    @Override
    public void Icono() {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");
        IPrincipal devolver = new IPrincipal();
        devolver.onMousePressedProperty();

    }


    public Label getLabel() {
        label.setGraphic(new ImageView(imagen));
        label.setId("And");

        return label;
    }

    public Image getImage() {
        //label.setGraphic(new ImageView(imagen));

        return imagen;
    }

}

