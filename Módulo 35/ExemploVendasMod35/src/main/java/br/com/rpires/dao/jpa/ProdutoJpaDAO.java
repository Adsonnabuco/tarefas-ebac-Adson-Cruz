package br.com.rpires.dao.jpa;

import br.com.rpires.dao.generic.jpa.GenericJpaDAO;
import br.com.rpires.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO{
	
	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}
}
