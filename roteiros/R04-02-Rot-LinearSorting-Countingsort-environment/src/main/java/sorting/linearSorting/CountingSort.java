package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (array != null && array.length > 0 && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			
			int k = getMaior(array, leftIndex, rightIndex);
			Integer[] C = new Integer[k + 1];

			// Popula array C
			for (int i = 0; i < C.length; i++) {
				C[i] = 0;
			}

			// Frequência
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]] += 1;
			}

			// Cumulativa
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			Integer[] B = new Integer[array.length];

			// Ordenação
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]] - 1] = array[i];
				C[array[i]] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[i - leftIndex];
			}
		}
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