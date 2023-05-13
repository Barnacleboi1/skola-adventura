package Logika;

public class Predmet {
    private String nazev;
    private boolean bylSebran;
    private boolean nasazen;

    //kontsruktor normálních předmětů

    public Predmet(String nazev, boolean bylSebran) {
        this.nazev = nazev;
        this.bylSebran = bylSebran;
    }

    //konstruktor náhrdelníku
    public Predmet(String nazev, boolean bylSebran, boolean nasazen) {
        this(nazev, bylSebran);
        this.nasazen = nasazen;
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
}
