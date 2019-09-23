package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Uno extends Compuerta {
    /***
     * @param
     * Uno de brindar valores de entrada a las compuertas
     *
     */

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Uno.png"));

    public int Entradas = 0;
    public int Salida = 0;

    public Uno(){
        this.setGraphic(new ImageView(imagen));
    }
    @Override
    public void Operar(Lista x) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */
    }
/*
    public void Operacion(int in , int out){

        Nodo ent1 = new Nodo(1);
        Nodo ent2 = new Nodo(0);
        if(ent1==1 && ent2 ==1){
            int n = 1;
            Nodo salida = new Nodo(n);
            return salida;
        }else{
            int n = 0;
            Nodo salida= new Nodo(n);
            return salida;


        }

        //liked list

*/


    public Image getImage() {
        //label.setGraphic(new ImageView(imagen));

        return imagen;
    }


}