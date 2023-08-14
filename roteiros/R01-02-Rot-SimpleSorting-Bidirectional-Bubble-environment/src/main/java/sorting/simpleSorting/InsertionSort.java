package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++) {
			
			int j = i;

			while (j > 0 && (int) array[j] < (int) array[j - 1]) {
				swap(array, j, --j);
			}

		}
	}

	public void swap(T[] array, int indiceMenor, int indiceMaior) {
		T aux = array[indiceMenor];
		array[indiceMenor] = array[indiceMaior];
		array[indiceMaior] = aux;
	}
}