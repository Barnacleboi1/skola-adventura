package Logika;



/**
 * Třída příkazu, kterým hráč může sbírav předměty, které jsou s ním v místnosti
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazVezmi implements PrikazInterface {

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
            return "Tomu nerozumím, musíš mi říct co mám vzít";
        }
        if (parametry.length > 1) {
            return "Tomu nerozumím, můžu vzít jen jednu věc.";
        }
        String predmet = parametry[0];
        Lokace aktualniLokace = aktualniHra.getHerniSvet().getAktualniLokace();
        for (Predmet predmet1 : aktualniLokace.getPredmetyVLokaci()) {
            if (predmet1.getNazev().equalsIgnoreCase(predmet)) {
                if (predmet1.isNelzeSebrat()) {
                    return "Tento předmět nelze vzít.";
                } else {
                    return aktualniHra.pridejPredmet(predmet1);
                }
            }
        }
        return "Takový předmět v lokaci není.";
    }
}
