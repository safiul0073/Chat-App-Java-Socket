/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.computernetworking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JLabel;

/**
 *
 * @author Anis
 */
public class Server extends javax.swing.JFrame {

   static ServerSocket serverSocket;
   static DataOutputStream out;
   static DataInputStream in;
   static Socket socket;
   static String message;

    public Server() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendText = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageShow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Server Side ");

        messageShow.setColumns(20);
        messageShow.setRows(5);
        jScrollPane1.setViewportView(messageShow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(sendText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendText)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {
            String value = sendText.getText();
            out.writeUTF(value);
            messageShow.setText(messageShow.getText()+"\n\t\t\t"+value);
            sendText.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_sendButtonActionPerformed


    public static void main(String args[]) throws IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
        serverSocket = new ServerSocket(6001);
        while (true) {
        socket = serverSocket.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
       
        message = in.readUTF();
        messageShow.setText(messageShow.getText()+"\n"+message);
        
       
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea messageShow;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField sendText;
    // End of variables declaration//GEN-END:variables
}
