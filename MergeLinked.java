class NoL {
    int valor;
    NoL prox;
}

class FilaLinked {
    private NoL inicio = null;
    private NoL fim = null;

    public void insere(int v) {
        NoL n = new NoL();
        n.valor = v;
        n.prox = null;
        if (inicio == null) {
            inicio = n;
            fim = n;
        } else {
            fim.prox = n;
            fim = n;
        }
    }

    public boolean vazia() { return inicio == null; }

    public int remove() {
        if (inicio == null) {
            System.out.println("Fila vazia. Nenhum elemento removido.");
            return 0;
        }
        int x = inicio.valor;
        inicio = inicio.prox;
        if (inicio == null) fim = null;
        System.out.println("Removido da fila: " + x);
        return x;
    }

    public int frente() {
        if (inicio == null) return 0;
        return inicio.valor;
    }

    public void imprime() {
        if (inicio == null) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("Elementos da fila (da frente para trás):");
        NoL a = inicio;
        while (a != null) {
            System.out.println(a.valor);
            a = a.prox;
        }
    }
}

public class MergeLinked {
    public static FilaLinked merge(FilaLinked A, FilaLinked B) {
        FilaLinked C = new FilaLinked();
        while (!A.vazia() && !B.vazia()) {
            int a = A.frente();
            int b = B.frente();
            if (a <= b) C.insere(A.remove());
            else C.insere(B.remove());
        }
        while (!A.vazia()) C.insere(A.remove());
        while (!B.vazia()) C.insere(B.remove());
        return C;
    }

    public static void main(String[] args) {
        FilaLinked A = new FilaLinked();
        A.insere(12); A.insere(35); A.insere(52); A.insere(64);

        FilaLinked B = new FilaLinked();
        B.insere(5); B.insere(15); B.insere(23); B.insere(55); B.insere(75);

        FilaLinked C = merge(A, B);

        System.out.println("Fila C (merge encadeado):");
        C.imprime();
    }
}
