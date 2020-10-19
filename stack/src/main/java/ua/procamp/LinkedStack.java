package ua.procamp;


import ua.procamp.exception.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

	Node<T> head;
	private int size;

	private static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			next = null;
			this.data = data;
		}
	}

	@Override
	public void push(T element) {
		if (head == null) {
			head = new Node<>(element);
		}
		Node<T> temp = new Node<>(element);
		Node<T> current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = temp;
		this.size++; // todo: implement this method
	}

	@Override
	public T pop() {
		Node<T> current = head;
		if (current != null) {
			for (int i = 0; i < size-1 && current.next != null; i++) {
				current = current.next;
			}
			this.size--;
			T data = current.next.data;
			current.next = null;
			return data;
		}
		throw new EmptyStackException();// todo: implement this method
	}

	@Override
	public int size() {
		return this.size; // todo: implement this method
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0; // todo: implement this method
	}
}
