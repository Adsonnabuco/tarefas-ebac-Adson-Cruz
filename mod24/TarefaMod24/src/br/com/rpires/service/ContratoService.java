package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Sucesso ao Buscar";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Sucesso ao Excluir";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Sucesso ao Atualizar";
    }


    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }
}
