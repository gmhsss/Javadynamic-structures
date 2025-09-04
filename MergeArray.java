// fila implementada com array primitivo
class FilaArray {
    private static final int CAP = 64;   // capacidade máxima do array
    private final int[] dados = new int[CAP]; // vetor que guarda os elementos
    private int ini = 0;  // índice do início da fila
    private int fim = 0;  // índice da próxima posição livre
    private int tam = 0;  // quantidade atual de elementos

    // verifica se a fila está vazia
    public boolean vazia() { return tam == 0; }

    // verifica se a fila está cheia
    public boolean cheia() { return tam == CAP; }

    // insere elemento no fim da fila
    public void insere(int v) {
        if (cheia()) {
            System.out.println("Fila cheia. Nao inserido: " + v);
            return;
        }
        dados[fim] = v;          // coloca no vetor
        fim = fim + 1;           // avança o fim
        if (fim == CAP) fim = 0; // se chegou no limite, volta pro começo (fila circular)
        tam++;                   // aumenta o tamanho
    }

    // remove elemento do início da fila
    public int remove() {
        if (vazia()) {
            System.out.println("Fila vazia. Nenhum elemento removido.");
            return 0;
        }
        int x = dados[ini];      // pega o valor do início
        ini = ini + 1;           // avança o início
        if (ini == CAP) ini = 0; // volta pro começo se passar do limite
        tam--;                   // diminui o tamanho
        System.out.println("Removido da fila: " + x);
        return x;
    }

    // retorna o elemento da frente sem remover
    public int frente() {
        if (vazia()) return 0;
        return dados[ini];
    }

    // imprime todos os elementos da fila
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
            if (idx == CAP) idx = 0; // volta pro início se passar do limite
            i++;
        }
    }
}

// classe que faz o merge de duas filas ordenadas
public class MergeArray {
    public static FilaArray merge(FilaArray A, FilaArray B) {
        FilaArray C = new FilaArray();
        // enquanto as duas filas têm elementos
        while (!A.vazia() && !B.vazia()) {
            int a = A.frente();
            int b = B.frente();
            // escolhe o menor entre a frente das duas filas
            if (a <= b) C.insere(A.remove());
            else C.insere(B.remove());
        }
        // se sobrar elementos em A ou B, adiciona no final de C
        while (!A.vazia()) C.insere(A.remove());
        while (!B.vazia()) C.insere(B.remove());
        return C;
    }

    public static void main(String[] args) {
        // exemplo do enunciado
        FilaArray A = new FilaArray();
        A.insere(12); A.insere(35); A.insere(52); A.insere(64);

        FilaArray B = new FilaArray();
        B.insere(5); B.insere(15); B.insere(23); B.insere(55); B.insere(75);

        FilaArray C = merge(A, B);

        System.out.println("Fila C (merge com vetor):");
        C.imprime();
    }
}
