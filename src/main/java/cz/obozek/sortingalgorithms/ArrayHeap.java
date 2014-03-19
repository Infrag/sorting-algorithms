/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author infragile
 */
public class ArrayHeap {

	private Integer[] heap;

	private int tail = 0;
	private static final int INITIAL_SIZE = 256;

	public ArrayHeap(int size) {
		heap = new Integer[size];
	}

	public ArrayHeap() {
		heap = new Integer[INITIAL_SIZE];
	}

	public ArrayHeap(Integer[] elements) {
		int pointer = elements.length - 1;
		while (elements[pointer] == null) {
			pointer--;
		}
		tail = pointer + 1;
		heap = elements;
		while (pointer > 0) {
			pushParentDown(parentIndex(pointer));
			pointer = pointer - 2;
		}
	}

	public void addElement(Integer element) {
		int childIndex = tail++;
		if (childIndex >= heap.length) {
			heap = Arrays.copyOf(heap, heap.length * 2);
		}
		heap[childIndex] = element;
		while (childIndex > 0 && heap[parentIndex(childIndex)] > heap[childIndex]) {
			swap(parentIndex(childIndex), childIndex);
			childIndex = parentIndex(childIndex);
		}
	}

	public boolean hasNext() {
		return tail > 0;
	}

	public Integer pullRoot() {
		Integer result = null;
		if (tail > 0) {
			int lastElement = tail - 1;
			result = heap[0];
			heap[0] = heap[lastElement];
			heap[lastElement] = null;
			tail = tail - 1;
			pushParentDown(0);
		}
		return result;
	}

	private void pushParentDown(int parentIndex) {
		int parent = parentIndex;
		int smallestChild = smallestChild(parent);
		while (smallestChild > -1 && heap[smallestChild] < heap[parent]) {
			swap(smallestChild, parent);
			parent = smallestChild;
			smallestChild = smallestChild(parent);
		}
	}

	private int smallestChild(int parentIndex) {
		int child1 = parentIndex * 2 + 1;
		int child2 = child1 + 1;
		if (child1 >= tail) {
			return -1;
		}
		if (child2 >= tail || heap[child1] < heap[child2]) {
			return child1;
		} else {
			return child2;
		}
	}

	private int parentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private void swap(int index1, int index2) {
		Integer element = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = element;
	}
}
