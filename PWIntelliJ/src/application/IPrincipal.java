package application;
import Compuertas.And;
import InterFac.Compuerta;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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

public class IPrincipal extends AnchorPane {
    Image labeImage = new Image(getClass().getResourceAsStream("./Compuerta.png"), 80, 120, true, true);
    public  Label label = new Label();
    Label current = null;


    @FXML
    VBox paleta;

    @FXML
    AnchorPane papel;

    @FXML
    StackPane interfaz;

    public IPrincipal() {

    }

    /***
     * Método que agrega la imagen a el label y lo coloca en la paleta /DEBE CAMBIARSE
     */

    public void agregarImagen() {
        label.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label);
        InitUi();
    }



    public void InitUi() {
        /***
         * método que se encarga de pedirle a la fabrida las compuertas
         * @param interfaz AnchorPane donde se hará el diagrama.
         * @param Label Label en cual tiene una imagen la cual simula una compuerta.
         *
         */
        label.setOnMousePressed(new EventHandler<MouseEvent>() {

            //if para saber que compuerta se seleccionó y crear una nueva
            @Override
            /***
             *
             * @see
             * MouseEvent se encarga de hacer la llamada a la clase
             * FabCompuertas, que se encarga de crear las mismas.
             */
            public void handle(MouseEvent event) {
                System.out.println("se ha clickeado la compuerta");
                FabCompuertas fabrica = new FabCompuertas();
                Compuerta compuerta = fabrica.getConexion("And");
                compuerta.setIcono();

                //label = compuerta.getLabel();
                //Compuerta and = fabricar.getConexion("And");
                //and.setIcono();


            }
        });
        label.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            /***
             *
             * @see
             * una vez creada la compuerta en la fabrica
             * regresa para seguir el curso
             */
            public void handle(MouseEvent event) {
                System.out.println("se ha seleccionado la compuerta");
                Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(label.getStyle());
                db.setContent(content);
                event.consume();

            }
        });
        interfaz.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            /***
             * @see
             * DragEvent se encarga de darle seguimiento al label
             * y el mouse y crear la nueva compuerta en la interfaz de usuario
             * //DEBE TENER SU RESPETIVA IMAGEN
             */
            public void handle(DragEvent event) {
                System.out.println("compuerta arrastrándose");
                Dragboard db = event.getDragboard();

                if (event.getGestureSource() != interfaz &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.ANY);
                    //label.setGraphic(new ImageView(labeImage));
                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                }

                System.out.println("aquí imagen");
                event.consume();
            }
        });
        interfaz.setOnDragExited(new EventHandler <DragEvent>() {
            @Override
            /***
             * @see
             * DragEvent es el que debe reubicar el label según las coordenadas
             * del cursor en X y Y
             */
            public void handle(DragEvent event) {
                if (event.getTarget() instanceof StackPane) {
                    //StackPane target = (StackPane) event.getTarget();

                    //FabCompuertas fabrica = new FabCompuertas();
                    //Compuerta compuerta = fabrica.getConexion("And");
                    Label source = (Label) event.getGestureSource();
                    Label toAdd = new Label();
                    toAdd.setGraphic(new ImageView(labeImage));
                    System.out.println("no sé que hace");
                    //la cambié por interfaz, antes era target
                    toAdd.setTranslateX(event.getSceneX());
                    toAdd.setTranslateY(event.getSceneY());

                    papel.getChildren().add(toAdd);
                    toAdd.setGraphic(new ImageView(labeImage));
                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                    /*



                    //StackPane target = (StackPane) event.getTarget();
                    Label source = (Label) event.getGestureSource();
                    Label toAdd = new Label();
                    //FabCompuertas fabrica = new FabCompuertas();
                    //Compuerta compuerta = fabrica.getConexion("And");
                    //compuerta.setIcono();


                   //toAdd.setGraphic(new ImageView(compuerta.getImage()));
                    System.out.println("no sé que hace");
                    //la cambié por interfaz, antes era target
                    toAdd.setTranslateX(event.getSceneX());
                    toAdd.setTranslateY(event.getSceneY());

                    papel.getChildren().add(toAdd);
                   toAdd.setGraphic(new ImageView("/.Compuerta"));
*/
                }
                event.consume();
            }
        });


        label.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            /***
             *
             * @see
             * DragEvent ahora se encargará de avisar que la compuerta está en posición
             *
             */
            public void handle(DragEvent event) {

                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
                System.out.println("compuerta en posición");
                event.consume();

            }
        });
    }
}


