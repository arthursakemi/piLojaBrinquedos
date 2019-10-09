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
public class ClienteModel {

    private static int clientesCadastrados;
    private int id;
    private String nome,
            email,
            cpf,
            rg,
            nascimento,
            celular,
            telefone,
            endereco;

    public ClienteModel() {
        clientesCadastrados++;
        this.id = clientesCadastrados;
    }

    public ClienteModel(String nome,
            String email,
            String cpf,
            String nascimento,
            String celular,
            String endereco) {

        clientesCadastrados++;
        this.id = clientesCadastrados;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.celular = celular;
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String ceular) {
        this.celular = ceular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
