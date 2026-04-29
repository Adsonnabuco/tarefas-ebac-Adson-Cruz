
public class MinhaFila {

    private int[] elementos = new int[100];
    private int head = 0;
    private int tail = 0;

    public void enqueue (int valor) {
        elementos[tail++] = valor;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Fila vazia");
        return elementos[head++];
    }

    public int rear() {
        return elementos[tail -1];
    }

    public int front() {
        return elementos[head];
    }

    public int size() {
        return tail - head;
    }

    public boolean isEmpty() {
        return head == tail;
    }
}
