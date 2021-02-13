//author Mateusz Smoktunowicz
import java.awt.*;

public abstract class Figura {
    private double x,y;
    private Color color;

    Figura(double x, double y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }

    abstract String getNazwa();

    abstract double getA();

    abstract double getB();

    abstract void setA(int a);

    abstract void setB(int b);

    abstract public String toString();

    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
    void setX(double x){
        this.x = x;
    }
    void setY(double y){
        this.y = y;
    }


    Color getColor(){
        return color;
    }



}
