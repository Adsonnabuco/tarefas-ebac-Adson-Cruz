/**
 * 
 */
package br.com.acruz.dao;

import br.com.acruz.dao.generic.GenericDAO;
import br.com.acruz.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
