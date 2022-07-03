package Model;

import java.util.ArrayList;

public interface ICard {
    ArrayList<String> getElementos();

    void setElementos(ArrayList<String> elementos);

    @Override
    boolean equals(Object o);

    @Override
    String toString();
}
