package pe.bazan.luis.utp.s02;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = {15, 60, 8, 16, 44, 27, 12, 35};

        int[] tree = Arrays.copyOf(numbers, numbers.length);

        for (int i = 0; i < 4; i++) {

        }
    }

    private static int[] swap(int[] array, int from, int to) {
        int temp = array[to];
        array[to] = array[from];
        array[from] = temp;
        return array;
    }
}
