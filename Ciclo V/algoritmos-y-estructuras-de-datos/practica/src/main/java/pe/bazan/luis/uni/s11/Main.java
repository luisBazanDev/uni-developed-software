package pe.bazan.luis.uni.s11;

public class Main {
	public static void main(String[] args) {
		int length = 5;
		Tower origin = new Tower(length, TowerRole.ORIGIN, true);
		Tower destinationTower = new Tower(length, TowerRole.DESTINATION);
		Tower auxTower = new Tower(length, TowerRole.AUX);


		Hanoi.hanoiSolve(length, origin, destinationTower, auxTower);
	}
}
