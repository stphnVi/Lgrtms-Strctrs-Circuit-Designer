package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class IPrincipal {
    @FXML
    VBox paleta;

    @FXML
    StackPane interfaz;
    public void pressed(ActionEvent e){
        System.out.println("Pressed");
    }

    public void agregarImagen(){
        Image labeImage = new Image(getClass().getResourceAsStream("./Compuerta.png"));
        Label label1 = new Label();
        label1.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label1);

        Label label2 = new Label();
        label2.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label2);
    }


}
