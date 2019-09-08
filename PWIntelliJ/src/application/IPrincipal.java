package application;
import InterFac.Compuerta;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import java.awt.geom.Point2D;

public class IPrincipal extends AnchorPane {
    Image labeImage = new Image(getClass().getResourceAsStream("./Compuerta.png"), 80, 120, true, true);
    Label label1 = new Label();
    Label label2 = new Label();
    Label lab = new Label();
    private Double lastX = null;
    private Double lastY = null;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    @FXML
    VBox paleta;

    @FXML
    StackPane interfaz;

    public void pressed(ActionEvent e) {
        System.out.println("Pressed");
    }

    public void agregarImagen() {
        label1.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label1);
        label2.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label2);


        //dragable label
        InitUi();
    }


    /*
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * */
    public void InitUi() {
      //Image m = new Image(getClass().getResourceAsStream("./Compuerta.png"), 80, 120, true, true);
    //ImageView V= new ImageView();
    //V.setImage(labeImage);
    //Dragboard db = label2.startDragAndDrop(TransferMode.MOVE);

    label2.setScaleX(1.0);
    label2.setScaleY(1.0);

        label2.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow MOVE transfer mode */
               Dragboard db = label2.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(label2.getStyle());
                db.setContent(content);
                event.consume();
            }
        });
        interfaz.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */

                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                Dragboard db = event.getDragboard();

                if (event.getGestureSource() != interfaz &&
                        event.getDragboard().hasString()) {
                    /* allow for moving */
                    event.acceptTransferModes(TransferMode.ANY);

                    //label2.relocate(event.getSceneX(),event.getSceneY());

                    //label2.setTranslateX(event.getSceneX());
                    //label2.setTranslateY(event.getSceneY());


                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                }

                System.out.println("aquí imagen");
                //V.setImage(db.getImage());
                event.consume();
            }
        });

        /*interfaz.setOnDragEntered(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // the drag-and-drop gesture entered the target
                System.out.println("onDragEntered");
                // show to the user that it is an actual gesture target
                if (event.getGestureSource() != interfaz &&
                        event.getDragboard().hasImage()) {
                }
                event.consume();
            }
        });
*/
        interfaz.setOnDragExited(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */

                if (event.getTarget() instanceof StackPane) {
                    StackPane target = (StackPane) event.getTarget();
                    Label source = (Label) event.getGestureSource();
                    Label toAdd = new Label(source.getText(), source.getGraphic());
                    target.getChildren().add(toAdd);
                    toAdd.setGraphic(new ImageView(labeImage));
                }
                event.consume();

            }

        });


        label2.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
               // V.setImage(db.getImage());
                /* if the data was successfully moved, clear it */

                event.consume();

            }
        });

    }
}
