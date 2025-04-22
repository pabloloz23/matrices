package matrices;

public class Matriz {
    private final int[][] elementos;

    /**
     * Constructor que crea una matriz a partir de un arreglo bidimensional de enteros
     * @param elementos Arreglo bidimensional de enteros que representa la matriz
     */
    public Matriz(int[][] elementos) {
        // Validar que la matriz no sea nula
        if (elementos == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula");
        }

        // Validar que todas las filas tengan la misma longitud
        int columnas = elementos.length > 0 ? elementos[0].length : 0;
        for (int[] fila : elementos) {
            if (fila.length != columnas) {
                throw new IllegalArgumentException("Todas las filas deben tener la misma longitud");
            }
        }

        // Crear una copia defensiva de la matriz
        this.elementos = new int[elementos.length][];
        for (int i = 0; i < elementos.length; i++) {
            this.elementos[i] = elementos[i].clone();
        }
    }

    /**
     * Obtiene el número de filas de la matriz
     * @return Número de filas
     */
    public int getFilas() {
        return elementos.length;
    }

    /**
     * Obtiene el número de columnas de la matriz
     * @return Número de columnas
     */
    public int getColumnas() {
        return elementos.length > 0 ? elementos[0].length : 0;
    }

    /**
     * Obtiene el elemento en una posición específica de la matriz
     * @param fila Índice de la fila
     * @param columna Índice de la columna
     * @return Valor en la posición especificada
     */
    public int getElemento(int fila, int columna) {
        if (fila < 0 || fila >= getFilas() || columna < 0 || columna >= getColumnas()) {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
        return elementos[fila][columna];
    }

    /**
     * Imprime la matriz en la consola en un formato legible
     */
    public void imprimir() {
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                System.out.print(elementos[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Calcula la matriz transpuesta
     * @return Una nueva instancia de Matriz que representa la transpuesta
     */
    public Matriz calcularTranspuesta() {
        int filas = getFilas();
        int columnas = getColumnas();

        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = elementos[i][j];
            }
        }

        return new Matriz(transpuesta);
    }

    /**
     * Retorna una representación en cadena de la matriz
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                sb.append(elementos[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}