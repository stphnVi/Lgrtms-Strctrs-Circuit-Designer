package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;
import application.Nodo;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class And implements Compuerta {
    /*
    private Image imagen = new Image(getClass().getResourceAsStream("./Compuerta.png"));
    private Label label =new Label();
    public int Entradas = 0;
    public int Salida = 0;
    */

    @Override
    public void Icono() {
        //label.setGraphic(new ImageView(imagen));
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");
        IPrincipal devolver = new IPrincipal();
        devolver.onMousePressedProperty();

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



    public Label getLabel() {
        return label;
    }
    public Image getImage() {
        label.setGraphic(new ImageView(imagen));
        return imagen;
    }
*/

}