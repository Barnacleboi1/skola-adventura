package Logika;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída představující mapu lokací herního světa. V datovém atributu
 * aktualniLokace uchovává aktuální lokaci ve hře. V datovém atributu vsechnyPredmety
 * jsou uchovávány všechny předměty po celé hře.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */


public class HerniSvet
{
    private Lokace aktualniLokace;
    private List<Predmet> vsechnyPredmety = new ArrayList<>();
    /**
     * Konstruktor herního světa, vytváří všechny předměty, lokace, postavy a zadává všechny východy a také stratující lokaci.
     *
     */
    public HerniSvet()
    {
        Predmet baterka = new Predmet(false, "baterka", true);

        Predmet batoh = new Predmet("batoh", false);
        Predmet klic = new Predmet("klic", false);

        Predmet nahrdelnik = new Predmet("nahrdelnik", false, false);

        Predmet rubín = new Predmet(true, false, "rubin");
        Predmet smaragd = new Predmet(true, false, "smaragd");
        Predmet safír = new Predmet(true, false, "safir");
        Predmet ametyst = new Predmet(true, false, "ametyst");

        Predmet zlataTruhla = new Predmet("zlata_truhla", false, klic, safír, ametyst);

        Postava anubis = new Postava("Anubis", "zdravím"
                , "vypadáš ztraceně"
                , "aby se ti otevřel východ, musíš mít nasazený náhrdelník se čtyřmi drahokamy");

        Lokace chodba = new Lokace("chodba", baterka, batoh);
        Lokace vychod = new Lokace("vychod");
        Lokace velkaHala = new Lokace("velka_hala", nahrdelnik);
        Lokace obetniMistnost = new Lokace("obetni_mistnost", zlataTruhla);
        Lokace faraonovaHrobka = new Lokace("faraonova_hrobka", rubín, smaragd);
        Lokace sluzebnickaHrobka = new Lokace("sluzebnicka_hrobka", klic);

        velkaHala.pridejPostavu(anubis);

        vsechnyPredmety.add(baterka);
        vsechnyPredmety.add(batoh);
        vsechnyPredmety.add(nahrdelnik);
        vsechnyPredmety.add(klic);
        vsechnyPredmety.add(zlataTruhla);

        chodba.pridejVychod(vychod);
        chodba.pridejVychod(velkaHala);

        vychod.pridejVychod(chodba);

        velkaHala.pridejVychod(chodba);
        velkaHala.pridejVychod(obetniMistnost);
        velkaHala.pridejVychod(faraonovaHrobka);
        velkaHala.pridejVychod(sluzebnickaHrobka);

        sluzebnickaHrobka.pridejVychod(velkaHala);

        faraonovaHrobka.pridejVychod(velkaHala);

        obetniMistnost.pridejVychod(velkaHala);


        aktualniLokace = chodba;
    }
    /**
     * Metoda vracející aktuální lokaci, kde se hráč zrovna nachází
     *
     */
    public Lokace getAktualniLokace()
    {
        return aktualniLokace;
    }
    /**
     * Metoda nastavujéící aktuální lokaci hráče
     *
     */
    public void setAktualniLokace(Lokace aktualniLokace)
    {
        this.aktualniLokace = aktualniLokace;
    }
    /**
     * Metoda vracející všechny předměty na mapě
     *
     */
    public List<Predmet> getVsechnyPredmety() {
        return vsechnyPredmety;
    }

}

