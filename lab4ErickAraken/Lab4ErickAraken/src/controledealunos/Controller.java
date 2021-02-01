package controledealunos;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

	private HashMap<String, Aluno> mapaMatriculaAlunos;
	private HashMap<String, Grupo> mapaGrupoAlunos;

	private ArrayList<Aluno> listaRespostas;

	/**
	 * Constroi um Controller com um mapa de alunos e grupos e uma lista com as
	 * respostas.
	 */
	public Controller() {
		mapaMatriculaAlunos = new HashMap<>();
		mapaGrupoAlunos = new HashMap<String, Grupo>();
		listaRespostas = new ArrayList<>();
	}

	/**
	 * Cadastra os alunos no mapaMatriculaAlunos.
	 * 
	 * @param matricula Matrícula do aluno
	 * @param nome      Nome do aluno.
	 * @param curso     Curso do aluno
	 * @return se o cadastro foi realizado ou se a matrícula já estpa cadastrada.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!mapaMatriculaAlunos.containsKey(matricula)) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			mapaMatriculaAlunos.put(matricula, aluno);
			return "CADASTRO REALIZADO!";
		}
		return "MATRÍCULA JÁ CADASTRADA!";
	}

	/**
	 * Consulta os alunos no mapaMatriculaAluno a partir de sua matricula.
	 * 
	 * @param matricula Matrícula do aluno.
	 * @return o respectivo aluno ou se não foi cadastrado.
	 */
	public String consultaAluno(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula nula!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matrícula vazia!");
		}

		if (!mapaMatriculaAlunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		return "Aluno: " + mapaMatriculaAlunos.get(matricula).toString();

	}

	/**
	 * Cadastra um novo Grupo.
	 * 
	 * @param nomeGrupo Nome do grupo a ser cadastrado.
	 * @return String se o Grupo foi cadastrado.
	 */
	public String cadastraGrupo(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome do grupo nulo!");
		}
		if (nomeGrupo.trim().equals("")) {
			throw new IllegalArgumentException("Nome do grupo vazio!");
		}

		if (mapaGrupoAlunos.containsKey(nomeGrupo.toLowerCase())) {

			return "GRUPO JÁ CADASTRADO!";
		}
		Grupo grupo = new Grupo(nomeGrupo);

		mapaGrupoAlunos.put(nomeGrupo.toLowerCase(), grupo);
		return "CADASTRO REALIZADO!";
	}

	/**
	 * Aloca um Aluno em um Grupo a partir de sua matrícula e nome do grupo.
	 * 
	 * @param matricula Matricula do aluno a ser alocado.
	 * @param nomeGrupo Nome do grupo em questão.
	 * @return String se o Aluno foi alocado ou não no grupo.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula nula!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matrícula vazia!");
		}

		if (nomeGrupo == null) {
			throw new NullPointerException("Nome do grupo nulo!");
		}
		if (nomeGrupo.trim().equals("")) {
			throw new IllegalArgumentException("Nome do grupo vazio!");
		}

		String resp = "";
		boolean entrou = false;
		if (!mapaGrupoAlunos.containsKey(nomeGrupo.toLowerCase())) {
			entrou = true;
			resp += "Grupo não cadastrado\n";
		}
		if (!mapaMatriculaAlunos.containsKey(matricula)) {
			entrou = true;
			resp += "Aluno não cadastrado\n";
		}
		if (entrou) {
			return resp;
		}

		Grupo grupo = mapaGrupoAlunos.get(nomeGrupo.toLowerCase());
		Aluno aluno = mapaMatriculaAlunos.get(matricula);
		grupo.add(aluno);
		return "ALUNO ALOCADO!";
	}

	/**
	 * Imprime os Alunos de um Grupo a partir de seu nome.
	 * 
	 * @param nomeGrupo Nome do Grupo a ser impresso.
	 * @return String informando se o grupo existe ou se não foi cadastrado.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome do Grupo nulo!");
		}
		if (nomeGrupo.trim().equals("")) {
			throw new IllegalArgumentException("Nome do Grupo vazio!");
		}

		if (mapaGrupoAlunos.containsKey(nomeGrupo.toLowerCase())) {
			Grupo grupo = this.mapaGrupoAlunos.get(nomeGrupo.toLowerCase());
			return grupo.toString();
		}
		return "Grupo não cadastrado";
	}

	/**
	 * Registra as Respostas dos alunos que responderam às perguntas.
	 * 
	 * @param matricula Matrícula do aluno que respondeu.
	 * @return String se o aluno foi registrado ou se ele não está cadastrado.
	 */
	public String registraRespostas(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula nula!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matrícula vazia!");
		}

		if (!mapaMatriculaAlunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		Aluno aluno = mapaMatriculaAlunos.get(matricula);
		listaRespostas.add(aluno);
		return "ALUNO REGISTRADO!";
	}

	/**
	 * Imprime os alunos que responderam às perguntas.
	 * 
	 * @return String com a lista dos alunos que responderam.
	 */
	public String imprimeRespostas() {
		String lista = "Alunos: \n";
		int cont = 1;
		for (Aluno aluno : 	listaRespostas) {
			lista += cont + ". " + aluno.toString() + "\n";
			cont++;
		}

		return lista;
	}

}
