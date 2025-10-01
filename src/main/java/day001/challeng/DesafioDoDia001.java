package day001.exercise;

import day001.challeng.FiltroProduto;
import day001.challeng.model.Produto;
import day001.challeng.service.ProdutoService;
import day001.challeng.service.RelatorioService;

import java.util.List;

public class DesafioDoDia001 {

    private final ProdutoService produtoService;
    private final RelatorioService relatorioService;

    /**
     * SOLID: Dependency Inversion Principle (DIP)
     *
     * Injeção de dependências via construtor
     * Facilita testes (pode injetar mocks)
     */
    public DesafioDoDia001(ProdutoService produtoService, RelatorioService relatorioService) {
        this.produtoService = produtoService;
        this.relatorioService = relatorioService;
    }

    public void executar(List<Produto> produtos) {
        // Exibir todos produtos
        relatorioService.exibirTodosProdutos(produtos);

        // Filtrar produtos com preço > 100
        List<Produto> produtosCaros = produtoService.filtrarPorPrecoMinimo(produtos, 100.0);

        // Obter apenas nomes
        List<String> nomesProdutosCaros = produtoService.obterNomes(produtosCaros);

        // Exibir resultados
        relatorioService.exibirNomesProdutos(
                nomesProdutosCaros,
                "💰 Produtos com preço > R$ 100:"
        );

        // Calcular e exibir total
        double total = produtoService.calcularTotal(produtosCaros);
        relatorioService.exibirTotal(total);

        // Contar e exibir quantidade
        long quantidade = produtoService.contar(produtosCaros);
        relatorioService.exibirQuantidade(quantidade, "Quantidade de produtos > R$ 100");

        // Demonstrar extensibilidade (OCP)
        demonstrarExtensibilidade(produtos);
    }

    /**
     * SOLID: Open/Closed Principle (OCP)
     *
     * Demonstra como adicionar NOVOS filtros
     * sem modificar código existente!
     */
    private void demonstrarExtensibilidade(List<Produto> produtos) {
        System.out.println("\n=== DEMONSTRAÇÃO: EXTENSIBILIDADE (OCP) ===");

        // Filtro 1: Preço entre 50 e 200
        var filtroPrecario = FiltroProduto.porPrecoMinimo(50)
                .and(FiltroProduto.porPrecoMaximo(200));

        List<Produto> produtosMedianos = produtoService.filtrar(produtos, p -> filtroPrecario.test(p));
        relatorioService.exibirNomesProdutos(
                produtoService.obterNomes(produtosMedianos),
                "💡 Produtos entre R$ 50 e R$ 200:"
        );

        // Filtro 2: Nome contém "Teclado" OU "Mouse"
        var filtroPerifericos = FiltroProduto.porNomeContem("Teclado")
                .or(FiltroProduto.porNomeContem("Mouse"));

        List<Produto> perifericos = produtoService.filtrar(produtos, p -> filtroPerifericos.test(p));
        relatorioService.exibirNomesProdutos(
                produtoService.obterNomes(perifericos),
                "🖱️ Periféricos (Teclado ou Mouse):"
        );

        System.out.println("\n✅ Adicionamos 2 filtros NOVOS sem modificar código existente!");
    }
}

