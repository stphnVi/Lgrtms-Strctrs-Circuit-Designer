package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.Button;
import java.io.IOException;
import java.util.UUID;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tabla extends AnchorPane {
        @FXML
    TableView Tabla;
        @FXML
    Button Boperar;
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        public void start(Lista lista1) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Tabla.fxml"));
                /*
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
                IniTabla(lista1);

            }catch (IOException e){
                alerta.setContentText("Se ha fallado al tratar de abrir la vetana, termine el circuito o ");
                System.out.println("se ha fallado al tratar de abrir la tabla de verdad");
            }


            }

    public void IniTabla(Lista lista1){
            //inicio de intriduccion de los datos a la tabla de verdad
            //buscar observable list
            TableView <> = new TableView<>();
            TableColumn<>= new TableColumn<>();
            tVerdad.setEditable(true);
            for(int i=0; i <= lista1.getTamaño()-1; i++){

            tVerdad.getColumns().Add(lista1.ver(i));
            }



            /*
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/Tabla.fxml")
            );

            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);


            try {
                fxmlLoader.load();

            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }


            ////////////////////////////////////////////////////
            //provide a universally unique identifier for this object
            // setId(UUID.randomUUID().toString());

            Scene scene = new Scene(new Group());
            stage.setTitle("Table View Sample");
            stage.setWidth(450);
            stage.setHeight(500);

            final Label label = new Label("Address Book");
            label.setFont(new Font("Arial", 20));

            //table.setEditable(true);

            TableColumn firstNameCol = new TableColumn("entrada");
            firstNameCol.setMinWidth(100);
            firstNameCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("entrada"));

            TableColumn lastNameCol = new TableColumn("entrada");
            lastNameCol.setMinWidth(100);
            lastNameCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("entrada"));

            TableColumn emailCol = new TableColumn("salida");
            emailCol.setMinWidth(200);
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("salida"));

           // table.setItems(data);
           // table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            //vbox.getChildren().addAll(label, table);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            stage.setScene(scene);
            stage.show();
        }

        public static class Person {

            private final SimpleStringProperty firstName;
            private final SimpleStringProperty lastName;
            private final SimpleStringProperty email;

            private Person(String fName, String lName, String email) {
                this.firstName = new SimpleStringProperty(fName);
                this.lastName = new SimpleStringProperty(lName);
                this.email = new SimpleStringProperty(email);
            }

            public String getFirstName() {
                return firstName.get();
            }

            public void setFirstName(String fName) {
                firstName.set(fName);
            }

            public String getLastName() {
                return lastName.get();
            }

            public void setLastName(String fName) {
                lastName.set(fName);
            }

            public String getEmail() {
                return email.get();
            }

            public void setEmail(String fName) {
                email.set(fName);
            }

             */
        }
}
