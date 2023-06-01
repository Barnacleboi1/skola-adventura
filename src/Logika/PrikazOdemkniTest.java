
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu odemkni
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazOdemkniTest
{
    Hra hra;
    Predmet truhla;
    Predmet klic;
    Predmet drahokam;
    Lokace dum;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
        
        klic = new Predmet("klic");
        drahokam = new Predmet("drahokam");
        drahokam.setJeDrahokam(true);
        truhla = new Predmet("truhla", drahokam);

        Lokace dum = new Lokace("dům", truhla, klic);
        

        hra.getHerniSvet().setAktualniLokace(dum);
        
        hra.zpracujPrikaz("vezmi truhla");
        hra.zpracujPrikaz("vezmi klic");
    }


    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testOdemkni()
    {
        assertEquals(hra.zpracujPrikaz("odemkni"), "Musíš říct, co chceš odemknout.");
        assertEquals(hra.zpracujPrikaz("odemkni bla bla"), "Můžeš odemknout jednu truhlu najednou.");
    }
    @Test
    public void testOdemykani()
    {
        assertTrue(hra.zpracujPrikaz("odemkni truhla").contains("Otevřel si truhla" + "\n" + "našel si v ní: drahokam"));
        assertEquals(hra.getInventar().getObsahInventare().get(0).getNazev(), "drahokam");
    }
}
