package one.digitalinnovation;

import java.util.*;
import java.util.Locale;

public class ExemploSet {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

//      Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
        System.out.println("Crie um conjunto (Set) e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

//        System.out.println("Exiba a posição da nota 5.0: ");
//        Não é possível dentro de Set, por não possuir índice.

//        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
//        Não é possível dentro de Set, por não possuir índice.

//        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
//        Não é possível dentro de Set, por não possuir índice.

        System.out.println("Confira se a nota 5.0 está dentro do conjunto: " + notas.contains(5d));
//        Retorna um valor 'boolean' true ou false dependendo do objeto dado como argumento.

//        System.out.println("Exiba a terceira nota adicionada: ");
//        Não é possível dentro de Set pois os elementos são adicionados em ordem aleatória.
//        Set não possui índice, portanto é impossível pegar o objeto em determinada posição.

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

//      Utilizando o método "Iterator":
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores do conjunto: " + String.format("%.2f",soma));

//      Utilizando o método "size()":
        System.out.println("Exiba a média das notas do conjunto: " + String.format("%.2f", (soma/ notas.size())));

//      Utilizando o método "remove(object)":
        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

//        System.out.println("Remova a nota da posição 0: ");
//        Não é possível pois em Set não há índice, portanto é impossível
//        determinar a posição de um elemento.

        System.out.println("Remova as notas menores que 7.0 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

//        Utilizando o método "LinkedHashSet" com "Arrays.asList()":
        System.out.println("Exiba todas as notas na ordem em que foram adicionadas: ");
//        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
//        OU utilizando os métodos de adição "add()":
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
//        A nota '7' foi adicionada duas vezes, porém em Set os valores não são duplicados.
//        Sendo asssim, somente uma nota '7' será impressa.
        System.out.println(notas2);

//        Utilizando o método "TreeSet":
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
//        OBS.: O laço "for" também poderia ser utilizado para gerar o mesmo resultado.
        System.out.println(notas3);

//        Utilizando o método "clear()":
        System.out.println("Apague todo o conjunto: ");
        notas.clear();

        System.out.println("Confira se o conjunto 1 está vazio: ");
//        Retorna um valor 'boolean' true ou false.
        System.out.println(notas.isEmpty());

        System.out.println("Confira se o conjunto 2 está vazio: ");
        System.out.println(notas2.isEmpty());

        System.out.println("Confira se o conjunto 3 está vazio: ");
        System.out.println(notas3.isEmpty());

    }
}
