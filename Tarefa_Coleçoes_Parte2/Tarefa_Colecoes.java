import java.util.*;

public class Tarefa_Colecoes {
    public static void main(String[] args) {
        arraylistContendonomesEgeneros();
        // percorrendoArray();
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
    private static void percorrendoArray(){

        int[] Array = {1,2,5,4,3,56,76,98,75,7,5};
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }

}
