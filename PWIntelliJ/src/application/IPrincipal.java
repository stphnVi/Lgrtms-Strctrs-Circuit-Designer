package application;
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

import java.util.Random;


public class IPrincipal extends AnchorPane {
    /***
     * @param
     * labeImage encargada de ofrecer la nueva imagen a la
     * nueva compuerta que se cree
     * label será mi label base segun el usuario seleccione las compuertas
     *
     */
    public Image labeImage = new Image(getClass().getResourceAsStream("./And.png"), 80, 120, true, true);
    private Label label = new Label();
    private String Id = null;


    @FXML
    VBox paleta;

    @FXML
    AnchorPane papel;

    @FXML
    StackPane interfaz;

    public IPrincipal() {

    }


    /***
     * Método que agrega la imagen a el label y lo coloca en la paleta
     */

    public void Inicio() {
        /***
         * inicio de la fabrica
         */
        FabCompuertas fabrica = new FabCompuertas();
        Compuerta uno = fabrica.getConexion("Uno");
        paleta.getChildren().add(uno.getLabel());
        Compuerta cero = fabrica.getConexion("Cero");
        paleta.getChildren().add(cero.getLabel());
        Compuerta not = fabrica.getConexion("Not");
        paleta.getChildren().add(not.getLabel());
        Compuerta and = fabrica.getConexion("And");
        paleta.getChildren().add(and.getLabel());
        Compuerta nand = fabrica.getConexion("Nand");
        paleta.getChildren().add(nand.getLabel());
        Compuerta or = fabrica.getConexion("Or");
        paleta.getChildren().add(or.getLabel());
        Compuerta nor = fabrica.getConexion("Nor");
        paleta.getChildren().add(nor.getLabel());
        Compuerta xor = fabrica.getConexion("Xor");
        paleta.getChildren().add(xor.getLabel());
        Compuerta xnor = fabrica.getConexion("Xnor");
        paleta.getChildren().add(xnor.getLabel());
        Compuerta usuario = fabrica.getConexion("Usuario");
        paleta.getChildren().add(usuario.getLabel());



        paleta.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getTarget() == and.getLabel()) {
                    label = and.getLabel();
                    labeImage = and.getImage();
                    System.out.println("And clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == or.getLabel()) {
                    label = or.getLabel();
                    labeImage = or.getImage();
                    System.out.println("Or clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == nor.getLabel()) {
                    label = nor.getLabel();
                    labeImage = nor.getImage();
                    System.out.println("nor clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == xor.getLabel()) {
                    label = xor.getLabel();
                    labeImage = xor.getImage();
                    System.out.println("Xor clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == xnor.getLabel()) {
                    label = xnor.getLabel();
                    labeImage = xnor.getImage();
                    System.out.println("xnor clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == uno.getLabel()) {
                    label = uno.getLabel();
                    labeImage = uno.getImage();
                    System.out.println(" uno clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == cero.getLabel()) {
                    label = cero.getLabel();
                    labeImage = cero.getImage();
                    System.out.println("cero clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == not.getLabel()) {
                    label = not.getLabel();
                    labeImage = not.getImage();
                    System.out.println("not clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == usuario.getLabel()) {
                    label = usuario.getLabel();
                    labeImage = usuario.getImage();
                    System.out.println("usuario clickeada");
                    InicioInterfaz();
                }else if (event.getTarget() == nand.getLabel()) {
                    label = nand.getLabel();
                    labeImage = nand.getImage();
                    System.out.println("nand clickeada");
                    InicioInterfaz();


                } else {
                    System.out.println("se ha clickeado la paleta");
                }
            }
        });
    }


    private void InicioInterfaz() {

        papel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getPickResult().getIntersectedNode());
                System.out.println(event.getSource());
                System.out.println(label.getId());
            }
        });
        /***
         * método que se encarga de pedirle a la fabrida las compuertas
         * @param interfaz AnchorPane donde se hará el diagrama.
         * @param Label Label en cual tiene una imagen la cual simula una compuerta.
         *
         */

        label.setOnDragDetected(new EventHandler<MouseEvent>() {
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
        interfaz.setOnDragOver(new EventHandler<DragEvent>() {
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
            }
        });
        interfaz.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            /***
             * @see
             * DragEvent es el que debe reubicar el label según las coordenadas
             * del cursor en X y Y
             */
            public void handle(DragEvent event) {
                System.out.println("SetOnDragExited-Entrada");
                /***
                 *
                 * replicas de las compuertas
                 */
                if (event.getPickResult().getIntersectedNode() instanceof StackPane) {
                    //Label source = (Label) event.getGestureSource();
                    Label toAdd = new Label();
                    toAdd.setGraphic(new ImageView(labeImage));
                    toAdd.setTranslateX(event.getSceneX());
                    toAdd.setTranslateY(event.getSceneY());
                    papel.getChildren().add(toAdd);
                    /***
                     *
                     * creación de la linea
                     */
                    if(Id =="Cero"){
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX()+10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY()+25);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX()+10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY()+25);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY);
                        IPrincipal.Anchor PUend = new IPrincipal.Anchor(Color.AQUAMARINE, PUendX, PUendY);
                        papel.getChildren().add(PUstart);
                        papel.getChildren().add(PUend);

                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd);
                        papel.getChildren().add(PUline);

                        Line PFline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd);
                        papel.getChildren().add(PFline);

