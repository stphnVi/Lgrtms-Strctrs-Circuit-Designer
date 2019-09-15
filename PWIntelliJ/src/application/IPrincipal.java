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
    public Image labeImage = new Image(getClass().getResourceAsStream("./And.png"), 80, 120, true, true);
    private Image labeImage2 = new Image(getClass().getResourceAsStream("./or.png"), 80, 120, true, true);
    private  Label label = new Label();
    private Label label2 = new Label();


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
        FabCompuertas fabrica = new FabCompuertas();
        Compuerta and = fabrica.getConexion("And");
        paleta.getChildren().add(and.getLabel());
        Compuerta or = fabrica.getConexion("Or");
        paleta.getChildren().add(or.getLabel());


        paleta.setOnMousePressed(new EventHandler<MouseEvent>() {
        //onMouseClickedProperty().set(new EventHandler<MouseEvent>()
            @Override
            public void handle(MouseEvent event) {
                if(event.getTarget() == and.getLabel()){
                    label = and.getLabel();
                    labeImage = and.getImage();
                    System.out.println("And clickeada");
                    InitUi();

                }else if(event.getTarget() == or.getLabel()){
                    label = or.getLabel();
                    labeImage = or.getImage();
                    System.out.println("Or clickeada");
                    InitUi();
                }else{
                    System.out.println("se ha clickeado la paleta");

                }

            }
        });

/*
        label.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label);
        label2.setGraphic(new ImageView(labeImage2));
        paleta.getChildren().add(label2);
        InitUi();



 */
    }



    private void InitUi(){

        /***
         * método que se encarga de pedirle a la fabrida las compuertas
         * @param interfaz AnchorPane donde se hará el diagrama.
         * @param Label Label en cual tiene una imagen la cual simula una compuerta.
         *
         */

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
                Dragboard db = event.getDragboard();

                if (event.getGestureSource() != interfaz && event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }

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

                if ( event.getPickResult().getIntersectedNode() instanceof StackPane) {
                    System.out.println(event.getTarget());
                    System.out.println("Choque de compuertas");

                    //event.getPickResult().getIntersectedNode()
                    Label source = (Label) event.getGestureSource();
                    Label toAdd = new Label();

                    toAdd.setGraphic(new ImageView(labeImage));
                    toAdd.setTranslateX(event.getSceneX());
                    toAdd.setTranslateY(event.getSceneY());
                    papel.getChildren().add(toAdd);
                    System.out.println("SetOnDragExited-coordenadas de to Add");
                    DoubleProperty startX = new SimpleDoubleProperty(event.getX());
                    DoubleProperty startY = new SimpleDoubleProperty(event.getY());
                    DoubleProperty endX = new SimpleDoubleProperty(event.getX());
                    DoubleProperty endY = new SimpleDoubleProperty(event.getY());
                    IPrincipal.Anchor start = new IPrincipal.Anchor(Color.PALEGREEN, startX, startY);
                    IPrincipal.Anchor end = new IPrincipal.Anchor(Color.TOMATO, endX, endY);
                    papel.getChildren().add(start);
                    papel.getChildren().add(end);
                    Line line = new IPrincipal.BoundLine(startX, startY, endX, endY, toAdd);
                    System.out.println(event.getDragboard());
                    papel.getChildren().add(line);
                    event.consume();
                    System.out.println("SetOnDragExited-Salida");
                }
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
            setStroke(Color.BLUE.deriveColor(0, 1, 1, 0.5));
            setStrokeLineCap(StrokeLineCap.BUTT);
            //getStrokeDashArray().setAll(10.0, 5.0);
            setMouseTransparent(true);

        }


    }

    // a draggable anchor displayed around a point.
    class Anchor extends Circle {
        Anchor(Color color, DoubleProperty x, DoubleProperty y) {
            super(x.get(), y.get(), 5);
            setFill(color.deriveColor(1, 1, 1, 1));
            setStroke(color);
            setStrokeWidth(1);
            setStrokeType(StrokeType.OUTSIDE);
            x.bind(centerXProperty());
            y.bind(centerYProperty());
           if(color == color.PALEGREEN) {
           }else{
               enableDrag();

           }
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


