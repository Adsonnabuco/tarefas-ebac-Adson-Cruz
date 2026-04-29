import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    Calculadora calc = new Calculadora();

    @Test
    void testAdicionar() {
        assertEquals(5, calc.adicionar(2, 3));
    }

    @Test
    void testDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.dividir(10, 0));
    }
}