public class Pilha {

    private No inicio, atual, aux;
    private int size;

    public Pilha() {
        this.inicio = null;
        this.atual = null;
        this.size = 0;
    }

    public void push(double valor) {
        aux = new No(valor);
        if (size == 0) {
            inicio = aux;
            atual = inicio;
        } else {
            atual.setProx(aux);
            aux.setAnt(atual);
            atual = aux;
        }
        size++;
    }

    public double pop() {
        if (empty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        aux = atual;
        double valor = aux.getValor();

        if (atual == inicio) {
            inicio = null;
            atual = null;
        } else {
            atual = atual.getAnt();
            atual.setProx(null);
        }

        aux.setAnt(null);
        aux.setProx(null);

        size--;
        return valor;
    }

    public double top() {
        if (!empty()) {
            return atual.getValor();
        }
        throw new IllegalStateException("Pilha vazia");
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
