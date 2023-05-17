package Logika;

import java.util.*;
/**
 * Třída představující Lokaci v našem herním světě. Je uchováván název lokace,
 * vychody, kterými může hráč projít do jiných lokací a také Listy předmětů a postav v dané lokaci
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */

public class Lokace {
    private String nazev;
    private Set<Lokace> vychody;
    private List<Predmet> predmetyVLokaci;
    private List<Postava> postavyVLokaci;

    public Lokace(String nazev, Predmet... predmetyVLokaci) {
        this.nazev = nazev;
        this.vychody = new HashSet<>();
        this.predmetyVLokaci = new ArrayList<>(Arrays.asList(predmetyVLokaci));
        this.postavyVLokaci = new ArrayList<>();
    }

    public void pridejPostavu(Postava postava) {
        postavyVLokaci.add(postava);
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
    public String stringPostav() {
        StringBuilder postavyString = new StringBuilder();
        if (postavyVLokaci.size() == 0) {
            return "V místnosti nejsou žádné postavy!";
        }
        else {
            for (Postava postava : postavyVLokaci) {
                postavyString.append(postava.getJmeno()).append(", ");
            }
            return postavyString.toString();
        }
    }
    public String prohledaniMistnosti() {
        return  "Po prohledání místnosti si zjistil:\n" +
                "\n" +
                "Jsi v místnosti: " + this.getNazev() +
                "\nV místnosti jsou předměty: " + stringPredmetuVLokaci() +
                "\nMístnost má východy do: " + stringVychodu() +
                "\nV místnosti jsou postavy: " + stringPostav();
    }
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
    public Set<Lokace> getVychody() {
        return vychody;
    }

    public void setVychody(Set<Lokace> vychody) {
        this.vychody = vychody;
    }

    public List<Postava> getPostavyVLokaci() {
        return postavyVLokaci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lokace lokace = (Lokace) o;

        return Objects.equals(nazev, lokace.nazev);
    }

    @Override
    public int hashCode() {
        return nazev != null ? nazev.hashCode() : 0;
    }
}
