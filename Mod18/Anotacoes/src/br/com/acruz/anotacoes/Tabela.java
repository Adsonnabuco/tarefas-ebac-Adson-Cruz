package br.com.acruz.anotacoes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //para que possamos acessar durante a execução do programa.
public @interface Tabela {
   String nome(); //o nome da talela está armanezenado aqui.
}
