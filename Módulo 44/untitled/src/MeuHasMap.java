public class MeuHasMap {
    private Integer[] chaves = new Integer[10];
    private Integer[] valores = new Integer[10];

    // Função Hash: simples resto da divisão (modulo) pelo tamanho (10)
    // Justificativa: É a forma mais eficiente de distribuir inteiros uniformemente em um array de tamanho fixo.
    private int hash(int key) {
        return Math.abs(key) % 10;
    }

    public void put(int key, int value) {
        int index = hash(key);
        while (chaves[index] != null && chaves[index] != key) {
            index = (index + 1) % 10; // Linear probing
        }
        chaves[index] = key;
        valores[index] = value;
    }

    public int get(int key) {
        int index = hash(key);
        int start = index;
        while (chaves[index] != null) {
            if (chaves[index] == key) return valores[index];
            index = (index + 1) % 10;
            if (index == start) break;
        }
        throw new RuntimeException("Chave não encontrada");
    }

    public void delete(int key) {
        int index = hash(key);
        while (chaves[index] != null) {
            if (chaves[index] == key) {
                chaves[index] = null;
                valores[index] = null;
                return;
            }
            index = (index + 1) % 10;
        }
    }

    public void clear() {
        chaves = new Integer[10];
        valores = new Integer[10];
    }
}