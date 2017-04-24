package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import business.Bar;
import business.Cliente;
import persistence.CadastroClientes;

public class BarTest {

	Cliente c1, c2, c3, c4, c5;
	Bar b;
	CadastroClientes cad;

	@Before
	public void initialize() {
		c1 = new Cliente("Luis ", "55555555555", 25, "MASCULINO", true, 28);
		c2 = new Cliente("Pedro ", "11111111111", 95, "MASCULINO", true, 99);
		c3 = new Cliente("Joao ", "22222222222", 45, "MASCULINO", true, 55);
		c4 = new Cliente("Marisa ", "77777777777", 15, "FEMININO", false, 0);
		c5 = new Cliente("Cintia ", "3333333333", 29, "FEMININO", false, 0);
		b = new Bar();
		b.addCliente(c1);
		b.addCliente(c2);
	}

	@Test
	/**
	 * Testa método adicionar cliente ao bar
	 */
	public void testAddCliente() {
		assertTrue(b.addCliente(c3) == true);
	}

	@Test
	/**
	 * Testa método remover cliente do bar
	 */
	public void testRemoveCliente() {
		b.addCliente(c4);
		assertTrue(b.removeCliente(c4) == true);
	}

	@Test
	/**
	 * Adiciona um cliente no bar e retorna falso se o total de pessoas no bar é
	 * zero
	 */
	public void testTotalPessoas() {
		b.addCliente(c5);
		assertFalse(b.totalPessoas() == 0);
	}

	@Test
	/**
	 * Inclui um sócio no bar e testa se total de socios >0 então retorna true
	 */
	public void testTotalSocios() {
		b.addCliente(c1);
		assertTrue(b.totalSocios() > 0);
	}

	@Test
	/**
	 * Inclui um cliente não sócio no bar, e retorna true se o total de não
	 * sócios for >0
	 */
	public void testTotalNaoSocios() {
		b.addCliente(c5);
		assertTrue(b.totalNaoSocios() > 0);
	}

	@Test
	/**
	 * Adiciona um cliente na lista e retorna true se a mesma trouxer size >0
	 */
	public void testGetClientes() {
		b.addCliente(c5);
		assertTrue(b.getClientes().size() > 0);
	}
	/*
	 * @Test public void testDistribuicaoPorGenero() {
	 * fail("Not yet implemented"); }
	 */
}
