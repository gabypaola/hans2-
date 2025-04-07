import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class BusquedaProfundidad {
    public List<Nodo> buscar(Mundo mundo, Nodo inicio, Nodo objetivo) {
        Stack<Nodo> pila = new Stack<>();
        List<Nodo> camino = new ArrayList<>();
        pila.push(inicio);
        inicio.visitado = true;

        // Imprimir el estado inicial en coordenadas 1-based
        System.out.println("Estado inicial: (" + inicio.fila + ", " + inicio.columna + ")");

        while (!pila.isEmpty()) {
            Nodo actual = pila.pop();
            // Imprimir cada nodo procesado en coordenadas 1-based
            System.out.println("Procesando nodo: (" + actual.fila + ", " + actual.columna + ")");

            if (actual.equals(objetivo)) {
                System.out.println("¡Objetivo encontrado! Reconstruyendo el camino...");
                while (actual != null) {
                    camino.add(0, actual);
                    actual = actual.padre;
                }
                break;
            }

            // Agregar los vecinos a la pila y mostrar la dirección
            for (Nodo vecino : mundo.obtenerVecinos(actual)) {
                if (!vecino.visitado) {
                    vecino.visitado = true;
                    vecino.padre = actual;
                    pila.push(vecino);

                    // Mostrar el vecino agregado y la dirección
                    System.out.println("Agregando vecino a la pila: (" + vecino.fila + ", " + vecino.columna + ") - Movimiento: " + vecino.direccion);
                }
            }
        }

        if (camino.isEmpty()) {
            System.out.println("No se encontró un camino al objetivo.");
        } else {
            System.out.println("Camino encontrado:");
            for (Nodo nodo : camino) {
                // Imprimir el camino final con coordenadas 1-based
                System.out.println("Paso: (" + nodo.fila + ", " + nodo.columna + ")");
            }
        }

        return camino;
    }
}
