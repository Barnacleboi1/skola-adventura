package Logika;



/**
 * Třída příkazu, který umožňuje hráči komunikaci s postavami ve stejné lokaci
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazMluv implements PrikazInterface {
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
