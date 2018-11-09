import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private float valorTotal;
    private List<Produto> listaProdutos;

    public Carrinho(){
        listaProdutos = new ArrayList<>();
        valorTotal = 0;
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        valorTotal = valorTotal + produto.getPreco();
        System.out.println();
        System.out.println("O item " + produto.getTipo() + " " + produto.getMarca() + " foi adicionado ao carrinho");
        System.out.println();
    }
    public void excluirProduto(Produto produto){
        listaProdutos.remove(produto);
        valorTotal = valorTotal - produto.getPreco();
        System.out.println();
        System.out.println("O item " + produto.getTipo() + " " + produto.getMarca() + " foi excluído do carrinho");
        System.out.println();
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}