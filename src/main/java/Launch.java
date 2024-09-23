package main.java;

import java.io.*;

class Launch {
    public static void exportar(String texto, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(texto);
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
        StringBuilder saida = new StringBuilder();
        Lista lista = new Lista();
        saida.append("Lista criada\n");
        importar(lista, "file/alunos.txt");
        saida.append("Lista por ordem de inserção:\n");
        saida.append(lista.getTodos()).append("\n");
        lista.sortByMedia();
        saida.append("\nLista ordenada por media: \n").append(lista.getTodos());
        lista.sortByMatricula();
        saida.append("\nLista ordenada por matricula: \n").append(lista.getTodos());

        saida.append("\nBuscando por matricula: 558382\n");
        saida.append(lista.getByMatricula(558382));

        saida.append("\nremovendo por matricula: 558382\n");
        lista.remover(558382);
        saida.append("resultado: \n").append(lista.getTodos());

        exportar(saida.toString(), "file/alunos cadastrados.txt");
    }
}