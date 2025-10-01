package day001;

import day001.challenge.DesafioDoDia001;
import day001.examples.StreamBasicExamples;

/**
 * Day 001: Streams Básico + SOLID
 * Ponto de entrada da aplicação
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== DAY 001: Streams + SOLID ===\n");

        // Criar instância dos exemplos
        StreamBasicExamples examples = new StreamBasicExamples();

        // Executar exemplos
        examples.exemploFilterBasico();
        examples.exemploMap();
        examples.exemploCompleto();

        // Executar desafio
        System.out.println("\n=== DESAFIO DO DIA (COM SOLID) ===");
        DesafioDoDia001 desafio = new DesafioDoDia001();
        desafio.executar();
    }
}