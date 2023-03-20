package one.digitalinnovation;import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioProposto1Op1 {
    public static void main(String[] args) {
        ArrayList<Double> temperaturas = new ArrayList<Double>();
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 6; i++) {
            System.out.printf("Digite a temperatura média do mês %d: ", i);
            double temperatura = sc.nextDouble();
            temperaturas.add(temperatura);
        }

        double mediaSemestral = 0.0;
        for (double temperatura : temperaturas) {
            mediaSemestral += temperatura;
        }
        mediaSemestral /= temperaturas.size();

        System.out.printf("A média semestral das temperaturas é %.2f\n", mediaSemestral);

        System.out.println("Temperaturas acima da média semestral:");
        for (int i = 0; i < temperaturas.size(); i++) {
            if (temperaturas.get(i) > mediaSemestral) {
                String mes;
                switch (i) {
                    case 0:
                        mes = "janeiro";
                        break;
                    case 1:
                        mes = "fevereiro";
                        break;
                    case 2:
                        mes = "março";
                        break;
                    case 3:
                        mes = "abril";
                        break;
                    case 4:
                        mes = "maio";
                        break;
                    default:
                        mes = "junho";
                }
                System.out.printf("%.2f - %s\n", temperaturas.get(i), mes);
            }
        }

        sc.close();
    }
}

