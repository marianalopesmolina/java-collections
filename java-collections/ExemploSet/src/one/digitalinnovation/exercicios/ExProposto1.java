package one.digitalinnovation.exercicios;
/* Crie um conjunto contendo as cores do arco-íris e:
> Exiba todas as cores uma abaixo da outra;
> Exiba a quantidade total de cores no conjunto;
> Exiba as cores em ordem alfabética;
> Exiba as cores na ordem inversa que foram adicionadas;
*Para o passo acima, criar uma >List< e passar o 'Set' como argumento
dentro do construtor e utilizar o método da classe "Collections" que faz a reversão.*
> Exiba todas as cores que começam com "v";
> Remova todas as cores que não começam com "v";
> Limpe o conjunto;
> Confira se o conjunto está vazio.
*/
import java.util.*;
import java.util.Set;

public class ExProposto1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("----\tARCO-ÍRIS\t----");
        Set<ArcoIris> arcoIris = new HashSet<>(){{
            add(new ArcoIris(1,"vermelho"));
            add(new ArcoIris(2,"laranja"));
            add(new ArcoIris(3,"amarelo"));
            add(new ArcoIris(4,"verde"));
            add(new ArcoIris(5,"azul"));
            add(new ArcoIris(6,"anil"));
            add(new ArcoIris(7,"violeta"));
        }};
//        Set<ArcoIris> arcoIrisOrdenado = new TreeSet<>(Comparator.comparing(ArcoIris::getCor));

//        Exibindo as cores uma abaixo da outra:
        for (ArcoIris arcoIris1 : arcoIris) System.out.println(arcoIris1.getCor());

//        Exibindo a quantidade total de cores no conjunto:
        System.out.println("Total de cores: " + arcoIris.size());

//        Criando um novo conjunto somente para as cores:
        Set<String> cores = new HashSet<>();
        for (ArcoIris a : arcoIris) {
            cores.add(a.getCor());
        }
//        Criando um novo TreeSet com as cores em ordem alfabética:
        Set<String> arcoIris2 = new TreeSet<>(cores);
//        Exibindo as cores em ordem alfabética:
        System.out.println("----\tORDEM ALFABÉTICA\t----");
        for (String cor : arcoIris2) System.out.println(cor);

//        Outra opção para exibir o Set em ordem alfabética (porém imprime o Array inteiro):
//        arcoIrisOrdenado.addAll(arcoIris);
//        System.out.println("\n" + arcoIris);

//        Exibindo as cores na ordem inversa em que foram adicionadas:
        System.out.println("----\tORDEM INVERSA\t----");
        Set<String> inverso = new LinkedHashSet<>(Arrays.asList("vermelho","laranja","amarelo","verde","azul","anil","violeta"));
//        System.out.println(inverso); //Imprime para verificar se o processo está correto.
        List<String> inversoList = new ArrayList<>(inverso);
        Collections.reverse(inversoList);
//        System.out.println(inversoList); //Imprime em forma de ArrayList (uma cor ao lado da outra entre claves)
//        OU melhor opção abaixo (imprime as cores uma abaixo da outra):
        for (String cor : inversoList) {
            System.out.println(cor);
        }

//        Exibindo todas as cores que começam com a letra 'v':
        System.out.println("----\tCORES COM LETRA INICIAL 'V'\t----");
        for (String cor : arcoIris2)
            if (cor.toLowerCase().startsWith("v")) {
                System.out.println(cor);
            }

//        Removendo todas as cores que não começam com a letra 'v':
//        Iterator<String> iterator = arcoIris2.iterator();
//        while (iterator.hasNext()) {
//         if (!iterator.next().startsWith("v")) {
//             iterator.remove();
//         }
//        }
//        REMOVENDO AS CORES QUE *COMEÇAM* COM A LETRA 'V':
        Iterator<String> iterator = arcoIris2.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith("v")) {
                iterator.remove();
            }
        }
        System.out.println("----\tREMOÇÃO DAS CORES COM INICIAL 'V'\t----");
        for (String cor: arcoIris2) System.out.println(cor);
//        System.out.println(arcoIris2); //Confere se o método foi aplicado corretamente.

//        Limpando o conjunto:
        arcoIris.clear();

//        Conferindo se o conjunto está vazio:
        System.out.println("-----------------");
        System.out.println("O conjunto 'arcoIris' está vazio? \n" + "Resposta: " + arcoIris.isEmpty());

    }
}

class ArcoIris implements Comparable<ArcoIris> {
    private Integer num;
    private String cor;

    public ArcoIris(Integer num, String cor) {
        this.num = num;
        this.cor = cor;
    }

    public Integer getNum() {
        return num;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "ArcoIris{" +
                "num:" + num +
                ", cor:'" + cor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArcoIris arcoIris = (ArcoIris) o;
        return Objects.equals(num, arcoIris.num) && Objects.equals(cor, arcoIris.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, cor);
    }

    @Override
    public int compareTo(ArcoIris arcoIris) {
        int num = Integer.compare(this.getNum(), arcoIris.getNum());
        if (num != 0) return num;

        return this.getNum().compareTo(arcoIris.getNum());
    }
}
