package application;

import Compuertas.And;
import Compuertas.Or;
import InterFac.Compuerta;

/***
 *
 * @see FabCompuertas es la fabrica de compuertas, funciona con el patron de diseño Factory.
 */

public class FabCompuertas {
    /***
     *
     *
     *
     * @return
     * retorna a las compuertas respectivas por hacer.
     */
    public Compuerta getConexion(String compuertita) {
        if (compuertita.equalsIgnoreCase("And")) {
            return new And();
        }else if(compuertita.equalsIgnoreCase("Or")) {
            return new Or();
        }else{
            return null;
        }
    }
}
