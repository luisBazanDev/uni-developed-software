package pe.bazan.luis.uni.domain;

public class ThreeNumbers {
	public static int[] execute(int[] numbers) {
		for (int numberI : numbers) {
			for (int numberJ : numbers) {
				if(numberI == numberJ) continue;
				for (int numberK : numbers) {
					if(numberK == numberJ || numberK == numberI) continue;
					if(numberI * numberI + numberJ * numberJ == numberK * numberK) {
						System.out.printf("%d + %d = %d%n", numberI * numberI, numberJ * numberJ, numberK * numberK);

						return new int[]{numberI, numberJ, numberK};
					}
				}
			}
		}
		// Posible optimización: Filtrar los números duplicados para realizar menos iteraciones
		return new int[]{0, 0, 0};
	}
}
