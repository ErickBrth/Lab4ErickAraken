package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controledealunos.Aluno;
import controledealunos.Grupo;

class grupoTest {

	private Grupo grupo;
	private Aluno aluno;

	@BeforeEach
	void criar() {
		grupo = new Grupo("Listas");
		aluno = new Aluno("1", "Erick", "CC");

	}

	@Test
	void testGrupoNomeNull() {
		assertThrows(NullPointerException.class, () -> grupo = new Grupo(null));
	}

	@Test
	void testGrupoNomeVazia() {
		assertThrows(IllegalArgumentException.class, () -> grupo = new Grupo(""));
	}

	@Test
	void testToStringSemAluno() {
		assertEquals("Alunos do grupo Listas:\n", grupo.toString());
	}

	@Test
	void testToString() {
		grupo.add(aluno);
		assertEquals("Alunos do grupo Listas:\n* 1 - Erick - CC\n", grupo.toString());
	}

}
