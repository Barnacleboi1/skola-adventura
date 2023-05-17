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
        prikazy.add(new PrikazProhledej(this));
        prikazy.add(new PrikazVezmi(this));
        prikazy.add(new PrikazObsahBatohu(this));
        prikazy.add(new PrikazPouzij(this));
        prikazy.add(new PrikazOdemkni(this));
        prikazy.add(new PrikazMluv(this));
    }
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
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }
    public boolean maBatoh() {
        for (Predmet predmet : herniSvet.getVsechnyPredmety()) {
            if (predmet.getNazev().equals("batoh")) {
                return predmet.isBylSebran();
            }
        }
        return false;
    }
    public void odeberPredmet(Predmet predmet) {
        inventar.remove(predmet);
    }
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
    public String obsahBatohu() {
        StringBuilder batohString = new StringBuilder();
        for (Predmet predmet : inventar) {
            if (!predmet.getNazev().equals("batoh")) {
                batohString.append(predmet.getNazev()).append(", ");
            }
        }
        return "Obsah batohu: " + batohString;
    }
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }
    public String getProlog() {
        return "Probouzíš se v chodbě staré egyptské hrobky. Všude kolem je tma.";
    }

    public String getEpilog() {
        return "Po vstupu do místnosti vidíš, že se otevírá východ z hrobky. Tím tvá noční můra končí.";
    }
    public boolean jeDostDrahokamu() {
        return nahrdelnik.getDrahokamy().size() == 4;
    }
    public List<Predmet> getInventar() {
        return inventar;
    }
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
    public boolean isNahrdelnikNasazen() {
        return nahrdelnikNasazen;
    }

    public void setNahrdelnikNasazen(boolean nahrdelnikNasazen) {
        this.nahrdelnikNasazen = nahrdelnikNasazen;
    }

    public Predmet getNahrdelnik() {
        return nahrdelnik;
    }

    public String napoveda() {
        return """
                Tvým úkolem je dostat se s hrobky. Abys toto mohl splnit,
                tak je potřeba posbírat všechny potřebné drahokamy a nasadit je na náhrdelník.
                Po příchodu do místnosti východ s nasazeným náhrdelníkem se ti otevře východ a hra skončí.
                Použitelné příkazy:
                nasad
                napoveda
                jdi
                prohledej
                vezmi
                batoh
                pouzij
                odemkni
                mluv""";
    }
}
