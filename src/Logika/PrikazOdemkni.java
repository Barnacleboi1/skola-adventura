package Logika;




/**
 * Třída příkazu, kterým může hráč odemykat truhly v jeho inventáři.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
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

        for (Predmet predmet : aktualniHra.getInventar().getObsahInventare()) {
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
                return "Otevřel si " + jmenoPredmetu + "\n"
                + "našel si v ní: " + stringDrahokamu;
            }
        }

    }
}
