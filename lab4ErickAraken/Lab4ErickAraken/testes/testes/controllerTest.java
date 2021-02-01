package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controledealunos.Controller;

class controllerTest {
	private Controller controller;

	@BeforeEach
	public void criaController() {
		controller = new Controller();
	}

	@Test
	void testConsultaAlunoMatriculaNull() {
		assertThrows(NullPointerException.class, () -> controller.consultaAluno(null));
	}

	@Test
	void testConsultaAlunoMatriculaVazia() {
		assertThrows(IllegalArgumentException.class, () -> controller.consultaAluno(""));
	}

	@Test
	void testCadastraGrupoNomeNull() {
		assertThrows(NullPointerException.class, () -> controller.cadastraGrupo(null));
	}

	@Test
	void testCadastraGrupoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> controller.cadastraGrupo(""));
	}

	@Test
	void testAlocaAlunoNomeNull() {
		assertThrows(NullPointerException.class, () -> controller.alocaAluno("1", null));
	}

	@Test
	void testAlocaAlunoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> controller.alocaAluno("1", ""));
	}

	@Test
	void testAlocaAlunoMatriculaNull() {
		assertThrows(NullPointerException.class, () -> controller.alocaAluno(null, "Listas"));
	}

	@Test
	void testCadastraGrupoMatriculaVazio() {
		assertThrows(IllegalArgumentException.class, () -> controller.alocaAluno("", "Listas"));
	}

	@Test
	void testImprimeGrupoNomeNull() {
		assertThrows(NullPointerException.class, () -> controller.imprimeGrupo(null));
	}

	@Test
	void testImprimeGrupoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> controller.imprimeGrupo(""));
	}

	@Test
	void testRegistraRespostasMatriculaNull() {
		assertThrows(NullPointerException.class, () -> controller.registraRespostas(null));
	}

	@Test
	void testRegistraRespostasMatriculaVazio() {
		assertThrows(IllegalArgumentException.class, () -> controller.registraRespostas(""));
	}

	@Test
	void testAlunoCadastrado() {
		assertEquals("CADASTRO REALIZADO!", controller.cadastraAluno("2", "berg", "CC"));
	}

	@Test
	void testAlunoJaCadastrado() {
		controller.cadastraAluno("1", "Erick", "CC");
		assertEquals("MATRÍCULA JÁ CADASTRADA!", controller.cadastraAluno("1", "Erick", "CC"));
	}

	@Test	
	void testConsultaAlunoNaoCadastrado() {
		controller.cadastraAluno("1", "Erick", "CC");
		assertEquals("Aluno não cadastrado.", controller.consultaAluno("3"));
	}

	@Test
	void testConsultaAlunocadastrado() {
		controller.cadastraAluno("1", "Erick", "CC");
		assertEquals("Aluno: 1 - Erick - CC", controller.consultaAluno("1"));
	}

	@Test
	void testCadastraGrupo() {
		controller.cadastraAluno("1", "Erick", "CC");
		assertEquals("CADASTRO REALIZADO!", controller.cadastraGrupo("Design"));
	}

	@Test
	void testCadastraGrupoExistente() {
		controller.cadastraGrupo("Listas");
		assertEquals("GRUPO JÁ CADASTRADO!", controller.cadastraGrupo("Listas"));
	}

	@Test
	void testAlocaGrupoInexistente() {
		controller.cadastraAluno("1", "Erick", "CC");
		controller.cadastraGrupo("Listas");
		assertEquals("Grupo não cadastrado\n", controller.alocaAluno("1", "testes"));
	}

	@Test
	void testAlocaAlunoInexistente() {
		controller.cadastraAluno("1", "Erick", "CC");
		controller.cadastraGrupo("Listas");
		assertEquals("Aluno não cadastrado\n", controller.alocaAluno("4", "listas"));
	}

	@Test
	void testAlocaAlunoGrupoInexistente() {
		controller.cadastraGrupo("Listas");

		assertEquals("Grupo não cadastrado\n" + "Aluno não cadastrado\n", controller.alocaAluno("4", "testes"));
	}

	@Test
	void testAlocaAluno() {
		controller.cadastraAluno("1", "Erick", "CC");
		controller.cadastraGrupo("Listas");

		assertEquals("ALUNO ALOCADO!", controller.alocaAluno("1", "Listas"));
	}

	@Test
	void testImprimeGrupo() {
		controller.cadastraAluno("1", "Erick", "CC");
		controller.cadastraGrupo("Listas");
		controller.alocaAluno("1", "Listas");

		assertEquals("Alunos do grupo Listas:\n* 1 - Erick - CC\n", controller.imprimeGrupo("Listas"));
	}

	@Test
	void testImprimeGrupoNaoCadastrado() {
		assertEquals("Grupo não cadastrado", controller.imprimeGrupo("testes"));
	}

	@Test
	void testRegistraRespostasAlunoNaoCadastrado() {
		controller.cadastraAluno("1", "Erick", "CC");
		assertEquals("Aluno não cadastrado.", controller.registraRespostas("2"));
	}

	@Test
	void testRegistraResposta() {
		controller.cadastraAluno("1", "Erick", "CC");
		assertEquals("ALUNO REGISTRADO!", controller.registraRespostas("1"));
	}

	@Test
	void testImprimeRespostas() {
		controller.cadastraAluno("1", "Erick", "CC");
		controller.registraRespostas("1");
		assertEquals("Alunos: \n1. 1 - Erick - CC\n", controller.imprimeRespostas());
	}
}
