package Start;

import Logika.Hra;
import UI.TextoveRozhrani;


public class Start {
    /**
     * Hlavní metoda celé hry, vytváří se zde dvě instance hry, textového rozhrani a volá se metoda hraj.
     *
     */
    public static void main(String[] args) {
        Hra novaHra = new Hra();
        TextoveRozhrani textoveRozhrani = new TextoveRozhrani(novaHra);

        textoveRozhrani.hraj();
    }
}
