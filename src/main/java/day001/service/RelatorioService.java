package day001.challeng.service;


import day001.challeng.model.Produto;

import java.util.List;

/**
 * SOLID: Single Responsibility Principle (SRP)
 * 
 * Responsabilidade ÚNICA: Exibir relatórios e dados
 * 
 * NÃO é responsável por:
 * - Filtrar produtos (ProdutoService faz isso)
 * - Calcular totais (ProdutoService faz isso)
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
    
    /**
     * SOLID: Open/Closed Principle (OCP)
     * 
     * Para adicionar novo tipo de relatório,
     * basta criar novo método (extensão)
     * sem modificar os existentes!
     */
    public void exibirRelatorioCompleto(List<Produto> produtos, double total, long quantidade) {
        System.out.println("\n========== RELATÓRIO COMPLETO ==========");
        exibirTodosProdutos(produtos);
        exibirTotal(total);
        exibirQuantidade(quantidade, "Total de produtos");
        System.out.println("========================================");
    }
}