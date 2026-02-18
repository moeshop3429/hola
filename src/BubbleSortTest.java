/* comparando algoritmos
nombre: isaias mejia morente
carnet: 202503928 */
import java.util.Random;

public class BubbleSortTest {

    // ===============================
    // VARIABLES PARA MEDIR RENDIMIENTO
    // ===============================
    static long comparaciones;

    // ===============================
    // BUBBLE SORT TRADICIONAL
    // ===============================
    public static void bubbleTradicional(int[] arr) {
        comparaciones = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // ===============================
    // BUBBLE SORT CON BANDERA
    // ===============================
    public static void bubbleConBandera(int[] arr) {
        comparaciones = 0;
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    // ===============================
    // BUBBLE SORT OPTIMIZADO
    // ÚLTIMO INTERCAMBIO
    // ===============================
    public static void bubbleUltimoIntercambio(int[] arr) {
        comparaciones = 0;
        int n = arr.length;
        int nuevoN;

        do {
            nuevoN = 0;
            for (int i = 1; i < n; i++) {
                comparaciones++;
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    nuevoN = i;
                }
            }
            n = nuevoN;
        } while (n > 0);
    }

    // ===============================
    // MÉTODO AUXILIAR SWAP
    // ===============================
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ===============================
    // GENERADORES DE ESCENARIOS
    // ===============================
    public static int[] arregloOrdenado(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    public static int[] arregloInverso(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }

    public static int[] arregloAleatorio(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) arr[i] = r.nextInt(size);
        return arr;
    }

    // ===============================
    // COPIAR ARREGLO
    // ===============================
    public static int[] copiar(int[] arr) {
        return arr.clone();
    }

    // ===============================
    // MAIN (PRUEBAS)
    // ===============================
    public static void main(String[] args) {

        int[] tamaños = {100, 500, 1000};

        for (int size : tamaños) {

            System.out.println("\n===== Tamaño: " + size + " =====");

            int[] base = arregloAleatorio(size);

            int[] a1 = copiar(base);
            bubbleTradicional(a1);
            System.out.println("Tradicional: " + comparaciones + " comparaciones");

            int[] a2 = copiar(base);
            bubbleConBandera(a2);
            System.out.println("Con Bandera: " + comparaciones + " comparaciones");

            int[] a3 = copiar(base);
            bubbleUltimoIntercambio(a3);
            System.out.println("Último Intercambio: " + comparaciones + " comparaciones");
        }
    }
}
