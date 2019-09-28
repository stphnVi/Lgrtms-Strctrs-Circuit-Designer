package application;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Tabla extends AnchorPane {
    /***
     * tabla de verdad para en circuito con sus respectivas compuertas
     * @param lista1 es la lista que se está operando y la que se utilizará para sacar los datos y colocarlos en la tabla de verdad.
     */

        @FXML TableView<Lista> tablita;
        @FXML Button Boperar;

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        public void start(Lista lista1,Stage stage) {

            Scene scene = new Scene(new Group());
            stage.setTitle("Table View Sample");
            stage.setWidth(400);
            stage.setHeight(500);

            final Label label = new Label("Student IDs");
            label.setFont(new Font("Arial", 20));

            TableView tableView = new TableView<>();
            tableView.setEditable(true);
            tableView.getSelectionModel().setCellSelectionEnabled(true);

            ObservableList<TableColumn> tableViewColumns = generateTableViewColumns(lista1);
            tableView.getColumns().setAll(tableViewColumns);

            ObservableList<TableColumn> tcs = tableView.getColumns();
            for (int i = 0; i <= lista1.getTamaño()-1; i++) {
                TableColumn tc = tcs.get(i);
                }



            ObservableList<ArrayList> tableViewRows = generateTableViewRows(lista1);
            tableView.getItems().setAll(tableViewRows);

            for (int i = 0; i < tcs.size(); i++) {
                TableColumn dataColumn = tcs.get(i);
            }

            final VBox vbox = new VBox();

            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, tableView);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            stage.setScene(scene);

            stage.show();
        }

    private ObservableList<TableColumn> generateTableViewColumns(Lista lista1) {
        ObservableList<TableColumn> tableViewColumns = FXCollections.observableArrayList();
        //Compuertas
      // for(int i = 0; i <= lista1.get, i++){}

        for(int i = 0; i<= lista1.getTamaño()-1; i++){

            //col = new TableColumn<>();


        }


        TableColumn secondDataColumn = new TableColumn<>("Compuerta A");
        TableColumn thirdDataColumn = new TableColumn<>("Compuerta B");


        secondDataColumn.setMinWidth(130);
        thirdDataColumn.setMinWidth(130);


        tableViewColumns.add(secondDataColumn);
        tableViewColumns.add(thirdDataColumn);

        return tableViewColumns;
    }

    private ObservableList<ArrayList> generateTableViewRows(Lista lista1) {

            //Valores de las compuetas
        int max = lista1.getTamaño()-1;
        ObservableList<ArrayList> tableViewRows = FXCollections.observableArrayList();
        // ArrayList dataRow = new ArrayList<>();
        //Object n = lista1.ver(0);
        //dataRow.add(lista1.ver(0));
        System.out.println(lista1.getTamaño()+"ListaLista");



        for (int i = 0; i <= max; i++) {
            ArrayList dataRow = new ArrayList<>();


            String value2 = "A" + i + lista1.ver(i);
            String value3 = "B" + i + lista1.ver(i);


            dataRow.add(value2);
            dataRow.add(value3);

            tableViewRows.add(dataRow);
        }


        return tableViewRows;
    }

}