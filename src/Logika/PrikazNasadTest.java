/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package Logika;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída {@code PrikazNasadTest} slouží ke komplexnímu otestování
 * třídy {@link PrikazNasadTest}.
 *
 * @author  author name
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class PrikazNasadTest
{
    Hra hra;
    Predmet nahrdelnik;
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
        
        nahrdelnik = new Predmet("nahrdelnik");
        Lokace dum = new Lokace("dům", nahrdelnik);
        

        hra.getHerniSvet().setAktualniLokace(dum);
        hra.zpracujPrikaz("vezmi nahrdelnik");
    }
    @Test
    public void testVstupu()
    {
        assertEquals(hra.zpracujPrikaz("nasad bla"), "Tento příkaz nemá žádne parametry.");

    }

    /***************************************************************************
     * Test, který kontroluje požadovanou funkcionalitu.
     */
    @Test
    public void testNasad()
    {
        assertEquals(hra.zpracujPrikaz("nasad"), "Nasadil sis nahrdelnik.");
        assertTrue(hra.isNahrdelnikNasazen());
    }
}
