package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Dobble implements IDobble {
    // Datos
    // Num de elementos por carta
    int numE;
    // Numero max de cartas
    int numCartas;
    // Array con las cartas
    ArrayList<Card> cardsSet;
    // Lista con elementos que se usaran para el juego
    List<Character> listaElementos = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    // Metodos
    public static void main(String[] args) {

    }

    // Constructor
    public Dobble(int numElementos, int numeroCartas) {

        numE = numElementos;
        numCartas = numeroCartas;

    }

    // Generacion de Mazo
    // Se genera elemento,se agrega a carta
    // y esa carta se agrega al array de Cartas
    @Override
    public void generacionMazo(int numE) {
        int N = this.numE - 1;
        int num = this.numCartas;
        ArrayList<Card> cardsSet = new ArrayList<Card>();
        int i, j, k;

        Card x = new Card();
        for (i = 1; i <= N + 1; i++) {
            x.Elementos.add(String.valueOf(i));
        }
        cardsSet.add(x);
        for (i = 1; i <= N; i++) {
            Card y = new Card();
            y.Elementos.add(String.valueOf(1));
            for (j = 1; j <= N; j++) {
                y.Elementos.add(String.valueOf(i * N + (j + 1)));
            }
            cardsSet.add(y);
        }
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                Card z = new Card();
                z.Elementos.add(String.valueOf(i + 1));
                for (k = 1; k <= N; k++) {
                    z.Elementos.add(String.valueOf(N + 2 + N * (k - 1) + (((i - 1) * (k - 1) + j - 1) % N)));
                }
                cardsSet.add(z);
            }
        }
        Collections.shuffle(cardsSet);
        double Y = Math.pow(N, 2) + N + 1;
        if ((num > 0) && (num < Y)) {
            ArrayList<Card> cardsSetMax = new ArrayList<Card>();
            for (i = 0; i < num; i++) {
                cardsSetMax.add(cardsSet.get(i));
            }
            this.setMazo(cardsSetMax);
        } else {
            this.setMazo(cardsSet);
            this.setnumCartas(cardsSet.size());

        }

    }


    @Override
    // Consigo cartas en mazo
    public int numCards() {
        return this.cardsSet.size();
    }


    // Consigue primera carta
    @Override
    public Card primeraCarta(ArrayList cardsSet) {
        return (Card) cardsSet.get(0);
    }

    // Remplaza equals generico
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dobble dobble = (Dobble) o;
        return numE == dobble.numE && numCartas == dobble.numCartas && Objects.equals(cardsSet, dobble.cardsSet) && Objects.equals(listaElementos, dobble.listaElementos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numE, numCartas, cardsSet, listaElementos);
    }

    // Remplzaa toString generico
    @Override
    public String toString() {
        ArrayList<Card> X = this.getMazo();
        StringBuilder CardsString = new StringBuilder();
        int i = 0;
        for (Card carta : X) {
            String cartaString = carta.getElementos().toString();
            CardsString.append("Carta ");
            CardsString.append(i + 1);
            CardsString.append(": ");
            CardsString.append(cartaString);
            CardsString.append("\n");
            i++;
        }
        String CardsSetToString = CardsString.toString();
        return CardsSetToString;
    }

    // Verifica si mazo es valido
    @Override
    public boolean isDobble() {
        int j = 0;
        // Numero correcto cartas
        int N = this.getNumE();
        double cartasNecesarias = Math.pow(N, 2) + N + 1;
        if (this.getMazo().size() > (cartasNecesarias)) {
            return false;
        }
        // Elementos solo se repiten una vez
        for (Card carta : this.getMazo()) {
            Set<String> X = carta.Elementos.stream().collect(Collectors.toSet());
            for (Card carta2 : cardsSet) {
                Set<String> Y = carta2.Elementos.stream().collect(Collectors.toSet());
                Y.retainAll(X);
                if (Y.size() > 1) {
                    j++;
                }
            }
        }
        if (j > this.getnumCartas()) {
            return false;
        }
        return true;
    }

    // Encuentra las cartas faltanes
    @Override
    public Set<Card> missingCards() {
        Dobble missing = new Dobble(this.numE, -1);
        missing.generacionMazo(this.numE);
        Set<Card> Y = this.getMazo().stream().collect(Collectors.toSet());
        Set<Card> Z = this.getMazo().stream().collect(Collectors.toSet());
        Z.retainAll(Y);
        return Z;
    }

    // Getters and Setters
    public int getnumCartas() {
        return numCartas;
    }

    public void setnumCartas(int numCartas) {
        this.numCartas = numCartas;
    }

    public ArrayList<Card> getMazo() {
        return cardsSet;
    }

    public void setMazo(ArrayList<Card> cardsSet) {
        this.cardsSet = cardsSet;
    }

    public int getNumE() {
        return numE;
    }

    public void setNumE(int numE) {
        this.numE = numE;
    }

    public List<Character> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(List<Character> listaElementos) {
        this.listaElementos = listaElementos;
    }
}


