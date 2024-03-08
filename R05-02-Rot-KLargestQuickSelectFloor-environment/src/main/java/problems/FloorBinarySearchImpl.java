package problems;

import java.util.Arrays;

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

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int pivotIndex = pickPivotIndex(array, leftIndex, rightIndex);
		Util.swap(array, leftIndex, pivotIndex);

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, ++i, j);
			}
		}

		Util.swap(array, leftIndex, i);

		return i;
	}

	private int pickPivotIndex(Integer[] array, int leftIndex, int rightIndex) {
		
		int middle = (leftIndex + rightIndex) / 2;
    
    	Integer[] sorted = {array[leftIndex], array[middle], array[rightIndex]};
		Arrays.sort(sorted);

		if (sorted[1].compareTo(array[leftIndex]) == 0) {
			return leftIndex;
		} else if (sorted[1].compareTo(array[middle]) == 0) {
			return middle;
		}

		return rightIndex;
	}
}
