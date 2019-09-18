package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

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



    }

    public static void main(String[] args) {
        launch(args);
    }
}