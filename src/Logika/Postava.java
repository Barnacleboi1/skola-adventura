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
    /**
     * Konstruktor postavy, vytváří String jména, List Stringů dialogu, co postava říká a také pořadí věty, co postava zrovna říká
     *
     */
    public Postava(String jmeno, String... dialog) {
        this.jmeno = jmeno;
        this.dialog = Arrays.asList(dialog);
        this.veta = 0;
    }
    /**
     * Metoda vracející String dialogu, který má zrovna postava říkat. metoda používá
     * int veta aby určila pořadí věty kterou má říkat
     *
     */
    public String promluva() {
        String promluva = dialog.get(veta);
        veta++;
        if (veta == dialog.size()) {
            veta = 0;
        }
        return promluva;
    }
    /**
     * Metoda vracející jméno postavy.
     *
     */
    public String getJmeno() {
        return jmeno;
    }
}
