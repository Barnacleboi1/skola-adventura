package Start;

import Logika.Hra;
import UI.TextoveRozhrani;


public class Start {
    public static void main(String[] args) {
        Hra novaHra = new Hra();
        TextoveRozhrani textoveRozhrani = new TextoveRozhrani(novaHra);

        textoveRozhrani.hraj();
    }
}
