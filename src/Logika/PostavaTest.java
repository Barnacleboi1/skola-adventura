
package Logika;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*******************************************************************************
 * Testovací třída sloužící k testování třídy Postava
 *
 * @author  Robert Čuda
 * @version 25.5.2023
 */
public class PostavaTest
{
    Postava p;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        p = new Postava("postava", "ahoj", "jak se máš");
    }

    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testPromluvy()
    {
        assertEquals(p.promluva(), "ahoj");
        assertEquals(p.promluva(), "jak se máš");
    }
}
