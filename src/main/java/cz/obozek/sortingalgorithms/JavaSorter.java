/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.obozek.sortingalgorithms;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author infragile
 */
public class JavaSorter implements Sorter {

	@Override
	public List<Integer> sort(List<Integer> unsorted, Integer size) {
		Collections.sort(unsorted);
		return unsorted;
	}

	@Override
	public String getAlgorithmName() {
		return "Classic Java Sorter";
	}

}
