package application;
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
    static Label label1 = new Label();
    static  Label label2 = new Label();
    static Label lab = new Label();
    static int X = 0;

    @FXML
    VBox paleta;

    @FXML
    StackPane interfaz;

    public IPrincipal() {


    }

    public void agregarImagen() {
        label1.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label1);
        label2.setGraphic(new ImageView(labeImage));
        paleta.getChildren().add(label2);
        InitUi();
    }



    public void InitUi() {
        label2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("se ha clickeado la compuerta");
                FabCompuertas fabricar = new FabCompuertas();
                Compuerta and = fabricar.getConexion("And");
                and.icono();

            }
        });
        label2.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("se ha seleccionado la compuerta");
                Dragboard db = label2.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(label2.getStyle());
                db.setContent(content);

                event.consume();

            }
        });
        interfaz.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("compuerta arrastrándose");
                Dragboard db = event.getDragboard();

                if (event.getGestureSource() != interfaz &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.ANY);
                    label2.setGraphic(new ImageView(labeImage));
                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                }

                System.out.println("aquí imagen");
                event.consume();
            }
        });
        interfaz.setOnDragExited(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getTarget() instanceof StackPane) {
                    StackPane target = (StackPane) event.getTarget();
                    Label source = (Label) event.getGestureSource();
                    Label toAdd = new Label(source.getText(), source.getGraphic());
                    System.out.println("no sé que hace");
                    //la cambié por interfaz, antes era target
                    interfaz.getChildren().add(toAdd);
                    toAdd.setGraphic(new ImageView(labeImage));
                    System.out.println(event.getSceneX());
                    System.out.println(event.getSceneY());
                }
                event.consume();
            }
        });

        label2.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
                System.out.println("compuerta en posición");
                event.consume();

            }
        });
    }
}

/*
final int numNodes = 6;

    private double x = 0;
    private double y = 0;
    // mouse position
    private double mousex = 0;
    private double mousey = 0;
    private boolean dragging = false;
    private boolean moveToFront = true;
    //final int numNodes   =  6; // number of nodes to add
    final double spacing = 30;

        for(int i = 0; i < numNodes; i++) {
            DraggableNode node = new DraggableNode();
            node.setPrefSize(98, 80);
            // define the style via css
            node.setStyle(
                    "-fx-background-color: #334488; "
                            + "-fx-text-fill: black; "
                            + "-fx-border-color: black;") ;

        // add the node to the root pane

        //label1.setGraphic(new ImageView(labeImage));
        //paleta.getChildren().add(label1);
        //label2.setGraphic(new ImageView(labeImage));
            paleta.getChildren().add(node);
        //dragable label
}
    }

    class DraggableNode extends AnchorPane{
        // node position
        private double x = 0;
        private double y = 0;
        // mouse position
        private double mousex = 0;
        private double mousey = 0;
        private Node view;
        private boolean dragging = false;
        private boolean moveToFront = true;

        public DraggableNode() {
            init();
        }

        public DraggableNode(Node view) {
            this.view = view;

            getChildren().add(view);
            init();
        }

        private void init() {

            onMousePressedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    // record the current mouse X and Y position on Node
                    mousex = event.getSceneX();
                    mousey = event.getSceneY();

                    x = getLayoutX();
                    y = getLayoutY();

                    if (isMoveToFront()) {
                        toFront();

                    }
                    System.out.println("Nodo Presionado");
                }
            });

            //Event Listener for MouseDragged
            onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    //Node source = (Node) event.getGestureSource();
                    //toAdd.setGraphic(view);

                    // Get the exact moved X and Y

                    double offsetX = event.getSceneX() - mousex;
                    double offsetY = event.getSceneY() - mousey;

                    x += offsetX;
                    y += offsetY;

                    double scaledX = x;
                    double scaledY = y;

                    setLayoutX(scaledX);
                    setLayoutY(scaledY);

                    dragging = true;

                    // again set current Mouse x AND y position
                    mousex = event.getSceneX();
                    mousey = event.getSceneY();
                    System.out.println("Nodo arrastrandose");

                    event.consume();
                }
            });

            onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    dragging = false;
                    System.out.println("Nodo en posición");
                }
            });

        }


        protected boolean isDragging() {
            return dragging;
        }




        public Node getView() {
        return view;
        }



        public void setMoveToFront(boolean moveToFront) {
            this.moveToFront = moveToFront;
        }


        public boolean isMoveToFront() {
            return moveToFront;
        }

        public void removeNode(Node n) {
            getChildren().remove(n);

        }
    }
    */
