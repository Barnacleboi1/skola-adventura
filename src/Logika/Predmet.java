package Logika;

import java.io.Serializable;
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
    private boolean jeRozsvicena;
    private boolean jeBaterka;
    private boolean jeDrahokam;
    private boolean nelzeSebrat;
    private List<Predmet> drahokamy;


    //kontsruktor normálních předmětů

    public Predmet(String nazev) {
        this.nazev = nazev;
        if (nazev == "nahrdelnik"){
            this.drahokamy = new ArrayList<>();
        }
    }

    //konstruktor truhly
    public Predmet(String nazev, Predmet... drahokamy) {
        this(nazev);
        this.drahokamy = new ArrayList<>(Arrays.asList(drahokamy));

    }



    public void setJeBaterka(boolean jeBaterka) {
        this.jeBaterka = jeBaterka;
    }

    public void setJeDrahokam(boolean jeDrahokam) {
        this.jeDrahokam = jeDrahokam;
    }

    public void setNelzeSebrat(boolean nelzeSebrat) {
        this.nelzeSebrat = nelzeSebrat;
    }

    /**
     * Metoda která je volána příkazem pouzij. pokud je předmět paterka,
     * tak ji rozsvítí/zhasne, pokud je předmět drahokam, nasadí ho do náhrdelníku
     * metoda vrací string dle úspěšnsoti
     *
     *@param instance aktualni hry
     *@return String dle úspěšnosti
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
     * Metoda vracející boolean jestli jde předmět sebrat nebo ne
     * @return true jestli jde, false jestli ne
     */
    public boolean isNelzeSebrat() {
        return nelzeSebrat;
    }

    /**
     * Metoda vracející list drahokamů v náhrdelníku nebo truhle
     *
     *@return list drahokamů
     */
    public List<Predmet> getDrahokamy() {
        return drahokamy;
    }

    /**
     * Metoda vracející název předmětu
     *
     *@return nazev předmětu
     */
    public String getNazev() {
        return nazev;
    }



    /**
     * Metoda kotnrolující u předmětu baterky, jestli je rozsvícený (hodnota jeRozsvicena je true)
     *
     *@return boolean jestli je baterka rozsvícena
     */
    public boolean isRozsvicena() {
        return jeRozsvicena;
    }

    /**
     * Metoda, kterou se zrosvicí baterka. nastavuje hodnotu jeRozsvicena
     *
     *@param jestli je baterka rozsvícena
     */
    public void setJeRozsvicena(boolean jeRozsvicena) {
        this.jeRozsvicena = jeRozsvicena;
    }

    /**
     * Metoda pridávající drahokam, ať je to do náhrdelníku nebo do truhly
     *
     *@param predmět drahokamu, co cheme přidat
     */
    public void pridejDrahokam(Predmet drahokam) {
        drahokamy.add(drahokam);
    }

    /**
     * Metoda equals k porovnání dvou předmětů
     *
     *@param objektu, se kterým porovnáváme
     *@return boolean jestli se predmety rovnaji
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
     *@return kód
     */
    @Override
    public int hashCode() {
        return nazev != null ? nazev.hashCode() : 0;
    }
}