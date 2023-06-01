package Logika;


/**
 * Třída příkazu, který zobrazí hráči cíl hry a možné příkazy.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class PrikazNapoveda implements  PrikazInterface {
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
