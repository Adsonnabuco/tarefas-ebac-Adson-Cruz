class Node {
    int valor;
    Node next;
    Node(int valor) { this.valor = valor; }
}

public class MinhaLista {
    private Node head;

    public void push(int valor) {
        Node novo = new Node(valor);
        if (head == null) { head = novo; return; }
        Node atual = head;
        while (atual.next != null) atual = atual.next;
        atual.next = novo;
    }

    public int pop() {
        if (head == null) throw new RuntimeException("Lista vazia");
        if (head.next == null) { int v = head.valor; head = null; return v; }
        Node atual = head;
        while (atual.next.next != null) atual = atual.next;
        int v = atual.next.valor;
        atual.next = null;
        return v;
    }

    public void insert(int index, int valor) {
        Node novo = new Node(valor);
        if (index == 0) { novo.next = head; head = novo; return; }
        Node atual = head;
        for (int i = 0; i < index - 1; i++) atual = atual.next;
        novo.next = atual.next;
        atual.next = novo;
    }

    public void remove(int index) {
        if (index == 0) { head = head.next; return; }
        Node atual = head;
        for (int i = 0; i < index - 1; i++) atual = atual.next;
        atual.next = atual.next.next;
    }

    public int elementAt(int index) {
        Node atual = head;
        for (int i = 0; i < index; i++) atual = atual.next;
        return atual.valor;
    }

    public int size() {
        int count = 0;
        Node atual = head;
        while (atual != null) { count++; atual = atual.next; }
        return count;
    }

    public void printList() {
        Node atual = head;
        while (atual != null) { System.out.print(atual.valor + " -> "); atual = atual.next; }
        System.out.println("null");
    }



    //Estrutura	Método	Complexidade (Tempo)	Explicação
    //Pilha	Push / Pop	                O(1)	Acesso direto ao índice topo.
    //Fila	Enqueue / Dequeue	        O(1)	Acesso direto aos ponteiros head/tail.
    //Lista	Push / Pop	                O(n)	Precisa percorrer a lista até o fim.
    //Lista	Insert / Remove / ElementAt	O(n)	Precisa iterar até o índice desejado.

}