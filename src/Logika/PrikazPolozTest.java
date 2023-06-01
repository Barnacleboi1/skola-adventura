
package Logika;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu poloz
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazPolozTest
{
    Hra hra;
    Predmet kartacek;
    Predmet klice;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
        
        kartacek = new Predmet("kartacek");
        klice = new Predmet("klice");
        Lokace dum = new Lokace("dům", kartacek, klice);
        

        hra.getHerniSvet().setAktualniLokace(dum);
        hra.zpracujPrikaz("vezmi kartacek");
    }

    @Test
    public void testVstupu()
    {
        assertEquals(hra.zpracujPrikaz("poloz"), "Musíš říct, co za předmět chceš položit.");
        assertEquals(hra.zpracujPrikaz("poloz bla bla"), "Můžeš položit jen jeden předmět najednou.");
    }
    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testPoloz()
    {
        assertEquals(hra.zpracujPrikaz("poloz kartacek"), "Položil si kartacek v lokaci: dům");
        assertTrue(hra.getHerniSvet().getAktualniLokace().stringPredmetuVLokaci().contains("kartacek"));
    }
}
