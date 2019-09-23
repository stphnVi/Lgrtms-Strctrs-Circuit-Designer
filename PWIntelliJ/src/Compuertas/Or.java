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
    public void Operar(Lista x) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        if(x.ver(n).equals(0) && x.ver(n+2).equals(0) ){

            System.out.print("repuesta: "+0+"\n");



        }else{
            System.out.print("repuesta: "+1+"\n");

        }

    }


    public Image getImage() {
        return imagen;
    }

}

