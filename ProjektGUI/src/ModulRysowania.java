//author Mateusz Smoktunowicz
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ModulRysowania {
    List<Figura> listaFigur;
    Okno okno;

    ModulRysowania() {
        this.listaFigur = new ArrayList<>();
        okno = new Okno(1280, 960, listaFigur);
        okno.setLocationRelativeTo(null);
    }

    boolean czyOtwarte() {
        return okno.czyOtwarte();
    }

    void randomowaFigura(int zmienna) {
        if (zmienna == 0) {
            listaFigur.add(new Prostokat(
                    Math.random() * 8 + 0.5, Math.random() * 8 + 0.5,
                    new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
                    Math.random()/10, Math.random()/10
            ));
        }
        else if (zmienna == 1) {
            listaFigur.add(new Okrag(
                    Math.random() * 8 + 0.5, Math.random() * 8 + 0.5,
                    new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
                    Math.random()/10
            ));
        }
        else {
            listaFigur.add(new ZaokraglonyProstokat(
                    Math.random() * 8 + 0.5, Math.random() * 8 + 0.5,
                    new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
                    Math.random()/10, Math.random()/10
            ));

        }
        okno.repaint();
    }
}

