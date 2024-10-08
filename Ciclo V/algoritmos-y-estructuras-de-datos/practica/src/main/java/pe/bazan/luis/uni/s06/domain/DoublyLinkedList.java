package pe.bazan.luis.uni.s06.domain;

public class DoublyLinkedList<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> end;
	private int size;

	public DoublyLinkedList() {
		this.head = null;
		this.end = null;
		this.size = 0;
	}

	private void init(T data) {
		this.head = new DoubleNode<>(data);
		this.end = head;
		this.size = 1;
	}

	public void addFirst(T data) {
		if(this.size == 0) {
			init(data);
			return;
		}

		DoubleNode<T> newNode = new DoubleNode<>(data);
		newNode.setPrev(head);
		head.setNext(newNode);
		this.head = newNode;
		size++;
	}

	public void addLast(T data) {
		if(this.size == 0) {
			init(data);
			return;
		}

		DoubleNode<T> newNode = new DoubleNode<>(data);
		newNode.setPrev(end);
		end.setNext(newNode);
		this.end = newNode;
		size++;
	}

	public void add(T data) {
		addLast(data);
	}

	public void add(int index, T data) {
		if(index == 0) {
			addFirst(data);
			return;
		}

		if (index == this.size) {
			addLast(data);
			return;
		}

		if(this.size == 0 || index >= this.size) throw new ArrayIndexOutOfBoundsException();

		DoubleNode<T> newNode = new DoubleNode<T>(data);
		int counter = 0;
		DoubleNode<T> pointer = head;
		while (counter < index) {
			if(counter < index - 1) {
				pointer = pointer.getNext();
				counter++;
			} else {
				newNode.setPrev(pointer.getPrev());
				newNode.setNext(pointer);
				pointer.setPrev(newNode);
				this.size++;
				break;
			}
		}
	}

	public T get(int index) {
		int counter = 0;
		DoubleNode<T> pointer;
		if (index < Math.floorDiv(this.size, 2)) {
			// Start from head
			pointer = this.head;
			while (counter < index) {
				pointer = pointer.getNext();
				counter++;
			}
			return pointer.getData();
		} else {
			// Start from end
			pointer = this.end;
			while (counter < size - index - 1) {
				pointer = pointer.getPrev();
				counter++;
			}
			return pointer.getData();
		}
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < this.size; i++) {
			stringBuilder.append(get(i).toString());
			if(size - 1 != i ) stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}
}
