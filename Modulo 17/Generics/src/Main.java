import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      List<Carro> listadecarros = new ArrayList<>();
      //Adiciona carro a lista.
      listadecarros.add(new Honda("Civic"));
      listadecarros.add(new Chevrolet("Onix"));
      listadecarros.add(new Toyota("Corola"));
      
      for (Carro carro : listadecarros) {
         System.out.println(carro);
         System.out.println(carro);
         
      }
   }
}