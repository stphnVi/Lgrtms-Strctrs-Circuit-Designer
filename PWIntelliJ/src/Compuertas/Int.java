package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Int extends Compuerta {
    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Cero.png"));
    public int Entradas = 0;
    public int Salida = 0;

    public Int(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Int");
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                System.out.println("clickeo en el interruptor");
            }
        });
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





