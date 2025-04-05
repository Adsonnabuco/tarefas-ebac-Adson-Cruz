package br.com.acruz;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acruz.dao.CarroDao;
import br.com.acruz.dao.ICarroDao;
import br.com.acruz.domain.Carro;

public class CarroTest {

	private ICarroDao carroDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
	}
	
	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		carro.setCodigo("test");
		carro.setData("2022/2023");
		carro.setNome("Testando");
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
	
	
	
}


























