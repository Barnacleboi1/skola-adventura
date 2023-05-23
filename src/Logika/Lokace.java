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
    /**
     * Konstruktor třídy lokace, vytváří její název, Set výchdů, do
     * kterých může hráč z místnosti jít a také Listy předmětů a postav v lokaci.
     *
     */

    public Lokace(String nazev, Predmet... predmetyVLokaci) {
        this.nazev = nazev;
        this.vychody = new HashSet<>();
        this.predmetyVLokaci = new ArrayList<>(Arrays.asList(predmetyVLokaci));
        this.postavyVLokaci = new ArrayList<>();
    }
    /**
     * Metoda přidávájící postavu do lokace
     *
     */
    public void pridejPostavu(Postava postava) {
        postavyVLokaci.add(postava);
    }
    /**
     * Metoda přidávající východ do lokace, kam může hráč z ní jít
     *
     */
    public void pridejVychod(Lokace lokace) {
        vychody.add(lokace);
    }
    /**
     * Metoda vrací true, jestli má lokace do zadané lokace východ
     *
     */
    public boolean maVychod(String nazevLokace) {
        for (Lokace lokace : vychody) {
            if (lokace.getNazev().equals(nazevLokace)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metoda odebírající předmět z lokace
     *
     */
    public void odeberpredmet(Predmet predmet) {
        predmetyVLokaci.remove(predmet);
    }
    /**
     * Metoda přidávající předmět do lokace
     *
     */
    public void pridejPredmet(Predmet predmet) {
        predmetyVLokaci.add(predmet);
    }
    /**
     * Metoda vracející východ, který má stejný název jako String v jejím parametru.
     * vrací null pokud není žádný východ do lokace s tímto názvem
     *
     */
    public Lokace getVychod(String nazevLokace) {
        for (Lokace lokace : vychody) {
            if (lokace.getNazev().equals(nazevLokace)) {
                return lokace;
            }
        }
        return null;
    }
    /**
     * Metoda co vrací předměty, které jsou v lokaci
     *
     */
    public List<Predmet> getPredmetyVLokaci() {
        return predmetyVLokaci;
    }
    /**
     * Metoda která vrací předměty v lokaci dané do stringu.
     *
     */
    public String stringPredmetuVLokaci() {
        StringBuilder predmety = new StringBuilder();
        for (Predmet predmet : predmetyVLokaci) {
            predmety.append(predmet.getNazev()).append(", ");
        }
        return predmety.toString();
    }
    /**
     * Metoda která vrací východy z lokace dané do stringu.
     *
     */
    public String stringVychodu() {
        StringBuilder vychodyString = new StringBuilder();
        for (Lokace v : vychody) {
            vychodyString.append(v.getNazev()).append(", ");
        }
        return vychodyString.toString();
    }
    /**
     * Metoda která vrací postavy v lokaci dané do stringu.
     *
     */
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
    /**
     * Metoda která vrací předměty, postavy a vychody jako string.
     * Toto se hráči objeví vždy při příchodu do nové místnosti.
     *
     */
    public String prohledaniMistnosti() {
        return  "Po prohledání místnosti jsi zjistil:\n" +
                "\n" +
                "Jsi v místnosti: " + this.getNazev() +
                "\nV místnosti jsou předměty: " + stringPredmetuVLokaci() +
                "\nMístnost má východy do: " + stringVychodu() +
                "\nV místnosti jsou postavy: " + stringPostav();
    }
    /**
     * Metoda která vrací String názvu lokace
     *
     */
    public String getNazev() {
        return nazev;
    }
    /**
     * Metoda která vrací List postav v lokaci.
     *
     */
    public List<Postava> getPostavyVLokaci() {
        return postavyVLokaci;
    }
    /**
     * Metoda equals, která porovnává dvě lokace
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lokace lokace = (Lokace) o;

        return Objects.equals(nazev, lokace.nazev);
    }
    /**
     * vracející kód, který má každý objekt v javě přiřazený. Tuto metodu musíme vždy překrýt při překrývání equals() metody
     *
     */
    @Override
    public int hashCode() {
        return nazev != null ? nazev.hashCode() : 0;
    }
}
