//author Mateusz Smoktunowicz
import java.awt.*;

public class Okrag extends Figura{
    private double a;
    private String nazwa;
    public Okrag(double x, double y,Color color, double a){
        super(x, y, color);
        this.a=a;
        this.nazwa="Okrag";
    }

    String getNazwa(){
        return nazwa;
    }
    double getA() {
        return a;
    }

    double getB() {
        return 0;
    }

    void setA(int a) {
        this.a = a;
    }

    void setB(int b) {
    }

    public String toString(){
        return "Okrag;"+ getX() +";"+ getY() +";"+
                getColor().getRed() +":"+ getColor().getGreen() +":"+ getColor().getBlue()
                +";"+ getA();
    }
}
