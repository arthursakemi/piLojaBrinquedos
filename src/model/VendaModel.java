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
    private int id;
    private String data;
    private String nomeCliente;
    private ArrayList<String[]> produtos; // {ID Produto, nome, quantidade, valor unitario, total}
    private Double valorTotal;

    public VendaModel() {
        vendasCadastradas++;
        id = vendasCadastradas;
    }

    public VendaModel(String data,
            String nomeCliente,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        vendasCadastradas++;
        this.id = vendasCadastradas;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public VendaModel(int id,
            String data,
            String nomeCliente,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        this.id = id;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
