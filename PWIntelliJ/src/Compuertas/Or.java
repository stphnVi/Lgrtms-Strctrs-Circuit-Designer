package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Or extends Compuerta {
    /***
     * @param
     * Or se encargará de operar las compuertas de este tipo segun el id
     *
     */
    int n=0;
    //POR ALGUNA RAZON DAN ERROR
    private Image imagen = new Image(getClass().getResourceAsStream("../application/or.png"));

    public Or(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Or");
    }
    @Override
    public void Operar(Lista x, int n) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        if(x.ver(1).equals(0) && x.ver(2).equals(0) ){
            x.agregarDelante(0);
            System.out.print("repuesta: "+0+"\n");
            System.out.println("----------");

        }else{
            x.agregarDelante(1);
            System.out.print("repuesta: "+1+"\n");
            System.out.println("----------");

        }

    }


    public Image getImage() {
        return imagen;
    }

}

