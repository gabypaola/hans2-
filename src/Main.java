import java.util.List;

public class Main {
    public static void main(String[] args) {

        Mundo mundo = new Mundo(4);

        // deficion del mundo de estados
        // fila 1
        mundo.agregarNodo(0, 0, "vacío");
        mundo.agregarNodo(0, 1, "vacío");
        mundo.agregarNodo(0, 2, "vacío");
        mundo.agregarNodo(0, 3, "vacío");

        // fila 2
        mundo.agregarNodo(1, 0, "vacío");
        mundo.agregarNodo(1, 1, "agente"); // robot
        mundo.agregarNodo(1, 2, "brisa"); // brisa
        mundo.agregarNodo(1, 3, "wumpus"); // wumpus

        // fila 3
        mundo.agregarNodo(2, 0, "vacío");
        mundo.agregarNodo(2, 1, "hedor"); // hedor (S)
        mundo.agregarNodo(2, 2, "brisa"); // brisa (B)
        mundo.agregarNodo(2, 3, "tesoro"); // tesoro (oro)

        // fila 4
        mundo.agregarNodo(3, 0, "vacío");
        mundo.agregarNodo(3, 1, "hedor"); // hedor (S)
        mundo.agregarNodo(3, 2, "pozo"); // pozo (Pit)
        mundo.agregarNodo(3, 3, "brisa"); // brisa (B)

        // configuracion de la  búsqueda
        Nodo inicio = mundo.obtenerNodo(1, 1); // nodo inicial: agente
        Nodo objetivo = mundo.obtenerNodo(2, 3); // nodo objetivo: tesoro
        BusquedaProfundidad busqueda = new BusquedaProfundidad();

        // resetear nodos visitados antes de cada ejecución
        mundo.resetearVisitados();

        // ejecutar búsqueda y obtener el camino
        List<Nodo> camino = busqueda.buscar(mundo, inicio, objetivo);

        // camino encontrado
        System.out.println("Camino encontrado:");
        for (Nodo nodo : camino) {
            System.out.println("Paso: (" + nodo.fila + ", " + nodo.columna + ")");
        }
    }
}
