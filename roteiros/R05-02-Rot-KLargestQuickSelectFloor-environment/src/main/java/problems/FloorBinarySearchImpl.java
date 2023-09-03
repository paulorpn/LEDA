package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer floor = null;

		if (array != null && array.length > 0) {
			quickSort(array, 0, array.length - 1);
			floor = binarySearch(array, x, floor, 0, array.length - 1);
		} 

		return floor;
	}

	private Integer binarySearch(Integer[] array, Integer x, Integer floorCandidate, Integer leftIndex, Integer rightIndex) {
		
		if (leftIndex <= rightIndex) {

			Integer middle = (leftIndex + rightIndex) / 2;
			Integer midNumber = array[middle];

			if (midNumber.compareTo(x) == 0) {
				floorCandidate = midNumber;
			} else if (midNumber.compareTo(x) < 0) {
				return binarySearch(array, x, midNumber, middle + 1, rightIndex);
			} else {
				return binarySearch(array, x, floorCandidate, leftIndex, middle - 1);
			}
		}

		return floorCandidate;
	}

	private void quickSort(Integer[] array, Integer leftIndex, Integer rightIndex) {
		
		if (leftIndex < rightIndex) {
			
			Integer pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
			
		}
	}

	private Integer partition(Integer[] array, Integer leftIndex, Integer rightIndex) {
		
		Integer pivot = array[leftIndex];
		Integer i = leftIndex;

		if (leftIndex < rightIndex) {

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
