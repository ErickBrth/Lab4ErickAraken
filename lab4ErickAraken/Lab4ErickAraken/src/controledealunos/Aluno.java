package controledealunos;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Constroi um aluno a partir de sua matrícula, nome e curso.
	 * 
	 * @param matricula String com a Matrícula do aluno.
	 * @param nome      String com o nome do aluno.
	 * @param curso     String com o curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula nula!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matrícula vazia!");
		}

		if (nome == null) {
			throw new NullPointerException("Nome nulo!");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio!");
		}

		if (curso == null) {
			throw new NullPointerException("Curso nulo!");
		}
		if (curso.trim().equals("")) {
			throw new IllegalArgumentException("Curso vazio!");
		}

		this.curso = curso;
		this.matricula = matricula;
		this.nome = nome;
	}

	/**
	 * Pega a matrícula do aluno.
	 * 
	 * @return String com a matrícula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Compara o Hash Code dos objetos.
	 * 
	 * @return resultado do cálculo do hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * compara objetos contato. Se são nulos, iguais ou classes diferentes.
	 * 
	 * @param obj recebe um objeto contato.
	 * @return retorna um valor booleano.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Gera uma Representação Textual de Aluno.
	 * 
	 * @return String com a matrícula, nome e curso do aluno.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;

	}

}
