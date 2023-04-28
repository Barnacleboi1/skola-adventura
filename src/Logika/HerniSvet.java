package Logika;

public class HerniSvet
{
    private Lokace aktualniLokace;

    public HerniSvet()
    {
        Lokace domek = new Lokace("domek", "Tady bydlíš, proto tu začíná celá hra.");
        Lokace les = new Lokace("les", "Rostou tady houby.");
        Lokace temnyLes = new Lokace("temnoles", "Říká se, že tady můžeš potkat vlka.");
        Lokace jeskyne = new Lokace("jeskyne", "Nikdo se odsud nikdy nevrátil.");
        Lokace chaloupka = new Lokace("chaloupka", "Tady bydlí babička.");

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
}

