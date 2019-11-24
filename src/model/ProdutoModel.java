/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sakemi
 */
public class ProdutoModel {

    public static int produtosCadastrados;
    private int id, estoque;
    private double valor;
    private String nome,
            marca,
            fornecedor,
            descricao;

    public ProdutoModel() {
        produtosCadastrados++;
        this.id = produtosCadastrados;

    }

    /**
     * Metodo para criar objeto tipo Produto
     *
     * @param nome
     * @param marca
     * @param fornecedor
     * @param estoque
     * @param valor
     * @param descricao
     */
    public ProdutoModel(String nome,
            String marca,
            String fornecedor,
            int estoque,
            double valor,
            String descricao) {

        produtosCadastrados++;
        this.id = produtosCadastrados;
        this.nome = nome;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.estoque = estoque;
        this.descricao = descricao;
    }

    /**
     * Metodo para criar objeto tipo Produto
     *
     * @param pID
     * @param nome
     * @param marca
     * @param fornecedor
     * @param estoque
     * @param valor
     * @param descricao
     */
    public ProdutoModel(int pID,
            String nome,
            String marca,
            String fornecedor,
            int estoque,
            double valor,
            String descricao) {

        this.id = pID;
        this.nome = nome;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.estoque = estoque;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int quantidade) {
        this.estoque = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] toArray() {
        return new String[]{String.valueOf(this.id),
            this.nome,
            this.marca,
            String.valueOf(this.estoque),
            String.valueOf(this.valor)
        };
    }

}
