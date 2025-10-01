package day001.service;


import day001.model.Produto;

import java.util.List;

/**
 * SOLID: Single Responsibility Principle (SRP)
 * Responsabilidade: Exibir relatórios e dados formatados
 */
public class RelatorioService {

    public void exibirTodosProdutos(List<Produto> produtos) {
        System.out.println("📦 Todos os produtos:");
        produtos.forEach(System.out::println);
    }

    public void exibirNomesProdutos(List<String> nomes, String titulo) {
        System.out.println("\n" + titulo);
        nomes.forEach(nome -> System.out.println("   - " + nome));
    }

    public void exibirTotal(double total) {
        System.out.println(String.format("\n💵 Valor total: R$ %.2f", total));
    }

    public void exibirQuantidade(long quantidade, String descricao) {
        System.out.println(String.format("📊 %s: %d", descricao, quantidade));
    }
}