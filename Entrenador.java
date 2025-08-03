import java.util.ArrayList;

public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> equipo = new ArrayList<>();

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Pokemon> getEquipo() {
    return equipo;
}

    public void agregarPokemon(Pokemon p) {
        equipo.add(p);
    }

    public Pokemon seleccionarPokemon(int index) {
        return equipo.get(index);
    }

    public String getNombre() {
        return nombre;
    }
}
