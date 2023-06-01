package Logika;

/**
 * Třída příkazu, kterým může hráč hru kdykoli ukončint a vypnout.
 * 
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazKonec implements PrikazInterface {

    private Hra aktualniHra;

    public PrikazKonec(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    @Override
    public String getNazev() {
        return "konec";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length != 0) {
            return "Tento příkaz nepřijímá žádné parametry!";
        } 
        else {
            aktualniHra.setHraSkoncila(true);
            return "Děkuji za hraní!";
        }  
    }
}
