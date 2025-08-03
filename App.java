//App
// Jorge Martinez Cambara
//02082025
// Hecho en java poo
// Se realiza una guerra de pokemon




public class App {
    public static void main(String[] args) {
        //Se crean los 2 entrenadores que van a jugar
        Entrenador ash = new Entrenador("Ash");
        Entrenador misty = new Entrenador("Misty");
// Cada entenador tendra 4 pokemones
        ash.agregarPokemon(new Pokemon("Charmander", Tipo.FUEGO, 50, 30,
            new HabilidadEspecial("Llama Final", "ATAQUE", 15, 0.3)));
        ash.agregarPokemon(new Pokemon("Bulbasaur", Tipo.PLANTA, 45, 35,
            new HabilidadEspecial("Escudo Natural", "DEFENSA", 20, 0.2)));
        ash.agregarPokemon(new Pokemon("Squirtle", Tipo.AGUA, 48, 32,
            new HabilidadEspecial("Suiton", "DANO", -10, 0.25)));
        ash.agregarPokemon(new Pokemon("Pikachu", Tipo.ELECTRICO, 52, 28,
            new HabilidadEspecial("Impac Trueno", "ATAQUE", 18, 0.4)));

        misty.agregarPokemon(new Pokemon("Staryu", Tipo.AGUA, 49, 29,
            new HabilidadEspecial("Rayo Burbuja", "DANO", -12, 0.3)));
        misty.agregarPokemon(new Pokemon("Oddish", Tipo.PLANTA, 44, 36,
            new HabilidadEspecial("Fotosíntesis", "DEFENSA", 15, 0.2)));
        misty.agregarPokemon(new Pokemon("Vulpix", Tipo.FUEGO, 51, 30,
            new HabilidadEspecial("Fuego Fatuo", "ATAQUE", 17, 0.35)));
        misty.agregarPokemon(new Pokemon("Magnemite", Tipo.ELECTRICO, 70, 33,
            new HabilidadEspecial("Electroshock", "DANO", -8, 0.25)));
// se Mandan los entrenadores a la clase combate
        Combate combate = new Combate(ash, misty);
        combate.iniciar();
    }
}

