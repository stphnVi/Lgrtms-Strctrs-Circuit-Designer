package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Lista;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Xnor extends Compuerta {
    /***
     * @param
     * Xnor se encargará de operar las compuertas de este tipo segun el id
     *
     */

    public Image imagen =
            new Image(getClass().getResourceAsStream("../application/Xnor.png"));


    private int n = 0;
    public int Entradas = 0;
    public int Salida = 0;

    public Xnor(){
        this.setGraphic(new ImageView(imagen));
        this.setId("Xnor");

    }


    @Override
    public void Operar(Lista x, int n) {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        if(x.ver(n).equals(1) && x.ver(n+2).equals(1) ){

            System.out.print("repuesta: "+1+"\n");

        }else if(x.ver(n).equals(0) && x.ver(n+2).equals(0)){
            System.out.print("repuesta: "+1+"\n");

        }else{
            System.out.print("repuesta: "+0+"\n");

        }

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