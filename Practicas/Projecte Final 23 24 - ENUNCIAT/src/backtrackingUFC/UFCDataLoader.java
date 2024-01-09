package backtrackingUFC;

import backtracking.ElementMotxilla;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cargador de datos de UFC para cargar datos de un archivo de texto.
 * 
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class UFCDataLoader {

    private String filePath;

    /**
     * Crea una instancia de UFCDataLoader con la ruta de archivo especificada.
     *
     * @param filePath Ruta de archivo para cargar datos de UFC
     */
    public UFCDataLoader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Carga los datos de UFC del archivo especificado en el constructor.
     *
     * @return ElementMotxilla[] con los datos de UFC
     */
    public ElementMotxilla[] loadUFCData() {
        List<ElementMotxilla> ufcDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar la primera línea si contiene encabezados

            while ((line = br.readLine()) != null) {
                // Dividir la línea en campos usando la coma como delimitador
                String[] fields = line.split(",");

                // Verificar si hay suficientes campos antes de intentar convertir
                if (fields.length >= 7) {
                    try {
                        // Convertir los campos necesarios a los tipos de datos apropiados
                        String name = fields[0].replaceAll("\"", ""); // Elimina comillas dobles
                        double weight = Double.parseDouble(fields[6].replaceAll("\"", ""));
                        double height = Double.parseDouble(fields[5].replaceAll("\"", ""));
                        int wins = Integer.parseInt(fields[2].replaceAll("\"", ""));

                        // Verificar si los campos convertidos no son NaN (indicando un campo vacío)
                        if (!Double.isNaN(weight) && !Double.isNaN(height)) {
                            // Crear una instancia de ElementMotxilla y agregarla a la lista
                            ElementMotxilla elementMotxilla = new ElementMotxilla(name, weight, height, wins);
                            ufcDataList.add(elementMotxilla);
                        }
                    } catch (NumberFormatException e) {
                        // Imprimir detalles para depuración
                        System.out.println("Error converting line: " + line);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ufcDataList.toArray(new ElementMotxilla[0]);
    }

}
