package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class Cero implements Compuerta {

    public Image imagen =
            //cambiar imagen
            new Image(getClass().getResourceAsStream("../application/Cero.png"));
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
        return label;
    }

    public Image getImage() {
        return imagen;
    }
}
