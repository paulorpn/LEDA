package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if ((leftIndex < rightIndex) && (array != null) && (array.length != 0)
		 && (leftIndex >= 0) && (rightIndex <= array.length)) {

			swapIndiceMenor(array, leftIndex, rightIndex, leftIndex + 1);
			sort(array, leftIndex + 1, rightIndex);
		}
	}

	public void swapIndiceMenor(T[] array, int leftIndex, int rightIndex, int i) {
		if (i <= rightIndex) {
			int indiceMenor = leftIndex;

			if (array[i].compareTo(array[indiceMenor]) <= -1) {
				indiceMenor = i;
				swapIndiceMenor(array, i, rightIndex, i + 1);
			}
			else {
				swapIndiceMenor(array, indiceMenor, rightIndex, i + 1);
			}

			Util.swap(array, leftIndex, indiceMenor);
		}
	}

}