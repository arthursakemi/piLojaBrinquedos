/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Sakemi
 */
public class VendaModel {

    private int idVenda,
            idCliente;
    private String cpf;
    private String nome;
    private String data;
    private ArrayList<String[]> produtos; // {ID Produto, nome, quantidade, valor unitario, subtotal}
    private Double valorTotal;

    public VendaModel() {
    }

    public VendaModel(int idVenda, String cpf, String data, Double valorTotal) {
        this.idVenda = idVenda;
        this.cpf = cpf;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public VendaModel(int idCliente,
            String data,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        this.idCliente = idCliente;
        this.data = data;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public VendaModel(int idVenda,
            int idCliente,
            String data,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.data = data;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<String[]> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<String[]> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
