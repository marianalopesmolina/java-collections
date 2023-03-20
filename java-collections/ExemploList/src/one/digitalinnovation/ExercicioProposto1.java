package one.digitalinnovation;

// Crie um programa que receba a temperatura média dos  primeiros 6 meses do ano e armazene-as em uma lista.
// Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
// e em que mês elas ocorreram (exibir o mês por extenso, por exemplo: 1- janeiro, 2- fevereiro, ...).

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto1 {

    public static void main(String[] args) {

        System.out.println("Informe as médias de temperaturas dos primeiros 6 meses do ano:");
        List<Double> listaTemp = new ArrayList<Double>();

        Scanner sc = new Scanner(System.in);
        Double temp;
        int meses = 6;

        for(int i = 1; i <= meses; i++) {
            System.out.printf("Informe a média do mês %d: ", i);
            temp = sc.nextDouble();
            listaTemp.add(temp);
        }

        Iterator<Double> iterator = listaTemp.iterator();
        Double soma = 0d, media = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
            media = (soma/meses);
        }

        System.out.println("------------------------------");
        System.out.println("------ TEMPERATURAS ------");
        System.out.println(listaTemp);

        System.out.println("---------- MÉDIA ----------");
        System.out.println("A média de temperatura de " + meses + " meses é de " + media);

        System.out.println("------------------------------");
        System.out.println("Temperaturas acima da média de " + media);
        System.out.println("------------------------------");

        for(int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i) > media) {
                String mes;
                switch (i) {
                    case 0:
                        mes = "Janeiro";
                        break;
                    case 1:
                        mes = "Fevereiro";
                        break;
                    case 2:
                        mes = "Março";
                        break;
                    case 3:
                        mes = "Abril";
                        break;
                    case 4:
                        mes = "Maio";
                        break;
                    default:
                        mes = "Junho";
                        break;
                }
                System.out.printf(listaTemp.get(i) + " - " + mes + "\n");
                System.out.println("------------------------------");
            }
        }

        sc.close();
    }
}
