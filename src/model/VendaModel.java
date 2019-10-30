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

    private static int vendasCadastradas;

    private int idVenda,
            idCliente;
    private String data,
            nomeCliente;
    private ArrayList<String[]> produtos; // {ID Produto, nome, quantidade, valor unitario, total}
    private Double valorTotal;

    public VendaModel() {
        vendasCadastradas++;
        idVenda = vendasCadastradas;
    }

    public VendaModel(int idCliente,
            String data,
            String nomeCliente,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        vendasCadastradas++;
        this.idVenda = vendasCadastradas;
        this.idCliente = idCliente;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public VendaModel(int idVenda,
            int idCliente,
            String data,
            String nomeCliente,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
