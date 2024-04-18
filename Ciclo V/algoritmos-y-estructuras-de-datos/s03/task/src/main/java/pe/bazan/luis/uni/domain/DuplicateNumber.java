package pe.bazan.luis.uni.domain;

import java.util.Arrays;

public class DuplicateNumber {
	public static boolean execute(int[] numbers) {
		int[] values = {};
		for (int number : numbers) {
			for (int i = 0; i < values.length; i++) {
				if(values[i] == number)
					return true;
			}

			values = Arrays.copyOf(values, values.length + 1);
			values[values.length - 1] = number;
		}
		return false;
	}
}
