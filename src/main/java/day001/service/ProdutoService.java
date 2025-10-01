package day001.service;


import day001.model.Produto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * SOLID: Single Responsibility Principle (SRP)
 * Responsabilidade: Operações de negócio sobre produtos
 */
public class ProdutoService {

    public List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> filtro) {
        return produtos.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }

    public List<String> obterNomes(List<Produto> produtos) {
        return produtos.stream()
                .map(Produto::getNome)
                .collect(Collectors.toList());
    }

    public double calcularTotal(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

    public long contar(List<Produto> produtos) {
        return produtos.stream().count();
    }

    public List<Produto> filtrarPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(p -> p.getPreco() > precoMinimo)
                .collect(Collectors.toList());
    }
}