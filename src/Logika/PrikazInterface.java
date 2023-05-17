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
        return "nasad";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length != 0) {
            return "Tento příkaz nemá žádne parametry.";
        }
        return aktualniHra.nasazeniNahrdelniku();
    }
}

class PrikazNapoveda implements  PrikazInterface {
    private Hra aktualniHra;

    public PrikazNapoveda(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public String proved(String[] parametry) {
        return aktualniHra.napoveda();
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
        boolean jeRozsvicena = false;

        for (Predmet predmet : aktualniHra.getInventar()) {
            if (predmet.getNazev().equalsIgnoreCase("baterka")) {
                maBaterku = true;
                jeRozsvicena = predmet.isRozsvicena();
                break;
            }
            else {
                maBaterku = false;
            }
        }
        if (!maBaterku) {
            return "Všude je tma, potřebuješ baterku.";
        }
        if (!jeRozsvicena) {
            return "Baterku musíš také rozsvítit!";
        }

        Lokace cilovaLokace = aktualniLokace.getVychod(nazevCilovaLokace);
        aktualniHra.getHerniSvet().setAktualniLokace(cilovaLokace);
        if (aktualniHra.getNahrdelnik() != null) {
            if (aktualniHra.jeDostDrahokamu() && nazevCilovaLokace.equals("vychod")) {
                aktualniHra.setHraSkoncila(true);
                return aktualniHra.getEpilog();
            }
        }
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
            if (predmet1.getNazev().equalsIgnoreCase(predmet)) {
                return aktualniHra.pridejPredmet(predmet1);
            }
        }
        return "Takový předmět v lokaci není.";
    }
}
class PrikazObsahBatohu implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazObsahBatohu(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "batoh";
    }

    @Override
    public String proved(String[] parametry) {
        return aktualniHra.obsahBatohu();
    }
}
class PrikazPouzij implements PrikazInterface {
    private Hra aktualniHra;
    public PrikazPouzij(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }
    @Override
    public String getNazev() {
        return "pouzij";
    }
    @Override
    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musíš říct, co chceš použít";
        }
        if (parametry.length == 2) {
            return "Můžeš použít jeden předmět najednou.";
        }
        String jmenoPredmetu = parametry[0];
        Predmet predmet = null;
        for (Predmet p : aktualniHra.getInventar()) {
            if (p.getNazev().equalsIgnoreCase(jmenoPredmetu)) {
                predmet = p;
            }
        }
        if (predmet == null) {
            return "Tento předmět nemáš v inventáři.";
        }
        return predmet.pouzij(aktualniHra);
    }
}
class PrikazOdemkni implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazOdemkni(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "odemkni";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musíš říct, co chceš odemknout.";
        }
        if (parametry.length == 2) {
            return "Můžeš odemknout jednu truhlu najednou.";
        }
        Predmet truhla = null;
        Predmet klíč = null;
        boolean máKlíč = false;
        String jmenoPredmetu = parametry[0];
        StringBuilder stringDrahokamu = new StringBuilder();


        for (Predmet predmet : aktualniHra.getInventar()) {
            if (predmet.getNazev().equalsIgnoreCase(jmenoPredmetu)) {
                truhla = predmet;
            }
            if (predmet.getNazev().equals("klic")) {
                klíč = predmet;
                máKlíč = true;
            }
        }
        if (truhla == null) {
            return "Takovou truhlu nemáš v batohu.";
        }
        else {
            if (!máKlíč) {
                return "K této truhle nemáš klíč";
            }
            else {
                for (Predmet drahokam : truhla.getDrahokamy()) {
                    aktualniHra.pridejPredmet(drahokam);
                    stringDrahokamu.append(drahokam.getNazev()).append(", ");
                }
                aktualniHra.odeberPredmet(klíč);
                aktualniHra.odeberPredmet(truhla);
                return "Otevřel si" + jmenoPredmetu + "\n"
                        + "našel si v ní: " + stringDrahokamu;
            }
        }

    }
}
class PrikazMluv implements PrikazInterface {
    private Hra aktualniHra;

    public PrikazMluv(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musíš říct, na koho chceš mluvit";
        }
        if (parametry.length == 2) {
            return "Můžeš mluvit jen na jednoho člověka najednou.";
        }
        Postava postava = null;
        String jmenoPostavy = parametry[0];
        for (Postava p : aktualniHra.getHerniSvet().getAktualniLokace().getPostavyVLokaci()) {
            if (jmenoPostavy.equalsIgnoreCase(p.getJmeno())) {
                postava = p;
            }
        }
        if (postava == null) {
            return "Taková postava v této lokaci není.";
        }
        return postava.promluva();
    }
}

