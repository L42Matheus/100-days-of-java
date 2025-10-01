package day001.challenge;

import day001.filters.FiltroProduto;
import day001.model.Produto;
import day001.service.ProdutoService;
import day001.service.RelatorioService;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * SOLID: Dependency Inversion Principle (DIP)
 * Orquestra o desafio usando injeção de dependências
 */
public class DesafioDoDia001 {

    private final ProdutoService produtoService;
    private final RelatorioService relatorioService;

    // Construtor sem parâmetros (cria as dependências)
    public DesafioDoDia001() {
        this.produtoService = new ProdutoService();
        this.relatorioService = new RelatorioService();
    }

    // Construtor com injeção de dependências (para testes)
    public DesafioDoDia001(ProdutoService produtoService, RelatorioService relatorioService) {
        this.produtoService = produtoService;
        this.relatorioService = relatorioService;
    }

    public void executar() {
        // Criar lista de produtos
        List<Produto> produtos = criarProdutos();

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

    private List<Produto> criarProdutos() {
        return Arrays.asList(
                new Produto("Notebook", 3500.00),
                new Produto("Mouse", 50.00),
                new Produto("Teclado", 150.00),
                new Produto("Monitor", 800.00),
                new Produto("Webcam", 80.00),
                new Produto("Headset", 120.00),
                new Produto("SSD 500GB", 400.00)
        );
    }

    private void demonstrarExtensibilidade(List<Produto> produtos) {
        System.out.println("\n=== DEMONSTRAÇÃO: EXTENSIBILIDADE (OCP) ===");

        // Filtro 1: Preço entre 50 e 200
        Predicate<Produto> filtroPrecario = FiltroProduto.porPrecoMinimo(50)
                .and(FiltroProduto.porPrecoMaximo(200));

        List<Produto> produtosMedianos = produtoService.filtrar(produtos, filtroPrecario);
        relatorioService.exibirNomesProdutos(
                produtoService.obterNomes(produtosMedianos),
                "💡 Produtos entre R$ 50 e R$ 200:"
        );

        // Filtro 2: Nome contém "Teclado" OU "Mouse"
        Predicate<Produto> filtroPerifericos = FiltroProduto.porNomeContem("Teclado")
                .or(FiltroProduto.porNomeContem("Mouse"));

        List<Produto> perifericos = produtoService.filtrar(produtos, filtroPerifericos);
        relatorioService.exibirNomesProdutos(
                produtoService.obterNomes(perifericos),
                "🖱️ Periféricos (Teclado ou Mouse):"
        );

        System.out.println("\n✅ Adicionamos 2 filtros NOVOS sem modificar código existente! (OCP)");
    }
}