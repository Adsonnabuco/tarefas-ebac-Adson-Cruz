public class Calculadora {

    public int adicionar(int a, int b) {
        return a+b;
    }
    public int subtrair(int a, int b){
        return a-b;
    }
    public int multiplicar(int a, int b){
        return a*b;
    }

    public int dividir(int a, int b){
        if (b == 0) {
            throw new ArithmeticException("Divisão por zxero nao permitida");
        }
        return a/b;
    }

}
