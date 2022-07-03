package Model;

import java.util.Objects;


public class Player {
    // datos
    String nombre;
    Integer puntaje = 0;

    // Metodos
    // remplaza Equals generico
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(nombre, player.nombre) && Objects.equals(puntaje, player.puntaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, puntaje);
    }
    //Getter and Setters
    public Player(String nombreJugador) {
        this.nombre = nombreJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString(){
        String string = this.getNombre() + " tiene " + this.getPuntaje() + " puntos";
        return string;
    }
}
