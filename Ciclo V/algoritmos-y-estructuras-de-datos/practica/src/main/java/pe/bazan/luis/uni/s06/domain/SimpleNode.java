package pe.bazan.luis.uni.s06.domain;

public class SimpleNode<T> {
	private T data;
	private SimpleNode nextNode;

	public SimpleNode(T data) {
		this.data = data;
	}

	public SimpleNode(SimpleNode nextNode, T data) {
		this.nextNode = nextNode;
		this.data = data;
	}

	public void setNextNode(SimpleNode nextNode) {
		this.nextNode = nextNode;
	}

	public SimpleNode getNextNode() {
		return nextNode;
	}

	public T getData() {
		return data;
	}
}
