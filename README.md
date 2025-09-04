# Pilha, Fila (listas encadeadas) e Merge (lista encadeada e vetor)


## O que foi implementado
- `Main.java`: Pilha e Fila **dinâmicas (lista encadeada)** com `insere`, `remove`, `imprime`.
- `MergeLinked.java`: MERGE de duas filas **encadeadas** ordenadas → terceira fila ordenada.
- `MergeArray.java`: MERGE de duas filas **com array primitivo** ordenadas → terceira fila ordenada.

Em todas as remoções, o programa **informa o elemento removido**.  
O usuário pode inserir **manualmente** ou com **Random** (opcional).

## Como compilar e executar (VS Code / PowerShell / cmd)
```bash
javac *.java
java Main         # pilha/fila encadeadas com menu
java MergeLinked  # merge com filas encadeadas
java MergeArray   # merge com filas usando vetor (array primitivo)
