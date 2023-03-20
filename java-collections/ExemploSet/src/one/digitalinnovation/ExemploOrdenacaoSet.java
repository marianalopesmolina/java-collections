package one.digitalinnovation;

// Dadas as seguintes informações sobre as séries favoritas de uma pessoa,
// crie um conjunto e ordene este conjunto exibindo:
// (nome - genero - tempo de episódio);

// Série 1 = Nome: GOT, genero: Fantasia, tempoEp: 60
// Série 2 = Nome: Dark, genero: Drama, tempoEp: 45
// Série 3 = Nome: That '70 Show, genero: Comédia, tempoEp: 25

import java.util.*;
import java.util.Comparator;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 45));
            add(new Serie("That '70s Show", "Comédia", 25));
        }};
        for (Serie serie : minhasSeries) System.out.println(serie.getNome() + " | "
               + serie.getGenero() + " | " + serie.getTempoEp());
        System.out.println();

        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 45));
            add(new Serie("That '70s Show", "Comédia", 25));
        }};
        for (Serie serie : minhasSeries1) System.out.println(serie.getNome() + " | "
               + serie.getGenero() + " | " + serie.getTempoEp());
        System.out.println();

        System.out.println("--\tOrdem natural (Tempo Episódio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie : minhasSeries2) System.out.println(serie.getNome() + " | "
                + serie.getGenero() + " | " + serie.getTempoEp());
        System.out.println();

        System.out.println("--\tOrdem Nome/Gênero/Tempo Episódio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEp());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie : minhasSeries3) System.out.println(serie.getNome() + " | "
                + serie.getGenero() + " | " + serie.getTempoEp());
        System.out.println();

//        Ordene por Gênero:
        System.out.println("--\tOrdem gênero\t--");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie : minhasSeries4) System.out.println(serie.getNome() + " | "
                + serie.getGenero() + " | " + serie.getTempoEp());
        System.out.println();

//        Ordene por Tempo de Episódio:
        System.out.println("--\tOrdem tempo de episódio\t--");
        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorTempoEp());
        minhasSeries5.addAll(minhasSeries);
        for (Serie serie : minhasSeries5) System.out.println(serie.getNome() + " | "
                + serie.getGenero() + " | " + serie.getTempoEp());
        System.out.println();

        System.out.println(minhasSeries.toString());

    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEp;

    public Serie(String nome, String genero, Integer tempoEp) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEp = tempoEp;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEp() {
        return tempoEp;
    }

    @Override
    public String toString() {
        return "Séries{" +
                "Nome: " + nome + '\'' +
                "| Gênero: " + genero + '\'' +
                "| Tempo Ep: " + tempoEp +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEp, serie.tempoEp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEp);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEp = Integer.compare(this.getTempoEp(), serie.getTempoEp());
        if (tempoEp != 0) return tempoEp;

        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEp implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEp(), s2.getTempoEp());
    }

}

class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return genero;
    }
}

class ComparatorTempoEp implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int tempoEp = s1.getTempoEp().compareTo(s2.getTempoEp());
        if (tempoEp != 0) return tempoEp;

        return tempoEp;
    }

}

