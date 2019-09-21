package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Cero extends Compuerta {
    /***
     * @param
     * Cero de brindar valores de entrada a las compuertas
     *
     */

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Cero.png"));
   // public Label label = new Label();


    public int Entradas = 0;
    public int Salida = 0;

    public Cero(){
        this.Entradas = 0;
        this.setGraphic(new ImageView(imagen));
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
        //label.setGraphic(new ImageView(imagen));

        return imagen;
    }
    public int getint(){
        return Entradas;
    }
}


