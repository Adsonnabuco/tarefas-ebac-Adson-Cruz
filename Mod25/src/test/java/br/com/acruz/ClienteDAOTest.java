/**
 * 
 */
package br.com.acruz;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.acruz.dao.ClienteDaoMock;
import br.com.acruz.dao.IClienteDAO;
import br.com.acruz.dao.clienteDAO;
import br.com.acruz.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;
	
	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDao = new ClienteDaoMock();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12345678912l);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("Sp");
		cliente.setNumero(10);
		cliente.setTel(119999999l);
		clienteDao.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
	
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteDao.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Adson Cruz");
		clienteDao.alterar(cliente);
		
		Assert.assertEquals(("Adson Cruz"), cliente.getNome());
	}
	
	
}


