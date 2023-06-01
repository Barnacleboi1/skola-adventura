/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package Logika;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída sloužící k testování třídy Predmet
 *
 * @author  Robert Čuda
 * @version 25.5.2023
 */
public class PredmetTest
{
    Hra h;
    Predmet baterka;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        h = new Hra();
        baterka = new Predmet("baterka");
        baterka.setJeRozsvicena(false);
        baterka.setJeBaterka(true);
    }

    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testRozsviceniBaterky()
    {
        baterka.pouzij(h);
        assertTrue(baterka.isRozsvicena());
    }
}
