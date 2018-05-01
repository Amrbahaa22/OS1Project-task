/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.awt.Container;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amr-bahaa
 */
public class Data extends javax.swing.JFrame {
    MyException exc;
    static int process;
    static int quantum;
    static ArrayList<pair> A=new ArrayList<>();
    static DefaultTableModel dm;
    
    public Data(int num,int q) {
        initComponents();
        this.AddRowsToTable(num,q);
        exc=new MyException();
    }

public void AddRowsToTable(int num,int q) {
         this.process=num;
         this.quantum=q;
        dm=new DefaultTableModel(0,0);
        String[] Header=new String[]{"Process","Arrival Time","CPU burst"};
        dm.setColumnIdentifiers(Header);
        Table.setModel(dm);
        for (int i=0;i<num;++i) {
                pair rowData = new pair();
                rowData.p=(i+1);
                rowData.AT=0;
                rowData.BT=0;
                dm.addRow(new Object[]{rowData.p,rowData.AT,rowData.BT});
         }
    
            
}

public boolean getrows()
{
   pair Data;
   String x;
   boolean state=true;
  for(int i=0;i<this.process && state==true;++i)
  {
      
      Data=new pair();
      x=new String();
      
      x=Table.getModel().getValueAt(i,0).toString();
      if(exc.ISnumeric(x) && exc.checkPositive(x))
      Data.p=Integer.parseInt(x);
      else
          state=false;
      
      x=Table.getModel().getValueAt(i,1).toString();
      if(exc.ISnumeric(x) && exc.checkPositive(x))
      Data.AT=Integer.parseInt(x);
      else
          state=false;
      
      x=Table.getModel().getValueAt(i,2).toString();
      if(exc.ISnumeric(x) && exc.checkPositive(x))
      Data.BT=Integer.parseInt(x);
      else
          state=false;
      A.add(Data);
  }
  if(state)
  {
    this.A.sort((pair a,pair b)->a.AT-b.AT);
    this.print();
    return true;
  }
    else
      return false;
}
public void print()
{
        for(int i=0;i<process;++i)
        {
            System.out.println("Process\t\t"+"AT\t\t"+"BT\t\t");
             System.out.print(A.get(i).p+"\t\t");     
            System.out.print(A.get(i).AT+"\t\t");
            System.out.println(A.get(i).BT+"\t\t");
        }
}

public void setColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(186, 177, 246));
}

public void resetColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        GO = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setAutoCreateRowSorter(true);
        Table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Table.setForeground(new java.awt.Color(109, 99, 174));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Process", "Arrival Time", "Cpu Burst"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        GO.setBackground(new java.awt.Color(255, 255, 255));
        GO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GOMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GOMousePressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Services_50px_1.png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(93, 85, 146));
        jLabel11.setText("GO");

        javax.swing.GroupLayout GOLayout = new javax.swing.GroupLayout(GO);
        GO.setLayout(GOLayout);
        GOLayout.setHorizontalGroup(
            GOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GOLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        GOLayout.setVerticalGroup(
            GOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GOLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(GOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addComponent(GO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(342, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(GO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GOMouseEntered
        setColor(GO);
    }//GEN-LAST:event_GOMouseEntered

    private void GOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GOMouseExited
        resetColor(GO);
    }//GEN-LAST:event_GOMouseExited

    private void GOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GOMousePressed
       
        if(this.getrows()){
        this.setVisible(false);
        RR rr=new RR(this.A,this.process,this.quantum);
        rr.print();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"check your data(Numeric posotive values only)");
        }
        
        
        
        
       
    }//GEN-LAST:event_GOMousePressed

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
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data(process,quantum).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GO;
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

