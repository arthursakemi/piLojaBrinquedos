/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ClienteModel;
import model.ProdutoModel;
import util.Validador;

/**
 *
 * @author Sakemi
 */
public class VendaView extends javax.swing.JFrame {

    private DefaultTableModel tmCarrinho = new DefaultTableModel();
    private TelaPrincipalView telaPrincipal;
    private ClienteModel c;
    private boolean clienteEncontrado = false;

    /**
     * Creates new form VendaView
     */
    public VendaView() {
        initComponents();
        setLocationRelativeTo(null);
        loadTableProdutos();
        lblNomeCliente.setVisible(false);

        tmCarrinho.addColumn("ID");
        tmCarrinho.addColumn("Nome");
        tmCarrinho.addColumn("Quantidade");
        tmCarrinho.addColumn("Valor Un.");
        tmCarrinho.addColumn("Total Parcial");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblData.setText(dateFormat.format(date));
    }

    public VendaView(TelaPrincipalView tp) {
        initComponents();
        setLocationRelativeTo(null);
        loadTableProdutos();
        lblNomeCliente.setVisible(false);

        tmCarrinho.addColumn("ID");
        tmCarrinho.addColumn("Nome");
        tmCarrinho.addColumn("Quantidade");
        tmCarrinho.addColumn("Valor Un.");
        tmCarrinho.addColumn("Total Parcial");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblData.setText(dateFormat.format(date));
        telaPrincipal = tp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnConcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jPanel = new javax.swing.JPanel();
        txtQuantidade = new javax.swing.JTextField();
        lblNomeProduto = new javax.swing.JLabel();
        txtIDProduto = new javax.swing.JTextField();
        lblIDProduto = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        btnBuscarProduto = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrinho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Valor Un.", "Total Parcial"
            }
        ));
        jScrollPane1.setViewportView(tblCarrinho);

        btnBuscar.setText("Buscar Cliente");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setPreferredSize(new java.awt.Dimension(46, 25));

        jLabel8.setText("CPF:");

        lblNomeCliente.setText("Nome");

        jLabel4.setText("Cliente:");

        Data.setText("Data:");

        lblData.setText("lblDate");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblData)))
                .addGap(352, 352, 352)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblNomeCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Data)
                            .addComponent(lblData))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
        );

        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText(" Cancelar Venda");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Remover do Carrinho");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Total:  R$");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTotal.setText("00.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(27, 27, 27)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(lblTotal))))
                    .addComponent(btnConcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Marca", "Estoque", "Valor"
            }
        ));
        jScrollPane2.setViewportView(tblProduto);

        txtQuantidade.setPreferredSize(new java.awt.Dimension(140, 25));

        lblNomeProduto.setText("Nome:");

        txtIDProduto.setPreferredSize(new java.awt.Dimension(140, 25));

        lblIDProduto.setText("ID Produto:");

        lblQuantidade.setText("Quantidade:");

        txtNomeProduto.setPreferredSize(new java.awt.Dimension(140, 25));

        btnBuscarProduto.setText("Buscar Produto");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar ao Carrinho");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDProduto)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeProduto)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelLayout.createSequentialGroup()
                                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtIDProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIDProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeProduto)
                    .addComponent(lblQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnAtualizar.setText("Atualizar Produtos");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Webp.net-resizeimage.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 48)); // NOI18N
        jLabel3.setText("TableTop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblCarrinho.getSelectedRow();
        if (tblCarrinho.getRowCount() > 0) {
            if (linha >= 0) {
                tmCarrinho.removeRow(linha);
                tblCarrinho.setModel(tmCarrinho);
                getTotal();

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para excluír!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há produtos para excluir!");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int quantidade, estoque;
        int linha = tblProduto.getSelectedRow();

        if (tblProduto.getRowCount() < 0) {
            JOptionPane.showMessageDialog(this, "Não há produtos para adicionar!");
            return;
        }

        if (!validarQuantidade(linha)) {
            return;
        }

        quantidade = Integer.parseInt(txtQuantidade.getText());
        estoque = Integer.parseInt(tblProduto.getModel().getValueAt(linha, 3).toString());

        if (!txtQuantidade.getText().equals("")) {

            if (quantidade > estoque) {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente!");
            } else {
                addCarrinho(linha, quantidade, estoque);
                loadTableProdutos();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Informe a quantidade desejada!");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        int id;
        String nome;
        if (tblProduto.getRowCount() > 0) {

            if (validarBuscaProduto()) {
                if (!txtIDProduto.getText().equals("")) {
                    id = Integer.parseInt(txtIDProduto.getText());

                    buscaProduto(id);
                } else {
                    nome = txtNomeProduto.getText().toLowerCase();

                    buscaProduto(nome);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há produtos para buscar!");
        }
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        loadTableProdutos();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cpfString = txtCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
        long cpf;
        if (!cpfString.equals("")) {
            if (Validador.validarCPF(cpfString)) {
                cpf = Long.parseLong(cpfString);
                c = ClienteController.buscaCliente(cpf);
                if (c != null) {
                    lblNomeCliente.setVisible(true);
                    lblNomeCliente.setText(c.getNome());
                    clienteEncontrado = true;

                } else {
                    JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
                    clienteEncontrado = false;
                }
            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o CPF do Cliente!");
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        ArrayList<String[]> produtos = new ArrayList<>();

        if (tblCarrinho.getRowCount() > 0) {
            if (clienteEncontrado) {

                for (int i = 0; i < tblCarrinho.getRowCount(); i++) {
                    int quantidade = Integer.parseInt(tblCarrinho.getModel().getValueAt(i, 2).toString());
                    Double valorUnitario = Double.parseDouble(tblCarrinho.getModel().getValueAt(i, 3).toString());

                    String[] linha = {tblCarrinho.getModel().getValueAt(i, 0).toString(),
                        tblCarrinho.getModel().getValueAt(i, 1).toString(),
                        String.valueOf(quantidade),
                        String.valueOf(valorUnitario),
                        String.valueOf(quantidade * valorUnitario)};

                    produtos.add(linha);
                }

                if (VendaController.salvar(c.getId(),
                        lblData.getText(),
                        produtos,
                        Double.parseDouble(lblTotal.getText().replace(",", ".")))) {

                    JOptionPane.showMessageDialog(this, "Venda concluída com sucesso!");

                    atualizarEstoque(produtos);

                    telaPrincipal.loadTableVendas();
                    telaPrincipal.loadTableProdutos();
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao registrar a venda!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Informe o CPF do cliente!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há produtos no carrinho!");
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    public void atualizarEstoque(ArrayList<String[]> produtos) {
        int id, quantidade;

        for (String[] p : produtos) {
            id = Integer.parseInt(p[0]);
            quantidade = Integer.parseInt(p[2]);
        }

    }

    public void loadTableProdutos() {

        ArrayList<ProdutoModel> produtos = ProdutoController.loadProdutos();

        DefaultTableModel tmProdutos = new DefaultTableModel();
        tmProdutos.addColumn("ID");
        tmProdutos.addColumn("Nome");
        tmProdutos.addColumn("Marca");
        tmProdutos.addColumn("Estoque");
        tmProdutos.addColumn("Valor");

        tblProduto.setModel(tmProdutos);

        for (ProdutoModel p : produtos) {
            tmProdutos.addRow(p.toArray());
        }

    }

    public void getTotal() {
        double total = 00.00;
        int linhas = tblCarrinho.getRowCount();
        for (int i = 0; i < linhas; i++) {
            double valor = Double.parseDouble(tblCarrinho.getModel().getValueAt(i, 3).toString());
            int quantidade = Integer.parseInt(tblCarrinho.getModel().getValueAt(i, 2).toString());
            total += valor * quantidade;
        }

        lblTotal.setText(String.format("%.2f", total));
    }

    public void addCarrinho(int linha, int quantidade, int estoque) {
        String[] produto = new String[5];
        int novaQuantidade, posicaoAdicionada;
        double novoTotal;
        int id = Integer.parseInt(tblProduto.getModel().getValueAt(linha, 0).toString());

        produto[0] = String.valueOf(id);
        produto[1] = tblProduto.getModel().getValueAt(linha, 1).toString();
        produto[2] = String.valueOf(quantidade);
        produto[3] = tblProduto.getModel().getValueAt(linha, 4).toString();
        produto[4] = String.valueOf(quantidade * Double.parseDouble(produto[3]));

        posicaoAdicionada = adicionado(id);

        if (posicaoAdicionada != -1) {
            novaQuantidade = Integer.parseInt(tblCarrinho.getModel().getValueAt(posicaoAdicionada, 2).toString()) + quantidade;

            if (novaQuantidade > estoque) {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente!");
                return;
            }

            novoTotal = novaQuantidade * Double.parseDouble(produto[3]);

            produto[2] = String.valueOf(novaQuantidade);
            produto[4] = String.valueOf(novoTotal);
            tmCarrinho.removeRow(posicaoAdicionada);

        }

        tblCarrinho.setModel(tmCarrinho);
        tmCarrinho.addRow(produto);
        getTotal();
    }

    public int adicionado(int id) {
        for (int i = 0; i < tblCarrinho.getRowCount(); i++) {
            int idAdicionado = Integer.parseInt(tblCarrinho.getModel().getValueAt(i, 0).toString());

            if (id == idAdicionado) {
                return i;
            }
        }
        return -1;
    }

    public boolean validarQuantidade(int linha) {
        String quantidade = txtQuantidade.getText().toLowerCase();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione o produto a ser adicionado!");
            return false;
        }

        int estoque = Integer.parseInt(tblProduto.getModel().getValueAt(linha, 3).toString());

        if (quantidade.equals("")) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade desejada");
            return false;
        }
        if (!Validador.validarInt(quantidade)) {
            JOptionPane.showMessageDialog(this, "Quantidade Inválida");
            return false;
        }
        if (Integer.parseInt(quantidade) > estoque) {
            JOptionPane.showMessageDialog(this, "Estoque insuficiente");
            return false;
        }
        return true;
    }

    public boolean validarBuscaProduto() {
        boolean idPreenchido = !txtIDProduto.getText().equalsIgnoreCase("");
        boolean nomePreenchido = !txtNomeProduto.getText().equalsIgnoreCase("");

        if (!idPreenchido && !nomePreenchido) {
            JOptionPane.showMessageDialog(this, "Informe o ID ou o Nome do produto!");
            return false;

        } else if (idPreenchido && !Validador.validarInt(txtIDProduto.getText())) {
            JOptionPane.showMessageDialog(this, "ID inválido!");
            return false;
        }

        return true;
    }

    public void buscaProduto(String nome) {
        ArrayList<String[]> linhasProdutos = ProdutoController.buscaProduto(nome);

        if (!linhasProdutos.isEmpty()) {

            DefaultTableModel tmProdutos = new DefaultTableModel();
            tmProdutos.addColumn("ID");
            tmProdutos.addColumn("Nome");
            tmProdutos.addColumn("Marca");
            tmProdutos.addColumn("Fornecedor");
            tmProdutos.addColumn("Valor");
            tmProdutos.addColumn("Quantidade");
            tmProdutos.addColumn("Descrição");

            for (String[] p : linhasProdutos) {
                tmProdutos.addRow(p);
            }

            tblProduto.setModel(tmProdutos);
            tblProduto.removeColumn(tblProduto.getColumnModel().getColumn(3));
            tblProduto.removeColumn(tblProduto.getColumnModel().getColumn(5));
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        }

    }

    public void buscaProduto(int id) {
        ProdutoModel produto = ProdutoController.buscaProduto(id);

        if (produto != null) {

            DefaultTableModel tmProdutos = new DefaultTableModel();
            tmProdutos.addColumn("ID");
            tmProdutos.addColumn("Nome");
            tmProdutos.addColumn("Marca");
            tmProdutos.addColumn("Valor");
            tmProdutos.addColumn("Quantidade");

            tmProdutos.addRow(produto.toArray());

            tblProduto.setModel(tmProdutos);

        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblIDProduto;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTable tblProduto;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtIDProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
