package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @FXML
    Button Boperar;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new AnchorPane();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("./Sample.fxml"));

        fxmlLoader.setRoot(root);

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.show();

        IPrincipal iPrincipal = (IPrincipal) fxmlLoader.getController();
        iPrincipal.Inicio();

        Boperar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Scene scene = new Scene(new Group());
                primaryStage.setTitle("Table View Sample");
                primaryStage.setWidth(450);
                primaryStage.setHeight(500);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });




    }

    public static void main(String[] args) {
        launch(args);
    }
}