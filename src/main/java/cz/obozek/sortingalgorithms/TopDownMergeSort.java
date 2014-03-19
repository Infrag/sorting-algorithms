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
public class TopDownMergeSort implements Sorter {

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		List<Integer> result = new ArrayList<>(size);
		for (int chunkSize = 4; chunkSize < size; chunkSize = chunkSize * 2) {
			int first = 0, second = chunkSize, middle = second;
			int secondEnd = 2 * chunkSize;
			if (secondEnd >= size) {
				secondEnd = size - 1;
			}
			for (int i = 0; i < size; i++) {
				if (first == chunkSize && second == secondEnd) {
					first = secondEnd;
					second = secondEnd + chunkSize;
					secondEnd = second + chunkSize;
					if (secondEnd >= size) {
						secondEnd = size - 1;
					}
					middle = second;
				}
				if (second > secondEnd || (unsorted.get(first) <= unsorted.get(second))) {
					result.add(unsorted.get(first++));
				} else {
					result.add(unsorted.get(second++));
				}
			}
			unsorted = result;
			result = new ArrayList<>();
		}
		return result;
	}

	@Override
	public String getAlgorithmName() {
		return "Top Down Merge Sort";
	}

}
