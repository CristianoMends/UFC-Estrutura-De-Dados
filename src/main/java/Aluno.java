package main.java;

public class Aluno {
    private String matricula;
    private String nome;
    private Double mediaFinal;

    public Aluno(String m, String n, Double mf){
        this.matricula = m;
        this.nome = n;
        this.mediaFinal = mf;
    }

    //get e set---
    public String getMatricula(){
        return this.matricula;
    }
    public String getNome(){
        return this.nome;
    }
    public Double getMedia(){
        return this.mediaFinal;
    }
    public void setMatricula(String m){
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
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", mediaFinal=" + mediaFinal +
                '}';
    }
}
