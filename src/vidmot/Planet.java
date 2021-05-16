package vidmot;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


import static vidmot.Main.getDeltaT;

public class Planet extends Circle {

    final double pi = 3.1415926535897932;
    private int radius;
    private double mass;
    private double xloc;
    private double yloc;
    private double xVel;
    private double yVel;
    private String color;

    public Planet (int r, double x, double y, double xv, double yv, String litur) {
        super(r, Paint.valueOf(litur));
        radius = r;
        mass = Math.pow(r,3)*pi*4/3;
        xloc = x;
        yloc = y;
        xVel = xv;
        yVel = yv;
        color = litur;
        setTranslateX(xloc);
        setTranslateY(yloc);

    }

    public void movePlanet(double x, double y) {
        xVel = xVel + x;
        yVel = yVel + y;
        xloc = xloc + xVel*getDeltaT();
        yloc = yloc + yVel*getDeltaT();
        setTranslateX(xloc);
        setTranslateY(yloc);
    }

    public void setXloc(double xloc) {
        this.xloc = xloc;
    }

    public void setYloc(double yloc) {
        this.yloc = yloc;
    }

    public double getMass() {
        return mass;
    }

    public double getXloc() {
        return xloc;
    }

    public double getYloc() {
        return yloc;
    }

    public double getxVel() {
        return xVel;
    }

    public double getyVel() {
        return yVel;
    }

    public String getColor() {
        return color;
    }






}
