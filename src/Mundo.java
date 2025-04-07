import java.util.List;
import java.util.ArrayList;

class Mundo {
    private Nodo[][] cuadricula;
    private int tamano;

    public Mundo(int tamano) {
        this.tamano = tamano;
        this.cuadricula = new Nodo[tamano][tamano];
    }

    public void agregarNodo(int fila, int columna, String estado) {
        // Las coordenadas deben ser 1-based, pero el arreglo es 0-based
        // De manera que ajustamos el índice restando 1
        cuadricula[fila - 1][columna - 1] = new Nodo(fila, columna, estado);
    }

    public Nodo obtenerNodo(int fila, int columna) {
        // Ajustar el acceso de coordenadas 1-based a 0-based
        return cuadricula[fila - 1][columna - 1];
    }

    public void resetearVisitados() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (cuadricula[i][j] != null) {
                    cuadricula[i][j].reset();
                }
            }
        }
    }

    public List<Nodo> obtenerVecinos(Nodo nodo) {
        List<Nodo> vecinos = new ArrayList<>();
        String[][] direcciones = {{"Sur", "Este"}, {"Este", "Sur"}, {"Norte", "Oeste"}, {"Oeste", "Norte"}};

        int[][] movimientos = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // Movimientos: Sur, Este, Norte, Oeste
        for (int i = 0; i < movimientos.length; i++) {
            int nuevaFila = nodo.fila + movimientos[i][0];
            int nuevaColumna = nodo.columna + movimientos[i][1];

            if (nuevaFila > 0 && nuevaColumna > 0 && nuevaFila <= tamano && nuevaColumna <= tamano) {
                Nodo vecino = cuadricula[nuevaFila - 1][nuevaColumna - 1];
                if (vecino != null && !vecino.estado.equals("pozo") && !vecino.estado.equals("wumpus")) {
                    vecino.direccion = direcciones[i][0];  // Asignamos la dirección de movimiento
                    vecinos.add(vecino);
                }
            }
        }
        return vecinos;
    }
}
