package Model;

import java.util.ArrayList;

public interface IDobbleGame {
    ArrayList<String> stackMode(Dobble cardsSet);

    // Permitira al jugador tomar acciones
    String play(String X, String guess);

    String match(ArrayList<String> cartas);

    boolean register(String nombre);

    String whoseTurnIsIt();
}
