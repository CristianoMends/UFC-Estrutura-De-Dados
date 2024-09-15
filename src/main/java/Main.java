package main.java;

class Main{
    public static void main(String[] args) {

        Lista lista = new Lista();

        lista.adicionar(new Aluno("558381", "Cristiano", 8.5));
        lista.adicionar(new Aluno("558382", "Chico", 8.5));
        lista.adicionar(new Aluno("558383", "Jose", 8.5));
        lista.adicionar(new Aluno("558384", "albert", 8.5));
        lista.adicionar(new Aluno("558385", "rodrigo", 8.5));

        lista.remover("558386");


        System.out.println(lista.getTodos());

    }
}