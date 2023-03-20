package one.digitalinnovation;
/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
> "Telefonou para a vítima?"
> "Esteve no local do crime?"
> "Mora perto da vítima?"
> "Devia algum dinheiro para a vítima?"
> "Já trabalhou com a vítima?"
Caso a pessoa responda positivamente ("S") a 02 questões ela deve ser classificada como "Suspeita",
entre 03 e 04 como "Cúmplice" e 05 como "Culpada". Caso contrário, ela será classificada como "Inocente".
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto2 {
    public static void main(String[] args) {

        System.out.println("------ FORMULÁRIO ------");
        System.out.println("Responda as questões abaixo (S/N):");

        List<String> form = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String resposta;
        int pontos = 0;

        int conta = 0;
        while (conta != 5) {
            System.out.println("1. Mora perto da vítima?");
            resposta = sc.nextLine().toUpperCase();
            form.add(resposta);
            conta++;
            if(resposta.equals("S")){
                pontos++;
            }
            System.out.println("2. Esteve no local do crime?");
            resposta = sc.nextLine().toUpperCase();
            form.add(resposta);
            conta++;
            if(resposta.equals("S")){
                pontos++;
            }
            System.out.println("3. Telefonou para a vítima?");
            resposta = sc.nextLine().toUpperCase();
            form.add(resposta);
            conta++;
            if(resposta.equals("S")){
                pontos++;
            }
            System.out.println("4. Já trabalhou com a vítima?");
            resposta = sc.nextLine().toUpperCase();
            form.add(resposta);
            conta++;
            if(resposta.equals("S")){
                pontos++;
            }
            System.out.println("5. Devia alguma quantia em dinheiro para a vítima?");
            resposta = sc.nextLine().toUpperCase();
            form.add(resposta);
            conta++;
            if(resposta.equals("S")){
                pontos++;
            }
            System.out.println("--------------------");
            System.out.println("RESPOSTAS FORMULÁRIO: " + form);
            System.out.println("PONTUAÇÃO P/ CLASSIFICAÇÃO: " + pontos);
            System.out.println("--------------------");
            break;
        }

        if (pontos == 0  || pontos == 1) {
            System.out.println("Classificação: >> INOCENTE <<");
        } else if (pontos == 2) {
            System.out.println("Classificação: >> SUSPEITO(A) <<");
        } else if (pontos == 3 || pontos == 4) {
            System.out.println("Classificação: >> CÚMPLICE <<");
        } else {
            System.out.println("Classificação: >> CULPADO(A) <<");
        }

        sc.close();
    }
}
