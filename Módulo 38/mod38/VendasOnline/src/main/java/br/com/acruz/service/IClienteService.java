/**
 * 
 */
package br.com.acruz.service;

import br.com.acruz.domain.Cliente;
import br.com.acruz.exceptions.DAOException;
import br.com.acruz.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
