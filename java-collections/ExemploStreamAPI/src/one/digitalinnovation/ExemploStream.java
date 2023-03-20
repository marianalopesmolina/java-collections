package one.digitalinnovation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExemploStream {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1","0","4","1","2","3","9","9","6","5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
//        numerosAleatorios.stream().forEach(System.out::println);
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros elementos e coloque dentro de um 'Set': ");
//        numerosAleatorios.stream()
//                .limit(5)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);

//        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
//        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
//                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//                        .forEach(System.out::println);

        System.out.println("Pegue os números pares e maiores que '2' e coloque-os em uma lista: ");
        numerosAleatorios.stream().map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
//                .map(Integer::parseInt)
//                .filter(i -> (i % 2 == 0 && i > 2))
//                .collect(Collectors.toList());
//        System.out.println(listParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
//        Transformar a lista que passamos para 'Integer' em uma variável
//        numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if (integer % 2 != 0) return true;
//                return false;
//            }
//        });
//        System.out.println(numerosAleatoriosInteger);
        numerosAleatoriosInteger.removeIf(integer -> integer % 2 != 0);
        System.out.println(numerosAleatoriosInteger);

//        Exercitando:

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatoriosInteger.stream().skip(3).forEach(System.out::println);

        long contNumerosUnicos = numerosAleatoriosInteger.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + contNumerosUnicos);

        System.out.println("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);

        int somaNumerosPares = numerosAleatoriosInteger.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Pegue apenas os números pares e some: " + somaNumerosPares);

        System.out.println("Mostre a lista na ordem numérica: ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());;
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de '3' ou '5': ");
//        *Dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean,List<Integer>> agrupamentoNumerosMultiplos = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(agrupamentoNumerosMultiplos);

    }
}
