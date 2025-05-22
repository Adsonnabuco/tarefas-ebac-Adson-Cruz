/**
 * 
 */
package br.com.acruz.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.acruz.dao.IClienteDAO;
import br.com.acruz.domain.Cliente;
import br.com.acruz.exceptions.DAOException;
import br.com.acruz.exceptions.MaisDeUmRegistroException;
import br.com.acruz.exceptions.TableException;
import br.com.acruz.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
