package orderStatistic;

import java.util.Arrays;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) {
		T orderStatistic = null;

		if (array != null && array.length > 0 && !(k < 1 || k > array.length - 1)) {
			orderStatistic = recursiveQuickSelect(array, k, 0, array.length - 1);
		}

		return orderStatistic;
	}

	private T recursiveQuickSelect(T[] array, int k, int leftIndex, int rightIndex) {
		int pivot = partition(array, leftIndex, rightIndex);

		if (leftIndex < rightIndex) {

			if (k - 1 < pivot) {
				return recursiveQuickSelect(array, k, leftIndex, pivot - 1);
			} else if (k - 1 > pivot) {
				return recursiveQuickSelect(array, k, pivot + 1, rightIndex);
			}
		}

		return array[pivot];
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = pickPivotIndex(array, leftIndex, rightIndex);
		Util.swap(array, leftIndex, pivotIndex);

		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, ++i, j);
			}
		}

		Util.swap(array, leftIndex, i);

		return i;
	}

	private int pickPivotIndex(T[] array, int leftIndex, int rightIndex) {
		
		int middle = (leftIndex + rightIndex) / 2;
    
    	T[] sorted = (T[]) new Comparable[3];

		sorted[0] = array[leftIndex];
		sorted[1] = array[middle];
		sorted[2] = array[rightIndex];

		Arrays.sort(sorted);

		if (sorted[1].compareTo(array[leftIndex]) == 0) {
			return leftIndex;
		} else if (sorted[1].compareTo(array[middle]) == 0) {
			return middle;
		}

		return rightIndex;
	}
}