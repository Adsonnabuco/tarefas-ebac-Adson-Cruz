
public class MinhaPilha {
    private int[] elementos = new int[100];
    private int topo= -1;

    public void push(int valor) {
        elementos[++topo] = valor;
    }

    public int pop(){
        if (isEmpty()) throw new RuntimeException("Pilha Vazia");
        return elementos[topo--];

    }

    public int top() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return elementos[topo];
    }

    public boolean isEmpty(){
        return topo == -1;
    }

    public int size() {
        return topo +1;
    }

}
