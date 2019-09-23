package InterFac;
import application.Lista;
import javafx.scene.image.Image;
import javafx.scene.control.Label;



public abstract class Compuerta extends Label {

    public abstract void Operar(Lista x);

    public abstract Image getImage();


}
