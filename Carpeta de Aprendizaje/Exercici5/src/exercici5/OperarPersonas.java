package exercici5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import personas.Estudiante;
import personas.Persona;
import personas.Profesor;

/**
 * Clase que proporciona métodos para operar y listar información sobre
 * personas. Incluye funciones para listar personas por nombre en orden inverso,
 * listar estudiantes por programa y nombre en orden inverso, y listar
 * profesores por área y nombre en orden inverso.
 *
 * La clase utiliza una serie de métodos privados para realizar operaciones
 * específicas, como filtrar estudiantes y profesores de una lista de personas y
 * imprimir las primeras 10 personas de una lista dada.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class OperarPersonas {

    /**
     * Imprime las primeras personas de una lista junto con un mensaje
     * descriptivo.
     *
     * @param msg Descripción precedente a la lista impresa.
     * @param personas Lista de personas a imprimir.
     * @param <T> Tipo de persona, que debe extender de la clase Persona.
     */
    private static <T extends Persona> void imprimirPrimeras(String msg, List<T> personas) {
        System.out.println("\n" + msg);
        int elementos = Math.min(10, personas.size()); // Obtener el mínimo entre 10 y el tamaño real de la lista
        for (int i = 0; i < elementos; i++) {
            System.out.println("\t" + personas.get(i));
        }
    }

    /**
     * Filtra y devuelve una lista de estudiantes de la lista dada de personas.
     *
     * @param personas Lista de personas.
     * @return Lista de estudiantes.
     */
    private static List<Estudiante> filtrarEstudiantes(List<Persona> personas) {
        List<Estudiante> estudiantes = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Estudiante) {
                estudiantes.add((Estudiante) persona);
            }
        }
        return estudiantes;
    }

    /**
     * Filtra y devuelve una lista de profesores de la lista dada de personas.
     *
     * @param personas Lista de personas.
     * @return Lista de profesores.
     */
    private static List<Profesor> filtrarProfesores(List<Persona> personas) {
        List<Profesor> profesores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Profesor) {
                profesores.add((Profesor) persona);
            }
        }
        return profesores;
    }

    /**
     * Extrae y devuelve el número de un nombre en formato "Nombre_XXXXXX".
     *
     * @param nombre El nombre del cual se extraerá el número.
     * @return El número extraído del nombre.
     */
    private static int extraerNumero(String nombre) {
        return Integer.parseInt(nombre.substring(7));
    }

    /**
     * Lista las personas por nombre en orden inverso y muestra las primeras 10.
     *
     * @param personas Lista de personas.
     */
    public static void listarPersonasPorNombreEnOrdenInverso(List<Persona> personas) {
        List<Persona> persona = new ArrayList<>(personas);
        persona.sort(Collections.reverseOrder());
        imprimirPrimeras("LISTADO DE PERSONAS POR NOMBRE EN ORDEN INVERSO (LAS 10 PRIMERAS): ", persona);
    }

    /**
     * Lista los estudiantes por programa y nombre en orden inverso, mostrando
     * las 10 primeras.
     *
     * @param personas Lista de personas.
     */
    public static void listarEstudiantesPorProgramaYNombreEnOrdenInverso(List<Persona> personas) {
        List<Estudiante> estudiantes = filtrarEstudiantes(personas);

        estudiantes.sort(new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                int programaComparar = Integer.compare(
                        Integer.parseInt(e2.getPrograma().substring(9)),
                        Integer.parseInt(e1.getPrograma().substring(9))
                ); //DE MAYOR A MENOR

                if (programaComparar == 0) {
                    return Integer.compare(extraerNumero(e2.getNombre()), extraerNumero(e1.getNombre())); //DE MAYOR A MENOR
                } else {
                    return programaComparar;
                }
            }
        });

        imprimirPrimeras("\nLISTADO DE ESTUDIANTES POR PROGRAMA Y NOMBRE EN ORDEN INVERSO (LAS 10 PRIMERAS): ", estudiantes);
    }

    /**
     * Lista los profesores por área y nombre en orden inverso, mostrando las 10
     * primeras.
     *
     * @param personas Lista de personas.
     */
    public static void listarProfesoradoPorAreaYNombreEnOrdenInverso(List<Persona> personas) {
        List<Profesor> profesores = filtrarProfesores(personas);

        profesores.sort(new Comparator<Profesor>() {
            @Override
            public int compare(Profesor p1, Profesor p2) {
                int areaComparison = Integer.compare(
                        Integer.parseInt(p2.getArea().substring(5)),
                        Integer.parseInt(p1.getArea().substring(5))
                ); //DE MAYOR A MENOR

                if (areaComparison == 0) {
                    return Integer.compare(extraerNumero(p2.getNombre()), extraerNumero(p1.getNombre())); //DE MAYOR A MENOR
                } else {
                    return areaComparison;
                }
            }
        });

        imprimirPrimeras("\nLISTADO DE PROFESORES POR ÁREA Y NOMBRE EN ORDEN INVERSO (LAS 10 PRIMERAS): ", profesores);
    }

}
