/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapsuna.model;

import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author engel
 */
public class GraphicManager {

    private int contClick;
    private int rclick;
    private int clickCounterDelay;
    private int superMatrix[][];
    private boolean online;
    private ArrayList<Line> lineas;
    private ArrayList<Line> lineaInicio;
    private ArrayList<Line> auxLinea;
    private ArrayList<Line> lineaAuxiliar;
    private ArrayList<Double> logicLines;
    private ArrayList<Point> offRoads;
    private Point target;
    private Point verticeOrigen;
    private Polyline Linea;
    private Line lineaSeleccion;
    private PathTransition movimiento;
    private StackPane stack;
    private Circle backCircle;
    private Circle backCircle2;
    private Text textoAuxiliar;
    private Thread thread;
    private boolean actualizar;
    private boolean activar;
    private boolean trigger;
    private Animacion animacion;
    private int clicks;
    private Dijkstra dijkstra = new Dijkstra();
    private Floyd floyd = new Floyd();
    private Grafo grafo = new Grafo();
    private boolean leftFlag;
    private boolean rightFlag;
    private int trafico;

    private Circle circle;
    private AnchorPane pane;
    private AnchorPane paneMapa;
    private RadioButton rdbDijkstra;
    private RadioButton rdbFloyd;
    private Label lbltotalPrevio;
    private Label coLabel1;
    private Label time;
    private ToggleButton leftway;
    private ToggleButton rightway;
    private boolean reCalcular;
    private String init;
    //

