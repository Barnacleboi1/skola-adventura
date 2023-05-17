package Logika;


import java.util.Arrays;
import java.util.List;

public class Postava {
    private String jmeno;
    private List<String> dialog;
    private int veta;
    public Postava(String jmeno, String... dialog) {
        this.jmeno = jmeno;
        this.dialog = Arrays.asList(dialog);
        this.veta = 0;
    }
    public String promluva() {
        String promluva = dialog.get(veta);
        veta++;
        if (veta == dialog.size()) {
            veta = 0;
        }
        return promluva;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public List<String> getDialog() {
        return dialog;
    }

    public void setDialog(List<String> dialog) {
        this.dialog = dialog;
    }
}
