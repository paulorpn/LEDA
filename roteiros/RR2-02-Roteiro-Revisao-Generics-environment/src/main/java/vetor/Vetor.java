package vetor;

import java.util.Comparator;

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
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[this.tamanho];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T result = null;

		for (int i = 0; i <= indice; i++) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				arrayInterno[i] = null;
				break;
			}
		}
		
		indice--;
		return result;
	}
	

	// Procura um elemento no vetor
	public T procurar(T o) {
		T result = null;

		for (int i = 0; i <= indice; i++) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				break;
			}
		}

		return result;
	}

	public T maximo() {
		T result = arrayInterno[0];
		
		for (int i = 1; i <= indice; i++) {
			if (comparadorMaximo.compare(result, arrayInterno[i]) < 0) {
				result = arrayInterno[i];
			}
		}

		return result;
	}

	public T minimo() {
		T result = arrayInterno[0];

		for (int i = 1; i <= indice; i++) {
			if (comparadorMinimo.compare(result, arrayInterno[i]) < 0) {
				result = arrayInterno[i];
			}
		}

		return result;
	}
}

class comparadorMaximo implements Comparator<Aluno> {
	
	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}
}

class comparadorMinimo implements Comparator<Aluno> {
	
	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}
}