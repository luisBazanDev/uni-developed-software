package pe.bazan.luis.utp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };
        int auxiliar;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j >= i; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    auxiliar = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = auxiliar;
                    System.out.println(Arrays.toString(numbers));
                }
            }
        }
    }
}
