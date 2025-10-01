package day001.challeng.service;

import day001.challeng.FiltroProduto;
import day001.challeng.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService {
    
    /**
     * SOLID: Dependency Inversion Principle (DIP)
     * 
     * Depende de ABSTRAÇÃO (FiltroProduto/Predicate)
     * Não depende de implementação concreta
     */
    public List<Produto> filtrar(List<Produto> produtos, FiltroProduto filtro) {
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
    
    /**
     * SOLID: Open/Closed Principle (OCP)
     * 
     * Método extensível: pode aplicar QUALQUER filtro
     * sem modificar este código!
     */
    public List<Produto> filtrarPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return filtrar(produtos, FiltroProduto.porPrecoMinimo(precoMinimo));
    }
}