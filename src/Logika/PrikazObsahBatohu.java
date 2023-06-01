package Logika;


/**
 * Třída příkazu, který zobrazí hráči obsah jeho batohu.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazObsahBatohu implements PrikazInterface {
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
