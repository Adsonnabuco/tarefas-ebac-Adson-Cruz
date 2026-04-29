import java.math.BigInteger;

public class FatorialBottomUp {
    public static BigInteger calcular(int n) {
        BigInteger[] tabela = new BigInteger[n + 1];
        tabela[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            tabela[i] = tabela[i - 1].multiply(BigInteger.valueOf(i));
        }
        return tabela[n];
    }
}
