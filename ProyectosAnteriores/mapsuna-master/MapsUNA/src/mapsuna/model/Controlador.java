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
 * @author natal
 */
public class Controlador {

    private int contadorCK;
    private int rclick;
    private int contClick;
    private int[][] Matriz;
    private boolean habilitado;
    private ArrayList<Line> lineas;
    private ArrayList<Line> lineaInicio;
    private ArrayList<Line> auxLinea;
    private ArrayList<Line> lineaAuxiliar;
    private ArrayList<Double> logicLines;
    private ArrayList<Point> trayecto;
    private Point destino;
    private Point verticeOrigen;
    private Polyline Linea;
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
    private boolean banIzq;
    private boolean banDer;
    private int trafico;
    private Circle circulo;
    private AnchorPane pane;
    private AnchorPane paneMapa;
    private RadioButton rdbDijkstra;
    private RadioButton rdbFloyd;
    private Label lbltotalPrevio;
    private Label coLabel1;
    private Label time;
    private RadioButton calleDR;
    private RadioButton calleIZ;
    private boolean reCalcular;
    private String init;
    //
public Controlador(Circle circulo, RadioButton rdbDijkstra, RadioButton rdbFloyd, Label topre, RadioButton iz, RadioButton dr, AnchorPane pa, boolean izB, boolean drB, int tra, Label tiempo,Label costTo) { // Variables para resivir del controlador de la ventana
        
        
        
        textoAuxiliar = new Text("5");
        textoAuxiliar.setStyle("-fx-fill: Green;-fx-font-size: 14px;-fx-font-weight: bold;");
        this.rdbDijkstra = rdbDijkstra;
        this.rdbFloyd = rdbFloyd;
        paneMapa = pa;
        calleDR = dr;
        calleIZ = dr;
        pane = pa;
        lbltotalPrevio = topre;
        time = tiempo;
        coLabel1 = costTo;   
        trafico = tra;
        
        //inicializacion de variables
        activar = false;
        trigger = false;
        lineaAuxiliar = new ArrayList<>();
        rclick = 0;
        animacion = new Animacion();
        contadorCK = 0;
        habilitado = false;
        verticeOrigen = new Point();
        destino = new Point();
        movimiento = new PathTransition();
        Linea = new Polyline();
        lineas = new ArrayList<>();
        lineaInicio = new ArrayList<>();
        auxLinea = new ArrayList<>();
        logicLines = new ArrayList<>();
        trayecto = new ArrayList<>();
        movimiento.setNode(circulo);
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
                                        movimiento.setPath(animacion.pop());
                                        costTo.setText(animacion.getAcarreo()+ "");
                                        movimiento.play();
                                } else {
                                    actualizar = false;
                                    costTo.setText(animacion.getAcarreo() + "");
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
        trayecto.forEach(x -> {
            if (banIzq) {
                grafo.cortarPaso(x.getXPosition(), x.getYPosition());
                grafo.cortarPasoMatPeso(x.getXPosition(), x.getYPosition());//Se trabaja con la de pesos
            }
            if (banDer) {
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
        launch(grafo.getMatPeso(), grafo.getMatPeso(), calleDR, calleIZ);
        path = new ArrayList<>();
        calleDR.setSelected(false);
        calleIZ.setSelected(false);
        repintar();
    }

    public void setActualizar() {
        actualizar = !actualizar;
    }

    public boolean getActualizar() {
        return actualizar;
    }

    public void setContClick(int x) {
        contClick = x;
    }

    public void inhabilitar() {
        actualizar = false;
    }

    public void Habilitar() {
        actualizar = true;
    }

    public int getContClick() {
        return contClick;
    }

    public String getOrigin() {
        return verticeOrigen.getId();
    }

    public String getDestino() {
        return destino.getId();
    }

    public void launch(int[][] m, int[][] peso, RadioButton rbtn, RadioButton rbtn1) {
        launcher(verticeOrigen.getXPosition(), verticeOrigen.getYPosition(),
                destino.getXPosition(), destino.getYPosition(), pane, circulo, m, peso, rbtn, rbtn1);
    }

    public void mouseEvent(Node x, AnchorPane pane, int n) {
        boolean lock = false;

        if (contadorCK == 0) {
            animacion.Restablecer();
            lock = true;
            verticeOrigen.actualizar(x);
            init = x.getId();
            trigger = false;
            lineaAuxiliar.forEach(q -> {
                pane.getChildren().remove(q);
            });
        }

        if (contadorCK == 1) {
            destino.actualizar(x);
            contadorCK = 0;
            trigger = true;
        }
        if (lock) {
            contadorCK++;
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
                RadioButton vertice = (RadioButton) item;
                if (vertice.getId().equals(verticeOrigen.getId()) || vertice.getId().equals(destino.getId())) {
                    (vertice).setSelected(false);
                }
            }
        });
    }

    private void launcher(int x1, int y1, int x2, int y2, AnchorPane pane, Circle circulo, int[][] m, int[][] peso,
         RadioButton rbtn, RadioButton rbtn1) {

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
                BuscarConexion(x, pane, rbtn, rbtn1);
                habilitado = true;
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
        trajectory.add(destino.getId());
        return trajectory;
    }

    public void toLines(ArrayList<String> logicPath) {
        ArrayList<RadioButton> vertices = new ArrayList<>();
        ArrayList<RadioButton> graphicPath = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton vertice = (RadioButton) item;
                vertice.setSelected(false);
                vertices.add(vertice);
            }
        });

        logicPath.forEach(x -> {
            vertices.forEach(y -> {
                if (y.getId().equals(x)) {
                    RadioButton vertice = (RadioButton) y;
                    graphicPath.add(y);
                }
            });
        });

        for (int i = 0; i < graphicPath.size(); i++) {
            if (i + 1 < graphicPath.size()) {
                verticeOrigen = new Point();
                destino = new Point();

                verticeOrigen.actualizar((Node) graphicPath.get(i));
                destino.actualizar((Node) graphicPath.get(i + 1));

                logicLines.add(verticeOrigen.getXPosition() + 0.0);
                logicLines.add(verticeOrigen.getYPosition() + 0.0);
                logicLines.add(destino.getXPosition() + 0.0);
                logicLines.add(destino.getYPosition() + 0.0);

                lineas.add(new Line(verticeOrigen.getXPosition(), verticeOrigen.getYPosition(),
                        destino.getXPosition(), destino.getYPosition()));
                lineas.forEach(l -> {
                    l.setStyle("-fx-stroke: rgba(0,0, 255,0.3);");
                });
            }
        }

    }

    public void inicio(AnchorPane pane, int[][] m, RadioButton rbtn, RadioButton rbtn1) {
        
        Matriz = m;
        Line selectedLine = new Line();
        ArrayList<RadioButton> vertices = new ArrayList<>();
        ArrayList<RadioButton> graphicPath = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton vertice = (RadioButton) item;
                vertices.add(vertice);
            }
        });

        vertices.forEach(y -> {

            RadioButton vertice = (RadioButton) y;
            graphicPath.add(y);

        });

        verticeOrigen = new Point();
        destino = new Point();
        boolean actualizar = false;
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                if (m[i][j] == 1) {
                    actualizar = false;
                    for (RadioButton r : vertices) {
                        if (r.getId().equals("A" + (i + 1))) {
                            verticeOrigen.actualizar((Node) r);
                            actualizar = true;
                        }
                        if (r.getId().equals("A" + (j + 1))) {
                            destino.actualizar((Node) r);
                            actualizar = true;
                        }
                    }

                    if (actualizar) {
                        Line linea = new Line(verticeOrigen.getXPosition(), verticeOrigen.getYPosition(),
                                destino.getXPosition(), destino.getYPosition());

                        linea.setStrokeWidth(5);

                        linea.addEventFilter(MouseEvent.MOUSE_EXITED, event -> {
                            linea.getScene().setCursor(Cursor.DEFAULT);
                        });

                        linea.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> {
                            linea.getScene().setCursor(Cursor.HAND);
                        });

                        linea.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                            BuscarConexion(linea, pane, rbtn, rbtn1);
                            habilitado = true;
                            clearSelection();
                            linea.setStyle("-fx-stroke: rgba(170, 57, 57,0.5);");
                        });
                        linea.toFront();

                        lineaInicio.add(linea);
                    }
                }
            }
        }
        lineaInicio.forEach(x -> x.setStyle("-fx-stroke: rgba(170, 57, 57,0.1);"));
        lineaInicio.forEach(x -> pane.getChildren().add(x));
        vertices.forEach(x -> pane.getChildren().remove(x));
        vertices.forEach(x -> pane.getChildren().add(x));
        verticeOrigen = new Point();
        destino = new Point();
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
        ArrayList<RadioButton> vertices = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();

        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton vertice = (RadioButton) item;
                vertices.add(vertice);
            }
        });

        vertices.forEach(x -> {
            if ((x.getLayoutX() == line.getStartX() - 7 || x.getLayoutX() == line.getEndX() - 7)
                    && (x.getLayoutY() == line.getStartY() - 9 || x.getLayoutY() == line.getEndY() - 9)) {

                conected.add(x);
            }
        });
        int peso1 = 0;
        int peso2 = 0;
        int visible = 0;
        int verticeInicial = Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", "")) - 1;
        int rutaIni = Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", "")) - 1;
        if (Matriz[verticeInicial][rutaIni] == 1) {
            peso1 = weightMatrix[verticeInicial][rutaIni];
        }
        if (Matriz[rutaIni][verticeInicial] == 1) {
            peso2 = weightMatrix[rutaIni][verticeInicial];
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

    private void BuscarConexion(Line l, AnchorPane pane, RadioButton rbtn, RadioButton rbtn1) {
        ArrayList<RadioButton> vertices = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();
        rbtn.setSelected(false);
        rbtn.setSelected(false);
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton vertice = (RadioButton) item;
                vertices.add(vertice);
            }
        });

        vertices.forEach(x -> {
            if ((x.getLayoutX() == l.getStartX() - 7 || x.getLayoutX() == l.getEndX() - 7)
                    && (x.getLayoutY() == l.getStartY() - 9 || x.getLayoutY() == l.getEndY() - 9)) {

                conected.add(x);
            }
        });

        int verticeInicial = Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", "")) - 1;
        int rutaIni = Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", "")) - 1;
        boolean calleDer = true;
        boolean calleIzq = true;
        boolean bandera1 = true;
        boolean bandera2 = true;
        if (Matriz[verticeInicial][rutaIni] == 1) {
            for (int i = 0; i < trayecto.size(); i++) {
                if (bandera1) {
                    if (verticeInicial == trayecto.get(i).getXPosition() && rutaIni == trayecto.get(i).getYPosition()) {
                        rbtn.setSelected(true);
                        bandera1 = false;
                    } else {
                        rbtn.setSelected(false);
                    }
                }
            }
            rbtn.setText(conected.get(0).getId() + "->" + conected.get(1).getId());
            calleIzq = false;
        }
        if (Matriz[rutaIni][verticeInicial] == 1) {
            int verticeInicial1 = Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", "")) - 1;
            int rutaIni1 = Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", "")) - 1;
            for (int i = 0; i < trayecto.size(); i++) {
                if (bandera2) {
                    if (verticeInicial1 == trayecto.get(i).getXPosition() && rutaIni1 == trayecto.get(i).getYPosition()) {
                        rbtn1.setSelected(true);
                        bandera2 = false;
                    } else {
                        rbtn1.setSelected(false);
                    }
                }
            }
            rbtn1.setText(conected.get(1).getId() + "->" + conected.get(0).getId());
            calleDer = false;
        }

        if (calleIzq) {
            rbtn.setText("No hay via");
        }
        if (calleDer) {
            rbtn1.setText("");
        }
    }


    public int toNumber(RadioButton button, int n) {
        if (!"No hay via".equals(button.getText())) {
            int x = Integer.valueOf(button.getText().split("->")[n].replaceAll("\\D+", "")) - 1;
            return x;
        }

        return 0;
    }

    public void añadirRuta(int x, int y) {
        Point localOffRoad = new Point();
        boolean found = false;
        localOffRoad.actualizar(x, y);
        for (Point p : trayecto) {
            if (p.getXPosition() == x && p.getYPosition() == y) {
                found = true;
            }
        }

        if (!found) {
            trayecto.add(localOffRoad);
        }
    }

    public void removerRuta(int x, int y) {
        trayecto = (ArrayList) trayecto.
                stream().filter(i -> i.getXPosition() != x && i.getYPosition() != y).
                collect(Collectors.<Point>toList());
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
    public void repintar() {
        ArrayList<RadioButton> vertices = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton vertice = (RadioButton) item;
                vertice.setSelected(false);
                vertices.add(vertice);
            }
        });
        vertices.forEach(x -> pane.getChildren().remove(x));
        vertices.forEach(x -> pane.getChildren().add(x));
    }

    public int getTrafico() {
        return trafico;
    }

    public void setTrafico(int trafico) {
        this.trafico = trafico;
    }
}
