package one.digitalinnovation.exercicios;

/* Crie uma classe LinguagemFavorita que possua os atributos: 'nome', 'anoDeCriacao' e 'ide'.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a. Ordem de inserção;
b. Ordem natural (nome);
c. IDE;
d. Ano de criação e nome;
e. Nome, ano de criação e IDE.
Ao final, exiba as linguagens no console, uma abaixo da outra.
> Python, 1991, PyCharm;
> JavaScript, 1995, IntelliJ;
> Java, 1991, Visual Studio Code.
*/

import java.util.*;

class LinguagemFavorita implements Comparable<LinguagemFavorita> {

    String nome;
    String ide;
    int anoDeCriacao;

    public LinguagemFavorita (String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.nome.compareTo(linguagemFavorita.getNome());
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Ano: " + anoDeCriacao + " | IDE: " + ide;
    }
}

public class ExProposto2 {
    public static void main(String[] args) {

        Set<LinguagemFavorita> linguagemFavorita = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Python",1991,"PyCharm"));
            add(new LinguagemFavorita("JavaScript",1995,"IntelliJ"));
            add(new LinguagemFavorita("Java",1991,"Visual Studio Code"));
        }};
//        Exibindo os elementos por Ordem de Inserção:
        System.out.println("---\tORDEM DE INSERÇÃO\t---");
        for (LinguagemFavorita linguagem : linguagemFavorita) System.out.println("Nome: " + linguagem.getNome() + " | "
                + "Ano: " + linguagem.getAnoDeCriacao() + " | " + "IDE: " + linguagem.getIde());
        System.out.println();

//        Exibindo os elementos por Ordem Natural (nome):
        System.out.println("---\tORDEM NATURAL (NOME)\t---");
        Set<LinguagemFavorita> ordemNatural = new TreeSet<>(linguagemFavorita);
        for (LinguagemFavorita linguagem : ordemNatural) System.out.println(linguagem);
        System.out.println();

//        Exibindo os elementos por Ordem Natural (IDE):
        System.out.println("---\tORDEM NATURAL (IDE)\t---");
        Set<LinguagemFavorita> ordemIde = new TreeSet<>(Comparator.comparing(LinguagemFavorita::getIde));
        ordemIde.addAll(linguagemFavorita);
        for (LinguagemFavorita linguagem : ordemIde) System.out.println(linguagem);
        System.out.println();

//        Exibindo os elementos por Ano de Criação e Nome:
        System.out.println("---\tORDEM ANO & NOME\t---");
        Set<LinguagemFavorita> ordemAnoNome = new TreeSet<>(Comparator.comparing(LinguagemFavorita::
                getAnoDeCriacao).thenComparing(LinguagemFavorita::getNome));
        ordemAnoNome.addAll(linguagemFavorita);
        for (LinguagemFavorita linguagem : ordemAnoNome) System.out.println(linguagem);
        System.out.println();

//        Exibindo os elementos por Nome, Ano de Criação e IDE:
        System.out.println("---\tORDEM NOME | ANO | IDE\t---");
        Set<LinguagemFavorita> ordemNomeAnoIde = new TreeSet<>(Comparator.comparing(LinguagemFavorita::
                getNome).thenComparing(LinguagemFavorita::getAnoDeCriacao).thenComparing(LinguagemFavorita::getIde));
        ordemNomeAnoIde.addAll(linguagemFavorita);
        for (LinguagemFavorita linguagem : ordemNomeAnoIde) System.out.println(linguagem);
        System.out.println();

//        Exibindo as linguagens uma abaixo da outra:
        System.out.println("---\tLINGUAGENS DE PROGRAMAÇÃO\t---");
        System.out.println(linguagemFavorita);

    }
}

