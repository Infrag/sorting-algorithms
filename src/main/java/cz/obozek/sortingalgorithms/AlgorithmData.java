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
public class AlgorithmData {

	private Sorter sorter;
	private List<Long> results = new ArrayList<>();

	public AlgorithmData(Sorter sorter) {
		this.sorter = sorter;
	}

	public void addResult(Long result) {
		results.add(result);
	}

	public Sorter getSorter() {
		return sorter;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

	public List<Long> getResults() {
		return results;
	}

	public void setResults(List<Long> results) {
		this.results = results;
	}

}
