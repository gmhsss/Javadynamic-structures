// nó da lista encadeada
class NoL {
    int valor;   // guarda o valor inteiro
    NoL prox;    // referência para o próximo nó da fila
}

// fila implementada com lista encadeada
class FilaLinked {
    private NoL inicio = null; // aponta pro primeiro nó
    private NoL fim = null;    // aponta pro último nó

    // insere elemento no fim da fila
    public void insere(int v) {
        NoL n = new NoL();
        n.valor = v;
        n.prox = null;
        if (inicio == null) {   // fila vazia
            inicio = n;
            fim = n;
        } else {                // liga no fim
            fim.prox = n;
            fim = n;
        }
    }

    // checa se a fila está vazia
    public boolean vazia() { return inicio == null; }

    // remove o elemento do início
    public int remove() {
        if (inicio == null) {
            System.out.println("Fila vazia. Nenhum elemento removido.");
            return 0;
        }
        int x = inicio.valor;       // pega o valor
        inicio = inicio.prox;       // avança o ponteiro
        if (inicio == null) fim = null; // se esvaziou, zera o fim também
        System.out.println("Removido da fila: " + x);
        return x;
    }

    // olha o valor da frente sem remover
    public int frente() {
        if (inicio == null) return 0;
        return inicio.valor;
    }

    // imprime todos os elementos da fila
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

// classe que faz o merge de duas filas encadeadas ordenadas
public class MergeLinked {
    public static FilaLinked merge(FilaLinked A, FilaLinked B) {
        FilaLinked C = new FilaLinked();
        // enquanto as duas filas tiverem elementos
        while (!A.vazia() && !B.vazia()) {
            int a = A.frente();
            int b = B.frente();
            // compara a frente de cada fila e insere o menor em C
            if (a <= b) C.insere(A.remove());
            else C.insere(B.remove());
        }
        // se sobrar elementos em A ou B, coloca em C
        while (!A.vazia()) C.insere(A.remove());
        while (!B.vazia()) C.insere(B.remove());
        return C;
    }

    public static void main(String[] args) {
        // exemplo do enunciado
        FilaLinked A = new FilaLinked();
        A.insere(12); A.insere(35); A.insere(52); A.insere(64);

        FilaLinked B = new FilaLinked();
        B.insere(5); B.insere(15); B.insere(23); B.insere(55); B.insere(75);

        // faz o merge e imprime a fila C
        FilaLinked C = merge(A, B);

        System.out.println("Fila C (merge encadeado):");
        C.imprime();
    }
}
