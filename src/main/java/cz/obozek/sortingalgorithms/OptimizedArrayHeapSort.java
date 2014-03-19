/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author infragile
 */
public class OptimizedArrayHeapSort implements Sorter {

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		ArrayHeap heap = new ArrayHeap(unsorted.toArray(new Integer[0]));
		List<Integer> result = new ArrayList<>();
		while (heap.hasNext()) {
			result.add(heap.pullRoot());
		}
		return result;
	}

	@Override
	public String getAlgorithmName() {
		return "Optimized Array HeapSort";
	}
}
