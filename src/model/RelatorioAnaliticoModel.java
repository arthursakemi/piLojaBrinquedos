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
public class RelatorioAnaliticoModel {

    private static int vendasCadastradas;
    private int IDVenda;
    private String[] data;
    private String nomeCliente;
    private int quantidadeItens;
    private Double valorTotal;

    public RelatorioAnaliticoModel() {
        vendasCadastradas++;
        this.setIDVenda(vendasCadastradas);
    }

    public RelatorioAnaliticoModel(String[] data,
            String nomeCliente,
            int quantidadeItens,
            Double valorTotal) {

        vendasCadastradas++;
        this.setIDVenda(vendasCadastradas);
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
    }

    public RelatorioAnaliticoModel(int IDVenda, String[] data, String nomeCliente, int quantidadeItens, Double valorTotal) {
        this.IDVenda = IDVenda;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
