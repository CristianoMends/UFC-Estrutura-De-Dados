package main.java.app;

import java.io.*;
import java.util.Scanner;

class Launch {
    // Função para importar dados de um arquivo
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
            System.out.println("Os dados de '"+nomeArquivo+"' foram importados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao importar os dados: " + e.getMessage());
        }
    }

    // Métodos utilitários para simplificar a leitura de entrada e conversão de dados
    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void println(Object value) {
        System.out.println(value);
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static Double toDouble(String value) {
        return Double.parseDouble(value);
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        while (true) {
            println("\nEscolha uma opção:------------------------------------------");
            println("1 - Adicionar novo aluno");
            println("2 - Remover aluno por matrícula");
            println("3 - Listar todos os alunos");
            println("4 - Ordenar por matrícula");
            println("5 - Ordenar por média");
            println("6 - Buscar aluno por matrícula");
            println("7 - importar alunos do arquivo alunos.txt");
            println("0 - Sair");
            println("-------------------------------------------------------------");

            int op = toInt(input()); // Recebe a opção do usuário

            switch (op) {
                case 1: // Adicionar aluno
                    println("Digite os dados do aluno separados por vírgula (matrícula,nome,média):");
                    String[] alunoDados = input().split(",");
                    if (alunoDados.length == 3) {
                        lista.adicionar(new Aluno(toInt(alunoDados[0]), alunoDados[1], toDouble(alunoDados[2])));
                        println("Aluno adicionado com sucesso.");
                    } else {
                        println("Entrada inválida! Use o formato: matricula,nome,media.");
                    }
                    break;

                case 2: // Remover aluno
                    println("Digite o número da matrícula do aluno que deseja remover:");
                    int matriculaRemover = toInt(input());
                    lista.remover(matriculaRemover);
                    println("Aluno removido.");
                    break;

                case 3: // Listar todos os alunos
                    println("\nLista de alunos:");
                    println(lista.getTodos());
                    break;

                case 4: // Ordenar por matrícula
                    lista.sortByMatricula();
                    println("Lista ordenada por matrícula.");
                    break;

                case 5: // Ordenar por média
                    lista.sortByMedia();
                    println("Lista ordenada por média.");
                    break;

                case 6: // Buscar aluno por matrícula
                    println("Digite o número da matrícula do aluno que deseja buscar:");
                    int matriculaBuscar = toInt(input());
                    println(lista.getByMatricula(matriculaBuscar));
                    break;
                case 7:
                    importar(lista, "file/alunos.txt");
                    break;
                case 0: // Sair do sistema
                    println("Sistema finalizado!");
                    return; // Encerra o programa

                default: // Comando inválido
                    println("Comando inválido! Tente novamente.");
            }
        }
    }
}
