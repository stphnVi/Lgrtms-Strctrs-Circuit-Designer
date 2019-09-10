package Compuertas;

import InterFac.Compuerta;
import application.IPrincipal;

public class And implements Compuerta {
    @Override

    public void icono() {
        /***
         * @see
         * devuelve a la Iprincipal para seguir con el curso del programa
         */

        System.out.print("Se ha creado una compuerta AND");
        IPrincipal devolver = new IPrincipal();
        devolver.onMousePressedProperty();
    }
}