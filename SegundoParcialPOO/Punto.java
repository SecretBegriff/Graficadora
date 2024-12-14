package SegundoParcialPOO;
import java.util.Vector;
import java.awt.*;
import java.awt.geom.*;

public class Punto <E>{
    private E x;
    private E y;

    public Punto(E x, E y){
        this.x = x;
        this.y = y;
    }

    public void setX(E x){
        this.x = x;
    }

    public E getX(){
        return x;
    }

    public void setY(E y){
        this.y = y;
    }

    public E getY(){
        return y;
    }


}
