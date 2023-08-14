package sorting.simpleSorting;

import sorting.AbstractSorting;
import java.util.Arrays;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean sorted = true;

		while (sorted) {

			sorted = false;

			for (int i = leftIndex; i < rightIndex; i++) {
				if ((int) array[i + 1] < (int) array[i]) {
					swap(array, i, i + 1);
					sorted = true;
				}
			
			}
		}
	}

	public void swap(T[] array, int indiceMenor, int indiceMaior) {
		T aux = array[indiceMenor];
		array[indiceMenor] = array[indiceMaior];
		array[indiceMaior] = aux;
	}
}