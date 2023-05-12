package Logika;

import java.util.ArrayList;
import java.util.List;

public class HerniSvet
{
    private Lokace aktualniLokace;
    private List<Predmet> vsechnyPredmety = new ArrayList<>();
    public HerniSvet()
    {
        Predmet baterka = new Predmet("baterka", false);
        Predmet dopis = new Predmet("dopis", false);
        Predmet batoh = new Predmet("batoh", false);
        Predmet nahrdelnik = new Predmet("nahrdelnik", false, false);
        Predmet jidloProPsa = new Predmet("jidlo pro psa", false);


        vsechnyPredmety.add(baterka);
        vsechnyPredmety.add(dopis);
        vsechnyPredmety.add(batoh);
        vsechnyPredmety.add(nahrdelnik);



        Lokace chodba = new Lokace("chodba", "Tady si se probudil, začíná tu celá hra", baterka, dopis, batoh);
        Lokace vychod = new Lokace("vychod", "Východ z hrobky");
        Lokace velkaHala = new Lokace("velka_hala", "Velká hala, ze které jde vyjít ", nahrdelnik);
        Lokace obetniMistnost = new Lokace("obetni_mistnost", "Místnost s obětmi pro faraona", jidloProPsa);
        Lokace faraonovaHrobka = new Lokace("faraonova_hrobka", "Hrobka faraona");
        Lokace sluzebnickaHrobka = new Lokace("sluzebnicka_hrobka", "Hrobka služemních, kteří se nechali pohřbít s faraonem");

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

    public Lokace getAktualniLokace()
    {
        return aktualniLokace;
    }

    public void setAktualniLokace(Lokace aktualniLokace)
    {
        this.aktualniLokace = aktualniLokace;
    }

    public List<Predmet> getVsechnyPredmety() {
        return vsechnyPredmety;
    }

    public void setVsechnyPredmety(List<Predmet> vsechnyPredmety) {
        this.vsechnyPredmety = vsechnyPredmety;
    }
}

