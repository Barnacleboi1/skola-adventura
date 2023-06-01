
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu mluv
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazMluvTest
{
    Hra hra;
    Postava po;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
        po = new Postava("postava", "ahoj", "jak se máš");
        
        Lokace dum = new Lokace("dům");
        dum.pridejPostavu(po);        

        hra.getHerniSvet().setAktualniLokace(dum);
    }

    @Test
    public void testMluv()
    {
        assertEquals(hra.zpracujPrikaz("mluv postava"), "ahoj");
        assertEquals(hra.zpracujPrikaz("mluv postava"), "jak se máš");
    }
}
