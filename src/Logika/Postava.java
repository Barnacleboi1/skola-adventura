package Logika;


import java.util.Arrays;
import java.util.List;

/**
 * Třída představující postavu vyskytující se ve hře. Postava má atribut jména a List dialogových stringů, které postava říká při interakci.
 * Také má int věta, který určuje, jakou větu zrovna postava říká.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */

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
    public List<String> getDialog() {
        return dialog;
    }

}
