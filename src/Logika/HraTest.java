
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída sloužící k testování třídy Hra
 *
 * @author  Robert Čuda
 * @version 25.5.2023
 */
public class HraTest
{
    Hra h;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        h = new Hra();
    }

    @Test
    public void testInicializace()
    {
        assertNotNull(h);
        assertFalse(h.isHraSkoncila());
    }
    @Test
    public void testPrubehuHry() 
    {
        assertEquals("chodba", h.getHerniSvet().getAktualniLokace().getNazev());
        h.zpracujPrikaz("jdi velka_hala");
        assertEquals("chodba", h.getHerniSvet().getAktualniLokace().getNazev());
        
        h.zpracujPrikaz("vezmi baterka");
        h.zpracujPrikaz("vezmi batoh");
        assertTrue(h.getInventar().maBatoh());
        assertEquals(h.getInventar().getObsahInventare().get(0).getNazev(), "baterka");
        
        h.zpracujPrikaz("pouzij baterka");
        h.zpracujPrikaz("jdi velka_hala");
        assertEquals("velka_hala", h.getHerniSvet().getAktualniLokace().getNazev());
        
        h.zpracujPrikaz("vezmi nahrdelnik");
        h.zpracujPrikaz("nasad");
        assertTrue(h.isNahrdelnikNasazen());
    }

}
