package pe.bazan.luis.uni.domain;

import java.util.Arrays;

public class FirstRepeat {
	public static int execute(int[] numbers) {
		int[] values = {};
		for (int number : numbers) {
			for (int i = 0; i < values.length; i++) {
				if(values[i] == number)
					return number;
			}

			values = Arrays.copyOf(values, values.length + 1);
			values[values.length - 1] = number;
		}
		return -1;
	}
}
