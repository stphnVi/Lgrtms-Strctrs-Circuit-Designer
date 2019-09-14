package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;


public class Or implements Compuerta {
    /*
    POR ALGUNA RAZON DAN ERROR
    public Image imagen = new Image(getClass().getResourceAsStream("./Compuerta.png"));
    public Label label =new Label();

     */
    @Override
    public void Icono() {

       // label.setGraphic(new ImageView(imagen));
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");
        IPrincipal devolver = new IPrincipal();
        devolver.onMousePressedProperty();
    }
/*}
    public Label getLabel() {
        return label;
    }
    public Image getImage() {
        return imagen;
    }
*/
}

