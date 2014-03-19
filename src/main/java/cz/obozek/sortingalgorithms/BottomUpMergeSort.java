/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.List;

/**
 *
 * @author infragile
 */
public class BottomUpMergeSort implements Sorter {

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		return recursive(unsorted, 0, size - 1);
	}

	List<Integer> recursive(List<Integer> list, int start, int end) {
		if (end - start <= 1) {
			Integer second = list.get(end), first = list.get(start);
			if (first > second) {
				list.set(start, second);
				list.set(end, first);
			}
			return list;
		}
		Integer middle = (start + end) / 2;
		recursive(list, start, middle);
		recursive(list, middle + 1, end);
		return merge(list, start, middle + 1, end);
	}

	List<Integer> merge(List<Integer> list, int start, int middle, int end) {
		int first = start, second = middle;
		for (int i = start; i <= end; i++) {
			if (second > end || (list.get(first) <= list.get(second))) {
				list.set(i, list.get(first++));
			} else {
				list.set(i, list.get(second++));
			}
		}
		return list;
	}

	@Override
	public String getAlgorithmName() {
		return "Bottom Up Merge Sort";
	}
}
