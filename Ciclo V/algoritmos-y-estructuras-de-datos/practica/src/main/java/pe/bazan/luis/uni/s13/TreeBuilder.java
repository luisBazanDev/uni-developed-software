package pe.bazan.luis.uni.s13;

import java.util.Stack;

public class TreeBuilder {

	// "A(B(D,E),C(F))"
	public static Node<Character> buildTree(final String treeString) {
		Node<Character> root = new Node<>(treeString.charAt(0));

		try {
			buildSubTree(treeString.substring(2, treeString.length() - 1), root);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return root;
	}

	public static Node<Character> buildSubTree(final String treeString, Node<Character> parent)
			throws Exception {
		if(treeString.isEmpty()) return null;

		if(treeString.length() == 1) {
			return new Node<>(treeString.charAt(0));
		}

		// Match (A,BA)
		if(treeString.matches("\\([A-Z],[A-Z]\\)")) {
			Node<Character> left = new Node<>(treeString.charAt(1));
			Node <Character> right = new Node<>(treeString.charAt(1));

			parent.setLeft(left);
			parent.setRight(right);
		} else if (treeString.matches("\\([A-Z]\\)")) {
			Node<Character> left = new Node<>(treeString.charAt(1));

			parent.setLeft(left);
		} else {
			Node<Character> subTree = new Node<>(treeString.charAt(0));
			String content = treeString.substring(1, treeString.length());

			Stack<Character> stackOpen = new Stack<>();

			int comma = 0;

			for (int i = content.length() - 1; i >= 0; i--) {
				if(content.charAt(i) == ')') {
					stackOpen.push(content.charAt(i));
				} else if(content.charAt(i) == '(') {
					stackOpen.pop();
				} else if(content.charAt(i) == ',') {
					if(stackOpen.isEmpty()) {
						comma = content.length() - i - 1;
						break;
					}
				}
			}

			Node<Character> left = buildSubTree(content.substring(0, comma), subTree);
			Node<Character> right = comma == 0 ? null : buildSubTree(content.substring(comma + 1), subTree);



			parent.setNext(left);
			parent.setNext(right);

		}


		return parent;
	}

//	public static Node<Character> buildSubTree2(String treeString) {
//		switch (treeString.charAt(0)) {
//			case '(':
//				return buildSubTree(treeString.substring(1));
//			case ',':
//				return buildSubTree(treeString.substring(1));
//		}
//	}
}
