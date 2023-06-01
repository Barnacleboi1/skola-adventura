
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu pouzij
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazPouzijTest
{
    Hra hra;
    Predmet baterka;
    Predmet nahrdelnik;
    Predmet drahokam;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
        baterka = new Predmet("baterka");
        baterka.setJeRozsvicena(false);
        baterka.setJeBaterka(true);
        nahrdelnik = new Predmet("nahrdelnik");

        drahokam = new Predmet("drahokam");
        drahokam.setJeDrahokam(true);
        Lokace dum = new Lokace("dům", baterka, nahrdelnik, drahokam);
        
        hra.getHerniSvet().setAktualniLokace(dum);
        
        hra.zpracujPrikaz("vezmi baterka");
        hra.zpracujPrikaz("vezmi nahrdelnik");
        hra.zpracujPrikaz("vezmi drahokam");
        hra.zpracujPrikaz("nasad");
    }
    @Test 
    public void testVstupu()
    {
        assertEquals(hra.zpracujPrikaz("pouzij"), "Musíš říct, co chceš použít");
        assertEquals(hra.zpracujPrikaz("pouzij bla bla"), "Můžeš použít jeden předmět najednou.");
    }
    @Test
    public void testPouzij()
    {
        assertEquals(hra.zpracujPrikaz("pouzij baterka"), "Rozsvítil si baterku.");
        assertEquals(hra.zpracujPrikaz("pouzij drahokam"), "Nasadil si drahokam do náhrdelníku.");
        assertTrue(baterka.isRozsvicena());
        assertEquals(nahrdelnik.getDrahokamy().get(0).getNazev(), "drahokam");
    }
}
