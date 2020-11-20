package mapauna.clases;

import java.beans.EventHandler;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionExample extends Application {

    PathTransition transition;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        // create movable object
        Rectangle rect = new Rectangle(50, 50);
        rect.setStroke(Color.BLUE);
        rect.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));
        rect.relocate(100, 80);
        root.getChildren().add(rect);

        Label label = new Label("Click on scene to set destination");
        label.relocate(0, 0);
        root.getChildren().add(label);

        // init transition
        transition = new PathTransition();
        transition.setNode(rect);
        transition.setDuration(Duration.seconds(5));

        double toX = 500;
        double toY = 500;

        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(toX, toY));
        path.getElements().add(new LineTo(toX, 0));

        transition.setPath(path);
        transition.play();
        

        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
