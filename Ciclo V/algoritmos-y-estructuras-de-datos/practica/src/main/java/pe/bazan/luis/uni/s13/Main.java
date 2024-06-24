package pe.bazan.luis.uni.s13;

public class Main {
	public static void main(String[] args) {
		System.out.println("(A,B)".matches("\\([A-Z],[A-Z]\\)"));

		Node<Character> a = TreeBuilder.buildTree("A(B(D,E),C(F))");

		System.out.println("a");
	}
}
