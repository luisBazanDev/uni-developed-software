package pe.bazan.luis.uni.domain;

import java.util.HashMap;

public class EvenNumber {
	public static Integer execute(int[] numbers) {
		HashMap<Integer, Integer> repeats = new HashMap<>();

		for (int number : numbers) {
			repeats.put(number, repeats.get(number) == null ? 1 : repeats.get(number) + 1);
		}

		for(int key : repeats.keySet()) {
			if(repeats.get(key) % 2 == 0) return key;
		}

		return null;
	}
}
