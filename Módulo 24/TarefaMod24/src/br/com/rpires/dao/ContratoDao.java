package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public class ContratoDao implements IContratoDao {

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }
    @Override
    public void atualizar() {
//        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public void buscar() {
//        throw new UnsupportedOperationException("Não funciona a busca sem config do banco");
    }

    @Override
    public void excluir() {
//        throw new UnsupportedOperationException("Não funciona a exclusão sem config do banco");
    }
}
