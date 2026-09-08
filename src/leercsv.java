import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class leercsv {
        private String file;

        public leercsv(String file) {
            this.file = file;
        }

        public Array2ADT<Integer> cargarCSV(int filas, int columnas) {
            Array2ADT<Integer> tablero = new Array2ADT<>(filas, columnas);
            tablero.rellenar(0);

            BufferedReader reader = null;
            String line = "";

            try {
                reader = new BufferedReader(new FileReader(file));
                int r = 0;
                while ((line = reader.readLine()) != null && r < filas) {
                    String[] row = line.split(",");
                    for (int c = 0; c < row.length && c < columnas; c++) {
                        int valor = Integer.parseInt(row[c].trim());
                        tablero.insertarElemento(r, c, valor);
                    }
                    r++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return tablero;
        }

        public void imprimirTablero(Array2ADT<Integer> tablero) {
            for (int r = 0; r < tablero.obtenerRenglones(); r++) {
                for (int c = 0; c < tablero.obtenerColumnas(); c++) {
                    System.out.print(tablero.obtenerElemento(r, c) == 1 ? "■ " : "□ ");
                }
                System.out.println();
            }
        }
    }
