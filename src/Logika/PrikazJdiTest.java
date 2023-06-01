package Logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro otestování třídy příkazu jdi
 *
 * @author Robert Čuda
 * @version 25.5.2023
 */
public class PrikazJdiTest
{
    private Hra hra;

    @BeforeEach
    public void setUp()
    {
        hra = new Hra();
        hra.zpracujPrikaz("vezmi baterka");
        hra.zpracujPrikaz("pouzij baterka");

        Lokace dum = new Lokace("dům");
        Lokace les = new Lokace("les");

        dum.pridejVychod(les);
        les.pridejVychod(dum);

        hra.getHerniSvet().setAktualniLokace(dum);
    }

    @Test
    public void testNespravneParametry()
    {
        assertEquals("Tomu nerozumím, musíš mi říct kam jít", hra.zpracujPrikaz("jdi"));
        assertEquals("dům", hra.getHerniSvet().getAktualniLokace().getNazev());

        assertEquals("Tomu nerozumím, muzu jit jen na jedno misto. Název místnosti s tímto příkazem zadávej s podtržítkem místo mezery.", hra.zpracujPrikaz("jdi a b c"));
        assertEquals("dům", hra.getHerniSvet().getAktualniLokace().getNazev());

        assertEquals("do teto lokace se neda jit", hra.zpracujPrikaz("jdi abc"));
        assertEquals("dům", hra.getHerniSvet().getAktualniLokace().getNazev());
    }

    @Test
    public void testLogikaPrikazu()
    {
        hra.zpracujPrikaz("jdi les");
        assertEquals("les", hra.getHerniSvet().getAktualniLokace().getNazev());

        hra.zpracujPrikaz("jdi dům");
        assertEquals("dům", hra.getHerniSvet().getAktualniLokace().getNazev());
    }
}
