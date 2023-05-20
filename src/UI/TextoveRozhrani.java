package UI;

import Logika.Hra;
import java.util.Scanner;

public class TextoveRozhrani
{
    private Hra aktualniHra;
    private Scanner scanner;

    /**
     * Konstruktor třídy. v něm se vytváří instance třídy hra a také instance objektu Scanner.
     *
     *
     */
    public TextoveRozhrani(Hra aktualniHra)
    {
        this.aktualniHra = aktualniHra;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metoda vytváří prostředí, které pomocí instance objektu scanner čte vstupy uživatele
     * a zpracovává je pomocí metody zpracujPrikaz. Také volá prolog aktuální hry
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
