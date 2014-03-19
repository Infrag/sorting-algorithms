/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.List;
import java.util.Random;

/**
 *
 * @author infragile
 */
public class PartitionedQuickSort implements Sorter {

	private final Random rand = new Random(12);

	public static int smallest = 0;
	public static int notSmallest = 0;

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		return quickSort(unsorted, 0, size - 1, 1);
	}

	private List<Integer> quickSort(List<Integer> unsorted, int start, int end, int level) {
		if (end - start < 1) {
			return unsorted;
		}
		if (level == 1) {
			smallest = 0;
			notSmallest = 0;
		}
		int pivotIndex = rand.nextInt(end - start) + start;
//		int pivotIndex = start;
//		if (isSmallestValue(unsorted, start, end, pivotIndex)) {
//			smallest++;
//		} else {
//			notSmallest++;
//		}
		int pivotValue = unsorted.get(pivotIndex);
		swap(unsorted, pivotIndex, end);
		int storeIndex = start;
		pivotIndex = end;
		for (int i = start; i < end; i++) {
			if (unsorted.get(i) <= pivotValue) {
				swap(unsorted, storeIndex, i);
				storeIndex++;
			}
		}
		swap(unsorted, pivotIndex, storeIndex);
		quickSort(unsorted, start, storeIndex - 1, level + 1);
		quickSort(unsorted, storeIndex + 1, end, level + 1);
		return unsorted;
	}

	private void swap(List<Integer> list, int index1, int index2) {
		if (index1 == index2) {
			return;
		}
		int val = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, val);
	}

	public boolean isSmallestValue(List<Integer> list, int start, int end, int index) {
		int value = list.get(index);
		for (int i = start; i <= end; i++) {
			if (list.get(i) > value) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getAlgorithmName() {
		return "Partitioned QuickSort";
	}

}
