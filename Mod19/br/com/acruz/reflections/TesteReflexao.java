package br.com.acruz.reflections;

public class TesteReflexao {
   public static void main(String[] args) {
      try {
         Class<?> usuarioClass = Usuario.class;
         
         if (usuarioClass.isAnnotationPresent(Tabela.class)){
            Tabela tabela = usuarioClass.getAnnotation(Tabela.class);
            System.out.println("Nome da Tabela: " + tabela.nome());
         } else {
            System.out.println("Anotação @Tabela não encontrada.");
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
}

