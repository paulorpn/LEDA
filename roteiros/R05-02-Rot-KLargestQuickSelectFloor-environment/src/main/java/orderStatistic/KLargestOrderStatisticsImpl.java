package orderStatistic;

import java.util.Arrays;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		T[] out = (T[]) new Comparable[k];

		if (k <= array.length) {

			for (int i = 0; i < k; i++) {
				out[i] = orderStatistics(array, i);
			}
		}

		return out;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		T orderStatistic = null;
		quickSort(array, 0, array.length - 1);

		if (k < array.length) {
			orderStatistic = array[k];
		}

		return orderStatistic;
	}

	private void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {
			
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
			
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		T pivot = array[leftIndex];
		int i = leftIndex;

		if (array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {

			for (int j = leftIndex + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(pivot) <= 0) {
					i += 1;
					Util.swap(array, i, j);
				}
			}

			Util.swap(array, leftIndex, i);
		}

		return i;
	}

	public static void main(String[] args) {
		KLargestOrderStatisticsImpl<Integer> teste = new KLargestOrderStatisticsImpl<>();
		Integer[] inte = {4,8,6,9,12,1};
		System.out.println(Arrays.toString(teste.getKLargest(inte, 7)));
	}
}
