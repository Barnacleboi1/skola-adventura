package Logika;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Třída představující předměty vyskytujíci se ve hře.
 * Atributy jsou název a poté několik boolean,
 * které určují jaký typ předmětu to je, a nebo jestli byl použit nebo sebrán.
 * Také se u určitých typů předmětu ukládá i seznam drahokamů, nebo i klič, kterým předmět jde odemknout.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */

public class Predmet {
    private String nazev;
    private boolean bylSebran;
    private boolean jeNahrdelnik;
    private boolean jeRozsvicena;
    private boolean jeBaterka;
    private boolean jeDrahokam;
    private List<Predmet> drahokamy;
    private Predmet klíč;

    //kontsruktor normálních předmětů

    public Predmet(String nazev, boolean bylSebran) {
        this.nazev = nazev;
        this.bylSebran = bylSebran;
    }

    //konstruktor náhrdelníku
    public Predmet(String nazev, boolean bylSebran, boolean jeNahrdelnik) {
        this(nazev, bylSebran);
        this.jeNahrdelnik = jeNahrdelnik;
        this.drahokamy = new ArrayList<>();
    }

    //kontruktor baterky
    public Predmet(boolean bylSebran, String nazev, boolean jeBaterka) {
        this(nazev, bylSebran);
        this.jeBaterka = jeBaterka;
        this.jeRozsvicena = false;
    }
    //konstruktor truhly
    public Predmet(String nazev, boolean bylSebran, Predmet klíč, Predmet... drahokamy) {
        this(nazev, bylSebran);
        this.drahokamy = new ArrayList<>(Arrays.asList(drahokamy));
        this.klíč = klíč;
    }

    //kontruktor drahokamů
    public Predmet(boolean jeDrahokam, boolean bylSebran, String nazev) {
        this(nazev, bylSebran);
        this.jeDrahokam = jeDrahokam;
    }
    /**
     * Metoda která je volána příkazem pouzij. pokud je předmět paterka,
     * tak ji rozsvítí/zhasne, pokud je předmět drahokam, nasadí ho do náhrdelníku
     * metoda vrací string dle úspěšnsoti
     *
     */
    public String pouzij(Hra aktualniHra) {
        if (jeBaterka) {
            if (!jeRozsvicena) {
                setJeRozsvicena(true);
                return "Rozsvítil si baterku.";
            }
            else {
                setJeRozsvicena(false);
                return "Zhasl si baterku";
            }
        }
        if (jeDrahokam) {
            if (aktualniHra.isNahrdelnikNasazen()) {
                aktualniHra.getNahrdelnik().pridejDrahokam(this);
                aktualniHra.odeberPredmet(this);
                return "Nasadil si drahokam do náhrdelníku.";
            }
            else {
                return "Nejdřív musíš nasadit náhrdelník, abys do něj mohl dávat drahokamy.";
            }
        }
        return "Tento předmět se nedá nijak použít.";
    }
    /**
     * Metoda vracející list drahokamů v náhrdelníku nebo truhle
     *
     */
    public List<Predmet> getDrahokamy() {
        return drahokamy;
    }
    /**
     * Metoda vracející název předmětu
     *
     */
    public String getNazev() {
        return nazev;
    }
    /**
     * Metoda vracející, jestli byl předmět sebrán
     *
     */
    public boolean isBylSebran() {
        return bylSebran;
    }
    /**
     * Metoda která nastavuje hodnotu bylSebran
     *
     */
    public void setBylSebran(boolean bylSebran) {
        this.bylSebran = bylSebran;
    }
    /**
     * Metoda kotnrolující u předmětu baterky, jestli je rozsvícený (hodnota jeRozsvicena je true)
     *
     */
    public boolean isRozsvicena() {
        return jeRozsvicena;
    }
    /**
     * Metoda, kterou se zrosvicí baterka. nastavuje hodnotu jeRozsvicena
     *
     */
    public void setJeRozsvicena(boolean jeRozsvicena) {
        this.jeRozsvicena = jeRozsvicena;
    }
    /**
     * Metoda pridávající drahokam, ať je to do náhrdelníku nebo do truhly
     *
     */
    public void pridejDrahokam(Predmet drahokam) {
        drahokamy.add(drahokam);
    }
    /**
     * Metoda equals k porovnání dvou předmětů
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Predmet predmet = (Predmet) o;

        return Objects.equals(nazev, predmet.nazev);
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
