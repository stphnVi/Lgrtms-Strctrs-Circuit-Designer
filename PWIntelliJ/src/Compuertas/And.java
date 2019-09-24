package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class And extends Compuerta {
    /***
     * @param
     * And se encargará de operar las compuertas de este tipo segun el id
     *
     */
    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/And.png"));
  //  public Label label = new Label();

    public int Entradas = 0;
    public int Salida = 0;
    public int cont =0;

    public And(){
        this.setGraphic(new ImageView(imagen));
        this.setId("And");
    }
    @Override
    public void Operar(Lista x, int n) {


        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */
        if(x.ver(1).equals(1) && x.ver(2).equals(1) ){
            System.out.print("repuesta: "+1+"\n");
            x.agregarDelante(1);
            System.out.println("----------");

        }else{
            System.out.print("repuesta: " + 0 + "\n");
            x.agregarDelante(0);
            System.out.println("----------");

        }

    }


    public Image getImage() {
        return imagen;
    }


}