import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Map <String, String> meuMap1 = new HashMap<>();
        Map <String, String> meuMap2 = new LinkedHashMap<>();
        Map <String, String> meuMap3 = new TreeMap<>();

        meuMap1.put("Carro", "teste1");
        meuMap1.put("Moto", "teste2");
        meuMap1.put("Caminhão", "teste3");
        meuMap1.put("Avião", "teste4");
        meuMap1.put("Barco", "teste5");
        System.out.println(meuMap1);


        meuMap2.put("Carro", "teste1");
        meuMap2.put("Moto", "teste2");
        meuMap2.put("Caminhão", "teste3");
        meuMap2.put("Avião", "teste4");
        meuMap2.put("Barco", "teste5");
        System.out.println(meuMap2);

        meuMap3.put("Carro", "teste1");
        meuMap3.put("Moto", "teste2");
        meuMap3.put("Caminhão", "teste3");
        meuMap3.put("Avião", "teste4");
        meuMap3.put("Barco", "teste5");
        System.out.println(meuMap3);

        System.out.println("\n\t--\tHashMap(String)\t--");
        for (Map.Entry<String, String> item : meuMap1.entrySet()) {
            System.out.println(item);
        }

        System.out.println("\n\t--\tLinkedHashMap(String)\t--");
        for (Map.Entry<String, String> item : meuMap2.entrySet()) {
            System.out.println(item);
        }

        System.out.println("\n\t--\tTreeMap(String)\t--");
        for (Map.Entry<String, String> item : meuMap3.entrySet()) {
            System.out.println(item);
        }

        Map <Integer, Carro> meuMap4 = new HashMap<>();
        meuMap4.put(104, new Carro("Honda", "Civic", 2021));
        meuMap4.put(103, new Carro("Chevrolet", "Onix", 2013));
        meuMap4.put(102, new Carro("Fiat", "Toro", 2016));
        meuMap4.put(101, new Carro("Toyota", "Hilux", 1996));
        meuMap4.put(100, new Carro("Toyota", "Corolla", 2023));
        
        
        Map <Integer, Carro> meuMap5 = new LinkedHashMap<>();
        meuMap5.put(104, new Carro("Honda", "Civic", 2021));
        meuMap5.put(103, new Carro("Chevrolet", "Onix", 2013));
        meuMap5.put(102, new Carro("Fiat", "Toro", 2016));
        meuMap5.put(101, new Carro("Toyota", "Hilux", 1996));
        meuMap5.put(100, new Carro("Toyota", "Corolla", 2023));
        
        
        System.out.println("\n\t--\tHashMap(Class)\t--");
        for (Map.Entry<Integer, Carro> item : meuMap4.entrySet()) {
            System.out.println(item);
        }

        System.out.println("\n\t--\tLinkedHashMap(Class)\t--");
        for (Map.Entry<Integer, Carro> item : meuMap5.entrySet()) {
            System.out.println(item);
        }

        Map <Integer, Carro> meuMap6 = new TreeMap<>();
        meuMap6.put(104, new Carro("Honda", "Civic", 2021));
        meuMap6.put(103, new Carro("Chevrolet", "Onix", 2013));
        meuMap6.put(102, new Carro("Fiat", "Toro", 2016));
        meuMap6.put(101, new Carro("Toyota", "Hilux", 1996));
        meuMap6.put(100, new Carro("Toyota", "Corolla", 2023));

        System.out.println("\n\t--\tTreeMap(Class)\t--");
        for (Map.Entry<Integer, Carro> item : meuMap6.entrySet()) {
            System.out.println(item);
        }

        Map <Carro, Integer> meuMap8 = new TreeMap<>();
        meuMap8.put(new Carro("Honda", "Civic", 2021), 104);
        meuMap8.put(new Carro("Chevrolet", "Onix", 2013), 103);
        meuMap8.put(new Carro("Fiat", "Toro", 2016), 102);
        meuMap8.put(new Carro("Toyota", "Hilux", 1996), 101);
        meuMap8.put(new Carro("Toyota", "Corolla", 2023), 100);
        
        System.out.println("\n\t--\tTreeMap(Class/ Comparable)\t--");
        for (Map.Entry<Carro, Integer> item : meuMap8.entrySet()) {
            System.out.println(item);
        }

    }
}

class Carro implements Comparable<Carro>{
    String marca;
    String modelo;
    Integer ano;
    public Carro(String marca, String modelo, Integer ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public Integer getAno() {
        return ano;
    }
    @Override
    public String toString() {
        return "marca: " + marca + " - modelo: " + modelo + " - ano: " + ano;
    }
    @Override
    public int compareTo(Carro o) {
        int modelo = this.getModelo().compareTo(o.getModelo());
        return modelo;
    }
}

class ComparatorCarroModelo implements Comparator<Map.Entry<Integer, Carro>>{
    @Override
    public int compare(Entry<Integer, Carro> carro1, Entry<Integer, Carro> carro2) {
        int modelo = carro1.getValue().getModelo().compareToIgnoreCase(carro2.getValue().getModelo());
        if (modelo != 0){
            return modelo;
        }
        return carro1.getValue().getAno().compareTo(carro2.getValue().getAno());
    }
}

class ComparatorCarroModelo2 implements Comparator<Map.Entry<Carro, Integer>>{
    @Override
    public int compare(Entry<Carro, Integer> carro1, Entry<Carro, Integer> carro2) {
        int modelo = carro1.getKey().getModelo().compareToIgnoreCase(carro2.getKey().getModelo());
        if (modelo != 0){
            return modelo;
        }
        return carro1.getKey().getAno().compareTo(carro2.getKey().getAno());
    }
}
