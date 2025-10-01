package day001.model;

import java.util.Objects;

/**
 * SOLID: Single Responsibility Principle (SRP)
 * Responsabilidade: Representar um Produto com seus dados
 */
public class Produto {
    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s (R$ %.2f)", nome, preco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.preco, preco) == 0 &&
                Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }
}