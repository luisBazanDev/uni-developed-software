package pe.bazan.luis.uni.domain;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class CountNumber {
	// Implementar un algoritmo que indique qué número se repite el mayor número de veces
	public static int execute(int[] numbers) {
		HashMap<Integer, Integer> repeats = new HashMap<>();

		for (int number : numbers) {
			repeats.put(number, repeats.get(number) == null ? 1 : repeats.get(number) + 1);
		}



		Integer maxKey = null;
		int maxRepeat = 0;

		for (int key : repeats.keySet()) {
			if(repeats.get(key) > maxRepeat) {
				maxRepeat = repeats.get(key);
				maxKey = key;
			}
		}

		return maxKey;
	}
}
