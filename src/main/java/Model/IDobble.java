package Model;

import java.util.ArrayList;
import java.util.Set;

public interface IDobble {
    void generacionMazo(int numE);

    int numCards();

    Card primeraCarta(ArrayList cardsSet);

    @Override
    String toString();

    boolean isDobble();

    Set<Card> missingCards();
}
