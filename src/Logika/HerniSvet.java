package Logika;

import java.util.ArrayList;
import java.util.List;

public class HerniSvet
{
    private Lokace aktualniLokace;
    private List<Predmet> vsechnyPredmety = new ArrayList<>();
    public HerniSvet()
    {
        Predmet baterka = new Predmet(false, "baterka", false);
        Predmet dopis = new Predmet("dopis", false);
        Predmet batoh = new Predmet("batoh", false);
        Predmet nahrdelnik = new Predmet("nahrdelnik", false, false);
        Predmet klic = new Predmet("klic", false);
        Predmet zlataTruhla = new Predmet("zlata_truhla", false);

        Predmet rubín = new Predmet(true, false, "rubin");
        Predmet smaragd = new Predmet(true, false, "smaragd");
        Predmet safír = new Predmet(true, false, "safir");
        Predmet ametyst = new Predmet(true, false, "ametyst");


        vsechnyPredmety.add(baterka);
        vsechnyPredmety.add(dopis);
        vsechnyPredmety.add(batoh);
        vsechnyPredmety.add(nahrdelnik);
        vsechnyPredmety.add(klic);
        vsechnyPredmety.add(zlataTruhla);



        Lokace chodba = new Lokace("chodba", baterka, dopis, batoh);
        Lokace vychod = new Lokace("vychod");
        Lokace velkaHala = new Lokace("velka_hala", nahrdelnik);
        Lokace obetniMistnost = new Lokace("obetni_mistnost", zlataTruhla);
        Lokace faraonovaHrobka = new Lokace("faraonova_hrobka");
        Lokace sluzebnickaHrobka = new Lokace("sluzebnicka_hrobka", klic);

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

