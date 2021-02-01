package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controledealunos.Aluno;
import controledealunos.Grupo;

class alunoTest {

	private Aluno aluno;
	private Aluno aluno2;

	@BeforeEach
	void criaAluno() {
		aluno = new Aluno("1", "Erick", "CC");
	}
	
	@Test
	void testAlunoMatriculaNull() {
		assertThrows(NullPointerException.class, () -> aluno = new Aluno(null, "erick", "cc"));
	}
	
	@Test
	void testAlunoMatriculaVazia() {
		assertThrows(IllegalArgumentException.class, () -> aluno = new Aluno("", "erick", "cc"));
	}
	
	@Test
	void testAlunoNomeNull() {
		assertThrows(NullPointerException.class, () -> aluno = new Aluno("1", null, "cc"));
	}
	
	@Test
	void testAlunoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> aluno = new Aluno("1", "", "cc"));
	}
	
	@Test
	void testAlunoCursoNull() {
		assertThrows(NullPointerException.class, () -> aluno = new Aluno("1", "erick", null));
	}
	
	@Test
	void testAlunoCursoVazio() {
		assertThrows(IllegalArgumentException.class, () -> aluno = new Aluno("1", "erick", ""));
	}
	
	@Test
	void testGetMatricula() {
		assertEquals("1", aluno.getMatricula());
	}

	@Test
	void testHashCode() {
		aluno2 = new Aluno("1", "Erick", "CC");
		assertEquals(aluno.hashCode(), aluno2.hashCode());
	}
	
	@Test
	void testNotHashCode() {
		aluno2 = new Aluno("2", "John", "D");
		assertNotEquals(aluno.hashCode(), aluno2.hashCode());
	}


	@Test
	void testEquals() {
		aluno2 = new Aluno("1", "Erick", "CC");
		assertEquals(true, aluno.equals(aluno2));
	}

	@Test
	void testEqualsNull() {
		Object aluno2 = null;
		assertEquals(false, aluno.equals(aluno2));
	}

	@Test
	void testEqualsObject() {
		Object aluno = new Aluno("1", "Erick", "CC");
		Object aluno2 = aluno;
		assertEquals(true, aluno.equals(aluno2));
	}

	@Test
	void testNotEqualsClass() {
		Aluno aluno = new Aluno("1", "Erick", "CC");
		Grupo grupo = new Grupo("listas");
		assertEquals(false, aluno.equals(grupo));
	}

	@Test
	void testEqualsOneMatriculaNull() {
		Aluno aluno = new Aluno("2", "Erick", "CC");
		Aluno aluno2 = new Aluno("1", "Erick", "CC");
		assertEquals(false, aluno.equals(aluno2));
	}

	@Test
	void testNotEquals() {
		Aluno aluno = new Aluno("1", "Erick", "CC");
		Aluno aluno2 = new Aluno("2", "Erick", "CC");
		assertEquals(false, aluno.equals(aluno2));
	}

	@Test
	void testToString() {
		Aluno aluno = new Aluno("1", "Erick", "CC");
		assertEquals("1 - Erick - CC", aluno.toString());
	}

}
