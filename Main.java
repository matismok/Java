//author Mateusz Smoktunowicz

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String []args)throws IOException {
        File file = new File(args[0]);
        wyszukiwanieNajdluzszegoPodciagu(file);
    }


    public static void wyszukiwanieNajdluzszegoPodciagu(File file)throws IOException {
        FileReader fileReader= new FileReader(file);
        String [] str;
        int x;
        String pom="";

        while ((x=fileReader.read())!=-1){
            pom+=(char)x;
        }
        str=pom.split(" ");

        int dane=0;
        int dane2=0;
        int dane3=0;
        int dane4=0;
        int zm1;
        int zm2;
        int licznik=1;
        int licznik2=1;
        int sumaMaxCiagu=0;
        int sumaMaxLicznik=0;

        if ((zm1 = Integer.parseInt(str[0]))!=-1){
            dane+=zm1;
            if (dane > sumaMaxCiagu || licznik > sumaMaxLicznik) {
                sumaMaxCiagu = dane;
                sumaMaxLicznik = licznik;
            }
            dane=0;
        }

        for (int i = 0; i < str.length-1; i++) {

            if ((zm1 = Integer.parseInt(str[i])) < (zm2 = Integer.parseInt(str[i + 1]))) {
                dane3=0;
                dane4=0;
                licznik2=1;
                dane += zm1;
                dane2 = dane + zm2;
                licznik++;
                if (dane2 > sumaMaxCiagu || licznik > sumaMaxLicznik) {
                    sumaMaxCiagu = dane2;
                    sumaMaxLicznik = licznik;
                }
            }

            if ((zm1 = Integer.parseInt(str[i])) > (zm2 = Integer.parseInt(str[i + 1]))) {
                dane=0;
                dane2=0;
                licznik=1;
                dane3 += zm1;
                dane4 = dane3 + zm2;
                licznik2++;
                if (dane4 > sumaMaxCiagu || licznik2 > sumaMaxLicznik) {
                    sumaMaxCiagu = dane4;
                    sumaMaxLicznik = licznik2;
                }
            }
            if ((zm1 = Integer.parseInt(str[i])) == (zm2 = Integer.parseInt(str[i + 1]))) {
                licznik++;
                dane+=zm1;
                dane2=dane+zm2;
                dane3+=zm1;
                dane4=dane3+zm2;
                licznik2++;
                if (dane2>sumaMaxCiagu || licznik>sumaMaxCiagu){
                    sumaMaxCiagu=dane2;
                    sumaMaxLicznik=licznik;
                }
                if (dane4>sumaMaxCiagu || licznik2>sumaMaxLicznik){
                    sumaMaxCiagu=dane4;
                    sumaMaxLicznik=licznik2;
                }
            }
        }
        System.out.println(sumaMaxLicznik+" "+sumaMaxCiagu);
    }
}
