/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author User
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenuBuku = new javax.swing.JButton();
        btnMenuMember = new javax.swing.JButton();
        btnMenuPeminjaman = new javax.swing.JButton();
        btnMenuPengembalian = new javax.swing.JButton();
        btnMenuRiwayat = new javax.swing.JButton();
        btnMenuKeluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-literature-84.png"))); // NOI18N
        jLabel7.setText("Perpustakaan Kami");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-read-32.png"))); // NOI18N
        btnMenuBuku.setText("Buku");
        btnMenuBuku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuBukuActionPerformed(evt);
            }
        });

        btnMenuMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-bank-cards-32.png"))); // NOI18N
        btnMenuMember.setText("Member");
        btnMenuMember.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuMemberActionPerformed(evt);
            }
        });

        btnMenuPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-book-shelf-32.png"))); // NOI18N
        btnMenuPeminjaman.setText("Peminjaman");
        btnMenuPeminjaman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPeminjamanActionPerformed(evt);
            }
        });

        btnMenuPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-checklist-32.png"))); // NOI18N
        btnMenuPengembalian.setText("Pengembalian");
        btnMenuPengembalian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPengembalianActionPerformed(evt);
            }
        });

        btnMenuRiwayat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-report-card-32.png"))); // NOI18N
        btnMenuRiwayat.setText("Riwayat");
        btnMenuRiwayat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuRiwayatActionPerformed(evt);
            }
        });

        btnMenuKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-logout-32.png"))); // NOI18N
        btnMenuKeluar.setText("Keluar");
        btnMenuKeluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenuBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnMenuRiwayat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenuBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuMember, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user(2).png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setText("Hai, Admin!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuBukuActionPerformed
        // TODO add your handling code here:
        buku buku = new buku();
        this.setVisible(false);
        buku.setVisible(true);
    }//GEN-LAST:event_btnMenuBukuActionPerformed

    private void btnMenuMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuMemberActionPerformed
        // TODO add your handling code here:
        member member = new member();
        this.setVisible(false);
        member.setVisible(true);
    }//GEN-LAST:event_btnMenuMemberActionPerformed

    private void btnMenuPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPeminjamanActionPerformed
        // TODO add your handling code here:
        peminjaman pinjam = new peminjaman();
        this.setVisible(false);
        pinjam.setVisible(true);
    }//GEN-LAST:event_btnMenuPeminjamanActionPerformed

    private void btnMenuPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPengembalianActionPerformed
        // TODO add your handling code here:
        pengembalian kembali = new pengembalian();
        this.setVisible(false);
        kembali.setVisible(true);
    }//GEN-LAST:event_btnMenuPengembalianActionPerformed

    private void btnMenuRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuRiwayatActionPerformed
        // TODO add your handling code here:
        riwayat_peminjaman riwayat = new riwayat_peminjaman();
        this.setVisible(false);
        riwayat.setVisible(true);
    }//GEN-LAST:event_btnMenuRiwayatActionPerformed

    private void btnMenuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuKeluarActionPerformed
        // TODO add your handling code here:
        login login = new login();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_btnMenuKeluarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenuBuku;
    private javax.swing.JButton btnMenuKeluar;
    private javax.swing.JButton btnMenuMember;
    private javax.swing.JButton btnMenuPeminjaman;
    private javax.swing.JButton btnMenuPengembalian;
    private javax.swing.JButton btnMenuRiwayat;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
