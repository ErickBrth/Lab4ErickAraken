package controledealunos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Controller controllerAluno = new Controller();

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controllerAluno, scanner);
		}
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao           Opção digitada.
	 * @param controllerAluno O Controller de alunos que estamos manipulando.
	 * @param scanner         Objeto scanner para o caso do comando precisar de mais
	 *                        input.
	 */
	private static void comando(String opcao, Controller controllerAluno, Scanner scanner) {
		switch (opcao) {
		case "C":
			adicionaAluno(controllerAluno, scanner);
			break;
		case "E":
			exibeAluno(controllerAluno, scanner);
			break;
		case "N":
			criaGrupo(controllerAluno, scanner);
			break;
		case "A":
			alocaAlunoImprimeGrupos(controllerAluno, scanner);
			break;
		case "R":
			registraRespostas(controllerAluno, scanner);
			break;
		case "I":
			imprimeRespostas(controllerAluno);
			break;
		case "O":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
		
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nSaindo...");
		System.exit(0);
	}

	/**
	 * Imprime quais alunos responderam às perguntas.
	 * 
	 * @param controllerAluno Guarda os alunos que resporam as perguntas.
	 */
	private static void imprimeRespostas(Controller controllerAluno) {
		System.out.println(controllerAluno.imprimeRespostas());
	}

	/**
	 * Registra os alunos que responderam às perguntas
	 * 
	 * @param controllerAluno gerencia os alunos e grupos.
	 * @param scanner         lê as entradas.
	 */
	private static void registraRespostas(Controller controllerAluno, Scanner scanner) {
		System.out.print("Matrícula: ");
		scanner.nextLine();
		String matricula = scanner.nextLine();

		System.out.println(controllerAluno.registraRespostas(matricula));

	}

	/**
	 * Aloca o aluno em um grupo ou imprime o grupo em q um determinado aluno está
	 * alocado.
	 * 
	 * @param ControllerAluno gerencia os Alunos e Grupos.
	 * @param scanner         Entrada de dados.
	 */
	private static void alocaAlunoImprimeGrupos(Controller controllerAluno, Scanner scanner) {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		scanner.nextLine();
		String opcao = scanner.nextLine().toUpperCase();

		if (opcao.equals("A")) {

			System.out.print("Matrícula: ");

			String matricula = scanner.nextLine();

			System.out.print("Grupo: ");
			String grupo = scanner.nextLine();

			System.out.println(controllerAluno.alocaAluno(matricula, grupo));
		}

		if (opcao.equals("I")) {
			System.out.print("Grupo: ");
			String nomeGrupo = scanner.nextLine();

			System.out.println(controllerAluno.imprimeGrupo(nomeGrupo));
		}

	}

	/**
	 * Cria os Grupos.
	 * 
	 * @param ControllerAluno gerencia os alunos e grupos.
	 * @param scanner         Entrada de dados.
	 */
	private static void criaGrupo(Controller controllerGrupo, Scanner scanner) {
		System.out.print("Grupo: ");
		scanner.nextLine();
		String nomeGrupo = scanner.nextLine();

		System.out.println(controllerGrupo.cadastraGrupo(nomeGrupo));
	}

	/**
	 * Exibe um aluno através da matrícula.
	 * 
	 * @param ControllerAluno gerencia os alunos e grupos.
	 * @param scanner         Entrada de dados.
	 */
	private static void exibeAluno(Controller controllerAluno, Scanner scanner) {
		System.out.print("Matrícula: ");
		scanner.nextLine();
		String matricula = scanner.nextLine();
		System.out.println(controllerAluno.consultaAluno(matricula));
	}

	/**
	 * Cadastra um novo aluno.
	 * 
	 * @param ControllerAluno gerencia os alunos e grupos.
	 * @param scanner         Entrada de dados.
	 */
	private static void adicionaAluno(Controller controllerAluno, Scanner scanner) {

		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curso: ");
		String curso = scanner.nextLine();

		System.out.println(controllerAluno.cadastraAluno(matricula, nome, curso));

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println("\n---\nMENU\n" + "(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Imprimir Grupos\n" + "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n" + "(O)ra, vamos fechar o programa!\r\n" + "\n" + "Opção> ");

		return scanner.next().toUpperCase();

	}
}
