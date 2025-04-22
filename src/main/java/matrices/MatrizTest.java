package matrices;

import matrices.Matriz;

public class MatrizTest {
    public static void main(String[] args) {
        // Crear una matriz 3x3
        int[][] datos = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Matriz matriz = new Matriz(datos);

        System.out.println("Matriz original:");
        matriz.imprimir();

        System.out.println("\nMatriz transpuesta:");
        Matriz transpuesta = matriz.calcularTranspuesta();
        transpuesta.imprimir();
    }
}