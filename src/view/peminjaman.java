/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.bukuController;
import controller.detilPeminjamanController;
import controller.memberController;
import controller.peminjamanController;
import java.awt.HeadlessException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TableModelBuku;
import model.TblBuku;
import model.TblDetilTransaksi;
import model.TblDetilTransaksiPK;
import model.TblMember;
import model.TblTransaksi;

/**
 *
 * @author User
 */
public class peminjaman extends javax.swing.JFrame {

    private DefaultTableModel modelTemp;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("finalproject_team6PU");
    EntityManager em = emf.createEntityManager();
    peminjamanController peminjamanjpa = new peminjamanController(em);
    bukuController bukujpa = new bukuController(em);
    memberController memberjpa = new memberController(em);
    detilPeminjamanController detiljpa = new detilPeminjamanController(em);
    List<TblBuku> listBuku = new ArrayList<TblBuku>();
    List<TblMember> listMember = new ArrayList<TblMember>();
    List<TblTransaksi> listTransaksi = new ArrayList<TblTransaksi>();
    Format formatter = new SimpleDateFormat("dd-MMMM-yyyy");
    Date date = new Date();
    ButtonGroup grup = new ButtonGroup();
    private TableModelBuku tableModelBuku;
    String idMember;
    
    TblTransaksi transaksi_model = new TblTransaksi();
    TblBuku buku_model = new TblBuku();
    TblMember member_model = new TblMember();
    /**
     * Creates new form peminjaman
     */
    public peminjaman() {
        initComponents();
        txtNamaMember.setEditable(false);
        modelTemp = new DefaultTableModel();
        tblDetilTransaksi.setModel(modelTemp);
        txtTanggalTransaksi.setDate(date);
        txtTanggalPinjam.setDate(date);
        txtTanggalKembali.setDate(date);
        txtKdTransaksi.setEditable(false);
        
        modelTemp.addColumn("Kode Buku");
        modelTemp.addColumn("Judul Buku");
        modelTemp.addColumn("Jumlah Peminjaman");
        
        load();
        clear();
    }
    
    public void load(){
        tableModelBuku = new TableModelBuku();
        tableModelBuku.deleteall();
        tableModelBuku.fireTableDataChanged();
        tblDaftarBuku.setModel(tableModelBuku);
        listBuku = bukujpa.tampilSemua();
        for (TblBuku buku : listBuku){
            tableModelBuku.insert(buku);
        }
    }
    
    private void clear() {
        grup.clearSelection();
        txtKdTransaksi.setText("");
        txtKodeMember.setText("");
        txtNamaMember.setText("");
        idOtomatis();
        
        DefaultTableModel model = (DefaultTableModel)tblDetilTransaksi.getModel();
        if(model.getRowCount() > 0) {
                for(int i = model.getRowCount() - 1; i > -1; i--){
                model.removeRow(i);
            }
        }
    }

    private void updateStok(String idBuku , int jumlah){
        TblBuku buku = new TblBuku();
        listBuku = bukujpa.tampilID(idBuku);
        int stok_temp = listBuku.get(0).getBkStok() - jumlah;
        
        buku.setBkKd(idBuku);
        buku.setBkJudul(listBuku.get(0).getBkJudul());
        buku.setBkPengarang(listBuku.get(0).getBkPengarang());
        buku.setBkPenerbit(listBuku.get(0).getBkPenerbit());
        buku.setBkTahunTerbit(listBuku.get(0).getBkTahunTerbit());
        buku.setBkStok(listBuku.get(0).getBkStok() - jumlah);
        
        if(stok_temp == 0)
        {
            buku.setBkStatus("Kosong");
        }
        else
        {
            buku.setBkStatus(listBuku.get(0).getBkStatus());
        }
        
        try
        {
            bukujpa.editBuku(buku);
        }
        catch(Exception ex)
        {
            System.out.println("error saat mengurangi stok buku " +ex);
        }
    }
    
    public void setMbKd() {
        idMember = txtKodeMember.getText();
        listMember = memberjpa.tampilID(idMember);
        txtNamaMember.setText(listMember.get(0).getMbNama());
    }
    
