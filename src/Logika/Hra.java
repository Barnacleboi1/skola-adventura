package Logika;

import java.util.*;

public class Hra {
    private HerniSvet herniSvet;
    List<Predmet> inventar;
    private boolean hraSkoncila;
    private Set<PrikazInterface> prikazy;

    public Hra() {
        herniSvet = new HerniSvet();
        hraSkoncila = false;

        inventar = new ArrayList<>();

        prikazy = new HashSet<>();
        prikazy.add(new PrikazNasad(this));
        prikazy.add(new PrikazNapoveda());
        prikazy.add(new PrikazJdi(this));
        prikazy.add(new PrikazProhledej(this));
        prikazy.add(new PrikazVezmi(this));
        prikazy.add(new PrikazObsahBatohu(this));
        prikazy.add(new PrikazPouzij(this));
    }
    public String zpracujPrikaz(String vstupUzivatele) {
        String[] array = vstupUzivatele.split(" ");
        String prikaz = array[0];

        for (PrikazInterface p : prikazy) {
            if (prikaz.equals(p.getNazev())){
                return p.proved(Arrays.copyOfRange(array, 1, array.length));
            }
        }

        return "Příkaz " + prikaz + " neznám.";
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
        return "Na předmět nemáš místo, možná by se hodil nějaký batoh.";
    }
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }
    public String getProlog() {
        return "Probouzíš se v chodbě staré egyptské hrobky. Všude kolem je tma.";
    }

    public String getEpilog() {
        return "Po vstupu do místnosti vidíš, že se otevírá východ z hrobky. Tím tvá noční můra končí.";
    }

    public List<Predmet> getInventar() {
        return inventar;
    }
}
