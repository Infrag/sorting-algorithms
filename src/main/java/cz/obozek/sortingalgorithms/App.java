package cz.obozek.sortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
//		test();
		System.out.println("Preparing sorters...");
		List<AlgorithmData> sorters = initializeSorters();
		System.out.println("Preparing test data...");
		List<List<Integer>> data = initializeData(11);
		System.out.println("Starting tests...");
		System.out.print("\n" + String.format("%25s", " elements:"));
		for (List<Integer> list : data) {
			System.out.print(String.format("%,12d", list.size()));
		}
		System.out.print("\n" + String.format("%25s", " "));
		System.out.print("--------------------------------------------------------------");
		for (AlgorithmData sorter : sorters) {
			System.out.print("\n" + String.format("%25s", sorter.getSorter().getAlgorithmName()) + ": ");
			for (List<Integer> list : data) {
				List<Integer> testData = new ArrayList<>(list);

				long start = System.currentTimeMillis();
				List<Integer> sorted = sorter.getSorter().sort(testData, testData.size());
				long end = System.currentTimeMillis();

//				if (sorted.size() <= 20) {
//					System.out.println(Arrays.toString(sorted.toArray()));
//				}
				sorter.addResult(end - start);
				System.out.print(String.format("%12s", " " + (end - start) + " - " + (checkSorted(sorted) ? "OK" : "Fail")));
//				System.out.println("Smallest - " + PartitionedQuickSort.smallest);
//				System.out.println("Not smallest - " + PartitionedQuickSort.notSmallest);
			}
		}

		System.out.println("");
	}

	private static void test() {
		Random rand = new Random(12);
		List<List<Integer>> lists = initializeData(11);
		for (List<Integer> list : lists) {
			while (list.size() > 1) {
				int index = rand.nextInt(list.size() - 1);
				System.out.print(" " + isSmallest(list, index));
				list.remove(index);
			}
		}
	}

	private static boolean isSmallest(List<Integer> list, int index) {
		int value = list.get(index);
		for (Integer integer : list) {
			if (integer < value) {
				return false;
			}
		}
		return true;
	}

	private static List<List<Integer>> initializeData(int seed) {
		List<List<Integer>> data = new ArrayList<>();
		data.add(randomizeList(seed, 5));
		data.add(randomizeList(seed, 20));
		data.add(randomizeList(seed, 1000));
		data.add(randomizeList(seed, 100001));
		data.add(randomizeList(seed, 4000000));
//		data.add(randomizeList(10, 59999999));
		return data;
	}

	private static List<AlgorithmData> initializeSorters() {
		List<AlgorithmData> sorters = new ArrayList<>();
		sorters.add(new AlgorithmData(new ArrayHeapSort()));
		sorters.add(new AlgorithmData(new OptimizedArrayHeapSort()));
		sorters.add(new AlgorithmData(new PriorityQueueHeapSort()));
		sorters.add(new AlgorithmData(new TopDownMergeSort()));
		sorters.add(new AlgorithmData(new BottomUpMergeSort()));
		sorters.add(new AlgorithmData(new JavaSorter()));
		sorters.add(new AlgorithmData(new QuickSort()));
		sorters.add(new AlgorithmData(new PartitionedQuickSort()));
//		sorters.add(new AlgorithmData(new ArrayQuickSort()));
		return sorters;
	}

	private static List<Integer> randomizeList(int seed, int size) {
		Random rand = new Random(seed);
		List<Integer> result = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			result.add(rand.nextInt(1000));
		}
		return result;
	}

	private static boolean checkSorted(List<Integer> list) {
		Integer last = Integer.MIN_VALUE;
		for (Integer integer : list) {
			if (integer == null || last > integer) {
				return false;
			}
			last = integer;
		}
		return true;
	}
}
