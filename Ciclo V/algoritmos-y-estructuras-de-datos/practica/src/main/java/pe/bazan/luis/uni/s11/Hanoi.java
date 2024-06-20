package pe.bazan.luis.uni.s11;

public class Hanoi {

	public static void hanoiSolve(int length, Tower origin, Tower destination, Tower aux) {
		hanoi(length, origin, destination, aux);
		print(length, origin, destination, aux);
	}

	public static void hanoi(int length, Tower origin, Tower destination, Tower aux) {
		if(length == 1) {
			destination.push(origin.pop());
			print(length, origin, destination, aux);
		} else {
			hanoi(length - 1, origin, aux, destination);
			destination.push(origin.pop());
			print(length, origin, destination, aux);
			hanoi(length - 1, aux, destination, origin);
		}
	}

	public static void print(int length, Tower origin, Tower destination, Tower aux) {
		for (int i = 0; i < length; i++) {
			System.out.print(
					origin.is(TowerRole.ORIGIN) ? origin.print()[i]
							: destination.is(TowerRole.ORIGIN) ? destination.print()[i]
									: aux.print()[i]
			);
			System.out.print(
					origin.is(TowerRole.DESTINATION) ? origin.print()[i]
							: destination.is(TowerRole.DESTINATION) ? destination.print()[i]
									: aux.print()[i]
			);
			System.out.print(
					origin.is(TowerRole.AUX) ? origin.print()[i]
							: destination.is(TowerRole.AUX) ? destination.print()[i]
									: aux.print()[i]
			);
			System.out.println();
		}
	}
}
