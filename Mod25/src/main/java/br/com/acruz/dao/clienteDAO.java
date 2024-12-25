/**
 * 
 */
package br.com.acruz.dao;

import br.com.acruz.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.dao.generic.GenericDAO;

/**
 * 
 */
public class clienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

	public clienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}
	
}
