package pe.bazan.luis.uni.s06.domain;

public class DoubleNode<T> {
	private T data;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;

	public DoubleNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public DoubleNode<T> getPrev() {
		return prev;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public void setPrev(DoubleNode<T> prev) {
		this.prev = prev;
	}
}
