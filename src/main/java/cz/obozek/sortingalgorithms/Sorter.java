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
public interface Sorter {

	List<Integer> sort(List<Integer> unsorted, Integer size);

	String getAlgorithmName();
}
