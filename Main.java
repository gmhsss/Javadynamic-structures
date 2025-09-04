import java.util.Scanner;
import java.util.Random;

class No {
    int valor;
    No prox;
}

class Pilha {
    private No topo = null;

    public void insere(int v) {
        No n = new No();
        n.valor = v;
        n.prox = topo;
        topo = n;
    }

    public int remove() {
        if (topo == null) {
            System.out.println("Pilha vazia. Nenhum elemento removido.");
            return 0;
        }
        int removido = topo.valor;
        topo = topo.prox;
        System.out.println("Removido da pilha: " + removido);
        return removido;
    }

    public void imprime() {
        if (topo == null) {
            System.out.println("Pilha vazia.");
            return;
        }
        System.out.println("Elementos da pilha (do topo para a base):");
        No atual = topo;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }

    public boolean vazia() {
        return topo == null;
    }
}

class Fila {
    private No inicio = null;
    private No fim = null;

    public void insere(int v) {
        No n = new No();
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

    public int remove() {
        if (inicio == null) {
            System.out.println("Fila vazia. Nenhum elemento removido.");
            return 0;
        }
        int removido = inicio.valor;
        inicio = inicio.prox;
        if (inicio == null) {
            fim = null;
        }
        System.out.println("Removido da fila: " + removido);
        return removido;
    }

    public void imprime() {
        if (inicio == null) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("Elementos da fila (da frente para trás):");
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }

    public boolean vazia() {
        return inicio == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        Pilha pilha = new Pilha();
        Fila fila = new Fila();

        while (true) {
            System.out.println();
            System.out.println("Selecione a estrutura:");
            System.out.println("1 Pilha");
            System.out.println("2 Fila");
            System.out.println("0 Sair");
            int estrutura = lerOpcao(in);

            if (estrutura == 0) {
                System.out.println("Encerrando.");
                break;
            }

            if (estrutura != 1 && estrutura != 2) {
                System.out.println("Opcao invalida.");
                continue;
            }

            System.out.println();
            System.out.println("Operacao:");
            System.out.println("1 Inserir elemento manualmente");
            System.out.println("2 Inserir elemento aleatorio");
            System.out.println("3 Remover elemento");
            System.out.println("4 Imprimir estrutura");
            int op = lerOpcao(in);

            if (estrutura == 1) {
                if (op == 1) {
                    System.out.print("Informe um inteiro para inserir na pilha: ");
                    int v = lerInteiro(in);
                    pilha.insere(v);
                    System.out.println("Inserido na pilha: " + v);
                } else if (op == 2) {
                    int v = gerarAleatorio(rand);
                    pilha.insere(v);
                    System.out.println("Inserido na pilha (aleatorio): " + v);
                } else if (op == 3) {
                    pilha.remove();
                } else if (op == 4) {
                    pilha.imprime();
                }
            } else {
                if (op == 1) {
                    System.out.print("Informe um inteiro para inserir na fila: ");
                    int v = lerInteiro(in);
                    fila.insere(v);
                    System.out.println("Inserido na fila: " + v);
                } else if (op == 2) {
                    int v = gerarAleatorio(rand);
                    fila.insere(v);
                    System.out.println("Inserido na fila (aleatorio): " + v);
                } else if (op == 3) {
                    fila.remove();
                } else if (op == 4) {
                    fila.imprime();
                }
            }
        }

        in.close();
    }

    private static int lerOpcao(Scanner in) {
        if (!in.hasNextInt()) {
            in.next();
            return -1;
        }
        return in.nextInt();
    }

    private static int lerInteiro(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.print("Número inválido. Informe um inteiro: ");
            in.next();
        }
        return in.nextInt();
    }

    private static int gerarAleatorio(Random r) {
        return r.nextInt(99) + 1;
    }
}
