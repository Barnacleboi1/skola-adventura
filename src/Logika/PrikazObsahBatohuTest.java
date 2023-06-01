
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu batoh
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazObsahBatohuTest
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
    }

    @Test
    public void testObsahu()
    {
        assertEquals(0, hra.getInventar().getObsahInventare().size());
        hra.zpracujPrikaz("vezmi kartacek");
        assertTrue(hra.zpracujPrikaz("batoh").contains("Obsah batohu:"));
        assertTrue(hra.zpracujPrikaz("batoh").contains("kartacek"));
        assertFalse(hra.zpracujPrikaz("batoh").contains("klice"));

    }
}
