package UI;

import Logika.Hra;
import java.util.Scanner;

public class TextoveRozhrani
{
    private Hra aktualniHra;
    private Scanner scanner;

    /**
     * Konstruktor třídy, vytvoří uživatelské rozhraní pro danou hru.
     *
     * @param aktualniHra hra
     */
    public TextoveRozhrani(Hra aktualniHra)
    {
        this.aktualniHra = aktualniHra;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metoda zajišťuje hraní hry. Nejprve vypíše úvodní text. Poté v cyklu
     * načítá zadané příkazy z konzole, předává je hře ke zpracování a vypisuje
     * reakce hry. To se neustále opakuje, dokud hra prostřednictvím metody
     * {@link Hra#isHraSkoncila() isHraSkoncila} neoznámí, že skončila.
     */
    public void hraj()
    {
        System.out.println(aktualniHra.getProlog());

        while(!aktualniHra.isHraSkoncila()) {
            System.out.print("\n> ");
            String vstupUzivatele = scanner.nextLine();

            System.out.println(aktualniHra.zpracujPrikaz(vstupUzivatele));
        }

    }
}
