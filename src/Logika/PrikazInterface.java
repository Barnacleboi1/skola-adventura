package Logika;

public interface PrikazInterface {
    String getNazev();
    String proved(String[] parametry);
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
        return null;
    }
}
class PrikazVezmi implements PrikazInterface {

    private Hra aktualniHra;

    public PrikazVezmi(Hra aktualniHra) {
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
class PrikazPouzijPredmet implements PrikazInterface {
    private Hra aktualniHra;
    public PrikazPouzijPredmet(Hra aktualniHra) {
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
class PrikazZanechPredmet implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazZanechPredmet(Hra aktualniHra) {
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
