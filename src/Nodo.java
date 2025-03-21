public class Nodo {
    int fila, columna;
    String estado;
    boolean visitado;
    Nodo padre;

    public Nodo(int fila, int columna, String estado) {
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.visitado = false;
        this.padre = null;
    }

    public void reset() {
        this.visitado = false;
        this.padre = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "fila=" + fila + ", columna=" + columna + ", estado='" + estado + '\'' + '}';
    }
}
