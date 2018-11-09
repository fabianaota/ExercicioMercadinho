import java.util.List;
import java.util.Scanner;

public class Main {

    static Mercado mercado = new Mercado();

    public static void main(String[] args) {


        // SETANDO NOME DO MERCADO

        mercado.setNome("Supermercado Dia");


        // CRIANDO PRODUTOS

        Produto arroz = new Produto("Arroz branco", "Camil", "1 kg", 1, 2.80F);
        Produto feijao = new Produto("Feijao carioca", "Rosalito", "1 kg", 2, 3.10F);
        Produto acucar = new Produto("Acucar cristal", "Native", "1 kg", 3,5.40F);
        Produto sal = new Produto ("Sal refinado", "Lebre", "1 kg", 4, 1.60F);
        Produto oleo = new Produto("oleo de milho", "Liza", "900 ml", 5, 5.40F);
        Produto molhoTomate = new Produto("Molho de tomate", "Salsaretti", "340 g", 6, 2.60F);
        Produto macarrao = new Produto("Macarrao espaguete", "Renata", "500 g", 7, 2.40F);
        Produto cafe = new Produto("Cafe", "Pilão", "250 g", 8, 6.00F);
        Produto farinha = new Produto("Farinha de trigo", "Dona Benta", "1 kg", 9, 3.70F);
        Produto leite = new Produto("Leite integral", "Jussara", "1 l", 10, 3.00F);


        // ADICIONANDO PRODUTOS NO MAPA

        mercado.adicionarNoMapa(arroz);
        mercado.adicionarNoMapa(feijao);
        mercado.adicionarNoMapa(acucar);
        mercado.adicionarNoMapa(sal);
        mercado.adicionarNoMapa(oleo);
        mercado.adicionarNoMapa(molhoTomate);
        mercado.adicionarNoMapa(macarrao);
        mercado.adicionarNoMapa(cafe);
        mercado.adicionarNoMapa(farinha);
        mercado.adicionarNoMapa(leite);


        // CRIANDO UM CARRINHO

        Carrinho carrinho = new Carrinho();


        // PRINTANDO O MENU

        System.out.println();
        System.out.println("Bem vindo!");
        mercado.criarEAddCliente();
        System.out.println();
        System.out.println("Olá " + mercado.getListaClientes().get(0).getNome()+ " " + mercado.getListaClientes().get(0).getSobrenome() + "!");
        System.out.println();
        System.out.println("Seu cadastro foi realizado com sucesso!");
        System.out.println();
        System.out.println("Escolha a opção desejada :");
        System.out.println("1 - buscar produto");
        System.out.println("2 - ver valor da compra");
        System.out.println("3 - finalizar compra");
        System.out.println("4 - sair do sistema");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        while(opcao != 4) {
            switch (opcao) {

                case 1:
                    Produto produtoSelecionado = buscaProduto();
                    if( produtoSelecionado.getIdProduto() == null){
                        System.out.println();
                        System.out.println("Produto não encontrado!");
                        System.out.println();
                    }
                    else{
                        System.out.println();
                        System.out.println("Deseja adicionar o produto acima ao seu carrinho? (digite 'sim' ou 'não')");
                        System.out.println();
                        Scanner sc1 = new Scanner(System.in);
                        String resposta = sc1.nextLine();
                        if(resposta.equalsIgnoreCase("sim") ){
                            carrinho.adicionarProduto(produtoSelecionado);
                        }
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("O valor parcial de sua compra é : R$ "+carrinho.getValorTotal());
                    break;

                case 3:
                    carrinho.getValorTotal();
                    System.out.println();
                    System.out.println("O valor total de sua compra é : R$ " + carrinho.getValorTotal());
                    System.out.println();
                    System.out.println("Deseja nota fiscal paulista? (digite 'sim' ou 'não')");
                    System.out.println();
                    Scanner sc2 = new Scanner(System.in);
                    String resposta2 = sc2.nextLine();
                    if(resposta2.equalsIgnoreCase("sim") ){
                        System.out.println();
                        System.out.println("-----------------------------------------------");
                        System.out.println("            " + mercado.getNome() + "            ");
                        System.out.println("-----------------------------------------------");
                        System.out.println("Nome do cliente : " + mercado.getListaClientes().get(0).getNome() + " " + mercado.getListaClientes().get(0).getSobrenome());
                        System.out.println("CPF : " + mercado.getListaClientes().get(0).getCpf());
                        System.out.println();
                        for (Produto produto : carrinho.getListaProdutos()) {
                            System.out.println("Item : " + produto.getTipo() +" " +produto.getMarca()+" "+ produto.getPeso()+"  "+ "R$"+produto.getPreco());

                        }

                        //  System.out.println("item :" carrinho.getListaProdutos().get());
                        System.out.println("Valor total : R$ " + carrinho.getValorTotal());
                        System.out.println();
                    }
                    break;
            }

            System.out.println();
            System.out.println("Escolha a opção desejada :");
            System.out.println();
            System.out.println("1 - buscar produto");
            System.out.println("2 - ver valor");
            System.out.println("3 - finalizar compra");
            System.out.println("4 - sair do sistema");
            System.out.println();
            opcao = scanner.nextInt();
        }
        System.out.println();
        System.out.println("Obrigado e volte sempre!");
    }

    public static Produto buscaProduto(){
        Produto produtoEncontrado = new Produto();
        System.out.println();
        System.out.println("Digite o produto desejado :");
        System.out.println();
        String nome = new Scanner(System.in).nextLine();
        try {
            List<Produto> produtosEncontrado = mercado.buscarPorProduto(nome);
            if (produtosEncontrado.size() == 0){
                
                return produtoEncontrado;
            }
            produtoEncontrado = produtosEncontrado.get(0);
                System.out.println();
                System.out.println("Resultado da busca :");
                System.out.println(produtoEncontrado.getTipo() + " " + produtoEncontrado.getMarca() + " " + produtoEncontrado.getPeso());
                System.out.println("Valor : R$ " + produtoEncontrado.getPreco());
                System.out.println();
             } catch (Exception e) {
            System.out.println("Alerta! Uma exceção foi encontrada!");
        }
        return produtoEncontrado;
    }

}