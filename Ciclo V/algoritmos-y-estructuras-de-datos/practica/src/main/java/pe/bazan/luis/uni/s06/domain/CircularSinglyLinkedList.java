package pe.bazan.luis.uni.s06.domain;

public class CircularSinglyLinkedList<T> {
	private SimpleNode<T> head;
	private SimpleNode<T> end;
	private int size;

	public CircularSinglyLinkedList() {
		this.head = null;
		this.end = null;
		this.size = 0;
	}

	public void add(T data) {
		addLast(data);
	}

	public void add(int index, T data) {
		if(this.size == 0 && index != 0) throw new ArrayIndexOutOfBoundsException();
		else if (index == this.size) {
			addLast(data);
			return;
		}
		else if(index > this.size) throw new ArrayIndexOutOfBoundsException();
		else if (index == 0) {
			addFirst(data);
			return;
		}

		// It's Other Node
		SimpleNode<T> newNode = new SimpleNode<T>(data);
		int counter = 0;
		SimpleNode pointer = head;

		while (counter <= index) {
			if(counter < index - 1) {
				pointer = pointer.getNextNode();
				counter++;
			} else {
				newNode.setNextNode(pointer.getNextNode());
				pointer.setNextNode(newNode);
				this.size++;
				break;
			}
		}
	}

	public void addFirst(T data) {
		if(this.size == 0) {
			initNodes(data);
			return;
		}
		SimpleNode<T> newData = new SimpleNode<>(data);
		newData.setNextNode(this.head);
		this.head = newData;
		this.size++;
	}

	public void addLast(T data) {
		if(this.size == 0) {
			initNodes(data);
			return;
		}
		SimpleNode<T> newData = new SimpleNode<>(data);
		this.end.setNextNode(newData);
		this.end = newData;
		this.end.setNextNode(head);
		this.size++;
	}

	// It's first node
	private void initNodes(T data) {
		if(head == null) {
			head = new SimpleNode<>(data);
			head.setNextNode(head);
			end	= head;
			this.size = 1;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(head.getData().toString());

		SimpleNode<T> pointer = head;

		for (int i = 0; i < this.size - 1; i++) {
			stringBuilder.append("\n");
			stringBuilder.append(pointer.getNextNode().getData().toString());
			pointer = pointer.getNextNode();
		}

		return stringBuilder.toString();
	}

	public T get(int index) {
		if(index >= this.size) throw new ArrayIndexOutOfBoundsException();

		SimpleNode<T> pointer = head;

		for (int i = 0; i < index; i++) {
			pointer = pointer.getNextNode();
		}

		return pointer.getData();
	}

	public int size() {
		return size;
	}
}
