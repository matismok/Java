//author Mateusz Smoktunowicz
import java.awt.*;
public class Prostokat extends Figura {
    private double a,b;
    private String nazwa;

    public Prostokat(double x, double y, Color color, double a, double b) {
        super(x, y, color);
        this.a = a;
        this.b = b;
        this.nazwa="Prostokat";
    }

    String getNazwa(){
        return nazwa;
    }
    double getA() {
        return a;
    }

    double getB() {
        return b;
    }

    void setA(int a) {
        this.a = a;
    }

    void setB(int b) {
        this.b = b;
    }

    public String toString() {
        return "Prostokat;" + getX() + ";" + getY() + ";" +
                getColor().getRed() + ":" + getColor().getGreen() + ":" + getColor().getBlue()
                + ";" + getA() + ";" + getB();
    }
}