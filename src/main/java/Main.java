package main.java;

import java.io.*;

class Main{
    public static void exportar(Lista lista, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(lista.getTodos());
            System.out.println("Dados exportados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao exportar os dados: " + e.getMessage());
        }
    }

    public static void importar(Lista lista, String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");

                int matricula = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double media = Double.parseDouble(dados[2]);

                Aluno aluno = new Aluno(matricula, nome, media);

                lista.adicionar(aluno);
            }
            System.out.println("Dados importados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao importar os dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Lista lista = new Lista();
        importar(lista, "alunos.txt");


        System.out.println("encontrei "+ lista.getByMatricula(558382));

        //lista.remover(500000);
        exportar(lista, "alunos cadastrados.txt");
    }
}