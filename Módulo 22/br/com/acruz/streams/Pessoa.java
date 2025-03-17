package br.com.acruz.streams;

public class Pessoa {
    String nome;
    String sexo;

    public Pessoa(String nome, String sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "Sexo: " + sexo;
    }
}
x