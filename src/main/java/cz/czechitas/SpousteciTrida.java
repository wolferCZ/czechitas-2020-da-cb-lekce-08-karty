package cz.czechitas;

import java.util.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        // TODO: Naimplementujte si nejprve funkcionalitu karty. Můžete experimentovat s jedinou kartoug

        // TODO: Naplňte balíček karet
        List<Card> balicekKaret = createCardDeck();
        System.out.println(balicekKaret);

        // TODO: BONUS pro rychlé Zamíchejte balíček karet
        shuffleCardDeck(balicekKaret);
        System.out.println(balicekKaret);

    }

    /**
     * Vytvoř balíček karet.
     *
     * @return balíček karet
     */
    public static List<Card> createCardDeck() {
        // TODO: Naimplementujte si nejprve funkcionalitu karty. Můžete experimentovat s jedinou kartou
        // TODO: Naplňte balíček karet
        // TODO: Přesuň vytváření balíčku karet do vlastní metody a použij
        // Vytvoř prázný seznam karet
        List<Card> cardDeck = new ArrayList<>();

        // Vygeneruj hodnoty od 7-14
        for (int hodnota = 7; hodnota <= 14; hodnota++) {

            // Vygeneruj barvy
            for (String barva : Arrays.asList("Kule", "Žaludy", "Listy", "Srdce")) {
                // For-each ciklus
                // Prochází postupně celý seznam (kolekci)
                // Syntaxe :
                // for (Typ aktuálníPrvek seznamu : procházenýSeznam) { /* blok kódu */ }
                cardDeck.add(new Card(hodnota, barva));
            }
        }
        // Vrať připravený balíček karet
        return cardDeck;
    }

    /**
     * Zamíchej balíček karet
     *
     * @param cardDeck balíček karet, který bude zamíchán
     */
    public static void shuffleCardDeck(List<Card> cardDeck) {
        // TODO: Zamíchejte balíček karet
        // TODO: Přesuň míchání balíčku karet do vlastní metody a použij
        // Připrav generátor náhodných čísel
        Random generatorNahodnychCisel = new Random();

        // Zjisti si velikost balíčku
        int deckSize = cardDeck.size();

        // Náhodně zamíchej karty pojedné.
        // Protože mícháme karty pojedné, provedeme jej vícekrát než je velikost balíčku,
        // abychom dosahly dostatečného zamýchání.
        for (int i = 0; i < deckSize * 20; i++) {
            // Náhodně vyndej kartu z balíčku
            Card removedCard = cardDeck.remove(generatorNahodnychCisel.nextInt(deckSize));
            // Vráť kartu na konec seznamu
            cardDeck.add(removedCard);
        }

        // Metoda nic nevrací.
        // Balíček, který jsme míchaly byl předán jako parametr metody.
        // POZOR: Objekty, které se předávají do metod jako parametry metody mohou být takto upraveny.
        // Metoda ale by neměla měnit objekty, pokud to není jejím úkolem.
        // Metoda by neměla mít takové to vedlejší efekty.
    }
}
