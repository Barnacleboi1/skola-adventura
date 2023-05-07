package Logika;

import java.util.HashSet;
import java.util.Set;

public class Lokace {
    private String nazev;
    private String popis;
    private Set<Lokace> vychody;
    private Predmet[] predmetyVLokaci;

    public Lokace(String nazev, String popis, Predmet... predmetyVLokaci) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashSet<>();
        this.predmetyVLokaci = predmetyVLokaci;
    }

    public void pridejVychod(Lokace lokace) {
        vychody.add(lokace);
    }
    public boolean maVychod(String nazevLokace) {
        for (Lokace lokace : vychody) {
            if (lokace.getNazev().equals(nazevLokace)) {
                return true;
            }
        }
        return false;
    }
    public String nechTuPredmet(Predmet predmet) {

    }
    public Lokace getVychod(String nazevLokace) {
        for (Lokace lokace : vychody) {
            if (lokace.getNazev().equals(nazevLokace)) {
                return lokace;
            }
        }
        return null;
    }


    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Set<Lokace> getVychody() {
        return vychody;
    }

    public void setVychody(Set<Lokace> vychody) {
        this.vychody = vychody;
    }
}
