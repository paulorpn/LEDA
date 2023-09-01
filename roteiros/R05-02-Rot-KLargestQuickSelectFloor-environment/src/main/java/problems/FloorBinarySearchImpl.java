package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
	}

	private Integer binarySearch(Integer[] array, Integer x, Integer leftIndex, Integer rightIndex) {
		Integer middle = (leftIndex + rightIndex) / 2;
		Integer floor = array[middle];

		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {

			if (array[middle].compareTo(x) < 0) {
				binarySearch(array, x, middle + 1, rightIndex);
			} else if (array[middle].compareTo(x) > 0) {
				binarySearch(array, x, leftIndex, middle);
			}
		}

		return floor;
	}

	private void quickSort(Integer[] array, Integer leftIndex, Integer rightIndex) {
		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {
			
			Integer pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
			
		}
	}

	private Integer partition(Integer[] array, Integer leftIndex, Integer rightIndex) {
		
		Integer pivot = array[leftIndex];
		Integer i = leftIndex;

		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {

			for (Integer j = leftIndex + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(pivot) <= 0) {
					i += 1;
					Util.swap(array, i, j);
				}
			}

			Util.swap(array, leftIndex, i);
		}

		return i;
	}
}
