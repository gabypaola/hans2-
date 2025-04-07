class Nodo {
    int fila, columna;
    String estado;
    boolean visitado;
    Nodo padre;
    String direccion;

    public Nodo(int fila, int columna, String estado) {
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.visitado = false;
        this.padre = null;
        this.direccion = "";  // Inicializamos como vacío
    }

    public void reset() {
        this.visitado = false;
        this.padre = null;
    }
}
