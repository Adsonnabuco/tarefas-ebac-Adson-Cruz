package br.com.acruz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.acruz.dao.ClienteDaoMock;
import br.com.acruz.dao.IClienteDAO;
import br.com.acruz.domain.Cliente;
import br.com.acruz.services.ClienteService;
import br.com.acruz.services.IClienteService;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

public class ClientesServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClientesServiceTest() {
		
		IClienteDAO dao = new ClienteDaoMock();
		
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		
		cliente = new Cliente();
		
		cliente.setCpf(12345678912l);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("Sp");
		cliente.setNumero(10);
		cliente.setTel(119999999l);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException{
		Boolean retorno = clienteService.salvar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException{
		cliente.setNome("Adson Cruz");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Adson Cruz", cliente.getNome());
	}
}


