package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Not extends Compuerta {
    /***
     * @param
     * Not se encargará de operar las compuertas de este tipo segun el id
     *
     */

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Not.png"));



    public int Entradas = 0;
    public int Salida = 0;

    public Not(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Not");

    }


    @Override
    public void Operar(Lista x,int n) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");


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