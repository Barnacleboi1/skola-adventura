package Logika;

import java.util.*;

/**
 * Třída Hry. uchovává odkaz na instanci třídy HerniSvet, představující mapu.
 * Také uchovává hráčův inventář, boolan zda hra skončila, kolekci použitelných příkazů a
 * také uchovává atributy nahrdelnikNasazen a nahrdelnik, které jsou potřebné pro naši hru
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public class Hra {
    private HerniSvet herniSvet;
    private List<Predmet> inventar;
    private boolean hraSkoncila;
    private Set<PrikazInterface> prikazy;
    private boolean nahrdelnikNasazen;
    private Predmet nahrdelnik;
    /**
     * Konstruktor hry,vytvoří nový herní svět, inventář a množinu příkazů, které může hráč použít
     *
     */
    public Hra() {
        herniSvet = new HerniSvet();
        hraSkoncila = false;
        nahrdelnikNasazen = false;
        nahrdelnik = null;

        inventar = new ArrayList<>();

        prikazy = new HashSet<>();
        prikazy.add(new PrikazNasad(this));
        prikazy.add(new PrikazNapoveda(this));
        prikazy.add(new PrikazJdi(this));
        // prikazy.add(new PrikazProhledej(this));
        prikazy.add(new PrikazVezmi(this));
        prikazy.add(new PrikazObsahBatohu(this));
        prikazy.add(new PrikazPouzij(this));
        prikazy.add(new PrikazOdemkni(this));
        prikazy.add(new PrikazMluv(this));
        prikazy.add(new PrikazPoloz(this));
    }
    /**
     * Metoda, která zpracovává vstupy uživatele a určuje,
     * jaký příkaz hodlá použít a volá metodu  "proved" daneho příkazu
     *
     */
    public String zpracujPrikaz(String vstupUzivatele) {
        String[] array = vstupUzivatele.split(" ");
        String prikaz = array[0];

        for (PrikazInterface p : prikazy) {
            if (prikaz.equalsIgnoreCase(p.getNazev())){
                return p.proved(Arrays.copyOfRange(array, 1, array.length));
            }
        }

        return "Příkaz " + prikaz + " neznám.";
    }
    /**
     * Metoda, která vrací herní svět
     */
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }
    /**
     * Metoda, která určuje, jestli hráč sebral batoh.
     * vrací true pokud má batoh, jako instance classy Predmet, boolean bylSebran = true, pokud ne tak false
     *
     */
    public boolean maBatoh() {
        for (Predmet predmet : herniSvet.getVsechnyPredmety()) {
            if (predmet.getNazev().equals("batoh")) {
                return predmet.isBylSebran();
            }
        }
        return false;
    }
    /**
     * Metoda odebírající předmět z inventáře hráče
     *
     */
    public void odeberPredmet(Predmet predmet) {
        predmet.setBylSebran(false);
        inventar.remove(predmet);
    }
    /**
     * Metoda přidávájící předmět do inventáře hráče, kontroluje,
     * jestli má hráč batoh (pomocí metohdy maBatoh()) a jestli má na předmět místo. metoda vrací string,
     * který oznamuje jestli byl předmět úspěšně sebrán nebo ne
     *
     */
    public String pridejPredmet(Predmet predmet) {
        int kapacita;
        if (maBatoh()) {
            kapacita = 20;
        }
        else {
            kapacita = 3;
        }
        if (inventar.size() < kapacita) {
            inventar.add(predmet);
            predmet.setBylSebran(true);
            herniSvet.getAktualniLokace().odeberpredmet(predmet);
            return "Vzal si " + predmet.getNazev();
        }
        return "Na předmět nemáš místo, možná by se hodil nějaký batoh.";
    }
    /**
     * Metoda vracející String se všemi předměty, co hráč má v batohu
     *
     */
    public String obsahBatohu() {
        StringBuilder batohString = new StringBuilder();
        for (Predmet predmet : inventar) {
            if (!predmet.getNazev().equals("batoh")) {
                batohString.append(predmet.getNazev()).append(", ");
            }
        }
        return "Obsah batohu: " + batohString;
    }
    /**
     * Metoda, která vrací true, když hra skončila, false jestli ne
     *
     */
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }
    /**
     * Metoda nastaví hodnotu hraSkoncila. Metodu voláme pokud hráč došel do poslední místnosti
     * se všemi potřebnými drahokamy a nasazeným náhrdelníkem
     *
     */
    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }
    /**
     * Metoda vracející string, který uvítává hru a také informace o první místnosti.
     *
     */
    public String getProlog() {
        return "Probouzíš se v chodbě staré egyptské hrobky. Všude kolem je tma." + "\n"
                + herniSvet.getAktualniLokace().prohledaniMistnosti();
    }
    /**
     * Metoda vracející String, který hru zakončuje.
     *
     */
    public String getEpilog() {
        return "Po vstupu do místnosti vidíš, že se otevírá východ z hrobky. Tím tvá noční můra končí.";
    }
    /**
     * Metoda, která určuje jestli je dpost drahokamu, aby mohl hráč vyhrát.
     *
     */
    public boolean jeDostDrahokamu() {
        return nahrdelnik.getDrahokamy().size() == 4;
    }
    /**
     * Metoda vracející inventář
     *
     */
    public List<Predmet> getInventar() {
        return inventar;
    }
    /**
     * Metoda, která je použita při nasazování náhrdelníku.
     * kontroluje jestli má hrář náhrdelník v inventáři
     * a pokud ano, nastavuje hodnotu nahrdelnikNasazen na true a vrací string co potvrzuje, že si ho nasadil
     * pokud ne tak vrací string, který oznamuje že hráč nemá náhrdelník
     *
     */
    public String nasazeniNahrdelniku() {
        boolean jeVBatohu = false;
        Predmet nahr = null;
        for (Predmet predmet : inventar) {
            if (predmet.getNazev().equalsIgnoreCase("nahrdelnik")) {
                jeVBatohu = true;
                nahr = predmet;
            }
        }
        if (jeVBatohu) {
            setNahrdelnikNasazen(true);
            nahrdelnik = nahr;
            inventar.remove(nahr);
            return "Nasadil sis nahrdelnik.";
        }
        else {
            return "Náhrdelník nemáš v batohu.";
        }
    }
    /**
     * Metoda vracející true, jestli je hodnota nahrdelnikNasazen true a false jestli je false
     *
     */
    public boolean isNahrdelnikNasazen() {
        return nahrdelnikNasazen;
    }
    /**
     * Metoda nastavující hodnotu nahrdelnikNasazen
     *
     */
    public void setNahrdelnikNasazen(boolean nahrdelnikNasazen) {
        this.nahrdelnikNasazen = nahrdelnikNasazen;
    }
    /**
     * Metoda vracejicí instanci předmětu náhrdelník
     *
     */
    public Predmet getNahrdelnik() {
        return nahrdelnik;
    }
    /**
     * Metoda vracející Strin napovedy
     *
     */
    public String napoveda() {
        return """
                Tvým úkolem je dostat se z hrobky. Abys toto mohl splnit,
                tak je potřeba posbírat všechny potřebné drahokamy a nasadit je na náhrdelník.
                Po příchodu do místnosti východ s nasazeným náhrdelníkem se ti otevře východ a hra skončí.
                Použitelné příkazy:
                nasad
                napoveda
                jdi
                vezmi
                batoh
                pouzij
                odemkni
                mluv
                poloz""";
    }
}
