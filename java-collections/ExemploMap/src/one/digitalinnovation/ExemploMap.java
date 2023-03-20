package one.digitalinnovation;

/* Dados os modelos dos carros e seus respectivos consumos na estrada, faça:
modelo = gol - consumo = 14,4 km/L
modelo = uno - consumo = 15,6 km/L
modelo = mobi - consumo = 16,1 km/L
modelo = hb20 - consumo = 14,5 km/L
modelo = kwid - consumo = 15,6 km/L
*/

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String,Double> carrosPopulares = new HashMap<>() {{
           put("gol",14.4);
           put("uno",15.6);
           put("mobi",16.1);
           put("hb20",14.5);
           put("kwid",15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o valor de consumo do 'gol' por '15,2 km/L': ");
        carrosPopulares.put("gol",15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo 'tucson' está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do 'uno': " + carrosPopulares.get("uno"));

//        System.out.println("Exiba o terceiro modelo adicionado: ");
//        Não é possível pois a interface 'Map' não comporta índices.

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoEconomico = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String,Double>> entries = carrosPopulares.entrySet();
        String modeloEconomico = "";

        for (Map.Entry<String,Double> entry : entries) {
            if (entry.getValue().equals(consumoEconomico)) {
                modeloEconomico = entry.getKey();
                System.out.println("Modelo mais econômico: " + modeloEconomico + " - " + consumoEconomico);
            }
        }

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double maiorConsumo = Collections.min(carrosPopulares.values());
        String modeloMaiorConsumo = "";
        Set<Map.Entry<String,Double>> entries1 = carrosPopulares.entrySet();

        for (Map.Entry<String,Double> entry : entries1) {
            if (entry.getValue().equals(maiorConsumo)) {
                modeloMaiorConsumo = entry.getKey();
                System.out.println("Modelo menos econômico: " + modeloMaiorConsumo + " - " + maiorConsumo);
            }
        }

//        Realizando a soma dos consumos
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média dos consumos: " + (soma/carrosPopulares.size()));

//        Removendo elementos com valor especificado
        System.out.println("Remova os modelos com o consumo igual a '15,6 km/L': ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os modelos na ordem em que foram informados: ");
        Map<String,Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String,Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());

    }
}
