package br.com.acruz;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acruz.dao.CarroDao;
import br.com.acruz.dao.ICarroDao;
import br.com.acruz.dao.IMarcaDao;
import br.com.acruz.dao.MarcaDao;
import br.com.acruz.domain.Carro;
import br.com.acruz.domain.Marca;

public class CarroTest {

	private ICarroDao carroDao;
	
	private IMarcaDao marcaDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = criarMarca("a1");
		
		Carro carro = new Carro();
		carro.setCodigo("test");
		carro.setData("2022/2023");
		carro.setNome("Testando");
		carro.setMarca(marca);
		
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
	
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Teste");
		return marcaDao.cadastrar(marca);
	}
	
}


























