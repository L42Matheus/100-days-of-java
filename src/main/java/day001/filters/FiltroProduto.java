package day001.challeng;


import day001.challeng.model.Produto;

import java.util.function.Predicate;

@FunctionalInterface
public interface FiltroProduto extends Predicate<Produto> {

    // Filtros pré-definidos (Factory Method Pattern)
    static FiltroProduto porPrecoMinimo(double precoMinimo) {
        return produto -> produto.getPreco() > precoMinimo;
    }

    static FiltroProduto porPrecoMaximo(double precoMaximo) {
        return produto -> produto.getPreco() < precoMaximo;
    }

    static FiltroProduto porNomeContem(String texto) {
        return produto -> produto.getNome().toLowerCase()
                .contains(texto.toLowerCase());
    }

    static FiltroProduto porPrecoExato(double preco) {
        return produto -> produto.getPreco() == preco;
    }
}