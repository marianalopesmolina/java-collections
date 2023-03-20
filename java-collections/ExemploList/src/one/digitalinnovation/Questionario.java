package one.digitalinnovation;
/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Questionario implements Iterable<String> {

    private List<String> perguntas;
    private List<String> respostas;

    public Questionario() {
        perguntas = new ArrayList<>();
        respostas = new ArrayList<>();
    }

    public void addPergunta(String pergunta) {
        perguntas.add(pergunta);
    }

    public void responder(boolean resposta) {
        respostas.add(resposta ? "S" : "N");
    }

    public int contarRespostas(String resposta) {
        int contador = 0;
        for (String r : respostas) {
            if (r.equals(resposta)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public Iterator<String> iterator() {
        return respostas.iterator();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questionario questionario = new Questionario();

        // Adicionar perguntas ao formulário:
        questionario.addPergunta("1. Esteve no local do crime?");
        questionario.addPergunta("2. Mora perto da vítima?");
        questionario.addPergunta("3. Telefonou para a vítima?");
        questionario.addPergunta("4. Já trabalhou com a vítima?");
        questionario.addPergunta("5. Devia alguma quantia em dinheiro para a vítima?");

        // Responder as perguntas do formulário:
        for (String pergunta : questionario.perguntas) {
            System.out.println(pergunta);
            String resposta = sc.nextLine().toUpperCase();
            while (!resposta.equals("S") && !resposta.equals("N")) {
                System.out.println("Resposta inválida. Digite 'S' para 'sim' ou 'N' para 'não'.");
                resposta = sc.nextLine().toUpperCase();
            }
            questionario.responder(resposta.equals("S"));
        }
        System.out.println("Respostas: " + questionario.respostas);
        System.out.println("Pontuação para classificação: " + questionario.contarRespostas("S"));

        // Classificar suspeito:
        int totalRespostas = questionario.contarRespostas("S");
        if (totalRespostas == 0 || totalRespostas == 1) {
            System.out.println("Classificação: >> INOCENTE <<");
        } else if (totalRespostas == 2) {
            System.out.println("Classificação = >> SUSPEITO(A) <<");
        } else if (totalRespostas == 3 || totalRespostas == 4) {
            System.out.println("Classificação: >> CÚMPLICE <<");
        } else if (totalRespostas == 5) {
            System.out.println("Classificação: >> CULPADO(A) <<");
        } else {}
    }
}

