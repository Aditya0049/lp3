import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    // Deterministic Quick Sort
    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            deterministicQuickSort(arr, low, pi - 1);
            deterministicQuickSort(arr, pi + 1, high);
        }
    }

    // Randomized Quick Sort
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    // Partition function for deterministic Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Randomized partition function
    private static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);
        swap(arr, randomIndex, high);
        return partition(arr, low, high);
    }

    // Swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

        // Sorting with deterministic Quick Sort
        int[] arrDeterministic = arr.clone();
        long startDeterministic = System.nanoTime();
        deterministicQuickSort(arrDeterministic, 0, n - 1);
        long durationDeterministic = System.nanoTime() - startDeterministic;
        System.out.println("Sorted (Deterministic): " + java.util.Arrays.toString(arrDeterministic));
        System.out.println("Time (Deterministic): " + durationDeterministic + " ns");

        // Sorting with randomized Quick Sort
        int[] arrRandomized = arr.clone();
        long startRandomized = System.nanoTime();
        randomizedQuickSort(arrRandomized, 0, n - 1);
        long durationRandomized = System.nanoTime() - startRandomized;
        System.out.println("Sorted (Randomized): " + java.util.Arrays.toString(arrRandomized));
        System.out.println("Time (Randomized): " + durationRandomized + " ns");

        scanner.close();
    }
}