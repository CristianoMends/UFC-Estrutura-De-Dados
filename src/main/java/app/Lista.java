package main.java.app;

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
            this.quantidade--;
            return;
        }

        for(No atual = cabeca, anterior = null; atual != null;anterior = atual, atual = atual.getProximo()){
            if (anterior != null && atual.getDado().getMatricula() == matricula){
                anterior.setProximo(atual.getProximo());
                this.quantidade--;
                return;
            }
        }
    }

    //------------------------------------------------------------------------------------------
    //função para ordenar a lista por media
    public void sortByMedia(){
        this.sortByMedia(this.cabeca);
    }
    private void sortByMedia(No atual){
        if (atual == null){return;}

        No noComMenorMedia = findNoComMenorMedia(atual, atual);

        if (noComMenorMedia != atual){
            this.trocarDados(noComMenorMedia, atual);
        }
        sortByMedia(atual.getProximo());
    }
    private No findNoComMenorMedia(No atual, No menor){//percorre a lista apartir de um nó
        if (atual == null){ return menor; }

        if (atual.getDado().getMedia() < menor.getDado().getMedia()){
            menor = atual;
        }
        return findNoComMenorMedia(atual.getProximo(), menor);
    }
    //--------------------------------------------------------------------------------------------
    //Função para ordenar alunos por matricula
    public void sortByMatricula() {
        sortByMatricula(this.cabeca);
    }
    private void sortByMatricula(No atual) {
        if (atual == null) { return; }

        No menorNo = findNoComMenorMatricula(atual, atual);

        if (menorNo != atual) {
            trocarDados(atual, menorNo);
        }

        sortByMatricula(atual.getProximo());
    }
    private No findNoComMenorMatricula(No atual, No menorNo) {
        if (atual == null) { return menorNo; }

        if (atual.getDado().getMatricula() < menorNo.getDado().getMatricula()) {
            menorNo = atual;
        }

        return findNoComMenorMatricula(atual.getProximo(), menorNo);
    }
    //-------------------------------------------------------------------------------------------------------
    //Função para buscar um aluno por matricula com busca binaria recursiva
    public Aluno getByMatricula(int matricula){
        this.sortByMatricula();
        Aluno[] alunos = this.toVetor();
        return getByMatricula(0, quantidade - 1, matricula, alunos);
    }
    private Aluno getByMatricula(int inicio, int fim, int matricula, Aluno[] alunos){
        if (inicio > fim){ return null; }

        int meio = ( inicio + fim ) / 2;

             if(alunos[meio].getMatricula() < matricula) { return getByMatricula(meio + 1, fim, matricula, alunos); }
        else if(alunos[meio].getMatricula() > matricula) { return getByMatricula(inicio, meio - 1, matricula, alunos); }

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