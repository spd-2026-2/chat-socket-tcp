package com.mycompany.clientechat;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class TelaCliente extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCliente.class.getName());
    private final ClienteChat cliente = new ClienteChat();
    private boolean conectado = false;
    private String nickname;

    // Itens da lista "Online"
    private final DefaultListModel<String> modeloUsuarios = new DefaultListModel<>();

    public TelaCliente() {
        initComponents();
        setLocationRelativeTo(null);
        atualizarBotoes();
    }

    private void atualizarBotoes() {
        btnConectar.setEnabled(!conectado);
        btnDesconectar.setEnabled(conectado);
        btnEnviar.setEnabled(conectado);
        tfMensagem.setEnabled(conectado);
        cbDestino.setEnabled(conectado);
        tfIP.setEnabled(!conectado);
        tfPorta.setEnabled(!conectado);
        tfNickname.setEnabled(!conectado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfIP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPorta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNickname = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMensagens = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbDestino = new javax.swing.JComboBox<>();
        tfMensagem = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat TCP");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Servidor"));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("IP:");

        tfIP.setText("127.0.0.1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Porta:");

        tfPorta.setText("6000");

        jLabel6.setText("Nickname:");

        btnConectar.setBackground(new java.awt.Color(204, 255, 204));
        btnConectar.setForeground(new java.awt.Color(0, 102, 51));
        btnConectar.setText("⏻");
        btnConectar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 0)));
        btnConectar.addActionListener(this::btnConectarActionPerformed);

        btnDesconectar.setBackground(new java.awt.Color(255, 204, 204));
        btnDesconectar.setForeground(new java.awt.Color(204, 0, 51));
        btnDesconectar.setText("⏻");
        btnDesconectar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 0)));
        btnDesconectar.addActionListener(this::btnDesconectarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConectar)
                    .addComponent(btnDesconectar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        taMensagens.setEditable(false);
        taMensagens.setColumns(20);
        taMensagens.setLineWrap(true);
        taMensagens.setRows(5);
        taMensagens.setWrapStyleWord(true);
        taMensagens.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensagens"));
        jScrollPane1.setViewportView(taMensagens);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Enviar Mensagem"));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setText("Para:");

        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        tfMensagem.addActionListener(this::tfMensagemActionPerformed);

        btnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 51, 204));
        btnEnviar.setText(">>");
        btnEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        btnEnviar.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnEnviar.addActionListener(this::btnEnviarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        try {
            nickname = tfNickname.getText().trim();
            if (nickname.isEmpty()) {
                taMensagens.append("Informe um nickname.\n");
                return;
            }

            cliente.conectar(tfIP.getText(), Integer.parseInt(tfPorta.getText()));
            cliente.enviar(new Requisicao("entrar", nickname, "", ""));

            conectado = true;
            atualizarBotoes();

            // Thread que fica escutando o servidor enquanto estiver conectado
            new Thread(this::escutarServidor).start();

        } catch (Exception e) {
            taMensagens.append("Erro: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        try {
            cliente.desconectar();   // a thread de escuta percebe e atualiza a tela
        } catch (Exception e) {
            taMensagens.append("Erro: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            String texto = tfMensagem.getText().trim();
            if (texto.isEmpty()) {
                return;
            }
        
            String destino = (String) cbDestino.getSelectedItem();
            String tipo = "privada";

            if (destino.equals("Todos")) {
                tipo = "todos";
                destino = "";
            }

            cliente.enviar(new Requisicao(tipo, nickname, destino, texto));

            tfMensagem.setText("");
            tfMensagem.requestFocus();

        } catch (Exception e) {
            taMensagens.append("Erro: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void tfMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMensagemActionPerformed
        btnEnviarActionPerformed(evt);   // Enter também envia
    }//GEN-LAST:event_tfMensagemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            cliente.desconectar();
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_formWindowClosing

    // Roda em uma thread separada: recebe tudo o que o servidor envia
    private void escutarServidor() {
        try {
            Resposta resposta = cliente.receber();

            while (resposta != null) {
                final Resposta r = resposta;

                // Solicita que a thread padrão do Swing (EDT) execute a atualização da interface gráfica.
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mostrar(r);
                    }
                });

                resposta = cliente.receber();
            }

        } catch (Exception e) {
            System.out.println("Conexão encerrada.");
        }
        
        // Solicita que a thread padrão do Swing (EDT) execute a atualização da interface gráfica.
        SwingUtilities.invokeLater(new Runnable() { 
            @Override
            public void run() {
                conectado = false;
                atualizarBotoes();
                modeloUsuarios.clear();
                taMensagens.append("Desconectado do servidor.\n");
            }
        });
    }   
    
    private void mostrar(Resposta r) {
        switch (r.getTipo()) {
            case "OK": //executa o mesmo que sistema
            case "SISTEMA":
                taMensagens.append("*** " + r.getTexto() + " ***\n");
                break;

            case "PUBLICA":
                taMensagens.append("[" + r.getHora() + "] "
                        + r.getRemetente() + ": " + r.getTexto() + "\n");
                break;

            case "PRIVADA":
                taMensagens.append("[" + r.getHora() + "] (privada) "
                        + r.getRemetente() + ": " + r.getTexto() + "\n");
                break;

            case "ERRO":
                taMensagens.append("Erro: " + r.getTexto() + "\n");
                break;

            case "USUARIOS":
                atualizarUsuarios(r.getTexto());
                break;
        }
    }    
    

    private void atualizarUsuarios(String nomes) {
        cbDestino.removeAllItems();
        cbDestino.addItem("Todos");

        for (String nome : nomes.split(",")) {
            if (!nome.isEmpty() && !nome.equals(nickname)) {
                cbDestino.addItem(nome);
            }
        }
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.out.println("Não foi possível alterar a aparência.");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taMensagens;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfMensagem;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JTextField tfPorta;
    // End of variables declaration//GEN-END:variables
}
