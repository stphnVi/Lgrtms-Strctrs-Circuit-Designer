package application;

import Compuertas.Cero;
import InterFac.Compuerta;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    Lista lista1 = new Lista();
    private int n = 0;
    /***
     * @see
     * alerta (excepción cuando se presiona el boton y el circuito aun no está terminado)
     */
    Alert alerta = new Alert(Alert.AlertType.ERROR);


    @FXML
    VBox paleta;

    @FXML
    AnchorPane papel;

    @FXML
    StackPane interfaz;
    @FXML
    Button Boperar;

    public IPrincipal() {

    }


    /***
     * Método que agrega la imagen a el label y lo coloca en la paleta
     */


    public void Inicio() {
        alerta.setTitle("Se ha dado un error");
        alerta.setContentText("Por favor, realize el circuito primero");

        /***
         * inicio de la fabrica
         */

        Boperar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boton();
            }
        });


        FabCompuertas fabrica = new FabCompuertas();
        Compuerta uno = fabrica.getConexion("Uno");
        paleta.getChildren().add(uno);
        Compuerta cero = fabrica.getConexion("Cero");
        paleta.getChildren().add(cero);
        Compuerta not = fabrica.getConexion("Not");
        paleta.getChildren().add(not);
        Compuerta and = fabrica.getConexion("And");
        paleta.getChildren().add(and);
        Compuerta nand = fabrica.getConexion("Nand");
        paleta.getChildren().add(nand);
        Compuerta or = fabrica.getConexion("Or");
        paleta.getChildren().add(or);
        Compuerta nor = fabrica.getConexion("Nor");
        paleta.getChildren().add(nor);
        Compuerta xor = fabrica.getConexion("Xor");
        paleta.getChildren().add(xor);
        Compuerta xnor = fabrica.getConexion("Xnor");
        paleta.getChildren().add(xnor);
        Compuerta usuario = fabrica.getConexion("Usuario");
        paleta.getChildren().add(usuario);


        paleta.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getTarget() == and) {
                    label = and;
                    labeImage = and.getImage();
                    Id = null;
                    InicioInterfaz();

                } else if (event.getTarget() == or) {
                    label = or;
                    labeImage = or.getImage();
                    Id = null;
                    InicioInterfaz();
                } else if (event.getTarget() == nor) {
                    label = nor;
                    labeImage = nor.getImage();
                    Id = null;
                    InicioInterfaz();
                } else if (event.getTarget() == xor) {
                    label = xor;
                    labeImage = xor.getImage();
                    Id = null;
                    InicioInterfaz();
                } else if (event.getTarget() == xnor) {
                    label = xnor;
                    labeImage = xnor.getImage();
                    Id = null;
                    InicioInterfaz();
                } else if (event.getTarget() == uno) {
                    label = uno;
                    labeImage = uno.getImage();
                    label.setId("Uno");
                    Id = "Uno";
                    InicioInterfaz();
                } else if (event.getTarget() == cero) {
                    label = cero;
                    labeImage = cero.getImage();
                    label.setId("Cero");
                    Id = "Cero";
                    // System.out.println("cero clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == not) {
                    label = not;
                    labeImage = not.getImage();
                    Id = "Not";
                    //System.out.println("not clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == usuario) {
                    label = usuario;
                    labeImage = usuario.getImage();
                    Id = null;
                    //System.out.println("usuario clickeada");
                    InicioInterfaz();
                } else if (event.getTarget() == nand) {
                    label = nand;
                    labeImage = nand.getImage();
                    Id = null;
                    //System.out.println("nand clickeada");
                    InicioInterfaz();
                } else {
                    Id = null;

                }
            }
        });
    }


    private void InicioInterfaz() {

        papel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println(event.getPickResult().getIntersectedNode());
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
                // System.out.println("se ha seleccionado la compuerta");
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
                //System.out.println("SetOnDragExited-Entrada");
                // System.out.println(event.getPickResult().getIntersectedNode());
                /***
                 *
                 * replicas de las compuertas
                 */
                FabCompuertas fabrica = new FabCompuertas();
                Compuerta toAdd = fabrica.getConexion(label.getId());


                if (event.getPickResult().getIntersectedNode() instanceof StackPane) {
                    //System.out.println(event.getPickResult().getIntersectedNode());
                    toAdd.setTranslateX(event.getSceneX());
                    toAdd.setTranslateY(event.getSceneY());
                    toAdd.setId(label.getId());
                    papel.getChildren().add(toAdd);

                    if (Id == "Cero") {
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY() + 25);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY() + 25);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY, toAdd);
                        IPrincipal.Anchor PUend = new IPrincipal.Anchor(Color.AQUAMARINE, PUendX, PUendY, toAdd);
                        papel.getChildren().add(PUstart);
                        papel.getChildren().add(PUend);

                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd, PUstart, PUend);
                        papel.getChildren().add(PUline);

                        Line PFline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd, PUstart, PUend);
                        papel.getChildren().add(PFline);

                        event.consume();

                    } else if (Id == "Uno") {
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY() + 25);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY() + 25);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY, toAdd);
                        IPrincipal.Anchor PUend = new IPrincipal.Anchor(Color.AQUAMARINE, PUendX, PUendY, toAdd);
                        papel.getChildren().add(PUstart);
                        papel.getChildren().add(PUend);

                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd, PUstart, PUend);
                        papel.getChildren().add(PUline);

                        Line PFline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd, PUstart, PUend);
                        papel.getChildren().add(PFline);

                        event.consume();

                    } else if (Id == "Not") {
                        //---------------------------------------------------------------------------
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY() + 37);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY() + 37);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY, toAdd);
                        PUstart.setId("In1");

                        papel.getChildren().add(PUstart);
                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd, PUstart, null);
                        papel.getChildren().add(PUline);
                        //--------------------------------------------------------------------------
                        DoubleProperty PDstartX = new SimpleDoubleProperty(event.getX() + 145);
                        DoubleProperty PDstartY = new SimpleDoubleProperty(event.getY() + 37);
                        DoubleProperty PDendX = new SimpleDoubleProperty(event.getX() + 145);
                        DoubleProperty PDendY = new SimpleDoubleProperty(event.getY() + 37);
                        IPrincipal.Anchor PDstart = new IPrincipal.Anchor(Color.BLUEVIOLET, PDstartX, PDstartY, toAdd);
                        IPrincipal.Anchor PDend = new IPrincipal.Anchor(Color.AQUAMARINE, PDendX, PDendY, toAdd);
                        PDstart.setId("Sal");
                        papel.getChildren().add(PDstart);
                        papel.getChildren().add(PDend);
                        Line PDline = new IPrincipal.BoundLine(PDstartX, PDstartY, PDendX, PDendY, toAdd, PUstart, null);
                        papel.getChildren().add(PDline);


                    } else {
                        //---------------------------------------------------------------------------
                        DoubleProperty PUstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUstartY = new SimpleDoubleProperty(event.getY() + 25);
                        DoubleProperty PUendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PUendY = new SimpleDoubleProperty(event.getY() + 25);
                        IPrincipal.Anchor PUstart = new IPrincipal.Anchor(Color.BLACK, PUstartX, PUstartY, toAdd);
                        PUstart.setId("EntradaS");
                        papel.getChildren().add(PUstart);

                        Line PUline = new IPrincipal.BoundLine(PUstartX, PUstartY, PUendX, PUendY, toAdd, PUstart, null);
                        PUline.setId("Pat1");
                        papel.getChildren().add(PUline);
                        //--------------------------------------------------------------------------
                        DoubleProperty PDstartX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PDstartY = new SimpleDoubleProperty(event.getY() + 50);
                        DoubleProperty PDendX = new SimpleDoubleProperty(event.getX() + 10);
                        DoubleProperty PDendY = new SimpleDoubleProperty(event.getY() + 50);
                        IPrincipal.Anchor PDstart = new IPrincipal.Anchor(Color.BLACK, PDstartX, PDstartY, toAdd);
                        PDstart.setId("pat1");

                        papel.getChildren().add(PDstart);
                        //papel.getChildren().add(PDend);

                        Line PDline = new IPrincipal.BoundLine(PDstartX, PDstartY, PDendX, PDendY, toAdd, PUstart, null);
                        PDline.setId("Pat2");
                        papel.getChildren().add(PDline);
                        //-------------------------------------------------------------------------
                        DoubleProperty PFstartX = new SimpleDoubleProperty(event.getX() + 145);
                        DoubleProperty PFstartY = new SimpleDoubleProperty(event.getY() + 37);
                        DoubleProperty PFendX = new SimpleDoubleProperty(event.getX() + 145);
                        DoubleProperty PFendY = new SimpleDoubleProperty(event.getY() + 37);
                        IPrincipal.Anchor PFstart = new IPrincipal.Anchor(Color.BLUEVIOLET, PFstartX, PFstartY, toAdd);
                        IPrincipal.Anchor PFend = new IPrincipal.Anchor(Color.AQUAMARINE, PFendX, PFendY, toAdd);

                        PFend.setId("salidaR");
                        PFstart.setId("salidaS");
                        papel.getChildren().add(PFstart);
                        papel.getChildren().add(PFend);

                        Line PFline = new IPrincipal.BoundLine(PFstartX, PFstartY, PFendX, PFendY, toAdd, PUstart, null);
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
                //System.out.println(label.getId());
            }
        });


    }

    /***
     *
     *
     * @param clase que crea la linea
     *
     */

    class BoundLine extends Line {
        Random r = new Random();
        Random g = new Random();
        Random b = new Random();

        BoundLine(DoubleProperty startX, DoubleProperty startY, DoubleProperty endX, DoubleProperty endY, Label toAdd, Anchor cirS, Anchor cirE) {
            startXProperty().bind(startX);
            startYProperty().bind(startY);
            endXProperty().bind(endX);
            endYProperty().bind(endY);
            setStrokeWidth(2);
            int R = r.nextInt(255) + 1;
            int G = g.nextInt(255) + 1;
            int B = b.nextInt(255) + 1;
            setStroke(Color.rgb(R, G, B));
            setStrokeLineCap(StrokeLineCap.BUTT);
            setMouseTransparent(true);

        }
    }

    /***
     *
     *
     * @param clase que crea el circulo
     *
     */
    class Anchor extends Circle {

        Compuerta micompuerta;

        Anchor(Color color, DoubleProperty x, DoubleProperty y, Compuerta micompuerta) {
            super(x.get(), y.get(), 10);
            setFill(color.deriveColor(1, 1, 1, 1));
            setStroke(color);
            setStrokeWidth(1);
            setStrokeType(StrokeType.OUTSIDE);
            x.bind(centerXProperty());
            y.bind(centerYProperty());
            this.micompuerta = micompuerta;

            if (color == color.BLACK) {

            } else {
                enableDrag(micompuerta);

            }
        }


        // make a node movable by dragging it around with the mouse.
        private void enableDrag(Label toAdd) {
            final IPrincipal.Anchor.Delta dragDelta = new IPrincipal.Anchor.Delta();
            setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    String Ini = label.getId();
                    // record a delta distance for the drag and drop operation.
                    dragDelta.x = getCenterX() - mouseEvent.getX();
                    dragDelta.y = getCenterY() - mouseEvent.getY();
                    getScene().setCursor(Cursor.MOVE);
                }
            });


            setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    double newX = mouseEvent.getX() + dragDelta.x;


                    if (mouseEvent.getPickResult().getIntersectedNode() instanceof Circle) {
                        mouseEvent.getPickResult().getIntersectedNode().setMouseTransparent(true);
                        //System.out.println("noddrrrr");

                    } else {
                        if (newX > 0 && newX < getScene().getWidth()) {
                            setCenterX(newX);
                            //System.out.println(mouseEvent.getPickResult().getIntersectedNode() + "Dragged");
                            //mouseEvent.getPickResult().getIntersectedNode().setMouseTransparent(false);
                        }
                        double newY = mouseEvent.getY() + dragDelta.y;
                        if (newY > 0 && newY < getScene().getHeight()) {
                            setCenterY(newY);
                            //System.out.println(mouseEvent.getPickResult().getIntersectedNode() + "Dragged");
                            //mouseEvent.getPickResult().getIntersectedNode().setMouseTransparent(false);
                        }
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
            setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    n++;
                    System.out.println(n);
                    if (toAdd.getId() == "Uno") {
                        lista1.agregarDelante(1);
                    } else if (toAdd.getId() == "Cero") {
                        lista1.agregarDelante(0);
                    }
                    if(mouseEvent.getPickResult().getIntersectedNode().getId() =="Not"){
                        if(lista1.ver(0).equals(0)) {
                            lista1.eliminar(0);
                            lista1.agregarDelante(1);
                            System.out.println("NOOOT/000");
                            n--;
                        }else{
                            lista1.eliminar(0);
                            lista1.agregarDelante(1);
                            System.out.println("NOOOT/111");
                            n--;
                        }

                    }

                    if (n % 2 == 0) {
                        if(mouseEvent.getPickResult().getIntersectedNode().getId() == "Not"){
                            System.out.println("No se intriduce");
                        }else {
                            FabCompuertas op = new FabCompuertas();
                            Compuerta operar = op.getConexion(mouseEvent.getPickResult().getIntersectedNode().getId());
                            lista1.agregarDelante(mouseEvent.getPickResult().getIntersectedNode().getId());
                            lista1.getTamaño();
                            operar.Operar(lista1, n);
                        }
                    }
                    mouseEvent.getPickResult().getIntersectedNode().setMouseTransparent(false);
                    getScene().setCursor(Cursor.HAND);

                }
            });

        }

        private class Delta {
            double x, y;
        }
    }

    private void boton() {
        try {

            for (int d = 0; d <= lista1.getTamaño()-1; d++) {
                System.out.println("se extrae" + lista1.ver(d));

            }
            System.out.println("valor de n:  " + n + "  " + (n - 2));


        } catch (Exception e) {
            alerta.show();
        }
    }

    public Lista getLista1() {
        return lista1;
    }
}

