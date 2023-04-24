package Logika;

public class HerniSvet {
    private Lokace aktualniLokace;

    public HerniSvet() {
        Lokace domek = new Lokace("domek", "tady bydlis");

        //pridat lokace a pridat do nich vychody, kam z lokace muze hrac jit
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }
}
