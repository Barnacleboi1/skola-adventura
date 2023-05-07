package Logika;

import java.util.ArrayList;
import java.util.List;

public class HerniSvet
{
    private Lokace aktualniLokace;
    private List<Predmet> vsechnyPredmety = new ArrayList<>();
    public HerniSvet()
    {
        Predmet mobil = new Predmet("mobil", false);
        Predmet penezenka = new Predmet("penezenka", false);
        Predmet klice = new Predmet("klice", false);
        Predmet batoh = new Predmet("batoh", false);
        Predmet kartacek = new Predmet("kartacek", false);
        Predmet jidloProPsa = new Predmet("jidlo pro psa", false);


        vsechnyPredmety.add(mobil);
        vsechnyPredmety.add(penezenka);
        vsechnyPredmety.add(klice);
        vsechnyPredmety.add(batoh);
        vsechnyPredmety.add(kartacek);
        vsechnyPredmety.add(jidloProPsa);


        Lokace pokoj = new Lokace("pokoj", "Tady si se probudil, proto tu začíná celá hra", mobil, penezenka, batoh);
        Lokace chodba = new Lokace("chodba", "chodba u tebe doma");
        Lokace koupelna = new Lokace("koupelna", "koupelna", kartacek);
        Lokace kuchyne = new Lokace("kuchyne", "kuchyne", jidloProPsa);
        Lokace venku = new Lokace("venku", "venku");
        Lokace Louka = new Lokace("louka", "tady můžeš venčit");
        Lokace skola = new Lokace("skola", "sem chceš dojít");

        domek.pridejVychod(les);

        les.pridejVychod(domek);
        les.pridejVychod(temnyLes);

        temnyLes.pridejVychod(les);
        temnyLes.pridejVychod(jeskyne);
        temnyLes.pridejVychod(chaloupka);

        chaloupka.pridejVychod(temnyLes);

        aktualniLokace = domek;
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

