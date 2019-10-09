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
    private int id;
    private String nome,
            marca,
            fornecedor,
            valor,
            quantidade,
            descricao;

    public ProdutoModel() {
        produtosCadastrados++;
        this.id = produtosCadastrados;

    }

    public ProdutoModel(String nome,
            String marca,
            String fornecedor,
            String valor,
            String quantidade) {

        produtosCadastrados++;
        this.id = produtosCadastrados;
        this.nome = nome;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.quantidade = quantidade;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
