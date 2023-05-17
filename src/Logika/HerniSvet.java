package Logika;

import java.util.ArrayList;
import java.util.List;

public class HerniSvet
{
    private Lokace aktualniLokace;
    private List<Predmet> vsechnyPredmety = new ArrayList<>();
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

        Predmet zlataTruhla = new Predmet("zlata_truhla", false, true, klic, safír, ametyst);

        Postava anubis = new Postava("anubis", "zdravím"
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

