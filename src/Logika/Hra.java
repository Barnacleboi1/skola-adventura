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
    private Inventar inventar;
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

        inventar = new Inventar();

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
        prikazy.add(new PrikazKonec(this));
    }

    /**
     * Metoda, která zpracovává vstupy uživatele a určuje,
     * jaký příkaz hodlá použít a volá metodu  "proved" daneho příkazu
     *
     *@param vstupu uzivatele
     *@return provedení příkazu
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
     * 
     * @return aktuální instanci herního světa
     */
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }



    /**
     * Metoda odebírající předmět z inventáře hráče
     *
     *@param predmet k odebrání
     */
    public void odeberPredmet(Predmet predmet) {
        inventar.odeberPredmet(predmet);
    }

    /**
     * Metoda přidávájící předmět do inventáře hráče, kontroluje,
     * jestli má hráč batoh (pomocí metohdy maBatoh()) a jestli má na předmět místo. metoda vrací string,
     * který oznamuje jestli byl předmět úspěšně sebrán nebo ne
     *
     *@param predmet k přidání
     *@return string jestli ho vzal
     */
    public String pridejPredmet(Predmet predmet) {

        if (inventar.pridejPredmet(predmet)) {
            herniSvet.getAktualniLokace().odeberpredmet(predmet);
            return "Vzal si " + predmet.getNazev();
        }
        return "Na předmět nemáš místo.";
    }

    /**
     * Metoda vracející String se všemi předměty, co hráč má v batohu
     *
     *@return string obsahu batohu
     */
    public String obsahBatohu() {
        StringBuilder batohString = new StringBuilder();
        for (Predmet predmet : inventar.getObsahInventare()) {
            if (!predmet.getNazev().equals("batoh")) {
                batohString.append(predmet.getNazev()).append(", ");
            }
        }
        if (batohString.length() == 0) {
            return "V batohu nemáš žádné předměty";
        }
        
        return "Obsah batohu: " + batohString.substring(0, batohString.length() - 2);
    }

    /**
     * Metoda, která vrací true, když hra skončila, false jestli ne
     *
     *@return boolean jestli hra skoncila
     */
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    /**
     * Metoda nastaví hodnotu hraSkoncila. Metodu voláme pokud hráč došel do poslední místnosti
     * se všemi potřebnými drahokamy a nasazeným náhrdelníkem
     *
     *@param boolean jestli hra skoncila
     */
    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }

    /**
     * Metoda vracející string, který uvítává hru a také informace o první místnosti.
     *
     *@return prolog hry a informace o místnosti
     */
    public String getProlog() {
        return "Probouzíš se v chodbě staré egyptské hrobky. Všude kolem je tma." + "\n"
        + herniSvet.getAktualniLokace().prohledaniMistnosti();
    }

    /**
     * Metoda vracející String, který hru zakončuje.
     *
     *@return epilog hry
     */
    public String getEpilog() {
        return "Po vstupu do místnosti vidíš, že se otevírá východ z hrobky. Tím tvá noční můra končí.";
    }

    /**
     * Metoda, která určuje jestli je dpost drahokamu, aby mohl hráč vyhrát.
     *
     *@return boolean jestli má hráč dost drahokamu na odchod
     */
    public boolean jeDostDrahokamu() {
        return nahrdelnik.getDrahokamy().size() == 4;
    }

    /**
     * Metoda vracející inventář
     *
     *@return inventář
     */
    public Inventar getInventar() {
        return inventar;
    }

    /**
     * Metoda, která je použita při nasazování náhrdelníku.
     * kontroluje jestli má hrář náhrdelník v inventáři
     * a pokud ano, nastavuje hodnotu nahrdelnikNasazen na true a vrací string co potvrzuje, že si ho nasadil
     * pokud ne tak vrací string, který oznamuje že hráč nemá náhrdelník
     *
     *@return string podle úspěšnosti
     */
    public String nasazeniNahrdelniku() {
        boolean jeVBatohu = false;
        Predmet nahr = null;
        for (Predmet predmet : inventar.getObsahInventare()) {
            if (predmet.getNazev().equalsIgnoreCase("nahrdelnik")) {
                jeVBatohu = true;
                nahr = predmet;
            }
        }
        if (jeVBatohu) {
            setNahrdelnikNasazen(true);
            nahrdelnik = nahr;
            inventar.getObsahInventare().remove(nahr);
            return "Nasadil sis nahrdelnik.";
        }
        else {
            return "Náhrdelník nemáš v batohu.";
        }
    }

    /**
     * Metoda vracející true, jestli je hodnota nahrdelnikNasazen true a false jestli je false
     *
     *@return boolean jestli je nahrdelnik nasazen
     */
    public boolean isNahrdelnikNasazen() {
        return nahrdelnikNasazen;
    }

    /**
     * Metoda nastavující hodnotu nahrdelnikNasazen
     *
     * @param jestli je nahrdelnik nasazen
     */
    public void setNahrdelnikNasazen(boolean nahrdelnikNasazen) {
        this.nahrdelnikNasazen = nahrdelnikNasazen;
    }

    /**
     * Metoda vracejicí instanci předmětu náhrdelník
     *
     *@return predmet nahrdelnik
     */
    public Predmet getNahrdelnik() {
        return nahrdelnik;
    }

    /**
     * Metoda vracející String napovedy
     *
     *@return string napovedy
     */
    public String napoveda() {
        StringBuilder prikaz = new StringBuilder();
        for (PrikazInterface prikazInterface : prikazy) {
            prikaz.append("\t\t").append(prikazInterface.getNazev()).append("\n");
        }
        return "Tvým úkolem je dostat se z hrobky. Abys toto mohl splnit,\n" +
        "                tak je potřeba posbírat všechny potřebné drahokamy a nasadit je na náhrdelník.\n" +
        "                Po příchodu do místnosti východ s nasazeným náhrdelníkem se ti otevře východ a hra skončí.\n" +
        "                Použitelné příkazy:\n" + prikaz;
    }
}
