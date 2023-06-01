package Logika;
/**
 * Rozhrání, které definuje metody, které implementují všechny příkazy ve hře.
 *
 * @author Robert Čuda
 * @Version 17.5.2023
 */
public interface PrikazInterface {
    /**
     * metoda vracející název příkazu
     * 
     * @return nazev příkazu
     */
    String getNazev();

    /**
     * metoda vracející provedení příkazu
     * 
     * @param vstupy uživatele
     * @return string, jak se příkaz povedl
     */
    String proved(String[] parametry);
}