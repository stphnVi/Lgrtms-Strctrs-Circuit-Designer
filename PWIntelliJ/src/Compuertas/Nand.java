package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
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


    private int n = 0;
    public int Entradas = 0;
    public int Salida = 0;


    public Nand(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Nand");

    }

    @Override
    public void Operar(Lista x, int n) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        if(x.ver(n).equals(1) && x.ver(n+2).equals(1) ){

            System.out.print("repuesta: "+0+"\n");



        }else{
            System.out.print("repuesta: "+1+"\n");

        }

    }
    public Image getImage() {
        return imagen;
    }
}



