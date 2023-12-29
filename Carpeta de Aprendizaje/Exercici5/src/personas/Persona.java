package personas;

/**
 * Clase que representa a una persona con nombre y dirección. Implementa la
 * interfaz Comparable para permitir la comparación y ordenación por nombre.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public abstract class Persona implements Comparable<Persona> {

    private String nombre;
    private String direccion;

    /**
     * Constructor para crear una instancia de Persona con nombre y dirección.
     *
     * @param nombre El nombre de la persona.
     * @param direccion La dirección de la persona.
     */
    public Persona(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección de la persona.
     *
     * @return La dirección de la persona.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la persona.
     *
     * @param direccion La nueva dirección de la persona.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve una representación en cadena de la persona.
     *
     * @return Una cadena que representa la persona en el formato "Persona
     * [Nombre= nombre, Dirección= direccion]".
     */
    @Override
    public String toString() {
        return "Persona [Nombre= " + nombre + ", Dirección= " + direccion + "]";
    }

    /**
     * Compara esta persona con otra persona basándose en el nombre.
     *
     * @param o La persona con la que se va a comparar.
     * @return Un valor negativo si esta persona es menor, cero si son iguales y
     * un valor positivo si esta persona es mayor.
     */
    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }

    /**
     * Compara esta persona con otro objeto para verificar la igualdad.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona persona = (Persona) obj;
        return nombre.equals(persona.nombre) && direccion.equals(persona.direccion);
    }
}
