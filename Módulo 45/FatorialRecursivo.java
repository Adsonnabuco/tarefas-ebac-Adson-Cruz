public class FatorialRecursivo {
    public static void main(String[] args) {
        int n =7;
        System.out.println("Fatorial de " + n + ": " + calcularFatorial(n);
    }

    public static long clacularFatorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * calcularFatorial(n-1);
    }
}
