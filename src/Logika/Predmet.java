package Logika;

public class Predmet {
    private String nazev;
    private boolean bylSebran;
    private boolean jeNasazen;
    private boolean jeRozsvicena;
    private boolean jeDrahokam;

    //kontsruktor normálních předmětů

    public Predmet(String nazev, boolean bylSebran) {
        this.nazev = nazev;
        this.bylSebran = bylSebran;
    }

    //konstruktor náhrdelníku
    public Predmet(String nazev, boolean bylSebran, boolean jeNasazen) {
        this(nazev, bylSebran);
        this.jeNasazen = jeNasazen;
    }

    //kontruktor baterky
    public Predmet(boolean bylSebran, String nazev, boolean jeRozsvicena) {
        this(nazev, bylSebran);
        this.jeRozsvicena = jeRozsvicena;
    }

    //kontruktor drahokamů
    public Predmet(boolean jeDrahokam, boolean bylSebran, String nazev) {
        this(nazev, bylSebran);
        this.jeDrahokam = jeDrahokam;
    }
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isBylSebran() {
        return bylSebran;
    }

    public void setBylSebran(boolean bylSebran) {
        this.bylSebran = bylSebran;
    }

    public boolean isNasazen() {
        return jeNasazen;
    }

    public boolean isRozsvicena() {
        return jeRozsvicena;
    }
}
