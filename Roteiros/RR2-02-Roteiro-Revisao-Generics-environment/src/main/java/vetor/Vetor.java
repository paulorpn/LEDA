package vetor;

import java.util.Comparator;

import javax.management.RuntimeErrorException;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T objeto) {
		this.arrayInterno[++indice] = objeto;
	}

	// Remove um objeto do vetor
	public T remover(T objeto) {
		T result = null;

		for (int i = 0; i < arrayInterno.length; i++) {
			if (!isVazio() && arrayInterno[i].equals(objeto)) {
				result = arrayInterno[i];
				arrayInterno[i] = null;
				indice--;
				return result;
			}
		}

		throw new RuntimeException("Produto inexistente!");
	}
	

	// Procura um elemento no vetor
	public T procurar(T objeto) {
		for (int i = 0; i < arrayInterno.length; i++) {
			if (!isVazio() && arrayInterno[i].equals(objeto)) {
				return arrayInterno[i];
			}
		}

		throw new RuntimeException("Produto inexistente!");
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.arrayInterno.length == this.tamanho;
	}

}
