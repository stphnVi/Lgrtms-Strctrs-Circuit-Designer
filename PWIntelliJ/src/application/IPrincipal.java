package application;
import Compuertas.And;
import InterFac.Compuerta;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class IPrincipal extends AnchorPane {
    Image labeImage = new Image(getClass().getResourceAsStream("./Compuerta.png"), 80, 120, true, true);
    public  Label label = new Label();
    FabCompuertas fabrica = new FabCompuertas();


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
        /*
        FabCompuertas fabrica = new FabCompuertas();
        Compuerta compuerta = fabrica.getConexion("And");
        compuerta.setIcono();

*/
        InitUi();



    }


    public void InitUi(){

        /***
         * método que se encarga de pedirle a la fabrida las compuertas
         * @param interfaz AnchorPane donde se hará el diagrama.
         * @param Label Label en cual tiene una imagen la cual simula una compuerta.
         *
         */

        label.setOnMousePressed(new EventHandler<MouseEvent>() {

            //if para saber que compuerta se seleccionó y crear una nueva
            @Override
            public void handle(MouseEvent event) {
                System.out.println("se ha clickeado la compuerta");
                //label = compuerta.getLabel();
                Compuerta and = fabrica.getConexion("And");
                and.Icono();

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
                System.out.println("SetOnDragOver-Entrada");
                System.out.println("compuerta arrastrándose");
                Dragboard db = event.getDragboard();
                System.out.println(event.getDragboard());

                if (event.getGestureSource() != interfaz && event.getDragboard().hasString()) { event.acceptTransferModes(TransferMode.MOVE);
                    //label.setGraphic(new ImageView(labeImage));
                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                    System.out.println("SetOnDragOver-If");
                }else{
                    System.out.println("SetOnDragOver-Else");

                }
                //System.out.println("SetOnDragOver-seguir para reubicar");
                event.consume();
                System.out.println("SetOnDragOver-Salida");
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
                System.out.println("SetOnDragExited-Entrada");

                if (event.getTarget() instanceof StackPane) {
                    System.out.println(event.getTarget());
                    System.out.println("Choque de compuertas");


                    //FabCompuertas fabrica = new FabCompuertas();
                    //Compuerta compuerta = fabrica.getConexion("And");

                }

               // if(event.getDragboard() ==)
                Label source = (Label) event.getGestureSource();
                Label toAdd = new Label();

                toAdd.setGraphic(new ImageView(labeImage));
                //Regtangle patilla = new Regtangle;
                //Rectangle rectangle = new Rectangle(10, 10, 10, 10);

                //StackPane target = new StackPane(rectangle,toAdd);

                //System.out.println("no sé que hace");
                //la cambié por interfaz, antes era target
                toAdd.setTranslateX(event.getSceneX());
                toAdd.setTranslateY(event.getSceneY());
                //toAdd.getChildren().add(labelpeq);

                papel.getChildren().add(toAdd);
                //toAdd.setGraphic(new ImageView(labeImage));

                System.out.println("SetOnDragExited-coordenadas de to Add");
                System.out.println(event.getSceneY());
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
                System.out.println(event.getSceneX());
                DoubleProperty startX = new SimpleDoubleProperty(event.getX());
                DoubleProperty startY = new SimpleDoubleProperty(event.getY());
                DoubleProperty endX = new SimpleDoubleProperty(event.getX());
                DoubleProperty endY = new SimpleDoubleProperty(event.getY());


                IPrincipal.Anchor start = new IPrincipal.Anchor(Color.PALEGREEN, startX, startY);
                IPrincipal.Anchor end  = new IPrincipal.Anchor(Color.TOMATO, endX, endY);

                papel.getChildren().add(start);
                papel.getChildren().add(end);

                Line line = new IPrincipal.BoundLine(startX, startY, endX, endY, toAdd);
                //StackPane stackPaneLeft = new StackPane();
                //stackPaneLeft.setStyle("-fx-background-color: yellow");
                //stackPaneLeft.setPrefSize(40, 80);

                System.out.println(event.getDragboard());
                //papel.getChildren().add(stackPaneLeft);

                papel.getChildren().add(line);


                event.consume();
                System.out.println("SetOnDragExited-Salida");
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
                System.out.println("SetOnDragDone-Entrada");

                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
                System.out.println("COMPUERTA EN POSICIÓN");
                System.out.println(event.getDragboard());
                event.consume();
                System.out.println("SetOnDragDone-Salida");


            }
        });


    }
    class BoundLine extends Line {
        BoundLine(DoubleProperty startX, DoubleProperty startY, DoubleProperty endX, DoubleProperty endY, Label toAdd) {
            startXProperty().bind(startX);
            startYProperty().bind(startY);
            endXProperty().bind(endX);
            endYProperty().bind(endY);
            setStrokeWidth(2);
            setStroke(Color.GRAY.deriveColor(0, 1, 1, 0.5));
            setStrokeLineCap(StrokeLineCap.BUTT);
            getStrokeDashArray().setAll(10.0, 5.0);
            setMouseTransparent(true);

        }


    }

    // a draggable anchor displayed around a point.
    class Anchor extends Circle {
        Anchor(Color color, DoubleProperty x, DoubleProperty y) {
            super(x.get(), y.get(), 10);
            setFill(color.deriveColor(1, 1, 1, 0.5));
            setStroke(color);
            setStrokeWidth(2);
            setStrokeType(StrokeType.OUTSIDE);

            x.bind(centerXProperty());
            y.bind(centerYProperty());
            enableDrag();
        }

        // make a node movable by dragging it around with the mouse.
        private void enableDrag() {
            final IPrincipal.Anchor.Delta dragDelta = new IPrincipal.Anchor.Delta();
            setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    // record a delta distance for the drag and drop operation.
                    dragDelta.x = getCenterX() - mouseEvent.getX();
                    dragDelta.y = getCenterY() - mouseEvent.getY();
                    getScene().setCursor(Cursor.MOVE);
                }
            });
            setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    getScene().setCursor(Cursor.HAND);
                }
            });
            setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    double newX = mouseEvent.getX() + dragDelta.x;
                    if (newX > 0 && newX < getScene().getWidth()) {
                        setCenterX(newX);
                    }
                    double newY = mouseEvent.getY() + dragDelta.y;
                    if (newY > 0 && newY < getScene().getHeight()) {
                        setCenterY(newY);
                    }
                }
            });
            setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    if (!mouseEvent.isPrimaryButtonDown()) {
                        getScene().setCursor(Cursor.HAND);
                    }
                }
            });
            setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    if (!mouseEvent.isPrimaryButtonDown()) {
                        getScene().setCursor(Cursor.DEFAULT);
                    }
                }
            });
        }

        // records relative x and y co-ordinates.
        private class Delta {
            double x, y;
        }
    }

}


