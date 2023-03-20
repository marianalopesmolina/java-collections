package one.digitalinnovation.exercicios;
/* Dada a população estimada dos estados do NE brasileiro:
Estado = PE - população = 9.616.621
Estado = AL - população = 3.351.543
Estado = CE - população = 9.187.103
Estado = RN - população = 3.534.265
Estado = PB - população = 4.039.277
Faça:
> Substitua a população do RN por '3.534.165';
> Confira se o estado da Paraíba (PB) está no dicionário, caso não, adicione;
> Exiba a população do estado PE;
> Exiba todos os estados e suas populações na ordem em que foram informados;
> Exiba todos os estados e suas populações em ordem alfabética;
> Exiba o estado com a menor população e seu valor;
> Exiba o estado com a maior população e seu respectivo valor;
> Exiba a soma das populações dos estados;
> Apague o dicionário dos estados;
> Confira se o dicionário está vazio.
*/
import java.util.*;

public class ExProposto1 {
    public static void main(String[] args) {

        Map<String,Integer> estadosBrNE = new HashMap<>() {{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};
//        System.out.println(estadosBrNE);

//        Substituindo a população do RN pelo valor '3.534.165':
        estadosBrNE.put("RN",3534165);
        System.out.println(estadosBrNE + "\n");

//        Conferindo se o estado da Paraíba (PB) está no dicionário, caso não, adicionar.
        System.out.println("O estado da 'Paraíba' (PB) faz parte do dicionário: " + estadosBrNE.containsKey("PB"));
//        Adicionando o elemento 'PB' - '4.039.277' no dicionário:
        estadosBrNE.put("PB",4039277);
        System.out.println("Estado 'PB' adicionado ao dicionário: " + estadosBrNE + "\n");

//        Exibindo a população do estado PE:
        System.out.println("População do estado do 'PE': " + estadosBrNE.get("PE") + "\n");

//        Exibindo todos os estados e suas populações na ordem em que foram informados:
        System.out.println("Estados brasileiros NE por ordem de inserção: ");
        Map<String,Integer> estadosBrNE1 = new LinkedHashMap<>() {{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
            put("PB",4039277);
        }};
        for (Map.Entry<String,Integer> estados : estadosBrNE1.entrySet())
            System.out.println(estados);
        System.out.println();

//        Exibindo todos os estados e suas populações em ordem alfabética:
        System.out.println("Estados brasileiros NE por ordem alfabética: ");
        Map<String,Integer> estadosBrAlfabeto = new TreeMap<>(estadosBrNE1);
        for (Map.Entry<String,Integer> alfabeto : estadosBrAlfabeto.entrySet())
            System.out.println(alfabeto.getKey() + " - " +  alfabeto.getValue());
        System.out.println();

//        Exiba o estado com a menor população e seu valor:
        System.out.println("Estado com menor população e seu valor: ");
        Collection<Integer> populacao = estadosBrNE.values();
        String estadoMaiorPop = "";
        String estadoMenorPop = "";
        for (Map.Entry<String,Integer> entry : estadosBrNE.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaiorPop = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenorPop = entry.getKey();
        }
        System.out.printf(estadoMenorPop,Collections.min(populacao));
        System.out.println();
        System.out.println("Estado com maior população e seu valor: ");
        System.out.printf(estadoMaiorPop,Collections.max(populacao));
        System.out.println();


//        Realizando a soma das populações dos estados:
//        System.out.println("Soma das populações dos estados brasileiros NE: ");
//        Double soma = 0d;

    }
}


