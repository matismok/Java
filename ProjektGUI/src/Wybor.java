//author Mateusz Smoktunowicz
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Wybor extends JFrame implements ActionListener {

    JButton modul_rysowania,modul_wyswietlania;
    Wybor(){
        super("Okno Wyboru");
        setSize(400,400);
        setLayout(null);

        modul_rysowania= new JButton("Modul Rysowania");
        modul_rysowania.setBounds(100,100,100,100);
        add(modul_rysowania);
        modul_rysowania.addActionListener(this);

        modul_wyswietlania= new JButton("Modul Wyswietlania");
        modul_wyswietlania.setBounds(200,100,100,100);
        add(modul_wyswietlania);
        modul_wyswietlania.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

            if (zrodlo == modul_rysowania) {
                ModulRysowania mr = new ModulRysowania();
                Thread randomowaFigura = new Thread(() -> {
                    do {
                        if (mr.czyOtwarte()) {
                            mr.randomowaFigura((int)(Math.random()*3));
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException x) {
                                System.out.println(x);
                            }
                        }
                    } while (true);
                });
                randomowaFigura.start();
            } else if (zrodlo == modul_wyswietlania) {
                    try {
                        new ModulWyswietlania();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

            }

    }
}