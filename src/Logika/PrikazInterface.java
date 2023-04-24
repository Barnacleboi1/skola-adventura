package Logika;

public interface PrikazInterface {
    public String getNazev();
    public String proved(String[] parametry);
}

class PrikazKonec implements PrikazInterface {

    @Override
    public String getNazev() {
        return "Konec";
    }

    @Override
    public String proved(String[] parametry) {
        return "hra byla ukonecna";
    }
}

class PrikazNapoveda implements  PrikazInterface {

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public String proved(String[] parametry) {
        return "Dostanes napovedu";
    }
}
