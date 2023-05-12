package Logika;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lokace {
    private String nazev;
    private String popis;
    private Set<Lokace> vychody;
    private List<Predmet> predmetyVLokaci;

    public Lokace(String nazev, String popis, Predmet... predmetyVLokaci) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashSet<>();
        this.predmetyVLokaci = List.of(predmetyVLokaci);
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
    public void odeberpredmet(Predmet predmet) {
        predmetyVLokaci.remove(predmet);
    }
    public Lokace getVychod(String nazevLokace) {
        for (Lokace lokace : vychody) {
            if (lokace.getNazev().equals(nazevLokace)) {
                return lokace;
            }
        }
        return null;
    }

    public List<Predmet> getPredmetyVLokaci() {
        return predmetyVLokaci;
    }

    public String stringPredmetuVLokaci() {
        StringBuilder predmety = new StringBuilder();
        for (Predmet predmet : predmetyVLokaci) {
            predmety.append(predmet.getNazev()).append(", ");
        }
        return predmety.toString();
    }

    public String stringVychodu() {
        StringBuilder vychodyString = new StringBuilder();
        for (Lokace v : vychody) {
            vychodyString.append(v.getNazev()).append(", ");
        }
        return vychodyString.toString();
    }
    public String prohledaniMistnosti() {
        return  "Po prohledání místnosti si zjistil:\n" +
                "\n" +
                "Jsi v místnosti:\n" + this.getNazev() +
                "\n" +
                "V místnosti jsou předměty:\n" + stringPredmetuVLokaci() +
                "\n" +
                "Místnost má východy do:" + stringVychodu();
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
