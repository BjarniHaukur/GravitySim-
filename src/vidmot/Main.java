package vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private Space space;
    private Planet sol, terra, luna, dune, venus;
    public static Timeline t;

    public static double deltaT = 0.01;

    public static double getDeltaT() {
        return deltaT;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        space = new Space(1000,1000);
        sol = new Planet(100, 500, 500, 0, 0, "#FDB813");
        terra = new Planet(10, 100, 500, 0, 30, "#19B5FE");
        dune = new Planet(20, 200, 500, 0, 30, "#ff0000");
        venus = new Planet(8, 350, 500, 0, 51, "#40ff00");
        luna = new Planet(2, 80, 500, 0, 25, "#ff00ff");
        space.addPlanet(sol);
        space.addPlanet(terra);
        space.addPlanet(dune);
        space.addPlanet(venus);
        space.addPlanet(luna);
        root.getChildren().add(space);

        lykkja();

        primaryStage.setResizable(false);
        primaryStage.setTitle("Gravity");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public void lykkja() {
        KeyFrame k = new KeyFrame(Duration.millis(2), e -> {
            space.movePlanets();
        });
        t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
