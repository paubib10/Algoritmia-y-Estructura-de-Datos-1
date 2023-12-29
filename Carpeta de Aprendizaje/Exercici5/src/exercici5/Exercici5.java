package exercici5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;

/**
 * Clase principal que contiene el metodo main y otros metodos para operar con
 * las personas.
 *
 * Esta clase se encarga de generar personas aleatorias, utilizando la clase
 * `DatosEnum` para obtener nombres, direcciones, programas, cursos, áreas, y
 * luego mezcla la lista de personas de manera aleatoria. Luego, utiliza la
 * clase `OperarPersonas` para realizar diferentes operaciones y listar
 * información sobre las personas generadas.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class Exercici5 {

    /**
     * Genera una lista de personas aleatorias, incluyendo estudiantes y
     * profesores.
     *
     * @return Lista de personas generadas aleatoriamente.
     */
    public static List<Persona> generarPersonasAleatorias() {
        List<Persona> personas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            if (random.nextBoolean()) {
                Estudiante estudiante = new Estudiante(
                        "Nombre_" + (i + 1),
                        "Direccion_" + (i + 1),
                        "Programa_" + (random.nextInt(20) + 1),
                        "Curso_" + (random.nextInt(20) + 1),
                        random.nextInt(10, 500)
                );
                personas.add(estudiante);
            } else {
                Profesor profesor = new Profesor(
                        "Nombre_" + (i + 1),
                        "Direccion_" + (i + 1),
                        "Area_" + (random.nextInt(20) + 1),
                        random.nextInt(1000,3000 )
                );
                personas.add(profesor);
            }
        }

        return personas;
    }

    /**
     * Método principal que utiliza la clase `OperarPersonas` para realizar
     * diferentes operaciones y mostrar información sobre las personas generadas
     * aleatoriamente.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este
     * caso).
     */
    public static void main(String[] args) {
        OperarPersonas op = new OperarPersonas();
        List<Persona> personas = generarPersonasAleatorias();
        op.listarPersonasPorNombreEnOrdenInverso(personas);
        op.listarEstudiantesPorProgramaYNombreEnOrdenInverso(personas);
        op.listarProfesoradoPorAreaYNombreEnOrdenInverso(personas);
    }

}
