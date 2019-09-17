package application;

import Compuertas.*;
import InterFac.Compuerta;

import java.awt.*;

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

        if (compuertita.equalsIgnoreCase("Uno")) {
            return new Uno();
        } else if (compuertita.equalsIgnoreCase("Cero")) {
            return new Cero();
        } else if (compuertita.equalsIgnoreCase("And")) {
            return new And();
        } else if (compuertita.equalsIgnoreCase("Nand")) {
            return new Nand();
        }else if (compuertita.equalsIgnoreCase("Or")) {
            return new Or();
        } else if (compuertita.equalsIgnoreCase("Not")) {
            return new Not();
        } else if (compuertita.equalsIgnoreCase("Xor")) {
            return new Xor();
        } else if (compuertita.equalsIgnoreCase("Xnor")) {
            return new Xnor();
        } else if (compuertita.equalsIgnoreCase("Nor")) {
            return new Nor();
        } else if (compuertita.equalsIgnoreCase("Usuario")) {
            return new Or();
        } else {
            return null;
        }
    }
}
