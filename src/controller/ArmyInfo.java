package controller;

import javafx.scene.image.ImageView;
import units.Army;

public class ArmyInfo {

    private Army a;
    private int x;
    private int y;
    private int xBesieg;
    private int yBesiege;
    private ImageView v;

    public ArmyInfo(Army a, int x, int y, int xBesieg, int yBesiege, ImageView v) {
        this.a = a;
        this.x = x;
        this.y = y;
        this.xBesieg = xBesieg;
        this.yBesiege = yBesiege;
        this.v = v;
    }



    public int getxBesieg() {
        return xBesieg;
    }



    public void setxBesieg(int xBesieg) {
        this.xBesieg = xBesieg;
    }



    public int getyBesiege() {
        return yBesiege;
    }



    public void setyBesiege(int yBesiege) {
        this.yBesiege = yBesiege;
    }



    public Army getA() {
        return a;
    }

    public void setA(Army a) {
        this.a = a;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageView getV() {
        return v;
    }

    public void setV(ImageView v) {
        this.v = v;
    }
    
    
}
