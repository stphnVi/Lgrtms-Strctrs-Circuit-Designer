package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Nand extends Compuerta {
    /***
     * @param
     * Nand se encargará de operar las compuertas de este tipo segun el id
     *
     */

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Nand.png"));



    public int Entradas = 0;
    public int Salida = 0;


    public Nand(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Nand");

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



