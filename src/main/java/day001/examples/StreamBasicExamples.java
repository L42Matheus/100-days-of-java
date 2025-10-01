package day001.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SOLID: Single Responsibility Principle (SRP)
 * Responsabilidade: Demonstrar exemplos básicos de Streams
 */
public class StreamBasicExamples {
    
    public void exemploFilterBasico() {
        System.out.println("--- Exemplo 1: Filter Básico ---");
        
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Números > 5:");
        numeros.stream()
               .filter(n -> n > 5)
               .forEach(n -> System.out.print(n + " "));
        
        System.out.println("\n");
    }
    
    public void exemploMap() {
        System.out.println("--- Exemplo 2: Map (Transformação) ---");
        
        List<String> nomes = Arrays.asList("ana", "joão", "maria", "pedro");
        
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        
        System.out.println("Original: " + nomes);
        System.out.println("Maiúsculas: " + nomesMaiusculos);
        
        List<Integer> tamanhos = nomes.stream()
                                      .map(String::length)
                                      .collect(Collectors.toList());
        
        System.out.println("Tamanhos: " + tamanhos);
        System.out.println();
    }
    
    public void exemploCompleto() {
        System.out.println("--- Exemplo 3: Filter + Map + Collect ---");
        
        List<String> frutas = Arrays.asList("maçã", "banana", "uva", "abacaxi", "kiwi");
        
        List<String> resultado = frutas.stream()
                                       .filter(fruta -> fruta.length() > 3)
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        
        System.out.println("Frutas originais: " + frutas);
        System.out.println("Filtradas (>3 letras) e maiúsculas: " + resultado);
        System.out.println();
    }
}