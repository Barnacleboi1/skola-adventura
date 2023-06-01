package Logika;



/**
 * Třída příkazu, kterým může hráč používat předměty v jeho inventáři.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazPouzij implements PrikazInterface {
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
        for (Predmet p : aktualniHra.getInventar().getObsahInventare()) {
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
