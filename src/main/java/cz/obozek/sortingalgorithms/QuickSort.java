/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author infragile
 */
public class QuickSort implements Sorter {

	private final Random rand = new Random(12);

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		return quickSort(unsorted);
	}

	private List<Integer> quickSort(List<Integer> unsorted) {
		if (unsorted.size() < 2) {
			return unsorted;
		}
		
		int pivot = unsorted.remove(0);
//		int pivot = unsorted.remove(rand.nextInt(unsorted.size() - 1));
		List<Integer> smaller = new ArrayList<>(), bigger = new ArrayList<>();
		for (Integer integer : unsorted) {
			if (integer < pivot) {
				smaller.add(integer);
			} else {
				bigger.add(integer);
			}
		}
		List<Integer> result = quickSort(smaller);
		result.add(pivot);
		result.addAll(quickSort(bigger));
		return result;
	}

	@Override
	public String getAlgorithmName() {
		return "QuickSort";
	}

}
