package Logika;



/**
 * Třída příkazu, kterým hráč zanechává předmět v aktuální lokaci
 *
 */
public class PrikazPoloz implements PrikazInterface {

    private Hra aktualniHra;

    public PrikazPoloz(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "poloz";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musíš říct, co za předmět chceš položit.";
        }
        if (parametry.length == 2) {
            return "Můžeš položit jen jeden předmět najednou.";
        }
        String jmenoPredmetu = parametry[0];
        Predmet predmetKPolozeni = null;
        for (Predmet predmet : aktualniHra.getInventar().getObsahInventare()) {
            if (predmet.getNazev().equals(jmenoPredmetu)) {
                predmetKPolozeni = predmet;
            }
        }
        if (predmetKPolozeni == null) {
            return "Takový předmět nemáš v inventáři";
        }
        if (predmetKPolozeni.getNazev().equals("batoh")) {
            return "Batoh nemůžeš položit";
        }
        aktualniHra.odeberPredmet(predmetKPolozeni);
        aktualniHra.getHerniSvet().getAktualniLokace().pridejPredmet(predmetKPolozeni);
        return "Položil si " + predmetKPolozeni.getNazev() + " v lokaci: " + aktualniHra.getHerniSvet().getAktualniLokace().getNazev();
    }
}
