/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author infragile
 */
public class ArrayQuickSort implements Sorter {

	private final Random rand = new Random(12);
	private static final Integer[] arrayType = new Integer[0];

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		return Arrays.asList(quickSort(unsorted.toArray(arrayType)));
	}

	private Integer[] quickSort(Integer[] unsorted) {

		Integer pivot = unsorted[0];
		Integer[] smaller = new Integer[unsorted.length], bigger = new Integer[unsorted.length];
		int s = 0, b = 0;
		Integer integer;
		for (int i = 1; i < unsorted.length; i++) {
			integer = unsorted[i];
			if (integer != null) {
				if (integer < pivot) {
					smaller[s] = integer;
					s++;
				} else {
					bigger[b] = integer;
					b++;
				}
			} else {
				break;
			}
		}
		Integer[] result;
		if (s > 1) {
			result = quickSort(smaller);
		} else {
			result = smaller;
		}
		result[s++] = pivot;
		if (b > 0) {
			if (b > 1) {
				bigger = quickSort(bigger);
			}
			int l = 0;
			for (int i = s; i < smaller.length; i++) {
				Integer big = bigger[l++];
				if (big != null) {
					result[i] = big;
				} else {
					break;
				}
			}
		}
		return result;
	}

	@Override
	public String getAlgorithmName() {
		return "Array QuickSort";
	}

}