                        event.consume();

                    }else if(Id == "Uno"){
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX()+10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY()+25);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX()+10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY()+25);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY);
                        IPrincipal.Anchor PUend = new IPrincipal.Anchor(Color.AQUAMARINE, PUendX, PUendY);
                        papel.getChildren().add(PUstart);
                        papel.getChildren().add(PUend);

                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd);
                        papel.getChildren().add(PUline);

                        Line PFline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd);
                        papel.getChildren().add(PFline);

                        event.consume();

                    }else{
                        //---------------------------------------------------------------------------
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY() + 25);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY() + 25);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY);
                        IPrincipal.Anchor PUend = new IPrincipal.Anchor(Color.AQUAMARINE, PUendX, PUendY);
                        PUend.setId("EntradaR");
                        PUstart.setId("EntradaS");
                        papel.getChildren().add(PUstart);
                        papel.getChildren().add(PUend);

                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd);
                        PUline.setId("Pat1");
                        papel.getChildren().add(PUline);
                        //--------------------------------------------------------------------------
                        DoubleProperty PDstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PDstartY = new SimpleDoubleProperty(event.getY() + 50);
                        DoubleProperty PDendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PDendY = new SimpleDoubleProperty(event.getY() + 50);
                        IPrincipal.Anchor PDstart = new IPrincipal.Anchor(Color.BLACK, PDstartX, PDstartY);
                        IPrincipal.Anchor PDend = new IPrincipal.Anchor(Color.AQUAMARINE, PDendX, PDendY);
                        PDend.setId("EntradaR");
                        PDstart.setId("EntradaS");

                        papel.getChildren().add(PDstart);
                        papel.getChildren().add(PDend);

                        Line PDline = new IPrincipal.BoundLine(PDstartX, PDstartY, PDendX, PDendY, toAdd);
                        PDline.setId("Pat2");
                        papel.getChildren().add(PDline);
                        //-------------------------------------------------------------------------
                        DoubleProperty PFstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PFstartY = new SimpleDoubleProperty(event.getY() + 75);
                        DoubleProperty PFendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PFendY = new SimpleDoubleProperty(event.getY() + 75);
                        IPrincipal.Anchor PFstart = new IPrincipal.Anchor(Color.BLUEVIOLET, PFstartX, PFstartY);
                        IPrincipal.Anchor PFend = new IPrincipal.Anchor(Color.AQUAMARINE, PFendX, PFendY);

                        PFend.setId("salidaR");
                        PFstart.setId("salidaS");
                        papel.getChildren().add(PFstart);
                        papel.getChildren().add(PFend);

                        Line PFline = new IPrincipal.BoundLine(PFstartX, PFstartY, PFendX, PFendY, toAdd);
                        PDline.setId("Sal");
                        papel.getChildren().add(PFline);


                        event.consume();
                    }
                }
            }
        });

        label.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.consume();
                System.out.println(label.getId());
            }
        });
    }


    class BoundLine extends Line {
        Random r = new Random();
        Random g = new Random();
        Random b = new Random();
            BoundLine(DoubleProperty startX, DoubleProperty startY, DoubleProperty endX, DoubleProperty endY, Label toAdd) {
                startXProperty().bind(startX);
                startYProperty().bind(startY);
                endXProperty().bind(endX);
                endYProperty().bind(endY);
                setStrokeWidth(2);
                int R = r.nextInt(255)+1;
                int G = g.nextInt(255)+1;
                int B = b.nextInt(255)+1;
                setStroke(Color.rgb(R,G,B));

                //setStroke(Color.rgb(50,45,75));
                setStrokeLineCap(StrokeLineCap.BUTT);
                setMouseTransparent(true);

            }


        }

        // a draggable anchor displayed around a point.
        class Anchor extends Circle {
            Anchor(Color color, DoubleProperty x, DoubleProperty y) {
                super(x.get(), y.get(), 10);
                setFill(color.deriveColor(1, 1, 1, 1));
                setStroke(color);
                setStrokeWidth(1);
                setStrokeType(StrokeType.OUTSIDE);
                x.bind(centerXProperty());
                y.bind(centerYProperty());

                if (color == color.BLACK) {
                    System.out.println(label.getId());


                } else {
                    System.out.println(label.getId());
                    enableDrag();

                }
            }

            // make a node movable by dragging it around with the mouse.
            private void enableDrag() {
                final IPrincipal.Anchor.Delta dragDelta = new IPrincipal.Anchor.Delta();
                setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // record a delta distance for the drag and drop operation.
                        dragDelta.x = getCenterX() - mouseEvent.getX();
                        dragDelta.y = getCenterY() - mouseEvent.getY();
                        getScene().setCursor(Cursor.MOVE);
                    }
                });
                setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        getScene().setCursor(Cursor.HAND);
                    }
                });
                setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
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
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (!mouseEvent.isPrimaryButtonDown()) {
                            getScene().setCursor(Cursor.HAND);
                        }
                    }
                });
                setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        if (!mouseEvent.isPrimaryButtonDown()) {
                            getScene().setCursor(Cursor.DEFAULT);

                        }
                    }
                });

            }
            private class Delta {
                double x, y;
            }
        }

    }


