package one.digitalinnovation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto2Op1 {
    public static void main(String[] args) {
        List<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ FORMULÁRIO ------");
        System.out.println("Responda as questões abaixo:");
        System.out.print("\n1. Mora perto da vítima? ");
        String resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("2. Esteve no local do crime? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("3. Telefonou para a vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("4. Já trabalhou com a vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());
        System.out.print("5. Devia alguma quantia em dinheiro para a vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println(respostas);

        int cont = 0;
        Iterator<String> contador = respostas.iterator();
        while (contador.hasNext()) {
            String resp = contador.next();
            if (resp.contains("S")) {
                cont++;
            }
        }

        switch (cont) {
            case 0:
            case 1:
                System.out.println("Classificação: >> INOCENTE <<");
                break;
            case 2:
                System.out.println("Classificação: >> SUSPEITO(A) <<");
                break;
            case 3:
            case 4:
                System.out.println("Classificação: >> CÚMPLICE <<");
                break;
            case 5:
                System.out.println("Classificação: >> CULPADO(A) <<");
        }
    }
}