    public GraphicManager(Circle circle, RadioButton rdbDijkstra, RadioButton rdbFloyd, Label lbltotalPrevio, ToggleButton leftway,
            ToggleButton rightway, AnchorPane pane, boolean left, boolean right, int trafic, Label timeCost,
            Label labelCost) { // Variables para resivir del controlador de la ventana
        
        
        
        textoAuxiliar = new Text("5");
        textoAuxiliar.setStyle("-fx-fill: Green;-fx-font-size: 14px;-fx-font-weight: bold;");
        this.rdbDijkstra = rdbDijkstra;
        this.rdbFloyd = rdbFloyd;
        this.paneMapa = pane;
        this.leftway = leftway;
        this.rightway = rightway;
        this.circle = circle;
        this.pane = pane;
        this.lbltotalPrevio = lbltotalPrevio;
        this.time = timeCost;
        this.coLabel1 = labelCost;   
        this.trafico = trafic;
        
        activar = false;
        trigger = false;
        lineaAuxiliar = new ArrayList<>();
        rclick = 0;
        animacion = new Animacion();
        contClick = 0;
        online = false;
        verticeOrigen = new Point();
        target = new Point();
        movimiento = new PathTransition();
        Linea = new Polyline();
        lineas = new ArrayList<>();
        lineaInicio = new ArrayList<>();
        auxLinea = new ArrayList<>();
        logicLines = new ArrayList<>();
        offRoads = new ArrayList<>();
        movimiento.setNode(circle);
        movimiento.setDuration(Duration.millis(3000));

        stack = new StackPane();
        backCircle = new Circle();
        backCircle.setRadius(10);
        backCircle.setFill(javafx.scene.paint.Color.BLUEVIOLET);
        backCircle2 = new Circle();
        backCircle2.setRadius(11);
        backCircle2.setFill(javafx.scene.paint.Color.BLACK);
        actualizar = false;
        thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                    Platform.runLater(() -> {
                        if (actualizar) {
                            if (movimiento.getStatus() == Animation.Status.RUNNING) {
                            } else {
                                if (!animacion.isEmpty()) {
                                        movimiento.setPath(animacion.saca());
                                        labelCost.setText(animacion.getAcarreo()+ "");
                                        movimiento.play();
                                } else {
                                    actualizar = false;
                                    labelCost.setText(animacion.getAcarreo() + "");
                                    animacion.getLineE();
                                }
                            }
                        }
                    });
                } catch (InterruptedException ex) {
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void setRecalculate(boolean recalculate) {
        this.reCalcular = recalculate;
    }

    private void reCalcular() {
        ArrayList<String> path = new ArrayList<>();
        path = getTrajectory();
        grafo.inicializarMatAux();
        grafo.inicializarPesos();
        grafo.editarMatriz(trafico);
        offRoads.forEach(x -> {
            if (leftFlag) {
                grafo.cortarPaso(x.getXPosition(), x.getYPosition());
                grafo.cortarPasoMatPeso(x.getXPosition(), x.getYPosition());//Se trabaja con la de pesos
            }
            if (rightFlag) {
                grafo.cortarPaso(x.getYPosition(), x.getXPosition());
                grafo.cortarPasoMatPeso(x.getXPosition(), x.getYPosition());
            }
        });
        if (rdbDijkstra.isSelected()) {
            int fila = Integer.valueOf(path.get(0).replaceAll("\\D+", ""));
            int col = Integer.valueOf(path.get(1).replaceAll("\\D+", ""));
            dijkstra.setMatPeso(grafo.getMatPeso());
            dijkstra.dijkstra(fila - 1, col - 1);//Resuelve mediante Dijkstra
            Collections.reverse(dijkstra.getLista());
            path = new ArrayList<>();
            for (int i = 0; i < dijkstra.getLista().size(); i++) {
                path.add("A" + (Integer.valueOf(dijkstra.getLista().get(i)) + 1));
            }
            long micro = (dijkstra.getResultTime() / 1000);
            time.setText(String.valueOf(micro));
            lbltotalPrevio.setText(String.valueOf(dijkstra.getCostoTotal()));

        } else if (rdbFloyd.isSelected()) {
            floyd.setMatPesos(grafo.getMatPeso());
            floyd.floyd();//Resuelve mediante Floyd
            long micro = (floyd.getResultTime() / 1000);
            time.setText(String.valueOf(micro));
            lbltotalPrevio.setText(String.valueOf(floyd.obtenerCostoPrevio(path.get(0), path.get(1))));
            path = (ArrayList<String>) floyd.obtenerRuta(path.get(0), path.get(1));
        }
        toLines(path);
        launch(grafo.getMatPeso(), grafo.getMatPeso(), leftway, rightway);
        path = new ArrayList<>();
        leftway.setSelected(false);
        rightway.setSelected(false);
        repaint();
    }

    public void setUpdate() {
        actualizar = !actualizar;
    }

    public boolean getUpdate() {
        return actualizar;
    }

    public void setMouseCounter(int x) {
        clickCounterDelay = x;
    }

    public void disable() {
        actualizar = false;
    }

    public void enable() {
        actualizar = true;
    }

    public int getClickCounter() {
        return clickCounterDelay;
    }

    public String getOrigin() {
        return verticeOrigen.getId();
    }

    public String getTarget() {
        return target.getId();
    }

    public void launch(int[][] m, int[][] peso, ToggleButton toggle,
            ToggleButton toggle1) {
        launcher(verticeOrigen.getXPosition(), verticeOrigen.getYPosition(),
                target.getXPosition(), target.getYPosition(), pane, circle, m, peso, toggle, toggle1);
    }

    public void mouseEvent(Node x, AnchorPane pane, int n) {
        boolean lock = false;

        if (contClick == 0) {
            animacion.Restablecer();
            lock = true;
            verticeOrigen.update(x);
            init = x.getId();
            trigger = false;
            lineaAuxiliar.forEach(q -> {
                pane.getChildren().remove(q);
            });
        }

        if (contClick == 1) {
            target.update(x);
            contClick = 0;
            trigger = true;
        }
        if (lock) {
            contClick++;
        }
    }

    public boolean getTrigger() {
        return trigger;
    }

    public int getR() {
        return rclick;
    }

    private void Limpiar(AnchorPane pane) {
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                if (radio.getId().equals(verticeOrigen.getId()) || radio.getId().equals(target.getId())) {
                    (radio).setSelected(false);
                }
            }
        });
    }

    private void launcher(int x1, int y1, int x2, int y2, AnchorPane pane, Circle circle, int[][] m, int[][] peso,
            ToggleButton toggle, ToggleButton toggle1) {

        auxLinea.forEach(x -> {
            pane.getChildren().remove(x);
        });

        lineas.forEach(x -> {
            x.setSmooth(true);
            x.setStrokeWidth(4);

            x.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> {
                x.getScene().setCursor(Cursor.HAND);
            });

            x.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                searchConectedRadios(x, pane, toggle, toggle1);
                online = true;
                clearSelection();
                x.setStyle("-fx-stroke: rgba(0,255, 255,0.3);");
            });

            x.addEventFilter(MouseEvent.MOUSE_EXITED, event -> {
                x.getScene().setCursor(Cursor.DEFAULT);
                stack.getChildren().remove(textoAuxiliar);
                stack.getChildren().remove(backCircle2);
                pane.getChildren().remove(stack);
            });

            x.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> {

                int yyPos = MouseInfo.getPointerInfo().getLocation().y;
                int xxPos = MouseInfo.getPointerInfo().getLocation().y;

                textoAuxiliar.setText(String.valueOf(weightHover(x, peso)));

                double xPos = 0;
                double yPos = 0;

                if (x.getStartX() > x.getEndX()) {
                    xPos = (Math.abs(x.getStartX() - x.getEndX())) / 2.0;
                    stack.setLayoutX(xPos + x.getEndX() - 10);
                } else {
                    xPos = (Math.abs(x.getEndX() - x.getStartX())) / 2.0;
                    stack.setLayoutX(xPos + x.getStartX() - 10);

                }

                if (x.getStartY() > x.getEndY()) {
                    yPos = (Math.abs(x.getStartY() - x.getEndY())) / 2.0;
                    stack.setLayoutY(yPos + x.getEndY() - 30);
                } else {
                    yPos = (Math.abs(x.getEndY() - x.getStartY())) / 2.0;
                    stack.setLayoutY(yPos + x.getStartY() - 30);
                }

                stack.getChildren().addAll(backCircle2, textoAuxiliar);
                pane.getChildren().add(stack);

            });

            pane.getChildren().add(x);
        });

        auxLinea = new ArrayList<>();
        lineas.forEach(x -> auxLinea.add(x));

        animacion.set(logicLines, pane,lineas, lineaInicio,  m, init);

        Linea = new Polyline();
        lineas = new ArrayList<>();
        logicLines = new ArrayList<>();
    }

    public ArrayList<String> getTrajectory() {
        ArrayList<String> trajectory = new ArrayList<>();
        trajectory.add(verticeOrigen.getId());
        trajectory.add(target.getId());
        return trajectory;
    }

    public void toLines(ArrayList<String> logicPath) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> graphicPath = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radio.setSelected(false);
                radios.add(radio);
            }
        });

        logicPath.forEach(x -> {
            radios.forEach(y -> {
                if (y.getId().equals(x)) {
                    RadioButton radio = (RadioButton) y;
                    graphicPath.add(y);
                }
            });
        });

        for (int i = 0; i < graphicPath.size(); i++) {
            if (i + 1 < graphicPath.size()) {
                verticeOrigen = new Point();
                target = new Point();

                verticeOrigen.update((Node) graphicPath.get(i));
                target.update((Node) graphicPath.get(i + 1));

                logicLines.add(verticeOrigen.getXPosition() + 0.0);
                logicLines.add(verticeOrigen.getYPosition() + 0.0);
                logicLines.add(target.getXPosition() + 0.0);
                logicLines.add(target.getYPosition() + 0.0);

                lineas.add(new Line(verticeOrigen.getXPosition(), verticeOrigen.getYPosition(),
                        target.getXPosition(), target.getYPosition()));
                lineas.forEach(l -> {
                    l.setStyle("-fx-stroke: rgba(0,0, 255,0.3);");
                });
            }
        }

    }

    public void start(AnchorPane pane, int[][] m, ToggleButton toggle, ToggleButton toggle1) {
        boolean start = true;
        superMatrix = m;
        Line selectedLine = new Line();
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> graphicPath = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });

        radios.forEach(y -> {

            RadioButton radio = (RadioButton) y;
            graphicPath.add(y);

        });

        verticeOrigen = new Point();
        target = new Point();
        boolean update = false;
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                if (m[i][j] == 1) {
                    update = false;
                    for (RadioButton r : radios) {
                        if (r.getId().equals("A" + (i + 1))) {
                            verticeOrigen.update((Node) r);
                            update = true;
                        }
                        if (r.getId().equals("A" + (j + 1))) {
                            target.update((Node) r);
                            update = true;
                        }
                    }

                    if (update) {
                        Line tmp = new Line(verticeOrigen.getXPosition(), verticeOrigen.getYPosition(),
                                target.getXPosition(), target.getYPosition());

                        tmp.setStrokeWidth(5);

                        tmp.addEventFilter(MouseEvent.MOUSE_EXITED, event -> {
                            tmp.getScene().setCursor(Cursor.DEFAULT);
                        });

                        tmp.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> {
                            tmp.getScene().setCursor(Cursor.HAND);
                        });

                        tmp.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                            searchConectedRadios(tmp, pane, toggle, toggle1);
                            online = true;
                            clearSelection();
                            tmp.setStyle("-fx-stroke: rgba(170, 57, 57,0.5);");
                        });
                        tmp.toFront();

                        lineaInicio.add(tmp);
                    }
                }
            }
        }
        lineaInicio.forEach(x -> x.setStyle("-fx-stroke: rgba(170, 57, 57,0.1);"));
        lineaInicio.forEach(x -> pane.getChildren().add(x));
        radios.forEach(x -> pane.getChildren().remove(x));
        radios.forEach(x -> pane.getChildren().add(x));
        verticeOrigen = new Point();
        target = new Point();
    }

    public void calcular() {
        reCalcular();
    }

    private void clearSelection() {
        lineaInicio.forEach(x -> x.setStyle("-fx-stroke: rgba(170, 57, 57,0.1);"));
        lineas.forEach(x -> x.setStyle("-fx-stroke: rgba(170, 57, 57,0.5);"));
        auxLinea.forEach(x -> x.setStyle("-fx-stroke: rgba(0,0, 255,0.3);"));
    }

    private int weightHover(Line line, int[][] weightMatrix) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();

        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });

        radios.forEach(x -> {
            if ((x.getLayoutX() == line.getStartX() - 7 || x.getLayoutX() == line.getEndX() - 7)
                    && (x.getLayoutY() == line.getStartY() - 9 || x.getLayoutY() == line.getEndY() - 9)) {

                conected.add(x);
            }
        });
        int peso1 = 0;
        int peso2 = 0;
        int visible = 0;
        int localOrigin = Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", "")) - 1;
        int localTarget = Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", "")) - 1;
        if (superMatrix[localOrigin][localTarget] == 1) {
            peso1 = weightMatrix[localOrigin][localTarget];
        }
        if (superMatrix[localTarget][localOrigin] == 1) {
            peso2 = weightMatrix[localTarget][localOrigin];
        }
        visible = cualquiera(peso1, peso2);
        return visible;
    }

    private int cualquiera(int x, int y) {
        if (x != 0) {
            return x;
        } else {
            return y;
        }
    }

    private void searchConectedRadios(Line l, AnchorPane pane, ToggleButton toggle, ToggleButton toggle1) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();

        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });

        radios.forEach(x -> {
            if ((x.getLayoutX() == l.getStartX() - 7 || x.getLayoutX() == l.getEndX() - 7)
                    && (x.getLayoutY() == l.getStartY() - 9 || x.getLayoutY() == l.getEndY() - 9)) {

                conected.add(x);
            }
        });

        int localOrigin = Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", "")) - 1;
        int localTarget = Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", "")) - 1;
        boolean rightWay = true;
        boolean leftWay = true;
        boolean bandera1 = true;
        boolean bandera2 = true;
        if (superMatrix[localOrigin][localTarget] == 1) {
            for (int i = 0; i < offRoads.size(); i++) {
                if (bandera1) {
                    if (localOrigin == offRoads.get(i).getXPosition() && localTarget == offRoads.get(i).getYPosition()) {
                        toggle.setSelected(true);
                        bandera1 = false;
                    } else {
                        toggle.setSelected(false);
                    }
                }
            }
            toggle.setText(conected.get(0).getId() + "->" + conected.get(1).getId());
            leftWay = false;
        }
        if (superMatrix[localTarget][localOrigin] == 1) {
            int localOrigin1 = Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", "")) - 1;
            int localTarget1 = Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", "")) - 1;
            for (int i = 0; i < offRoads.size(); i++) {
                if (bandera2) {
                    if (localOrigin1 == offRoads.get(i).getXPosition() && localTarget1 == offRoads.get(i).getYPosition()) {
                        toggle1.setSelected(true);
                        bandera2 = false;
                    } else {
                        toggle1.setSelected(false);
                    }
                }
            }
            toggle1.setText(conected.get(1).getId() + "->" + conected.get(0).getId());
            rightWay = false;
        }

        if (leftWay) {
            toggle.setText("No hay via");
        }
        if (rightWay) {
            toggle1.setText("");
        }
    }


    public int toNumber(ToggleButton button, int n) {
        if (!"No hay via".equals(button.getText())) {
            int x = Integer.valueOf(button.getText().split("->")[n].replaceAll("\\D+", "")) - 1;
            return x;
        }

        return 0;
    }

    public void addOffRoad(int x, int y) {
        Point localOffRoad = new Point();
        boolean found = false;
        localOffRoad.update(x, y);
        for (Point p : offRoads) {
            if (p.getXPosition() == x && p.getYPosition() == y) {
                found = true;
            }
        }

        if (!found) {
            offRoads.add(localOffRoad);
        }
    }

    public void removeOffRoad(int x, int y) {
        offRoads = (ArrayList) offRoads.
                stream().filter(i -> i.getXPosition() != x && i.getYPosition() != y).
                collect(Collectors.<Point>toList());
    }

    public void printOffRoads() {
        System.out.println("-----------------");
        offRoads.forEach(x -> System.out.println(x.getXPosition() + "-" + x.getYPosition()));
    }

    public void resetOffRodas() {
        offRoads = new ArrayList<>();
    }

    public boolean getOnline() {
        return online;
    }

    public void restoreOnline() {
        online = false;
    }

    public ArrayList<Point> getOffRoads() {
        return offRoads;
    }

    public void activate() {
        activar = !activar;
    }

    public void limpiarRuta(AnchorPane pane) {
        auxLinea.forEach(x -> {
            pane.getChildren().remove(x);
        });
        auxLinea = new ArrayList<>();
        lineas.forEach(x -> auxLinea.add(x));
        Linea = new Polyline();
        lineas = new ArrayList<>();
        logicLines = new ArrayList<>();
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public void ex(int i) {
        if (i == 0) {
            System.exit(-1);
        }
    }

    public void printlists() {

        //System.err.println("que: ");
        //animator.getQ().forEach(x->System.out.println(x));
    }

    public void repaint() {
        ArrayList<RadioButton> radios = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radio.setSelected(false);
                radios.add(radio);
            }
        });
        radios.forEach(x -> pane.getChildren().remove(x));
        radios.forEach(x -> pane.getChildren().add(x));
    }

    public boolean isLeftFlag() {
        return leftFlag;
    }

    public void setLeftFlag(boolean leftFlag) {
        this.leftFlag = leftFlag;
    }

    public boolean isRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(boolean rightFlag) {
        this.rightFlag = rightFlag;
    }

    public int getTrafico() {
        return trafico;
    }

    public void setTrafico(int trafico) {
        this.trafico = trafico;
    }
}
