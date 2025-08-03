import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combate {
    //La clase combate se uso como un tipo de controlador para todo el apartado
    private Entrenador e1;
    private Entrenador e2;
    private int rondasGanadas1 = 0;
    private int rondasGanadas2 = 0;

    public Combate(Entrenador e1, Entrenador e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
    ArrayList<Pokemon> disponibles1 = new ArrayList<>(e1.getEquipo());
    ArrayList<Pokemon> disponibles2 = new ArrayList<>(e2.getEquipo());//se inicia el combate con el array con los pokemons
    Random rand = new Random();

    for (int ronda = 1; ronda <= 4; ronda++) {
        System.out.println("\n--- Ronda " + ronda + " ---");

        //Muestra las opciones
        System.out.println("Pokémon disponibles para " + e1.getNombre() + ":");
        for (int i = 0; i < disponibles1.size(); i++) {
            System.out.println(i + ". " + disponibles1.get(i).getNombre());
        }

        System.out.print("Elige el número de tu Pokémon: ");
        int eleccion = scanner.nextInt();
        Pokemon p1 = disponibles1.get(eleccion);
        disponibles1.remove(eleccion);

        // Entrenador 2
        int eleccion2 = rand.nextInt(disponibles2.size());
        Pokemon p2 = disponibles2.get(eleccion2);
        disponibles2.remove(eleccion2);

        System.out.println(e1.getNombre() + " elige a " + p1.getNombre());
        System.out.println(e2.getNombre() + " elige a " + p2.getNombre());

        int a1 = p1.calcularAtaqueTotal(p2, true);
        int a2 = p2.calcularAtaqueTotal(p1, true);

        System.out.println("Ataque de " + p1.getNombre() + ": " + a1);
        System.out.println("Ataque de " + p2.getNombre() + ": " + a2);

        if (a1 > a2) {
            System.out.println("Gana la ronda: " + e1.getNombre());
            rondasGanadas1++;
        } else if (a2 > a1) {
            System.out.println("Gana la ronda: " + e2.getNombre());
            rondasGanadas2++;
        } else {
            System.out.println("Empate");
        }
    }

    mostrarGanador();
}
        
// se realizan las relaciones entre los elementos con un enum
    public static int calcularEfectoTipo(Tipo atacante, Tipo defensor) {
        if ((atacante == Tipo.FUEGO && defensor == Tipo.PLANTA) ||
            (atacante == Tipo.PLANTA && defensor == Tipo.AGUA) ||
            (atacante == Tipo.AGUA && defensor == Tipo.FUEGO) ||
            (atacante == Tipo.ELECTRICO && defensor == Tipo.AGUA)) return 20;

        if ((atacante == Tipo.FUEGO && defensor == Tipo.AGUA) ||
            (atacante == Tipo.AGUA && defensor == Tipo.PLANTA) ||
            (atacante == Tipo.PLANTA && defensor == Tipo.FUEGO) ||
            (atacante == Tipo.AGUA && defensor == Tipo.ELECTRICO)) return -10;

        return 0;
    }

    public void mostrarGanador() {
        System.out.println("\n--- Resultado Final ---");
        System.out.println(e1.getNombre() + ": " + rondasGanadas1 + " rondas ganadas");
        System.out.println(e2.getNombre() + ": " + rondasGanadas2 + " rondas ganadas");

        if (rondasGanadas1 > rondasGanadas2) {
            System.out.println("Ganador: " + e1.getNombre());
        } else if (rondasGanadas2 > rondasGanadas1) {
            System.out.println("Ganador: " + e2.getNombre());
        } else {
            System.out.println("Empate final");
        }
    }

    private String usa(Pokemon p) {
        return " elige a " + p.getNombre();
    }
}

