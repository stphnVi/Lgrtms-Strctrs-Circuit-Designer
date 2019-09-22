package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import java.awt.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tabla extends Application{
        @FXML
    TableView Tabla;
        @FXML
    Button Boperar;


        @Override

        public void start(Stage stage) {
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
        }
}
