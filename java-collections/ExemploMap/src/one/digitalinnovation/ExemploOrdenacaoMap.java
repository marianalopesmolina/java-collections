package one.digitalinnovation;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("---\tORDEM ALEATÓRIA\t---");
        Map<String, Livro> meusLivros = new HashMap<>() {{
           put("HAWKING, Stephen",new Livro("Uma Breve História do Tempo",256));
           put("DUHIGG, Charles",new Livro("O Poder do Hábito",408));
           put("HARARI, Yuval Noah",new Livro("21 Lições Para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("---\tORDEM DE INSERÇÃO\t---");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
           put("HAWKING, Stephen",new Livro("Uma Breve História do Tempo",256));
           put("DUHIGG, Charles",new Livro("O Poder do Hábito",408));
           put("HARARI, Yuval Noah",new Livro("21 Lições Para o Século 21",432));
        }};
        for (Map.Entry<String,Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("---\tORDEM AUTORES\t---");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("---\tORDEM TÍTULOS\t---");
        Set<Map.Entry<String,Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros1.entrySet());
        for (Map.Entry<String,Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("---\tORDEM NÚMERO PÁGINAS\t---");
        Set<Map.Entry<String,Livro>> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
        meusLivros4.addAll(meusLivros1.entrySet());
        for (Map.Entry<String,Livro> livro : meusLivros4)
            System.out.println(livro.getValue() + " - " + livro.getValue().getPaginas());

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>> {
    @Override
    public int compare(Map.Entry<String,Livro> l1, Map.Entry<String,Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String,Livro>> {
    @Override
    public int compare(Map.Entry<String,Livro> l1, Map.Entry<String,Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(),l2.getValue().getPaginas());
    }
}
