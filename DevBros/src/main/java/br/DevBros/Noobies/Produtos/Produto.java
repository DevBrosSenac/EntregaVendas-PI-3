package br.DevBros.Noobies.Produtos;

public class Produto {

    private int codProduto;
    private String nomeProd;
    private String descProd;
    private double valorCompra;
    private double valorVenda;
    private int quantidade;
    private String categoria;

    public Produto() {
    }
    
    public Produto(int codProduto, String nomeProd, String descProd, double valorCompra, double valorVenda, int quantidade, String categoria) {
        this.codProduto = codProduto;
        this.nomeProd = nomeProd;
        this.descProd = descProd;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Produto(String nomeProd, String descProd, double valorCompra, double valorVenda, int quantidade, String categoria) {
        this.nomeProd = nomeProd;
        this.descProd = descProd;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }
    
    public Produto(int codProduto,String nomeProd, String descProd, double valorCompra, double valorVenda) {
        this.codProduto = codProduto;
        this.nomeProd = nomeProd;
        this.descProd = descProd;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    Produto(int id) {
        this.codProduto = id;
    }
    
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
}

