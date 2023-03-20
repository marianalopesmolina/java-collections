package one.digitalinnovation.exercicios.alternativas;

import java.util.*;

public class ExProposto1Op3 {
    public static void main(String[] args) {
        Set<String> arcoIris = new HashSet<>();
        arcoIris.add("Vermelho");
        arcoIris.add("Laranja");
        arcoIris.add("Amarelo");
        arcoIris.add("Verde");
        arcoIris.add("Azul");
        arcoIris.add("Anil");
        arcoIris.add("Violeta");

        // Exibe todas as cores uma abaixo da outra
        System.out.println("Cores do arco-íris:");
        for (String cor : arcoIris) {
            System.out.println(cor);
        }
        System.out.println();

        // Quantidade de cores que o arco-íris possui
        System.out.println("Quantidade de cores no arco-íris: " + arcoIris.size());
        System.out.println();

        // Exibe as cores em ordem alfabética
        Set<String> arcoIrisOrdenado = new TreeSet<>(arcoIris);
        System.out.println("Cores do arco-íris em ordem alfabética:");
        for (String cor : arcoIrisOrdenado) {
            System.out.println(cor);
        }
        System.out.println();

        // Exibe as cores na ordem inversa da que foi informada
        List<String> arcoIrisInverso = new ArrayList<>(arcoIris);
        Collections.reverse(arcoIrisInverso);
        System.out.println("Cores do arco-íris em ordem inversa:");
        for (String cor : arcoIrisInverso) {
            System.out.println(cor);
        }
        System.out.println();

        // Exibe todas as cores que começam com a letra "v"
        System.out.println("Cores do arco-íris que começam com a letra 'v':");
        for (String cor : arcoIris) {
            if (cor.toLowerCase().startsWith("v")) {
                System.out.println(cor);
            }
        }
        System.out.println();

        // Remove todas as cores que não começam com a letra "v"
        arcoIris.removeIf(cor -> !cor.toLowerCase().startsWith("v"));
        System.out.println("Cores do arco-íris após remover as cores que não começam com a letra 'v':");
        for (String cor : arcoIris) {
            System.out.println(cor);
        }
        System.out.println();

        // Limpa o conjunto
        arcoIris.clear();
        System.out.println("Cores do arco-íris após limpar o conjunto:");
        System.out.println(arcoIris);
        System.out.println();

        // Confere se o conjunto está vazio
        System.out.println("O conjunto de cores do arco-íris está vazio? " + arcoIris.isEmpty());
    }
}
