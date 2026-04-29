import java.util.ArrayList;
import java.util.List;

public class SubconjuntosBacktracking {
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int n = 2;
        List<List<Integer>> resultado = new ArrayList<>();

        gerarSubconjuntos(S, n, 0, new ArrayList<>(), resultado);

        System.out.println("Saída: " + resultado);
    }

    private static void gerarSubconjuntos(int[] S, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
        // Condição de parada: se o subconjunto atual tem o tamanho n, adicionamos ao resultado
        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        // Percorre os elementos a partir do índice 'inicio' para evitar duplicatas (ex: [1,2] e [2,1])
        for (int i = inicio; i < S.length; i++) {
            // Escolha
            atual.add(S[i]);

            // Exploração (chamada recursiva)
            gerarSubconjuntos(S, n, i + 1, atual, resultado);

            // Backtrack: remove o último elemento para tentar o próximo do laço
            atual.remove(atual.size() - 1);
        }
    }
}