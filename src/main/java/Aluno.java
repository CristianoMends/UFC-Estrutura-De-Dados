package main.java;

public class Aluno {
    private int matricula;
    private String nome;
    private Double mediaFinal;

    public Aluno(int m, String n, Double mf){
        this.matricula = m;
        this.nome = n;
        this.mediaFinal = mf;
    }

    //get e set---
    public Integer getMatricula(){
        return this.matricula;
    }
    public String getNome(){
        return this.nome;
    }
    public Double getMedia(){
        return this.mediaFinal;
    }
    public void setMatricula(int m){
        this.matricula = m;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setMedia(Double mf){
        this.mediaFinal = mf;
    }

    @Override
    public String toString() {
        return  String.format("Nome: %20s, matricula: %5d, Média: %.1f",nome, matricula, mediaFinal);
    }
}
