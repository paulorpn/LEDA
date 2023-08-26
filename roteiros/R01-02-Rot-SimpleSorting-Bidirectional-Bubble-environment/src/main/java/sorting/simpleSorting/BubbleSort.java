package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean sorted = true;

		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length) {
			while (sorted) {

				sorted = false;

				for (int i = leftIndex; i < rightIndex; i++) {
					if (array[i + 1].compareTo(array[i]) <= -1) {
						Util.swap(array, i, i + 1);
						sorted = true;
					}
			
				}
			}
		}
	}
}