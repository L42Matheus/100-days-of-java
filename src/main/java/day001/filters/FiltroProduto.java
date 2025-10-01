package day001.filters;


import day001.model.Produto;

import java.util.function.Predicate;

/**
 * SOLID: Open/Closed Principle (OCP)
 * Interface extensível para criar novos filtros sem modificar código existente
 */
@FunctionalInterface
public interface FiltroProduto extends Predicate<Produto> {

    /**
     * Factory methods para criar filtros comuns
     */
    static FiltroProduto porPrecoMinimo(double precoMinimo) {
        return produto -> produto.getPreco() > precoMinimo;
    }

    static FiltroProduto porPrecoMaximo(double precoMaximo) {
        return produto -> produto.getPreco() < precoMaximo;
    }

    static FiltroProduto porNomeContem(String texto) {
        return produto -> produto.getNome()
                .toLowerCase()
                .contains(texto.toLowerCase());
    }
}