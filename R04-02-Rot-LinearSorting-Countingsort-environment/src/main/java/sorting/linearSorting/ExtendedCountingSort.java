package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (array != null && array.length > 0 && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int menor = getMenor(array, leftIndex, rightIndex);
			int maior = getMaior(array, leftIndex, rightIndex);

			Integer[] C = new Integer[maior - menor + 1];

			// Popula o array C
			for (int i = 0; i < C.length; i++) {
				C[i] = 0;
			}

			// Frequência
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i] - menor] += 1;
			}

			// Cumulativa
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			Integer[] B = new Integer[rightIndex - leftIndex + 1];

			// Ordenação
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i] - menor] - 1] = array[i];
				C[array[i] - menor] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}

	private int getMenor(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
		}

		return menor;
	}

	private int getMaior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
		}

		return maior;
	}
}