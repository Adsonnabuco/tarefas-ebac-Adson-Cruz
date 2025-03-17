package br.com.acruz;
public class pessoaFisica extends Pessoa{
    private String cpf;
    private String dataDenascimento;

    public  pessoaFisica(String nome, String endereco, String telefone){
        super(nome,endereco,telefone);
        this.cpf = cpf;
        this.dataDenascimento = dataDenascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDenascimento() {
        return dataDenascimento;
    }

    public void setDataDenascimento(String dataDenascimento) {
        this.dataDenascimento = dataDenascimento;
    }
}





