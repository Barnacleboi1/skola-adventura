package Logika;

import java.util.HashSet;
import java.util.Set;

public class Lokace {
    private String nazev;
    private String popis;
    private Set<Lokace> vychody;
    private PostavaInterface postavaVLokaci;

    public Lokace(String nazev, String popis, PostavaInterface postavaVLokaci) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashSet<>();
        this.postavaVLokaci = postavaVLokaci;
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
