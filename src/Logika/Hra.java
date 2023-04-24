package Logika;

import java.util.HashSet;
import java.util.Set;

public class Hra {
    private HerniSvet herniSvet;
    private boolean hraSkoncila;
    private Set<PrikazInterface> prikazy;

    public Hra() {
        herniSvet = new HerniSvet();
        hraSkoncila = false;

        prikazy = new HashSet<>();
        prikazy.add(new PrikazKonec());
    }
    public String zpracujPrikaz(String prikaz) {
        return null;
    }
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }

    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }
}
