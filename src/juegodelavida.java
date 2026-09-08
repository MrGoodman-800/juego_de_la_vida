public class juegovida2 {
    public void gameOfLife(Array2ADT<Integer> board) {
        int rows = board.obtenerRenglones();
        int cols = board.obtenerColumnas();

        int[][] directions = {
                {1, 0}, {1, -1}, {0, -1}, {-1, -1},
                {-1, 0}, {-1, 1}, {0, 1}, {1, 1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int live = 0;

                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && x < rows && y >= 0 && y < cols && Math.abs(board.obtenerElemento(x, y)) == 1) {
                        live++;
                    }
                }

                int estadoActual = board.obtenerElemento(i, j);

                if (estadoActual == 1 && (live < 2 || live > 3)) {
                    board.insertarElemento(i, j, -1);
                }
                if (estadoActual == 0 && live == 3) {
                    board.insertarElemento(i, j, 2);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board.obtenerElemento(i, j) > 0) {
                    board.insertarElemento(i, j, 1);
                } else {
                    board.insertarElemento(i, j, 0);
                }
            }
        }
    }
}
