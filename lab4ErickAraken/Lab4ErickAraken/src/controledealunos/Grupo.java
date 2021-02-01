package controledealunos;

import java.util.HashSet;

public class Grupo {
	private String nomeGrupo;
	HashSet<Aluno> grupo;

	/**
	 * Constrói um grupo a partir de seu nome.
	 * 
	 * @param nomeGrupo String com o nome do grupo.
	 */
	public Grupo(String nomeGrupo) {
		if (nomeGrupo == null)
			throw new NullPointerException("Nome Inválido");
		if (nomeGrupo.trim().equals(""))
			throw new IllegalArgumentException("Matrícula Vazia");

		this.nomeGrupo = nomeGrupo;
		this.grupo = new HashSet<Aluno>();
	}

	/**
	 * Gera uma representação textual de Grupo.
	 * 
	 * @return String com a lista de alunos do grupo.
	 */
	@Override
	public String toString() {
		String listaAluno = "Alunos do grupo " + this.nomeGrupo + ":\n";
		for (Aluno aluno : grupo) {
			listaAluno += "* " + aluno.toString() + "\n";
		}
		return listaAluno;
	}

	/**
	 * Adiciona um aluno ao grupo.
	 * 
	 * @param aluno Aluno a ser adicionado.
	 */
	public void add(Aluno aluno) {
		this.grupo.add(aluno);

	}

}
