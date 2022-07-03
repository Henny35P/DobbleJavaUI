package Model;

import java.util.ArrayList;

public interface IDobbleGame {
    // Editar esto
    static ArrayList<String> stackMode(Dobble cardsSet) {
        ArrayList<Card> X = cardsSet.getMazo();
        ArrayList<String> Y = new ArrayList<>();
        for (int i = 0; i < 2; i++) {

            Y.addAll(X.get(i).getElementos());
        }
        return Y;
    }

    void play(String X);

    String match(ArrayList<String> cartas);

    void register(String nombre);

    String whoseTurnIsIt();
}
