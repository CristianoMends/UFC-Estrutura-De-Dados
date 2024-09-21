package main.java;

public class Lista {
    private No cabeca;
    private No ultimo;
    private int quantidade;
    public Lista(){
        this.cabeca = null;
        this.ultimo = null;
        this.quantidade = 0;
    }
    public int getQuantidade(){ return this.quantidade; }

    public void adicionar(Aluno dado){
        No novoNo = new No(dado);

        if(this.cabeca == null){
            this.cabeca = novoNo;
        }else{
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo; //de qualquer forma o ultimo sempre sera o novoNo
        this.quantidade++;
    }
    public void remover(int matricula){
        if (this.cabeca == null){return;}

        if (this.cabeca.getDado().getMatricula().equals(matricula)) {
            this.cabeca = this.cabeca.getProximo();
            return;
        }

        for(No atual = cabeca, anterior = null; atual != null;anterior = atual, atual = atual.getProximo()){
            if (anterior != null && atual.getDado().getMatricula().equals(matricula)){
                anterior.setProximo(atual.getProximo());
                return;
            }
        }
    }

    //------------------------------

    public void ordenarPorMedia() {
        ordenarPorMedia(this.cabeca);
    }

    private void ordenarPorMedia(No atual) {
        if (atual == null) { return; }

        No menorNo = encontrarMenorMedia(atual);

        if (menorNo != atual) {
            trocarDados(atual, menorNo);
        }

        ordenarPorMedia(atual.getProximo());
    }

    private No encontrarMenorMedia(No inicio) {
        return encontrarMenorMedia(inicio, inicio);
    }

    private No encontrarMenorMedia(No atual, No menorNo) {
        if (atual == null) { return menorNo; }

        if (atual.getDado().getMedia() < menorNo.getDado().getMedia()) {
            menorNo = atual;
        }

        return encontrarMenorMedia(atual.getProximo(), menorNo);
    }

    public void sortByMatricula() {
        sortByMatricula(this.cabeca);
    }

    private void sortByMatricula(No atual) {
        if (atual == null) { return; }

        No menorNo = encontrarMenorMatricula(atual);

        if (menorNo != atual) {
            trocarDados(atual, menorNo);
        }

        sortByMatricula(atual.getProximo());
    }

    private No encontrarMenorMatricula(No inicio) {
        return encontrarMenorMatricula(inicio, inicio);
    }

    private No encontrarMenorMatricula(No atual, No menorNo) {
        if (atual == null) { return menorNo; }

        if (atual.getDado().getMatricula() < menorNo.getDado().getMatricula()) {
            menorNo = atual;
        }

        return encontrarMenorMatricula(atual.getProximo(), menorNo);
    }
    //-------------------------------------------------------------------------------------------------------
    //Função para buscar um aluno por matricula com busca binaria recursiva

    public Aluno getByMatricula(int matricula){
        this.sortByMatricula();
        return getByMatricula(0, quantidade - 1, matricula);
    }
    private Aluno getByMatricula(int inicio, int fim, int matricula){
        if (inicio > fim){return null;}

        int meio = (inicio+fim)/2;
        Aluno[] alunos = this.toVetor();

             if(alunos[meio].getMatricula() < matricula) { return getByMatricula(meio + 1, fim, matricula); }
        else if(alunos[meio].getMatricula() > matricula) { return getByMatricula(inicio, meio - 1, matricula); }

        return alunos[meio];
    }

    //----------------------------------------------------------------------------------------------------------------
    //Função para converter a lista encadeada em um vetor de alunos
    private Aluno[] toVetor(){
        Aluno[] alunos = new Aluno[quantidade];
        No atual = this.cabeca;
        for(int i=0;i<quantidade;i++){
            alunos[i] = atual.getDado();
            atual = atual.getProximo();
        }
        return alunos;
    }
    //------------------------------------------------------------------------------------------------------------
    //Função para trocar os dados entre dois Nós da lista
    private void trocarDados(No no1, No no2) {
        Aluno temp = no1.getDado();
        no1.setDado(no2.getDado());
        no2.setDado(temp);
    }
    //------------------------------------------------------------------------------------------------------------
    //Função para obter todos os alunos em uma String
    public String getTodos(){
        StringBuilder saida = new StringBuilder();
        No atual = this.cabeca;
        while(atual != null){
            saida.append(atual.getDado());
            saida.append("\n");
            atual = atual.getProximo();
        }
        return saida.toString();
    }
    //--------------------------------------------------------------------------------------------------------------
}