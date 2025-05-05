package br.com.rpires.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rpires.dao.VendaExclusaoJpaDAO;
import br.com.rpires.dao.jpa.IClienteJpaDAO;
import br.com.rpires.dao.jpa.IProdutoJpaDAO;
import br.com.rpires.dao.jpa.IVendaJpaDAO;
import br.com.rpires.dao.jpa.ProdutoJpaDAO;
import br.com.rpires.dao.jpa.VendaJpaDAO;
import br.com.rpires.domain.Venda.Status;
import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.domain.jpa.ProdutoJpa;
import br.com.rpires.domain.jpa.VendaJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class VendaJpaDAOTest {
	
	private IVendaJpaDAO vendaDao;
	
	private IVendaJpaDAO vendaExclusaoDao;
	
	private IClienteJpaDAO clienteDao;
	
	private IProdutoJpaDAO produtoDao;
	
	private Random rd;
	
	private ClienteJpa cliente;
	
	private ProdutoJpa produto;
	
	public VendaJpaDAOTest() {
		this.vendaDao = new VendaJpaDAO();
		vendaExclusaoDao = new VendaExclusaoJpaDAO();
		this.clienteDao = new ClienteJpaDAo();
		this.produtoDao = new ProdutoJpaDAO();
		rd = new Random();
	}

	@Before
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}
	
	@After
	public void end() throws DAOException {
		excluirVendas();
		excluirProdutos();
		clienteDao.excluir(this.cliente);
	}
	
	@Test
	public void pesquisar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		VendaJpa venda = criarVenda("A1");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		assertNotNull(vendaConsultada);
		assertNotNull(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		VendaJpa venda = criarVenda("A2");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
		
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		assertTrue(vendaConsultada.getId() != null);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void cancelarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A3";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertNotNull(codigoVenda, venda.getCodigo());
	
		retorno.setStatus(Status.CANCELADA);
		vendaDao.cancelarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}
	
	public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException{
		String codigoVenda = "A4";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProdutos(produto, 1);
		
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	
	}
	
	@Test
	public void adicionarMaisProdutosDiferetentes() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException{
		String codigoVenda = "A5";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertNotNull(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProdutos(prod, 1);
		
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}
	
	@Test(expected = DAOException.class)
	public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
		VendaJpa venda = criarVenda("A6");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		
		VendaJpa venda1 = criarVenda("A6");
		VendaJpa retorno1 = vendaDao.cadastrar(venda1);
		assertNull(retorno1);
		assertTrue(venda.getStatus().equals(Status.INICIADA));
		
	}
	
	@Test
	public void removerProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A7";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProdutos(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
		
	}
	
	
	@Test
	public void finalizarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A10";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A11";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
		
		vendaConsultada.adicionarProdutos(this.produto, 1);
		
	}
	
	
	private void excluirProdutos() throws DAOException {
		Collection<ProdutoJpa> list = this.produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.produtoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private void excluirVendas() throws DAOException {
		Collection<VendaJpa> list = this.vendaExclusaoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.vendaExclusaoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	
	private ProdutoJpa cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableExpceiton, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		return produto;
	}
	
	private ClienteJpa cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Adson");
		cliente.setCidade("Ceara");
		cliente.setEnd("End");
		cliente.setEstado("CE");
		cliente.setNumero(30);
		cliente.setTel(32498324983l);
		clienteDao.cadastrar(cliente);
		return cliente;
	}
	
	private VendaJpa criarVenda(String codigo) {
		VendaJpa venda = new VendaJpa();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);
		venda.adicionarProdutos(this.produto, 2);
		return venda;
	}
	
}
