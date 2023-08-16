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
		if (leftIndex > rightIndex) {
			return;
		}

		auxiliar(array, leftIndex, rightIndex, leftIndex);
		sort(array, leftIndex + 1, rightIndex);
	}

	public void auxiliar(T[] array, int leftIndex, int rightIndex, int i) {		
		if (i == rightIndex) {
			return;
		}

		if (array[i + 1].compareTo(array[leftIndex]) == -1) {
				Util.swap(array, leftIndex, i + 1);
		}

		auxiliar(array, leftIndex, rightIndex, i + 1);
	}

}