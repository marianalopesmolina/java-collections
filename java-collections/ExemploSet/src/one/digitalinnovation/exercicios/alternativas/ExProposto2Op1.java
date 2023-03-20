package one.digitalinnovation.exercicios.alternativas;

import java.util.*;

class LinguagemFav implements Comparable<LinguagemFav> {

    String nome;
    String ide;
    int anoCriacao;

    public LinguagemFav (String nome, int anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "LinguagemFav{" +
                "nome='" + nome + '\'' +
                ", ide='" + ide + '\'' +
                ", anoCriacao=" + anoCriacao +
                '}';
    }

    @Override
    public int compareTo(LinguagemFav linguagemFav) {
        return this.nome.compareTo(linguagemFav.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFav that = (LinguagemFav) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

class ComparatorIde implements Comparator<LinguagemFav> {

    @Override
    public int compare(LinguagemFav ling1, LinguagemFav ling2) {
        return ling1.ide.compareToIgnoreCase(ling2.ide);
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFav> {

    @Override
    public int compare(LinguagemFav ling1, LinguagemFav ling2) {
        int anoCriacao = Integer.compare(ling1.anoCriacao, ling2.anoCriacao);
        if (anoCriacao != 0) return anoCriacao;
        return ling1.nome.compareToIgnoreCase(ling2.nome);
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFav> {

    @Override
    public int compare(LinguagemFav ling1, LinguagemFav ling2) {
        int nome = ling1.nome.compareToIgnoreCase(ling2.nome);
        int anoCriacao = Integer.compare(ling1.anoCriacao, ling2.anoCriacao);
        if (nome != 0) return nome;
        if (anoCriacao != 0) return anoCriacao;
        return ling1.ide.compareToIgnoreCase(ling2.ide);
    }

}

public class ExProposto2Op1 {
    public static void main(String[] args) {

        Set<LinguagemFav> linguagensProg = new HashSet<>();
        linguagensProg.add(new LinguagemFav("Python",1991,"PyCharm"));
        linguagensProg.add(new LinguagemFav("JavaScript",1995,"IntelliJ"));
        linguagensProg.add(new LinguagemFav("Java",1991,"Visual Studio Code"));

        System.out.println("--------\tORDEM INSERÇÃO\t--------");
        Set<LinguagemFav> linguagensProg2 = new LinkedHashSet(Arrays.asList(
                new LinguagemFav("Python",1991,"PyCharm")));
                new LinguagemFav("JavaScript",1995,"IntelliJ");
                new LinguagemFav("Java",1991,"Visual Studio Code");


        for (LinguagemFav linguagem : linguagensProg) System.out.println(linguagem);

        System.out.println("--------\tORDEM NATURAL (NOME)\t--------");
        Set<LinguagemFav> linguagensProg3 = new TreeSet<>(linguagensProg);
        for (LinguagemFav linguagem : linguagensProg3) System.out.println(linguagem);

        System.out.println("--------\tORDEM IDE\t--------");
        Set<LinguagemFav> linguagensProg4 = new TreeSet<LinguagemFav>(new ComparatorIde());
        linguagensProg4.addAll(linguagensProg);
        for (LinguagemFav linguagem : linguagensProg4) System.out.println(linguagem);

        System.out.println("--------\tORDEM ANO E NOME\t--------");
        Set<LinguagemFav> linguagensProg5 = new TreeSet<LinguagemFav>(new ComparatorAnoCriacaoNome());
        linguagensProg5.addAll(linguagensProg);
        for (LinguagemFav linguagem : linguagensProg5) System.out.println(linguagem);

        System.out.println("--------\tORDEM NOME - ANO - IDE\t--------");
        Set<LinguagemFav> linguagensProg6 = new TreeSet<LinguagemFav>(new ComparatorNomeAnoIde());
        linguagensProg6.addAll(linguagensProg);
        for (LinguagemFav linguagem : linguagensProg6) System.out.println(linguagem);

    }
}
