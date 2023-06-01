
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída sloužící k testování třídy Lokace
 *
 * @author  Robert Čuda
 * @version 25.5.2023
 */
public class LokaceTest
{
    
    Hra h;
    Predmet p;
    Lokace l;
    Lokace l2;
    Postava po;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        h = new Hra();
        p = new Predmet("predmet");
        l = new Lokace("lokace");
        l2 = new Lokace("lokace2");
        po = new Postava("postava", "ahoj"); 
    }

    @Test
    public void testPredmetuVLokaci() 
    {
        assertEquals(l.stringPredmetuVLokaci(), "V místnosti nejsou žádné předměty!");
        
        l.pridejPredmet(p);
        
        assertTrue(l.getPredmetyVLokaci().contains(p));
        
        assertEquals(l.stringPredmetuVLokaci(), p.getNazev());
    }
    @Test 
    public void testPostavVLokaci() 
    {
        assertEquals(l.stringPostav(), "V místnosti nejsou žádné postavy!");
        
        l.pridejPostavu(po);
        
        assertEquals(l.stringPostav(), po.getJmeno());
    }
    @Test
    public void testPridaniVychoduZLokace()
    {
        assertFalse(l.maVychod("lokace2"));
        
        l2.pridejVychod(l);
        l.pridejVychod(l2);
        
        assertTrue(l2.maVychod("lokace"));
        assertTrue(l.maVychod("lokace2"));
        
        assertNull(l.getVychod("lokace"));
        
        assertEquals(l.stringPredmetuVLokaci(), "V místnosti nejsou žádné předměty!");
    }
}
