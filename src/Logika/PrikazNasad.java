package Logika;



/**
 * Třída příkazu, kterým si hráč nasazuje náhrdelník na "sebe"
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazNasad implements PrikazInterface {
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
