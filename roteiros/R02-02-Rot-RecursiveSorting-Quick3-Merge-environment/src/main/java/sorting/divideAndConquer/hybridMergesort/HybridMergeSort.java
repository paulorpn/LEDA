package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {

			if (array.length <= SIZE_LIMIT) {
				INSERTIONSORT_APPLICATIONS = 0;

				insertion(array, rightIndex);
				sort(array, leftIndex, rightIndex--);
			}

			else {
				MERGESORT_APPLICATIONS = 0;

				int middle = (leftIndex + rightIndex) / 2;

				sort(array, leftIndex, middle);
				sort(array, middle + 1, rightIndex);

				merge(array, leftIndex, middle, rightIndex);
			}
		}
	}

	public void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {
			MERGESORT_APPLICATIONS += 1;

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

	public void insertion(T[] array, int insertedIndex) {
		INSERTIONSORT_APPLICATIONS = 0;
		
		for (int i = insertedIndex; i >= 1; i--) {
            if (array[i].compareTo(array[i - 1]) < 0) {
           		Util.swap(array, i, i - 1);
            }
        }
	}
}
