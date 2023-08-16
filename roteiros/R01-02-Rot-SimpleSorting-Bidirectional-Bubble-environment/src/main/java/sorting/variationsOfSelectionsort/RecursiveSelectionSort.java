package sorting.variationsOfSelectionsort;

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

			int indiceMenor = auxiliar(array, leftIndex, rightIndex);
			Util.swap(array, leftIndex, indiceMenor);
			sort(array, leftIndex + 1, rightIndex);
		}
	}

	public int auxiliar(T[] array, int leftIndex, int rightIndex) {
		int indiceMenor = leftIndex;

		if (leftIndex != rightIndex) {
			if (array[indiceMenor + 1].compareTo(array[indiceMenor]) == -1) {
				indiceMenor += 1;
				auxiliar(array, indiceMenor, rightIndex);
			}
		}

		return indiceMenor;
	}

}