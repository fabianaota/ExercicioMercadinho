public class ClienteVIP extends Cliente implements VIP {

    private Integer numeroVIP;


    public double receberDesconto() {
        double valorComDesconto =  getCarrinho().getValorTotal() * 0.9;
        return valorComDesconto;
    }

    public Integer getNumeroVIP() {
        return numeroVIP;
    }

    public void setNumeroVIP(Integer numeroVIP) {
        this.numeroVIP = numeroVIP;
    }

}