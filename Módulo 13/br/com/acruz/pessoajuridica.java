package br.com.acruz;

public class pessoaJuridica extends Pessoa{
    private String cnpj;
    private String dataInalguracao;

    public pessoaJuridica(String nome, String endereco, String telefone){
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.dataInalguracao = dataInalguracao;

    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataInalguracao() {
        return dataInalguracao;
    }

    public void setDataInalguracao(String dataInalguracao) {
        this.dataInalguracao = dataInalguracao;
    }
}
