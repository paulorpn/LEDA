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
		// falhei
	}

}


class Main {
	public static void main(String[] args) {
		RecursiveSelectionSort<Integer> selecao = new RecursiveSelectionSort<>();
		Integer[] lista = {5, 3, 1, 1};
		selecao.sort(lista, 0, 3);
		System.out.println(Arrays.toString(lista));
	}
}