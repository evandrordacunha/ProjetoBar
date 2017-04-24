package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Bar;
import business.Cliente;
import business.Pessoa;
import persistence.CadastroClientes;

public class PessoaTest {
	Pessoa p;

	@Before
	public void initialize() {
		p = new Pessoa("Joana", "0234568985", 25, "FEMININO");

	}

	@Test
	/**
	 * Retorna false se não permitir adiciona idade negativa
	 */
	public void testSetIdade() {
		assertFalse(p.setIdade(-14) == true);
	}

}
