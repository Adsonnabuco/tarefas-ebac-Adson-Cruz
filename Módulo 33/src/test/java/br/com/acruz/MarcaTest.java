package br.com.acruz;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acruz.dao.IMarcaDao;
import br.com.acruz.dao.MarcaDao;
import br.com.acruz.domain.Marca;

public class MarcaTest {
	
private IMarcaDao marcaDao;
	
	public MarcaTest() {
		marcaDao = new MarcaDao();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("T-01");
		marca.setNome("Marca Test");
		
		marca = marcaDao.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
	}

}
