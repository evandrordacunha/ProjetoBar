package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controls.Controle;
import business.Bar;
import business.Cliente;
import persistence.CadastroClientes;

public class ControleTest {
	Cliente c1, c2, c3, c4, c5;
	Controle controle = new Controle();

	@Before
	public void initialize() {
		c1 = new Cliente("Luis ", "55555555555", 25, "MASCULINO", true, 28);
		c2 = new Cliente("Pedro ", "11111111111", 95, "MASCULINO", true, 99);
		c3 = new Cliente("Joao ", "22222222222", 45, "MASCULINO", true, 55);
		c4 = new Cliente("Marisa ", "77777777777", 15, "FEMININO", false, 0);
		c5 = new Cliente("Cintia ", "3333333333", 29, "FEMININO", false, 0);

	}

	/*
	 * 
	 * @Test /** Validação aplicada ao formulário
	 */
	/*
	 * public void testPopularListaClientes() { fail("Not yet implemented"); }
	 */
	/*
	 * @Test /** Validação aplicada ao formulário
	 */
	/*
	 * public void testValidaCpf() { fail("Not yet implemented"); }
	 * 
	 * @Test /** Validação aplicada ao formulário
	 */
	/*
	 * public void testValidaIdade() { fail("Not yet implemented"); }
	 */
	@Test
	/**
	 * Passa como parâmetro um número negativo que não deverá ser aceito
	 */
	public void testTratarNumeroSocio() {
		Cliente c = new Cliente("Eu", "11111222222", 25, "Masculino", true, -1);
		assertTrue(controle.tratarNumeroSocio("-1") >= 0);
	}
	/*
	 * @Test public void testValidaNumeroSocio() { fail("Not yet implemented");
	 * }
	 * 
	 * @Test public void testGerarAquivo() { fail("Not yet implemented"); }
	 */
}
