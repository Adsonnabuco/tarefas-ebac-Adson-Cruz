import java.math.BigInteger;

public class FatorialTopDOwm {
    private static BigInteger[] memo = new BigInteger[101];

    public static BigInteger calcular (int n) {
        if (n <= 1) return BigInteger.ONE;

        if (memo[n] != null  return memo[n]);

        return memo[n] = BigInteger.valueOf(n).multiply(calcular(n-1));
        }
    }
}
