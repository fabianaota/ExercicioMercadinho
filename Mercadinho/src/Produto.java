public class Produto {

    private String tipo;
    private String marca;
    private String peso;
    private Integer idProduto;
    private Float preco;

    public Produto() {
    }

    public Produto(String tipo, String marca, String peso, Integer idProduto, Float preco) {
        this.tipo = tipo;
        this.marca = marca;
        this.peso = peso;
        this.idProduto = idProduto;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

}