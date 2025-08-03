public class Pokemon {
    private String nombre;
    private Tipo tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;
    private boolean habilidadActiva = false;
    private int turnoHabilidadRestante = 0;

    public Pokemon(String nombre, Tipo tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    public int calcularAtaqueTotal(Pokemon enemigo, boolean usarHabilidad) {
        int bonificacion = Combate.calcularEfectoTipo(this.tipo, enemigo.tipo);
        int ataqueTotal = ataque + bonificacion;
// Verifica si se activa la habilidad
        if (usarHabilidad && habilidad.seActiva()) {
            System.out.println("Habilidad activada: " + habilidad.getNombre());  
            habilidadActiva = true;
            turnoHabilidadRestante = 2;// es la duracion de la habilidad
        }
// aplica la hablidad activa 
        if (habilidadActiva) {
            String tipo = habilidad.getTipoEfecto();
            int efecto = habilidad.aplicarEfecto();
            // Si el efecto es ofensivo o daño directo, se suma al ataque total
            if (tipo.equals("ATAQUE")) ataqueTotal += efecto;
            else if (tipo.equals("DANO")) ataqueTotal += efecto;

            turnoHabilidadRestante--;// La habilidad dura solo 2 turnos
            if (turnoHabilidadRestante == 0) habilidadActiva = false;
        }

        return ataqueTotal;
    }

    public String getNombre() {
        return nombre;
    }
}
