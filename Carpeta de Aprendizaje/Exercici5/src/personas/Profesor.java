package personas;

/**
 * Clase que representa a un profesor, que es una persona con detalles
 * específicos como área de enseñanza y sueldo. Extiende la clase Persona y
 * hereda sus propiedades y métodos.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class Profesor extends Persona {

    private String area;
    private double sueldo;

    /**
     * Constructor para crear una instancia de Profesor con nombre, dirección,
     * área y sueldo.
     *
     * @param nombre El nombre del profesor.
     * @param direccion La dirección del profesor.
     * @param area El área de enseñanza del profesor.
     * @param sueldo El sueldo del profesor.
     */
    public Profesor(String nombre, String direccion, String area, double sueldo) {
        super(nombre, direccion);
        this.area = area;
        this.sueldo = sueldo;
    }

    /**
     * Obtiene el área de enseñanza del profesor.
     *
     * @return El área del profesor.
     */
    public String getArea() {
        return area;
    }

    /**
     * Establece el área de enseñanza del profesor.
     *
     * @param area El nuevo área del profesor.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Obtiene el sueldo del profesor.
     *
     * @return El sueldo del profesor.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo del profesor.
     *
     * @param sueldo El nuevo sueldo del profesor.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Devuelve una representación en cadena del profesor.
     *
     * @return Una cadena que representa al profesor en el formato "Profesor
     * [Nombre= nombre, Dirección= direccion, Área= area, Sueldo= sueldo]".
     */
    @Override
    public String toString() {
        return "Profesor [Nombre= " + getNombre() + ", Dirección= " + getDireccion()
                + ", Área= " + area + ", Sueldo= " + sueldo + "]";
    }
}
