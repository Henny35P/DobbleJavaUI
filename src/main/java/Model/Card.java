package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Card implements ICard {
    // Este Array almacenara los elementos generados por Dobble
    public ArrayList<String> Elementos;

    public static void main(String[] args) {
    }

    // Constructor
    public Card() {
        Elementos = new ArrayList<String>();
    }

    @Override
    // Getter
    public ArrayList<String> getElementos() {
        return Elementos;
    }

    @Override
    // Setter
    public void setElementos(ArrayList<String> elementos) {
        Elementos = elementos;
    }

    @Override
    // Remplazo de equals generico
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getElementos(), card.getElementos());
    }
    @Override
    // Genera el String a traves de los elementos
    public String toString() {
        return "Carta : " + Elementos ;
    }

}

