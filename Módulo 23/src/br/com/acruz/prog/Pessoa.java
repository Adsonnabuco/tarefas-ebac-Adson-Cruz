package br.com.acruz.prog;

public class Pessoa {
    String nome;
    String sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pessoa(String nome, String sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Sexo: " + sexo;
    }
}
