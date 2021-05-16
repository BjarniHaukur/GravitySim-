package vidmot;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static vidmot.Main.getDeltaT;

public class Space extends AnchorPane {

    final double G = 0.1;
    private int haed;
    private int breidd;
    private ArrayList<Planet> planets = new ArrayList<>();

    public Space(int haed, int breidd) {
        this.haed = haed;
        this.breidd = breidd;
        setPrefSize(breidd, haed);
        setBackground(new Background(new BackgroundFill(Color.web("#000000"), null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

    public void addPlanet(Planet p) {
        planets.add(p);
        getChildren().add(p);
    }

    public void movePlanets() {
        double[] vector;
        double[] sumVector;
        double[] eV;
        double r;
        double Fx;
        double Fy;
        for (Planet p: planets) {
            sumVector = new double[2];
            for (Planet t: planets) {
                if (t.equals(p)) continue;
                vector = distVector(p, t);
                r = dist(vector);
                eV = unitVector(vector, r);
                Fx = ((G*p.getMass()*t.getMass())/Math.pow(r, 2))*eV[0];
                Fy = ((G*p.getMass()*t.getMass())/Math.pow(r, 2))*eV[1];
                sumVector[0] += (Fx/p.getMass())*getDeltaT();
                sumVector[1] += (Fy/p.getMass())*getDeltaT();
            }
            p.movePlanet(-sumVector[0], -sumVector[1]);
        }

    }

    public double[] distVector(Planet p1, Planet p2) {
        //Skilar vector frá p1 til p2
        double[] dist = {p1.getXloc()-p2.getXloc(), p1.getYloc() - p2.getYloc()};
        return dist;
    }

    public double dist(double[] vector) {
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));
    }

    public double[] unitVector(double[] vector, double dist) {
        double[] temp = {vector[0]/dist, vector[1]/dist};
        return temp;
    }



}
