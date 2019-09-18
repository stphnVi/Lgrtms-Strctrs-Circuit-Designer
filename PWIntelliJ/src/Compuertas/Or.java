package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Or extends Compuerta {

    //POR ALGUNA RAZON DAN ERROR
    private Image imagen = new Image(getClass().getResourceAsStream("../application/or.png"));

    public Or(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Or");

    }


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


    public Image getImage() {
        return imagen;
    }

}

