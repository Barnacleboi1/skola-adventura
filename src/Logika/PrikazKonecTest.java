/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída {@code PrikazKonecTest} slouží ke komplexnímu otestování
 * třídy {@link PrikazKonecTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class PrikazKonecTest
{
   Hra hra;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
    }


    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testVstupu()
    {
        assertEquals(hra.zpracujPrikaz("konec bla bla"), "Tento příkaz nepřijímá žádné parametry!");
    }
    @Test
    public void testOdemykani()
    {
        assertEquals(hra.zpracujPrikaz("konec"),"Děkuji za hraní!");
        assertTrue(hra.isHraSkoncila());
    }
}
