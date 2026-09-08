//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int filas = 10;
        int columnas = 10;
        int generacionesTotales = 10;

        String archivoCsv = "src\\juegovida.csv";

        leercsv lector = new leercsv(archivoCsv);
        Array2ADT<Integer> tablero = lector.cargarCSV(filas, columnas);

        juegodelavida juego = new juegodelavida();

         lector.imprimirTablero(tablero);

        for (int gen = 1; gen <= generacionesTotales; gen++) {
            juego.gameOfLife(tablero);

            lector.imprimirTablero(tablero);
        }
    }

}