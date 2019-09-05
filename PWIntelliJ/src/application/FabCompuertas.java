package application;

import Compuertas.And;
import InterFac.Compuerta;

public class FabCompuertas {
    public Compuerta getConexion(String compuertita) {
        if (compuertita.equalsIgnoreCase("And")) {
            return new And();
        }else {
            return null;
        }
    }
}
