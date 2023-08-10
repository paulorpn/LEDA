package vetor;

import org.junit.Test;

public class TestarVetor {
	private static Vetor<Aluno> alunos = new Vetor<>(4);

	public static void main(String[] args) {
		alunos.inserir(new Aluno("Fulano", 9.3));
		alunos.inserir(new Aluno("Ciclano", 9.0));
		alunos.inserir(new Aluno("Deltrano", 6.1));


	}

	@Test
	public void testaMaximo() {
		Aluno maximo = alunos.maximo();
		assert maximo.equals(new Aluno("Fulano", 9.3));
	} 


}
