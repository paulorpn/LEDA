package sorting.variationsOfBubblesort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for (int i = leftIndex; i < rightIndex; i++) {
			if ((int) array[i + 1] < (int) array[i]) {
				Util.swap(array, i, i + 1);
			}

			System.out.println(Arrays.toString(array));

			for (int j = rightIndex - i; j > leftIndex; j--) {
				if ((int) array[j - 1] > (int) array[j]) {
					Util.swap(array, j, j - 1);
				}

				System.out.println(Arrays.toString(array));
			}
		}
	}
}

class Main {
	public static void main(String[] args) {
		BidirectionalBubbleSort<Integer> bi = new BidirectionalBubbleSort<>();
		Integer[] lista = {5, 3, 1, 1, 8, 4};
		bi.sort(lista, 0, 5);
		System.out.println(Arrays.toString(lista));
	}
}