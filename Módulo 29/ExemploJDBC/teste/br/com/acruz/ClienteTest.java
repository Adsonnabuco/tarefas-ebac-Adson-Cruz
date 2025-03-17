package br.com.acruz;

import static org.junit.Assert.*;
import org.junit.Test;
import br.com.acruz.dao.generic.jdbc.dao.ClienteDAO;
import br.com.acruz.dao.generic.jdbc.dao.IClienteDAO;
import br.com.acruz.domin.Cliente;

public class ClienteTest {
	private IClienteDAO clienteDAO;
	
	@Test
	public void cadastrarTest() throws Exception {
		clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Rodrigo Pires");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDAO.buscar("10");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDAO.excluir(clienteBD);
		assertTrue(countDel == 1);
	}
}
