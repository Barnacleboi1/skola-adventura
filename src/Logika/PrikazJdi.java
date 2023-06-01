package Logika;


/**
 * Třída příkazu, který umožňuje hráči pohyb mezi lokacemi. Po vstupu do lokace se vypíší i informace o lokaci.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazJdi implements  PrikazInterface {
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

        for (Predmet predmet : aktualniHra.getInventar().getObsahInventare()) {
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
            return "Baterku musíš rozsvítit!";
        }

        Lokace cilovaLokace = aktualniLokace.getVychod(nazevCilovaLokace);
        aktualniHra.getHerniSvet().setAktualniLokace(cilovaLokace);
        if (aktualniHra.getNahrdelnik() != null && aktualniHra.jeDostDrahokamu() && nazevCilovaLokace.equals("vychod")) {
            aktualniHra.setHraSkoncila(true);
            return aktualniHra.getEpilog();
        }
        return "Jdeš do " + cilovaLokace.getNazev() + "\n"
        + cilovaLokace.prohledaniMistnosti();
    }
}