    public void idOtomatis()
    {
        String maxID = null;
        int idTampung = 0;
        String id = null;
        try
        {
            maxID = peminjamanjpa.idMaxTransaksi();
        
            if (maxID != null)
            {
                //Substring digunakan untuk memecah string id_karyawan jadi KRY + 05
                //Substring(3, 2) maksudnya, mulai dari digit ke 3 (B = 0, K = 1, 0 = 2, 0 = 3) dan diambil 2 karakter (0 dan 5)
                //Kemudian di convert ke int, sehingga 5 + 1 = 6
                idTampung = Integer.parseInt(maxID.substring(3, 6))+1;
                //Jika idbrg nya kurang dari 10 maka "KRY0" + 6 = "KRY06"
                if (idTampung < 10)
                {
                    id = "TR000" + idTampung;
                }
                //Jika idbrg nya lebih dari sama dengan 10 dan kurang dari 100 (10 - 99) maka "KRY" + idbrg, idbrg = 10 jadi KRY10
                else if (idTampung >= 10 && idTampung < 100)
                {
                    id = "TR00" + idTampung;
                }
                else if(idTampung >= 100 && idTampung < 1000){
                    id = "TR0" + idTampung;
                }
            }
            //Jika maxid kosong berarti tidak ada data karyawan, maka id dimulai dari KRY01
            else
            {
                id = "TR0001";
            }  
        }
        catch(Exception e)
        {
             id = "TR0001";
        }
        txtKdTransaksi.setText(id);
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
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenuBuku = new javax.swing.JButton();
        btnMenuMember = new javax.swing.JButton();
        btnMenuPeminjaman = new javax.swing.JButton();
        btnMenuPengembalian = new javax.swing.JButton();
        btnMenuRiwayat = new javax.swing.JButton();
        btnMenuKeluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKdTransaksi = new javax.swing.JTextField();
        txtKodeMember = new javax.swing.JTextField();
        txtNamaMember = new javax.swing.JTextField();
        txtTanggalPinjam = new com.toedter.calendar.JDateChooser();
        txtTanggalKembali = new com.toedter.calendar.JDateChooser();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtTanggalTransaksi = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarBuku = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetilTransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-literature-84.png"))); // NOI18N
        jLabel13.setText("Perpustakaan Kami");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
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
        btnMenuRiwayat.setHideActionText(true);
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
                    .addComponent(btnMenuPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(btnMenuKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("Transaksi Peminjaman");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Transaksi"));

        jLabel2.setText("No. Transaksi : ");

        jLabel3.setText("Tanggal Transaksi : ");

        jLabel4.setText("Kode Member : ");

        jLabel5.setText("Nama Member : ");

        jLabel6.setText("Tanggal Pinjam : ");

        jLabel7.setText("Tanggal Kembali : ");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKodeMember, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaMember)
                            .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTanggalKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTanggalTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKdTransaksi))))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtTanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKodeMember)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNamaMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Buku"));

        tblDaftarBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDaftarBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaftarBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDaftarBuku);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Transaksi"));

        tblDetilTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetilTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDetilTransaksiKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetilTransaksi);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        List<TblMember> listMember = new ArrayList<TblMember>();
        String id_member = txtKodeMember.getText();
        listMember = memberjpa.tampilID(id_member);
        TblTransaksi transaksi = new TblTransaksi();
        
        transaksi.setTransKd(txtKdTransaksi.getText());
        transaksi.setTransTglTransaksi(txtTanggalTransaksi.getDate());
        transaksi.setMbKd(txtKodeMember.getText());
        transaksi.setTransTglPinjam(txtTanggalPinjam.getDate());
        transaksi.setTransTglKembali(txtTanggalKembali.getDate());
        transaksi.setStatusPengembalian("Belum");
        
        try
        {
            //menyimpan data di penjualan dan member
            peminjamanjpa.simpanPeminjaman(transaksi);
        } 
        catch(HeadlessException e) 
        {
            System.out.println("Error saat panggil method simpan di controller "+e);
            JOptionPane.showMessageDialog(null, "Data tidak berhasil disimpan!");
        }
        //menghitung jumlah baris di tabel penjualan
        int j = tblDetilTransaksi.getModel().getRowCount();
        
        for (int k = 0; k < j; k++) 
        {
            //mengambil id buku berdasarkan kolom pertama baris ke k
            String idBuku = "";
            int JumlahPinjam;
            
            //deklarasi objek detil jual dan detil jual pk
            TblDetilTransaksi detail_transaksi = new TblDetilTransaksi();
            TblDetilTransaksiPK detail_transaksi_PK = new TblDetilTransaksiPK();
            idBuku = modelTemp.getValueAt(k, 0).toString();
            JumlahPinjam = Integer.valueOf(modelTemp.getValueAt(k, 2).toString()); //mengambil data jumlah item dari kolom ke 4 baris ke k

            detail_transaksi_PK.setBkKd(idBuku); //set id buku
            detail_transaksi_PK.setTransKd(txtKdTransaksi.getText()); //set id transaksi
            
            //TblBuku judul = em.find(TblBuku.class, modelTemp.getValueAt(k, 0).toString());//mecari data buku dari idbuku
            detail_transaksi.setBkJudul(modelTemp.getValueAt(k, 1).toString());//set id buku
            detail_transaksi.setTransQty(JumlahPinjam);
            
            TblTransaksi p = em.find(TblTransaksi.class, txtKdTransaksi.getText()); //mencari data transaksi berdasarkan id transaksi
            detail_transaksi.setTblTransaksi(p); //set id transaksi
            detail_transaksi.setTblDetilTransaksiPK(detail_transaksi_PK); // set detik pk
            
            updateStok(idBuku, JumlahPinjam); // update stok buku
            
            try 
            {
                detiljpa.tambah(detail_transaksi); // menambah data transaksi
                
            } catch (Exception e) {
                System.out.println("Terjadi error saat panggil method simpan detail penjualan di controller: " + e);
            }
        }
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        clear();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblDaftarBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaftarBukuMouseClicked
        // TODO add your handling code here:
        int jumlahBuku;
        int i = tblDaftarBuku.getSelectedRow();
        if(i == -1)
        {
            return;
        }

        try
        {
            boolean cek = true;
            int row = tblDaftarBuku.getRowCount();
            int cekRow = tblDetilTransaksi.getRowCount();
            if(cekRow != 0)
            {
                for (int j = 0; j < cekRow; j++) 
                {
                    if (tblDetilTransaksi.getValueAt(j, 0).equals((String) tableModelBuku.getValueAt(i, 0))) {
                        cek = false;
                    }
                }
            }

            if(cek == true)
            {
                modelTemp.addRow(
                        new Object[]{(String) tableModelBuku.getValueAt(i, 0), 
                        String.valueOf(tableModelBuku.getValueAt(i, 1)),""});
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Buku Sudah Ada di List!");
            }
        }
        catch (Exception ex)
        {
            System.out.println("Gagal Menambahkan Buku ke Dalam List" +ex);
        }
    }//GEN-LAST:event_tblDaftarBukuMouseClicked

    private void tblDetilTransaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetilTransaksiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDetilTransaksiKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtKodeMember.getText().equals("") || txtKodeMember.getText().equals(null))
        {
            JOptionPane.showMessageDialog(this, "Kode member harus terisi!");
        }
        else
        {
            idMember = txtKodeMember.getText();
            listMember = memberjpa.tampilID(idMember);
            String get_nama = listMember.get(0).getMbNama();
            if(get_nama.equals(null) || get_nama.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Member Tidak Ditemukan!");
            }
            txtNamaMember.setText(listMember.get(0).getMbNama());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMenuBuku;
    private javax.swing.JButton btnMenuKeluar;
    private javax.swing.JButton btnMenuMember;
    private javax.swing.JButton btnMenuPeminjaman;
    private javax.swing.JButton btnMenuPengembalian;
    private javax.swing.JButton btnMenuRiwayat;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDaftarBuku;
    private javax.swing.JTable tblDetilTransaksi;
    private javax.swing.JTextField txtKdTransaksi;
    private javax.swing.JTextField txtKodeMember;
    private javax.swing.JTextField txtNamaMember;
    private com.toedter.calendar.JDateChooser txtTanggalKembali;
    private com.toedter.calendar.JDateChooser txtTanggalPinjam;
    private com.toedter.calendar.JDateChooser txtTanggalTransaksi;
    // End of variables declaration//GEN-END:variables
}
