package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Uno implements Compuerta {

    public Image imagen =
            //cambiar imagen
            new Image(getClass().getResourceAsStream("../application/And.png"));
    public Label label = new Label();
    public int Salida = 0;


    @Override
    public void Icono() {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una fuente de 1");
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
