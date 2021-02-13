//author Mateusz Smoktunowicz
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModulWyswietlania {
    List<Figura> listaFigur;
    Okno modulWyswietlania;

    ModulWyswietlania() throws IOException {
        this.listaFigur = new ArrayList<>();
        odczytPliku("figury.txt");
        modulWyswietlania = new Okno(1280, 960, listaFigur);
        modulWyswietlania.setLocationRelativeTo(null);
    }

    Figura figuraZeStringu(String string) {
        String[] figury = string.split(";", 0);
        String[] color = figury[3].split(":", 0);

            if (figury[0].equals("Prostokat")) {
                return new Prostokat(Double.parseDouble(figury[1]), Double.parseDouble(figury[2]),
                        new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])),
                        Double.parseDouble(figury[4]), Double.parseDouble(figury[5])
                );
            }
            else if (figury[0].equals("Okrag")) {
                return new Okrag(Double.parseDouble(figury[1]), Double.parseDouble(figury[2]),
                        new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])),
                        Double.parseDouble(figury[4])

                );
            }
           else {
                return new ZaokraglonyProstokat(Double.parseDouble(figury[1]), Double.parseDouble(figury[2]),
                        new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])),
                        Double.parseDouble(figury[4]), Double.parseDouble(figury[5])
                );
            }

    }

    void odczytPliku(String nazwa_pliku) throws IOException{
        FileReader fr= new FileReader(nazwa_pliku);
        String dane= "";
        int znak;
        while((znak=fr.read()) >=0){
            dane +=(char)znak;
        }
        String [] linie= dane.split("\n+",0);
        for (int i=0;i<linie.length;i++){
            listaFigur.add(figuraZeStringu(linie[i]));
        }
    }
}
