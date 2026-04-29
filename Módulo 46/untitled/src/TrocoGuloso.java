import java.util.ArrayList;
import java.util.List;

    public class TrocoGuloso {
        public static void main(String[] args) {
            int quantia = 18;
            int[] moedas = {5, 2, 1}; // Importante: as moedas devem estar em ordem decrescente

            List<Integer> resultado = calcularTroco(quantia, moedas);

            System.out.println("Quantidade de moedas: " + resultado.size());
            System.out.println("Moedas usadas: " + resultado);
        }

        public static List<Integer> calcularTroco(int quantia, int[] moedas) {
            List<Integer> moedasUsadas = new ArrayList<>();
            int restante = quantia;

            for (int moeda : moedas) {
                // Enquanto a moeda couber na quantia restante, nós a utilizamos
                while (restante >= moeda) {
                    restante -= moeda;
                    moedasUsadas.add(moeda);
                }
            }
            return moedasUsadas;
        }
    }
}
