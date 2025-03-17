package br.com.acruz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.com.acruz.dao.generic.jdbc.dao.IProdutoDAO;
import br.com.acruz.dao.generic.jdbc.dao.ProdutoDAO;
import br.com.acruz.domin.Produto;

public class ProdutoTest {
	private IProdutoDAO produtoDAO;
	
	@Test
	public void cadastrarTestProd() throws Exception{
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("10");
		produto.setNome("Lápis");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("10");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
}
