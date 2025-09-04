class FilaArray {
    private static final int CAP = 64;
    private final int[] dados = new int[CAP];
    private int ini = 0;
    private int fim = 0;
    private int tam = 0;

    public boolean vazia() { return tam == 0; }
    public boolean cheia() { return tam == CAP; }

    public void insere(int v) {
        if (cheia()) {
            System.out.println("Fila cheia. Nao inserido: " + v);
            return;
        }
        dados[fim] = v;
        fim = fim + 1;
        if (fim == CAP) fim = 0;
        tam++;
    }

    public int remove() {
        if (vazia()) {
            System.out.println("Fila vazia. Nenhum elemento removido.");
            return 0;
        }
        int x = dados[ini];
        ini = ini + 1;
        if (ini == CAP) ini = 0;
        tam--;
        System.out.println("Removido da fila: " + x);
        return x;
    }

    public int frente() {
        if (vazia()) return 0;
        return dados[ini];
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("Elementos da fila (da frente para trás):");
        int i = 0;
        int idx = ini;
        while (i < tam) {
            System.out.println(dados[idx]);
            idx++;
            if (idx == CAP) idx = 0;
            i++;
        }
    }
}

public class MergeArray {
    public static FilaArray merge(FilaArray A, FilaArray B) {
        FilaArray C = new FilaArray();
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
        FilaArray A = new FilaArray();
        A.insere(12); A.insere(35); A.insere(52); A.insere(64);

        FilaArray B = new FilaArray();
        B.insere(5); B.insere(15); B.insere(23); B.insere(55); B.insere(75);

        FilaArray C = merge(A, B);

        System.out.println("Fila C (merge com vetor):");
        C.imprime();
    }
}
