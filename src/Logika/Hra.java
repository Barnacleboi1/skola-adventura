package Logika;

import java.util.*;

public class Hra {
    private HerniSvet herniSvet;
    List<Predmet> inventar = new ArrayList<>();
    private boolean hraSkoncila;
    private Set<PrikazInterface> prikazy;

    public Hra() {
        herniSvet = new HerniSvet();
        hraSkoncila = false;

        prikazy = new HashSet<>();
        prikazy.add(new PrikazKonec(this));
        prikazy.add(new PrikazNapoveda());
        prikazy.add(new PrikazJdi(this));
        prikazy.add(new PrikazProhledej(this));
        prikazy.add(new PrikazVezmi(this));
        prikazy.add(new PrikazObsahBatohu(this));
        prikazy.add(new PrikazPouzijPredmet(this));
        prikazy.add(new PrikazZanechPredmet(this));
    }
    public String zpracujPrikaz(String vstupUzivatele) {
        String[] array = vstupUzivatele.split(" ");
        String prikaz = array[0];

        for (PrikazInterface p : prikazy) {
            if (p.getNazev().equals(prikaz)){
                return p.proved(Arrays.copyOfRange(array, 1, array.length));
            }
        }

        return "Příkaz " + prikaz + "neznám.";
    }
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }
    public boolean maBatoh() {
        for (Predmet predmet : herniSvet.getVsechnyPredmety()) {
            if (predmet.getNazev().equals("batoh")) {
                return predmet.isBylSebran();
            }
        }
        return false;
    }
    public String pridejPredmet(Predmet predmet) {
        int kapacita;
        if (maBatoh()) {
            kapacita = 20;
        }
        else {
            kapacita = 3;
        }
        if (inventar.size() < kapacita) {
            inventar.add(predmet);
            return "Vzal si " + predmet.getNazev();
        }
        return "Na předmět nemáš místo";
    }
    public String odeberPredmet(Predmet predmet) {

        inventar.remove(predmet);
    }
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }
}
