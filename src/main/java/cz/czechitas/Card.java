package cz.czechitas;

import java.util.*;

public class Card {

    // TODO: Přidejte attributy (int) hodnota a (String) barva (hodnota 7-14, barva _"Kule, Žaludy, Listy, Srdce"_)
    private int hodnota;
    private String barva;

    public Card(int hodnota, String barva) {
        // TODO: Přidejte konstruktor s parametry hodnota a barva
        // TODO zajistěte, že nelze nastavit špatné hodnoty. Pokud špatná hodnota zadána, tak nenastavovat.
        // Nastav hodnotu karty pouze pokud je její hodnota 7-14
        if (hodnota >= 7 && hodnota <= 14) {
            this.hodnota = hodnota;
        }

        // BONUS: Ošetři chybnou hodnotu.
        // Toto nebylo původně součástí zadání.
        // Jak se vytváří a pracuje s vlastními vyjímkami jsme si zatím neukazovali

//        else {
//            // Vyhoď chybu pokud hodnota karty je mimo povolený rosah.
//            throw new IllegalArgumentException("Hodnota '"+hodnota+"' nemůže být použita jako hodnota karty");
//        }

        if (Arrays.asList("Kule", "Žaludy", "Listy", "Srdce").contains(barva)) {
            this.barva = barva;
        }
//        else {
//            // Vyhoď chybu pokud barvy karty není validní.
//            throw new IllegalArgumentException("Barva '" + barva + "' nemůže být použita jako jako hodnota barvy.");
//        }

    }

    // TODO: Přidejte gettry pro attributy hodnota a barva

    public int getHodnota() {
        return hodnota;
    }

    public String getBarva() {
        return barva;
    }

    // TODO: Přidejte metodu která vypíše hodnotu jako název karty (7-10, spodek, svršek, král, eso)

    /**
     * Vypiš hodnotu karty jako její jméno karty (11 -> spodek atd.)
     *
     * @return hodnotu karty jako její jméno karty (11 -> spodek atd.)
     */
    public String getCardName() {
        if (this.hodnota == 14) {
            return "eso";
        } else if (this.hodnota == 13) {
            return "král";
        } else if (hodnota == 12) {
            return "svršek";
        } else if (hodnota == 11) {
            return "svršek";
        } else {
            // Pokud je hodnota jíná než 11-14. Vypiš ji jako String
            return String.valueOf(hodnota);
        }
    }

    // TODO: implementujte toString metodu
    // TODO: místo hodnoty vypisujte název karty

    @Override
    public String toString() {
        return this.getCardName() + " " + barva;
    }

    // TODO: implementujte equals metodu

    @Override
    public boolean equals(Object o) {
        // Pokud porovnáváme kartu samu se sebou není třeba porovnávat jeho hodnoty.
        if (this == o) {
            return true;
        }

        // Pokud porovnávaný objekt není kartou, můžeme ukončit porovnávání a vráti `false`.
        if (!(o instanceof Card)) {
            return false;
        }

        // Převedeme porovnáváný objekt na kartu. Usnadní nám to přístup na jeho hodnoty.
        Card card = (Card) o;

        // Porovnáme hodnoty obou karet
        if (hodnota != card.getHodnota()) {
            return false;
        } else {
            // Při porovnání barev, porovnáváme hodnoty typu `String`.
            // Typ `String` je ve skutečnosti objektový typ.
            // Objekty nemůžeme porovnávat pomocí `==`.
            // Při použití `==` u objektů zjišťujeme, zda jsou porovnávané objekty, jeden a ten samí objekt.
            //
            // Pro porovnání `String` (a objektů) obecně, musíme opětovně použít metodu `.equals()`
            return barva.equals(card.getBarva());
        }
    }

    @Override
    public int hashCode() {
        int result = hodnota;
        result = 31 * result + barva.hashCode();
        return result;
    }
}
