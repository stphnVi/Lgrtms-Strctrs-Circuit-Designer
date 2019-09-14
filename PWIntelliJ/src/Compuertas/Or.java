package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Or implements Compuerta {

    //POR ALGUNA RAZON DAN ERROR
    private Image imagen = new Image(getClass().getResourceAsStream("../application/Compuerta.png"));
    private Label label =new Label();


    @Override
    public void Icono() {

       label.setGraphic(new ImageView(imagen));
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");
        IPrincipal devolver = new IPrincipal();
        devolver.onMousePressedProperty();
    }

    public Label getLabel() {
        return label;
    }
    public Image getImage() {
        return imagen;
    }

}

