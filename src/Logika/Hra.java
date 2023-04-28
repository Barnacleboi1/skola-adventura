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
    public void pridejPredmet(Predmet predmet) {
        inventar.add(predmet);
    }
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }
}
