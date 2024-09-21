# **TP Estrutura de dados 2024.1**

Este trabalho prático tem como objetivo implementar e manipular uma estrutura de dados personalizada para armazenar informações de alunos de uma turma. O projeto envolve operações básicas de inclusão, remoção, listagem e ordenação de alunos, além da busca eficiente por matrícula.

## **Estrutura de Dados Adotada**

Para este projeto, foi adotada uma **lista encadeada** como estrutura de dados. Cada nó da lista armazena as informações de um aluno (matrícula, nome e média final) e um ponteiro para o próximo nó da lista. Esta estrutura foi escolhida porque permite a inserção e remoção eficiente de elementos, especialmente quando há muitas operações de modificação no meio da lista.

### **Vantagens da Lista Encadeada:**
- **Inserção/Remoção eficiente:** A inserção ou remoção de nós pode ser feita em tempo constante (O(1)) se a posição do nó for conhecida.
- **Flexibilidade de Tamanho:** A lista encadeada pode crescer ou encolher dinamicamente sem a necessidade de realocação de memória.
- **Busca:** A busca pode ser feita linearmente (O(n)), mas uma otimização adicional será feita com a busca binária após a ordenação.


## **Tarefas**

### **1. Estrutura de Dados para Alunos**
- [x] **Finalizado**

Crie uma estrutura de dados para armazenar informações sobre alunos. Cada aluno deve conter as seguintes informações:

- Matrícula
- Nome
- Média final

A estrutura deve implementar as seguintes funcionalidades:

- Incluir novo aluno
- Remover aluno por matrícula
- Listar todos os alunos

> **Observação:** Não é permitido utilizar estruturas de dados já implementadas por bibliotecas.
---
### **2. Ordenar por Média Final**
- [x] **Concluído**

Implemente uma nova funcionalidade que ordene os alunos pela média final usando o algoritmo **SelectionSort** de forma recursiva.

---

### **3. Ordenar por Matrícula**
- [x] **Concluído**

Implemente a ordenação dos alunos por matrícula utilizando também o algoritmo **SelectionSort** recursivo.

---

### **4. Busca Binária por Matrícula**
- [ ] **Em andamento**

Implemente uma busca binária recursiva para encontrar um aluno pela matrícula. Lembre-se de que os alunos devem estar ordenados por matrícula para que a busca funcione corretamente.

> **Observação:** Para facilitar o teste do código, você pode importar e exportar os dados de alunos em um arquivo texto.

---

## **Detalhamento do Código**

### Função `adicionar()`
```java
    public void adicionar(T dado){
        No<T> novoNo = new No<>(dado);

        if(this.cabeca == null){
            this.cabeca = novoNo;
        }else{                  
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo;
    }
```
Quando chamar o metodo `adicionar(T dado)` deve ser passado o dado do tipo definido na instanciação
da lista, e então cria-se um novo Nó com esse dado;

Depois verificamos se a lista está vazia `cabeca == null`, se for, apontamos o cabeca para o novo no
se nao for nulo, quer dizer que existe pelomenos 1 No na lista, entao setamos o NovoNó no `ultimo.proximo(NovoNo)`
independente da lista estar vazia ou nao, a variavel ultimo sempre irá apontar para o novoNo
---
### Função `remover()`
```java
public void remover(int matricula){
   if (this.cabeca == null){return;}

   if (this.cabeca.getDado().getMatricula().equals(matricula)) {
      this.cabeca = this.cabeca.getProximo();  // Move a cabeça para o próximo nó
      return;  // Como removemos o primeiro nó, podemos sair
   }

   for(No atual = cabeca, anterior = null; atual != null;anterior = atual, atual = atual.getProximo()){
      if (anterior != null && atual.getDado().getMatricula() == matricula){
         anterior.setProximo(atual.getProximo());
         return;
      }
   }
}
```

- Verficamos se o nó cabeca é nulo, se for já saimos da função, pois significa que a lista
está vazia.
- verificamos se o Aluno com a matricula informada está no nó cabeça, se estiver, atribuimos
o seu nó proximo e saimos da função.
- caso a lista não esteja vazia e a matricula não está no nó cabeça, percorremos a lista da seguinte forma:
  - criamos um Nó `atual` e um Nó `anterior`, onde o anterior começa com o Nó cabeça e o anterior com nulo, indicando
  que não existe nó anterior.
  - Depois percorremos verificando se o aluno no Nó atual tem a matricula informada, se tiver
  setamos o Nó `anterior.setProximo()` para o Nó `atual.proximo()`;
  - No final do loop anterior vai receber o atual e o atual recebe `atual.proximo()`

---

### Função `ordernarPorMedia()`

```java
public void ordenarPorMedia() {
  ordenarPorMedia(this.cabeca);
}
```
Inicia a ordenação recursiva a partir do nó cabeça

```java
private void ordenarPorMedia(No atual) {
  if (atual == null) {
    return;
  }

  // Encontra o nó com a menor média a partir do nó atual
  No menorNo = encontrarMenor(atual);

  // Se o menor nó não for o nó atual, troca os dados
  if (menorNo != atual) {
    trocarDados(atual, menorNo);
  }

  // Chama recursivamente para ordenar o restante da lista
  ordenarPorMedia(atual.getProximo());
}
```
```java
private No encontrarMenor(No inicio) {
  // Inicia a busca pelo menor nó a partir do nó dado
  return encontrarMenor(inicio, inicio);
}

private No encontrarMenor(No atual, No menorNo) {
  // Caso base: ao final da lista, retorna o menor nó encontrado
  if (atual == null) {
    return menorNo;
  }

  // Atualiza o menor nó se encontrar um nó com média menor
  if (atual.getDado().getMedia() < menorNo.getDado().getMedia()) {
    menorNo = atual;
  }

  // Chama recursivamente para o próximo nó
  return encontrarMenor(atual.getProximo(), menorNo);
}
```
```java
private void trocarDados(No no1, No no2) {
  // Troca os dados entre os dois nós
  Aluno temp = no1.getDado();
  no1.setDado(no2.getDado());
  no2.setDado(temp);
}
```
