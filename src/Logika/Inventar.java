package Logika;

import java.util.ArrayList;
import java.util.List;

public class Inventar {
    private List<Predmet> obsahInventare;
    private int kapacita;
    public Inventar() {
        this.obsahInventare = new ArrayList<>();
        this.kapacita = 3;
    }

    public List<Predmet> getObsahInventare() {
        return obsahInventare;
    }
    public void odeberPredmet(Predmet predmet) {
        obsahInventare.remove(predmet);
    }
    public boolean pridejPredmet(Predmet predmet) {
        if (maBatoh()) {
            kapacita = 6;
        }
        if (obsahInventare.size() < kapacita) {
            obsahInventare.add(predmet);
            return true;
        }
        return false;
    }
    public boolean maBatoh() {
        for (Predmet predmet : obsahInventare) {
            if (predmet.getNazev().equals("batoh")) {
                return true;
            }
        }
        return false;
    }
    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

}
