package pe.bazan.luis.uni.s13;

public class Node<T> {
	Node<T> left, right;
	T data;

	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Node(T data, Node<T> left, Node<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public void setNext(Node<T> next) {
		if(left == null) this.left = next;
		else if(right == null) this.right = next;
		else this.left = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
