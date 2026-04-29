import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @Test
    void testFibonacciBase() {
        assertEquals(0, fibonacci(0));
        assertEquals(1, fibonacci(1));
    }

    @Test
    void testFibonacciComum() {
        assertEquals(5, fibonacci(5)); // Sequência: 0, 1, 1, 2, 3, 5
    }

    @Test
    void testFibonacciNove() {
        assertEquals(34, fibonacci(9));
    }
}