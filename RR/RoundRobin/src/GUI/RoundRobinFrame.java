/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.RR.a;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author amr-bahaa
 */
public class RoundRobinFrame extends javax.swing.JFrame {

    static int num=0;
    static ArrayList<pair2>a;
    static double AVGW;
    static double AVGT;
    static double AVGR;
    int X,Y,k;
    JTextField [] js=new JTextField[100];
    JLabel [] jl=new JLabel[100];
    public RoundRobinFrame(ArrayList<pair2> A ,double AVGW,double AVGT,double AVGR) {
        
        initComponents();
        this.AVGW=AVGW;
        this.AVGT=AVGT;
        this.AVGR=AVGR;
        this.num=A.size();
        this.a=new ArrayList<pair2>(A);
        Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
        int x=dm.width/2-this.getWidth()/2;
        int y=dm.height/2-this.getHeight()/2;
        this.setLocation(x, y);        
        X=End.getX();
        Y=End.getY();
        k=0;
        insertText(A);
        jTextFieldWaiting.setText(AVGW+"");
        jTextFieldTurnAround.setText(AVGT+"");
        jTextFieldResponse.setText(AVGR+"");
        
        
    }
     public void insertText(ArrayList<pair2>A)
    {
        int diff;
        for(int i=0;i<this.num;++i)
        {
            diff=A.get(i).end-A.get(i).start;
            js[k]=new JTextField("p"+String.valueOf(A.get(i).p));
            js[k].setBounds(X,Y+50,30*diff,30);
            js[k].setBackground(Color.red);
            js[k].setVisible(true);
            js[k].setEditable(false);
            jPanel2.add(js[k]);
            repaint();
           
            //label 
            jl[k]=new JLabel(A.get(i).start+"");
            jl[k].setBounds(X,Y+70,50,30);
            jl[k].setVisible(true);
            jPanel2.add(jl[k]);
            X=X+(30*diff)+10;
            jl[k]=new JLabel(A.get(i).end+"");
            jl[k].setBounds(X-10-10,Y+70,50,30);
            jl[k].setVisible(true);
            jPanel2.add(jl[k]);
            k++;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Start = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        End = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldWaiting = new javax.swing.JTextField();
        jTextFieldTurnAround = new javax.swing.JTextField();
        jTextFieldResponse = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Gantt Chart Round Robin");

        jLabel2.setText("Average Waiting");

        jLabel3.setText("Average TurnAround");

        jLabel4.setText("Average Response");

        jTextFieldWaiting.setEditable(false);
        jTextFieldWaiting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWaitingActionPerformed(evt);
            }
        });

        jTextFieldTurnAround.setEditable(false);

        jTextFieldResponse.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(End))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldWaiting)
                            .addComponent(jTextFieldTurnAround)
                            .addComponent(jTextFieldResponse, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(End)
                .addGap(8, 8, 8)
                .addComponent(Start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldWaiting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTurnAround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldResponse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldWaitingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWaitingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldWaitingActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoundRobinFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoundRobinFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoundRobinFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoundRobinFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new RoundRobinFrame(a,AVGW,AVGT,AVGR).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel End;
    private javax.swing.JLabel Start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldResponse;
    private javax.swing.JTextField jTextFieldTurnAround;
    private javax.swing.JTextField jTextFieldWaiting;
    // End of variables declaration//GEN-END:variables
}
