package application;

import Compuertas.And;
import Compuertas.Or;
import InterFac.Compuerta;

public class FabCompuertas {
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
