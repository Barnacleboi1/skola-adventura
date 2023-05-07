package Logika;

public class Predmet {
    private String nazev;
    private boolean bylSebran;

    public Predmet(String nazev, boolean bylSebran) {
        this.nazev = nazev;
        this.bylSebran = bylSebran;
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
