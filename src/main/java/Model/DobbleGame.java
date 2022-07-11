package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

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
    @Override
    public void play(String X) {
        if (X == "null") {
            System.out.println(IDobbleGame.stackMode(this.mazo));
        } else if (X == "pass") {
            this.players.add(this.players.get(0));
            this.players.remove(0);
        } else if (X == "spotit") {
            System.out.println(IDobbleGame.stackMode(this.mazo));
            Scanner myScanner = new Scanner(System.in);
            String respuesta = myScanner.nextLine();
            String cartaCorrecta = match(IDobbleGame.stackMode(this.getCardsSet()));

            if (cartaCorrecta.equals(respuesta)) {
                Player actual = this.players.get(0);
                actual.setPuntaje(actual.getPuntaje() + 1);
            }
            ArrayList<Card> nuevoMazo = this.mazo.getMazo();
            if (this.mazo.getMazo().size() < 2) {
                System.out.println("No quedan mas cartas");
                System.out.println("Finalizando este juego!");
            } else {
                nuevoMazo.remove(0);
                nuevoMazo.remove(0);
                this.mazo.setMazo(nuevoMazo);
                this.players.add(this.players.get(0));
                this.players.remove(0);
            }
        } else {
            System.out.println("No ingreso comando");
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