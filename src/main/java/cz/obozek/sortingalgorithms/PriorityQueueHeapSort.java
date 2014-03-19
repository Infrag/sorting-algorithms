/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author infragile
 */
public class PriorityQueueHeapSort implements Sorter {

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(unsorted);
		List<Integer> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			result.add(pq.poll());
		}
		return result;
	}

	@Override
	public String getAlgorithmName() {
		return "PriorityQueue HeapSort";
	}
}
