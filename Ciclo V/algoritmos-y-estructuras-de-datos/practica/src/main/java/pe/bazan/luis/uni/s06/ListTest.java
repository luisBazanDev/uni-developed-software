package pe.bazan.luis.uni.s06;

import pe.bazan.luis.uni.s06.domain.Company;
import pe.bazan.luis.uni.s06.domain.SinglyLinkedList;

public class ListTest {

	public static void main(String[] args) {
		System.out.println("Hello world");
//		testSinglyLinkedList();
		testCircularSinglyLinkedList();
	}

	private static void testCircularSinglyLinkedList() {
		System.out.println("Test CircularSinglyLinkedList");
		SinglyLinkedList<Company> singlyLinkedList = new SinglyLinkedList<>();

		singlyLinkedList.add(0, new Company("!", "Hi", 2023));
		singlyLinkedList.add(new Company("A", "Hi", 2023));
		singlyLinkedList.add(new Company("B", "Hi", 2023));
		singlyLinkedList.add(new Company("C", "Hi", 2023));
		singlyLinkedList.add(new Company("D", "Hi", 2023));
		singlyLinkedList.add(2, new Company("A2", "Hi", 2023));
		singlyLinkedList.add(6, new Company("E", "Hi", 2023));

		System.out.println(singlyLinkedList);
		System.out.println("Reverse CircularSinglyLinkedList --------");
		System.out.println(singlyLinkedList.get(6));
		System.out.println(singlyLinkedList.get(5));
		System.out.println(singlyLinkedList.get(4));
		System.out.println(singlyLinkedList.get(3));
		System.out.println(singlyLinkedList.get(2));
		System.out.println(singlyLinkedList.get(1));
		System.out.println(singlyLinkedList.get(0));
		System.out.println("End test CircularSinglyLinkedList");
		System.out.println();
	}

	private static void testSinglyLinkedList() {
		System.out.println("Test SinglyLinkedList");
		SinglyLinkedList<Company> singlyLinkedList = new SinglyLinkedList<>();

		singlyLinkedList.add(0, new Company("!", "Hi", 2023));
		singlyLinkedList.add(new Company("A", "Hi", 2023));
		singlyLinkedList.add(new Company("B", "Hi", 2023));
		singlyLinkedList.add(new Company("C", "Hi", 2023));
		singlyLinkedList.add(new Company("D", "Hi", 2023));
		singlyLinkedList.add(2, new Company("A2", "Hi", 2023));
		singlyLinkedList.add(6, new Company("E", "Hi", 2023));

		System.out.println(singlyLinkedList);
		System.out.println("Reverse SinglyLinkedList --------");
		System.out.println(singlyLinkedList.get(6));
		System.out.println(singlyLinkedList.get(5));
		System.out.println(singlyLinkedList.get(4));
		System.out.println(singlyLinkedList.get(3));
		System.out.println(singlyLinkedList.get(2));
		System.out.println(singlyLinkedList.get(1));
		System.out.println(singlyLinkedList.get(0));
		System.out.println("End test SinglyLinkedList");
		System.out.println();
	}
}
