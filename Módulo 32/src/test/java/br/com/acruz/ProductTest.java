package br.com.acruz;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.dao.IProductDao;
import br.com.dao.ProductDao;
import br.cruz.domain.Product;

public class ProductTest {
	
	private IProductDao productDao;
	
	public ProductTest() {
		productDao = new ProductDao();
	}

	@Test
	public void Cadastrar() {
		Product product = new Product();
		product.setNome("Teste");
		product.setDescricao("Produto teste");
		product = productDao.cadastrar(product);
		
		assertNotNull(product);
		assertNotNull(product.getId());
	}
}
