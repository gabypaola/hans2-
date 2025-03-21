import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class BusquedaProfundidad {

    public List<Nodo> buscar(Mundo mundo, Nodo inicio, Nodo objetivo) {
        Stack<Nodo> pila = new Stack<>();
        List<Nodo> camino = new ArrayList<>();
        pila.push(inicio);
        inicio.visitado = true;

        System.out.println("Iniciando búsqueda desde: (" + inicio.fila + ", " + inicio.columna + ")");

        while (!pila.isEmpty()) {
            Nodo actual = pila.pop();

            System.out.println("Procesando nodo: (" + actual.fila + ", " + actual.columna + ")");

            if (actual.equals(objetivo)) {
                System.out.println("¡Objetivo encontrado! Reconstruyendo el camino...");
                while (actual != null) {
                    camino.add(0, actual);
                    actual = actual.padre;
                }
                break;
            }

            List<Nodo> vecinos = mundo.obtenerVecinos(actual);

            Collections.sort(vecinos, (a, b) -> {
                if (a.fila > b.fila) return -1;
                if (a.fila < b.fila) return 1;
                if (a.columna > b.columna) return -1;
                return 1;
            });

            for (Nodo vecino : vecinos) {
                if (!vecino.visitado) {
                    vecino.visitado = true;
                    vecino.padre = actual;
                    pila.push(vecino);
                    System.out.println("Agregando vecino a la pila: (" + vecino.fila + ", " + vecino.columna + ")");
                }
            }
        }

        if (camino.isEmpty()) {
            System.out.println("No se encontró un camino al objetivo.");
        } else {
            System.out.println("Camino encontrado:");
            for (Nodo nodo : camino) {
                System.out.println("Paso: (" + nodo.fila + ", " + nodo.columna + ")");
            }
        }

        return camino;
    }
}
