package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

// Implementa interface
public class DobbleGame implements IDobbleGame {
//Datos
    private ArrayList<Player> players;
    private Dobble mazo;
    private int numPlayers;

    // Metodos
    // Constructor
    public DobbleGame(Dobble cardsSet, int numJugadores) {
        this.players = new ArrayList<Player>();
        this.numPlayers = numJugadores;
        this.mazo = cardsSet;
    }


    public static void main(String[] args) {
    }

    // Permitira al jugador tomar acciones

    public ArrayList<String> stackMode(Dobble cardsSet) {
        ArrayList<Card> X = cardsSet.getMazo();
        ArrayList<String> Y = new ArrayList<>();
        if (X.size() <= 1 ){
            Y.addAll(X.get(0).getElementos());
            return Y;
        }
        for (int i = 0; i < 2; i++) {

            System.out.println(X.toString());
            Y.addAll(X.get(i).getElementos());
            }
        return Y;
    }
    @Override
    public String play(String X, String guess) {
        if (X == "null") {
            String Y = stackMode(this.mazo).toString();
            return Y;
        } else if (X == "pass") {
            this.players.add(this.players.get(0));
            this.players.remove(0);
            return "Turno pasado";
        } else if (X == "spotit") {
            String cartaCorrecta = match(stackMode(this.getCardsSet()));
            String W = "Carta Incorrecta!";

            if (cartaCorrecta.equals(guess)) {
                Player actual = this.players.get(0);
                actual.setPuntaje(actual.getPuntaje() + 1);
                W = "Carta Correcta!";
            }
            ArrayList<Card> nuevoMazo = this.mazo.getMazo();
            if (this.mazo.getMazo().size() <= 2) {
                return "No quedan más cartas\n Finalizando juego.";

            } else {
                nuevoMazo.remove(0);
                nuevoMazo.remove(0);
                this.mazo.setMazo(nuevoMazo);
                this.players.add(this.players.get(0));
                this.players.remove(0);
                return W;


            }
        } else {
            return "No se ingreso comando";
        }
    }

    // remplaza equals Generico
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DobbleGame that = (DobbleGame) o;
        return numPlayers == that.numPlayers && Objects.equals(players, that.players) && Objects.equals(mazo, that.mazo);
    }

    // Transforma juego a String
    @Override
    public String toString() {
        return "DobbleGame{" +
                "players=" + players +
                ", mazo=" + mazo +
                ", numPlayers=" + numPlayers +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, mazo, numPlayers);
    }

    // Encuentra cual es el elemento en comun
    @Override
    public String match(ArrayList<String> cartas) {
        HashSet X = new HashSet();
        for (String elemento : cartas) {
            if (!X.add(elemento)) {
                return elemento;
            }
        }
        return "ERROR";
    }

    // Registra Jugador en la partida
    @Override
    public boolean register(String nombre) {


        if (this.getPlayers().size() >= numPlayers) {
            return false;
        }
        for (Player player : this.getPlayers()) {
            if (nombre.equals(player.getNombre())) {
                return false;
            }
        }
        Player player = new Player(nombre);
        players.add(player);
        return true;

    }

    // Encuentra a que jugador le toca jugar
    @Override
    public String whoseTurnIsIt() {
        Player X = this.getPlayers().get(0);
        return X.getNombre();
    }

    //Getter and Setter
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String playersToString() {
        String StringJugadores = "";
        for (Player x : this.getPlayers()){
            StringJugadores = StringJugadores + x + "\n";
        }
        return StringJugadores;
    }


    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Dobble getCardsSet() {
        return mazo;
    }

    public void setCardsSet(Dobble mazo) {
        this.mazo = mazo;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}