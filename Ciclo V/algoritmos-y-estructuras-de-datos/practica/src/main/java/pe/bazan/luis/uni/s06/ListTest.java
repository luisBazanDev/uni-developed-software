package pe.bazan.luis.uni.s06;

import pe.bazan.luis.uni.s06.domain.Company;
import pe.bazan.luis.uni.s06.domain.SinglyLinkedList;

public class ListTest {

	public static void main(String[] args) {
		System.out.println("Hello world");
		SinglyLinkedList<Company> list = new SinglyLinkedList<>();

		list.add(0, new Company("!", "Hi", 2023));
		System.out.println(list.size());
		list.add(new Company("A", "Hi", 2023));
		System.out.println(list.size());
		list.add(new Company("B", "Hi", 2023));
		System.out.println(list.size());
		list.add(new Company("C", "Hi", 2023));
		System.out.println(list.size());
		list.add(new Company("D", "Hi", 2023));
		System.out.println(list.size());
		list.add(2, new Company("A2", "Hi", 2023));
		System.out.println(list.size());
		list.add(6, new Company("E", "Hi", 2023));
		System.out.println(list.size());

		System.out.println(list);
		System.out.println("--------");
		System.out.println(list.get(6));
		System.out.println(list.get(5));
		System.out.println(list.get(4));
		System.out.println(list.get(3));
		System.out.println(list.get(2));
		System.out.println(list.get(1));
		System.out.println(list.get(0));
	}
}
