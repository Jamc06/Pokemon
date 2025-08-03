public class HabilidadEspecial {
    private String nombre;
    private String tipoEfecto; // Determina a que carateristica influira
    private int valor;
    private double probabilidad;

    public HabilidadEspecial(String nombre, String tipoEfecto, int valor, double probabilidad) {
        this.nombre = nombre;
        this.tipoEfecto = tipoEfecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }
// random para determinar si se usara la habilidad especial
    public boolean seActiva() {
        return Math.random() <= probabilidad;
    }

    public int aplicarEfecto() {
        return valor;
    }

    public String getTipoEfecto() {
        return tipoEfecto;
    }

    public String getNombre() {
        return nombre;
    }
}
