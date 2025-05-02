package br.com.rpires.dao;

import br.com.rpires.dao.generic.jpa.GenericJpaDAO;
import br.com.rpires.dao.jpa.IVendaJpaDAO;
import br.com.rpires.domain.jpa.VendaJpa;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {
	
	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}
	
	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("Operação não permitida");
	}
	
	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("Operação não permitida");
	}
	
	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("Operação não permitida");
	}
}
