import java.util.List;
import java.util.ArrayList;

public class Mundo {
    private Nodo[][] cuadricula;
    private int tamano;

    public Mundo(int tamano) {
        this.tamano = tamano;
        this.cuadricula = new Nodo[tamano][tamano];
    }

    public void agregarNodo(int fila, int columna, String estado) {
        cuadricula[fila][columna] = new Nodo(fila, columna, estado);
    }

    public Nodo obtenerNodo(int fila, int columna) {
        return cuadricula[fila][columna];
    }

    public List<Nodo> obtenerVecinos(Nodo nodo) {
        List<Nodo> vecinos = new ArrayList<>();
        int[][] direcciones = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] dir : direcciones) {
            int nuevaFila = nodo.fila + dir[0];
            int nuevaColumna = nodo.columna + dir[1];

            if (nuevaFila >= 0 && nuevaColumna >= 0 && nuevaFila < tamano && nuevaColumna < tamano) {
                Nodo vecino = cuadricula[nuevaFila][nuevaColumna];

                if (vecino != null && !vecino.estado.equals("pozo") && !vecino.estado.equals("wumpus")) {
                    vecinos.add(vecino);
                }
            }
        }
        return vecinos;
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
}
