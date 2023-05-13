package Logika;

public interface PrikazInterface {
    String getNazev();
    String proved(String[] parametry);
}

class PrikazNasad implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazNasad(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "Konec";
    }

    @Override
    public String proved(String[] parametry) {

        return "hra byla ukonecna";
    }
}

class PrikazNapoveda implements  PrikazInterface {

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public String proved(String[] parametry) {
        return "Dostanes napovedu";
    }
}
class PrikazJdi implements  PrikazInterface {
    private Hra aktualniHra;

    public PrikazJdi(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "jdi";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 1) {
            return "Tomu nerozumím, musíš mi říct kam jít";
        }
        if (parametry.length > 1) {
            return "Tomu nerozumím, muzu jit jen na jedno misto. Název místnosti s tímto příkazem zadávej s podtržítkem místo mezery.";
        }
        String nazevCilovaLokace = parametry[0];

        Lokace aktualniLokace = aktualniHra.getHerniSvet().getAktualniLokace();

        if (!aktualniLokace.maVychod(nazevCilovaLokace)) {
            return "do teto lokace se neda jit";
        }
        boolean maBaterku = false;
        for (Predmet predmet : aktualniHra.getInventar()) {
            if (predmet.getNazev().equals("baterka")) {
                maBaterku = true;
                break;
            }
            else {
                maBaterku = false;
            }
        }
        if (!maBaterku) {
            return "Všude je tma, potřebuješ baterku.";
        }

        Lokace cilovaLokace = aktualniLokace.getVychod(nazevCilovaLokace);
        aktualniHra.getHerniSvet().setAktualniLokace(cilovaLokace);

        return "Jdeš do " + cilovaLokace.getNazev();
    }
}
class PrikazProhledej implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazProhledej(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "prohledej";
    }

    @Override
    public String proved(String[] parametry) {
        Lokace aktualniLokace = aktualniHra.getHerniSvet().getAktualniLokace();
        return aktualniLokace.prohledaniMistnosti();
    }
}
class PrikazVezmi implements PrikazInterface {

    private Hra aktualniHra;

    public PrikazVezmi(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "vezmi";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 1) {
            return "Tomu nerozumím, musíš mi říct co mám vzíz";
        }
        if (parametry.length > 1) {
            return "Tomu nerozumím, můžu vzít jen jednu věc.";
        }
        String predmet = parametry[0];
        Lokace aktualniLokace = aktualniHra.getHerniSvet().getAktualniLokace();
        for (Predmet predmet1 : aktualniLokace.getPredmetyVLokaci()) {
            if (predmet1.getNazev().equals(predmet)) {
                predmet1.setBylSebran(true);
                aktualniLokace.odeberpredmet(predmet1);
                return aktualniHra.pridejPredmet(predmet1);
            }
        }
        return "Takový předmět v lokaci není.";
    }
}
class PrikazObsahBatohu implements PrikazInterface {
    Hra aktualniHra;

    public PrikazObsahBatohu(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return null;
    }

    @Override
    public String proved(String[] parametry) {
        return null;
    }
}
class PrikazPouzij implements PrikazInterface {
    private Hra aktualniHra;
    public PrikazPouzij(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }
    @Override
    public String getNazev() {
        return null;
    }
    @Override
    public String proved(String[] parametry) {
        return null;
    }
}

