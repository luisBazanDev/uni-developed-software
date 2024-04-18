package pe.bazan.luis.uni.domain;

public class ThreeNumbersSum {
	public static int[] execute(int[] numbers, int num) {
		for (int numberI : numbers) {
			for (int numberJ : numbers) {
				if(numberI == numberJ) continue;
				for (int numberK : numbers) {
					if(numberK == numberJ || numberK == numberI) continue;
					if(numberI + numberJ + numberK == num) {
						System.out.printf("%d + %d + %d = %d%n", numberI, numberJ, numberK, num);

						return new int[]{numberI, numberJ, numberK};
					}
				}
			}
		}
		return new int[]{};
	}
}
