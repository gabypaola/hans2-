import java.util.List;
public class Main {
    //
    public static void main(String[] args) {
        Mundo mundo = new Mundo(4); // Crear un mundo de tamaño 4x4

        // Definir el mundo con nodos (coordenadas del 1 al 4)
        mundo.agregarNodo(1, 1, "agente"); // Agente en (1,1)
        mundo.agregarNodo(2, 1, "hedor");  // Stench en (2,1)
        mundo.agregarNodo(3, 1, "wumpus"); // Wumpus en (3,1)
        mundo.agregarNodo(4, 1, "hedor");  // Stench en (4,1)

        mundo.agregarNodo(1, 2, "brisa");  // Breeze en (1,2)
        mundo.agregarNodo(2, 2, "vacío"); // Vacío en (2,2)
        mundo.agregarNodo(3, 2, "tesoro"); // Tesoro en (3,2)
        mundo.agregarNodo(4, 2, "vacío"); // Vacío en (4,2)

        mundo.agregarNodo(1, 3, "pozo");  // Pit en (1,3)
        mundo.agregarNodo(2, 3, "brisa"); // Breeze en (2,3)
        mundo.agregarNodo(3, 3, "pozo");  // Pit en (3,3)
        mundo.agregarNodo(4, 3, "brisa"); // Breeze en (4,3)

        mundo.agregarNodo(1, 4, "brisa"); // Breeze en (1,4)
        mundo.agregarNodo(2, 4, "vacío"); // Vacío en (2,4)
        mundo.agregarNodo(3, 4, "brisa"); // Breeze en (3,4)
        mundo.agregarNodo(4, 4, "pozo");  // Pit en (4,4)

        // Configuración de la búsqueda: Nodo inicial y objetivo
        Nodo inicio = mundo.obtenerNodo(1, 1);  // Nodo de inicio en (1,1)
        Nodo objetivo = mundo.obtenerNodo(3, 2); // Nodo objetivo en (3,2)

        // Realizar la búsqueda de profundidad
        BusquedaProfundidad busqueda = new BusquedaProfundidad();
        mundo.resetearVisitados();  // Resetear visitados antes de comenzar la búsqueda

        // Ejecutar la búsqueda
        List<Nodo> camino = busqueda.buscar(mundo, inicio, objetivo);
    }
}
