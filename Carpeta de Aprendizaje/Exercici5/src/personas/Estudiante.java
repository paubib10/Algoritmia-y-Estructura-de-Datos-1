package personas;

/**
 * Clase que representa a un estudiante, que es una persona con detalles
 * específicos como programa, curso y cuota. Extiende la clase Persona y hereda
 * sus propiedades y métodos.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class Estudiante extends Persona {

    private String programa;
    private String curso;
    private int cuota;

    /**
     * Constructor para crear una instancia de Estudiante con nombre, dirección,
     * programa, curso y cuota.
     *
     * @param nombre El nombre del estudiante.
     * @param direccion La dirección del estudiante.
     * @param programa El programa al que está inscrito el estudiante.
     * @param curso El curso que está cursando el estudiante.
     * @param cuota La cuota asociada al estudiante.
     */
    public Estudiante(String nombre, String direccion, String programa, String curso, int cuota) {
        super(nombre, direccion);
        this.programa = programa;
        this.curso = curso;
        this.cuota = cuota;
    }

    /**
     * Obtiene el programa al que está inscrito el estudiante.
     *
     * @return El programa del estudiante.
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Establece el programa al que está inscrito el estudiante.
     *
     * @param programa El nuevo programa del estudiante.
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * Obtiene el curso que está cursando el estudiante.
     *
     * @return El curso del estudiante.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Establece el curso que está cursando el estudiante.
     *
     * @param curso El nuevo curso del estudiante.
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Obtiene la cuota asociada al estudiante.
     *
     * @return La cuota del estudiante.
     */
    public int getCuota() {
        return cuota;
    }

    /**
     * Establece la cuota asociada al estudiante.
     *
     * @param cuota La nueva cuota del estudiante.
     */
    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    /**
     * Devuelve una representación en cadena del estudiante.
     *
     * @return Una cadena que representa al estudiante en el formato "Estudiante
     * [Nombre= nombre, Dirección= direccion, Programa= programa, Curso= curso,
     * Cuota= cuota]".
     */
    @Override
    public String toString() {
        return "Estudiante [Nombre= " + getNombre() + ", Dirección= " + getDireccion()
                + ", Programa= " + programa + ", Curso= " + curso + ", Cuota= " + cuota + "]";
    }

}
