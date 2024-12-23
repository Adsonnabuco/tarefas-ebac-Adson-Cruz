package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public class ClienteDao implements IClienteDao {

    public String salvar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
        //return "Sucesso";
    }
    public String buscar() {
        throw new UnsupportedOperationException("Não funciona a busca sem config do banco");
    }
    public String excluir() {
//        throw new UnsupportedOperationException("Não funciona a exclusão sem config do banco");
        return null;
    }
    public String atualizar() {
//        throw new UnsupportedOperationException("Não funciona a exclusão sem config do banco");
        return null;
    }
}
