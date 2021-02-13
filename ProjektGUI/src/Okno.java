//author Mateusz Smoktunowicz
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Okno extends JFrame {
   int width;
   int height;
   List<Figura> listaFigur;
   boolean czyOtwarte;

    Okno(int width, int height, List<Figura> listaFigur) {
        this.czyOtwarte=true;
        this.width=width;
        this.height=height;
        this.listaFigur=listaFigur;
        setTitle("Okno");
        setSize(new Dimension(this.width,this.height));
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                czyOtwarte = false;
                try {
                    zapisFigur();
                }catch (IOException ex){
                    System.out.println(ex);
                }
            }
        });

    }

    boolean czyOtwarte(){
        return this.czyOtwarte;
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i=0; i<listaFigur.size();i++){
            draw(g,listaFigur.get(i));
        }
    }

    void draw(Graphics g, Figura f) {

        g.setColor(f.getColor());
        int x = (int)(getWidth() * f.getX());
        int y = (int)(getHeight() * f.getY());
        int width = (int)(getWidth() * f.getA());
        int height = (int)(getHeight() * f.getB());

        while(x + width > getWidth() || y + width > getHeight()){
            f.setX(Math.random());
            f.setY(Math.random());
            x = (int)(getWidth() * f.getX());
            y = (int)(getHeight() * f.getY());
        }
        while(y + height > getHeight()){
            f.setY(Math.random());
            y = (int)(getHeight() * f.getY());
        }

        if(f.getNazwa().equals("Prostokat")) {
            g.drawRect( (int)(getWidth() * f.getX()),(int)(getHeight() * f.getY()),
                        (int)(getWidth() * f.getA()),(int)(getHeight() * f.getB())
            );
        }
        else if(f.getNazwa().equals("Okrag")){
            g.drawOval( (int)(getWidth() * f.getX()),(int)(getHeight() * f.getY()),
                        (int)(getWidth() * f.getA()),(int)(getHeight() * f.getA())
            );
        }
        else {
            g.drawRoundRect((int)(getWidth() * f.getX()),(int)(getHeight() * f.getY()), (int)(getWidth() * f.getA()),
                            (int)(getHeight() * f.getB()), 25, 25
            );
        }
    }

    void zapisFigur() throws IOException {
        FileWriter fw = new FileWriter("figury.txt");
        for(int i = 0; i < listaFigur.size(); ++i) {
                fw.write(listaFigur.get(i).toString());
            fw.write('\n');
        }
        fw.flush();
    }
}




