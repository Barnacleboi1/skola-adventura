/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package Logika;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu vezmi
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazVezmiTest
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
    public void testVstupu()
    {
        assertEquals(hra.zpracujPrikaz("vezmi"), "Tomu nerozumím, musíš mi říct co mám vzít");
        assertEquals(hra.zpracujPrikaz("vezmi bla bla"), "Tomu nerozumím, můžu vzít jen jednu věc.");
        assertEquals(hra.zpracujPrikaz("vezmi bla"), "Takový předmět v lokaci není.");

    }

    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testVezmi()
    {
        assertEquals(hra.zpracujPrikaz("vezmi kartacek"), "Vzal si kartacek");
        assertEquals(hra.getInventar().getObsahInventare().get(0).getNazev(), "kartacek");
    }
}
