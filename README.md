# Sistema de Gerenciamento de Atendimento ao Cliente  
Gestão de solicitações com **Fila** e **Pilha** implementadas sobre **Lista Encadeada própria**, em Java. Projeto pensado para disciplinas de Estruturas de Dados e Resolução de Problemas, com foco em autoria, clareza e comprovação de domínio do conteúdo.  

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue" />
  <img src="https://img.shields.io/badge/Build-javac%2Fjar-informational" />
  <img src="https://img.shields.io/badge/License-MIT-success" />
</p>

---

## Objetivos da aplicação  
* Simular um balcão de atendimento onde:  
  * **Fila** gerencia a ordem de clientes aguardando atendimento.  
  * **Pilha** registra o **histórico** de solicitações atendidas.  
* Implementar as estruturas com **lista encadeada** autoral, sem uso de coleções prontas.  
* Expor operações clássicas com entrada simples em terminal e relatórios resumidos.  

---

## Principais funcionalidades  
* Cadastrar solicitação na fila de atendimento  
* Chamar próximo cliente e mover a solicitação para o histórico na pilha  
* Visualizar o estado atual da fila e da pilha  
* Buscar e remover por ID  
* Estatísticas rápidas do atendimento no dia  
* Persistência simples opcional via CSV para reabrir a fila  

---

## Estrutura de Dados utilizada  
**Lista Encadeada:** Nó com campos `dado` e `proximo`.  
Operações: inserir no início e no fim, remover no início e por referência, obter tamanho.  

**Fila sobre Lista Encadeada:**  
* Operações em O(1) amortizado  
  * `enfileirar(dado)`  
  * `desenfileirar()`  
  * `primeiro()`  
  * `vazia()`  
  * `tamanho()`  

**Pilha sobre Lista Encadeada:**  
* Operações em O(1)  
  * `empilhar(dado)`  
  * `desempilhar()`  
  * `topo()`  
  * `vazia()`  
  * `tamanho()`  

Complexidades esperadas:  
* Enfileirar, desenfileirar, empilhar e desempilhar: O(1)  
* Remover por ID: O(n)  
* Busca por ID: O(n)  

---

## Testes unitários essenciais  
**ListaEncadeadaTest:**  
* inserir e remover no início  
* tamanho após operações  
* remoção por ID inexistente  

**FilaEncadeadaTest:**  
* enfileirar/desenfileirar mantém ordem  
* fila vazia lança exceção  

**PilhaEncadeadaTest:**  
* empilhar/desempilhar mantém LIFO  
* topo reflete último inserido  

---

## Diagrama conceitual  
```mermaid
flowchart TB
  subgraph Estruturas
    L[ListaEncadeada]
    F[FilaEncadeada]
    P[PilhaEncadeada]
  end
  subgraph Domínio
    S[Solicitação]
  end
  L --> F
  L --> P
  S --> F
  S --> P
