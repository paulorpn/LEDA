package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {
			
			int middle = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);

			merge(array, leftIndex, middle, rightIndex);
		}
	}

	public void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {

			Integer[] aux = new Integer[array.length];

			int i = leftIndex;
			int j = middle + 1;
			int k = leftIndex;

			while (i <= middle && j <= rightIndex) {
				if (array[i].compareTo(array[j]) < 0) {
					aux[k++] = (Integer) array[i++];
				} else {
					aux[k++] = (Integer) array[j++];
				}
			}

			while (i <= middle) {
				aux[k++] = (Integer) array[i++];
			}

			while (j <= rightIndex) {
				aux[k++] = (Integer) array[j++];
			}

			for (int n = leftIndex; n <= rightIndex; n++) {
				array[n] = (T) aux[n];
			}
		}
	}
}
