package one.digitalinnovation.exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PopulacaoEstadosNE {
    public static void main(String[] args) {

        // Cria um Map com os estados e suas populações
        Map<String, Integer> populacaoEstados = new HashMap<>();
        populacaoEstados.put("PE", 9616621);
        populacaoEstados.put("AL", 3351543);
        populacaoEstados.put("CE", 9187103);
        populacaoEstados.put("RN", 3534265);

        // Substitui a população do estado RN
        populacaoEstados.put("RN", 3534165);

        // Verifica se a Paraíba (PB) está no dicionário, caso não, adiciona
        if (!populacaoEstados.containsKey("PB")) {
            populacaoEstados.put("PB", 0);
        }

        // Exibe a população do estado PE
        System.out.println("População de PE: " + populacaoEstados.get("PE"));

        // Exibe todos os estados e suas populações na ordem em que foram informados
        System.out.println("Estados e suas populações (ordem de inserção):");
        for (Map.Entry<String, Integer> entry : populacaoEstados.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Exibe todos os estados e suas populações em ordem alfabética
        Map<String, Integer> populacaoEstadosOrdenado = new TreeMap<>(populacaoEstados);
        System.out.println("Estados e suas populações (ordem alfabética):");
        for (Map.Entry<String, Integer> entry : populacaoEstadosOrdenado.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Exibe o estado com a menor população e seu respectivo valor
        String estadoMenorPopulacao = null;
        int menorPopulacao = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : populacaoEstados.entrySet()) {
            if (entry.getValue() < menorPopulacao) {
                estadoMenorPopulacao = entry.getKey();
                menorPopulacao = entry.getValue();
            }
        }
        System.out.println("Estado com a menor população: " + estadoMenorPopulacao + " - " + menorPopulacao);

        // Exibe a soma da população desses estados
        int somaPopulacao = 0;
        for (int populacao : populacaoEstados.values()) {
            somaPopulacao += populacao;
        }
        System.out.println("Soma da população dos estados: " + somaPopulacao);

        // Exibe a média de população dos estados
        double mediaPopulacao = (double) somaPopulacao / populacaoEstados.size();
        System.out.println("Média de população dos estados: " + mediaPopulacao);

        // Apaga o dicionário dos estados
        populacaoEstados.clear();

        // Verifica se o dicionário está vazio
        System.out.println("O dicionário de estados está vazio: " + populacaoEstados.isEmpty());
    }
}

