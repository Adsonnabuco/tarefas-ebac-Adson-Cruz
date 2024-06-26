import java.util.*;

public class Tarefa_Colecoes {
    public static void main(String[] args) {
        nomesseparadosporvirgulaeemordemalfabetica();
        arraylistContendonomesEgeneros();
    }
    private static void nomesseparadosporvirgulaeemordemalfabetica(){

        //Leitura dos nomes aos quais o usuário informou.
        System.out.println("Olá, Digite alguns nomes separados por virgulas:");
        Scanner console = new Scanner(System.in);
        String classenomes = console.nextLine();
        //Separa os nomes da variavel. esses separados por ","
        String[] nomesArray = classenomes.split(", ");
        //Cria uma arraylist com cada nome já separado.
        List<String> lista  = new ArrayList<>(Arrays.asList(nomesArray));
        //Coloca esses nomes em ordem alfabetica.
        Collections.sort(lista);
        //Looping para que todos os nomes sejam escritos, e o metodo trim() para ignorar os espaços tanto no começo como no fim da variavel.
        System.out.println("Nomes ordenados:");
        for (String nome : lista){
            System.out.println(nome.trim());
        }
    }

    private static void arraylistContendonomesEgeneros(){
        System.out.println("Digite a seguir o nome e o gênero (Exemplos: Adson-M, Fernanda - F): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] arraynomes = input.split(", ");
        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        for (String entry : arraynomes){
            String[] parts = entry.trim().split("-");
            if (parts.length == 2){
                String nome = parts[0].trim();
                String genero = parts[1].trim().toUpperCase();
                if (genero.equals("M")){
                    masculino.add(nome);
                } else if (genero.equals("F")){
                    feminino.add(nome);
                }
            }
        }
        Collections.sort(masculino);
        Collections.sort(feminino);

        System.out.println("Grupo Masculino: ");
        for (String nome : masculino){
            System.out.println(nome);
        }
        System.out.println("Grupo Feminino: ");
        for (String nome : feminino){
            System.out.println(nome);
        }
    }
}
