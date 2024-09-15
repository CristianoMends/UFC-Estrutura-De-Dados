package main.java;

import java.util.Iterator;

public class Lista {
    private No cabeca;
    private No ultimo;
    private int length;
    public Lista(){
        this.cabeca = null;
        this.ultimo = null;
        this.length = 0;
    }

    public int getLength(){
        return this.length;
    }

    public void adicionar(Aluno dado){
        No novoNo = new No(dado);

        if(this.cabeca == null){
            this.cabeca = novoNo;
        }else{
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo; //de qualquer forma o ultimo sempre sera o novoNo
        this.length++;
    }
    public void remover(String matricula){
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
    public String getTodos(){
        StringBuilder saida = new StringBuilder();
        for(No atual = cabeca; atual != null; atual = atual.getProximo()){
            saida.append(atual);
            saida.append("\n");
        }
        return saida.toString();
    }
}
