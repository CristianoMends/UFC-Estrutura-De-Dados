package main.java;

public class No {

    private Aluno dado;
    private No proximo;

    public No(Aluno dado){
        this.dado = dado;
        this.proximo = null;
    }

    public Aluno getDado() {
        return dado;
    }
    public void setDado(Aluno dado) {
        this.dado = dado;
    }
    public No getProximo() {
        return this.proximo;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No { \n" +
                "  dado:   " + dado +"\n"+
                '}';
    }
}