package br.com.acruz.anotacoes;

public class Main {
   public static void main(String[] args) {
      //Acessando a anotação da classse cliente
      Tabela tabela = Cliente.class.getAnnotation(Tabela.class);
      
      if (tabela != null) {
         System.out.println("A tabela é: " + tabela.nome());
      } else {
         System.out.println("A classe não está anotada como @Tabela.");
      }
   }
}