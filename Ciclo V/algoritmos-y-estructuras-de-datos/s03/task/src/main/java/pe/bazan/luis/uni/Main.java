package pe.bazan.luis.uni;

import pe.bazan.luis.uni.domain.*;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		int[] array = new int[]{1,2,5,3,4,41,12,2,1,23,13,1,2,1,1,1,1,2,3,12,31,31,23,14124,12,312,312,312,31,23,13,2,1};

		int countNumber = CountNumber.execute(array);
		int firstRepeat = FirstRepeat.execute(array);
		boolean duplicateNumber = DuplicateNumber.execute(array);
		Integer evenNumber = EvenNumber.execute(array);
		int[] threeNumbers = ThreeNumbers.execute(array);
		int[] threeNumbersSum = ThreeNumbersSum.execute(array, 10);


		System.out.printf("Hi");
	}
}