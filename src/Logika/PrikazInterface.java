package Logika;

public interface PrikazInterface {
    public String getNazev();
    public String proved(String[] parametry);
}

class PrikazKonec implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazKonec(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "Konec";
    }

    @Override
    public String proved(String[] parametry) {
        aktualniHra.setHraSkoncila(true);
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
            return "Tomu nerozumim, musis mi rict kam jit";
        }
        if (parametry.length > 1) {
            return "Tomu nerozumím, muzu jit jen na jedno misto";
        }
        String nazevCilovaLokace = parametry[0];

        Lokace aktualniLokace = aktualniHra.getHerniSvet().getAktualniLokace();

        if (!aktualniLokace.maVychod(nazevCilovaLokace)) {
            return "do teto lokace se neda jit";
        }

        Lokace cilovaLokace = aktualniLokace.getVychod(nazevCilovaLokace);
        aktualniHra.getHerniSvet().setAktualniLokace(cilovaLokace);

        return "Jdeš" + cilovaLokace;
    }
}
