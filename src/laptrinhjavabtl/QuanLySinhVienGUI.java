/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laptrinhjavabtl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class QuanLySinhVienGUI extends javax.swing.JFrame {

    DefaultTableModel tableModelSinhVien;
    DefaultTableModel tableModelMonHoc;
    DefaultTableModel tableModelHocTap;
    SinhVien sv;
    ArrayList<MonHoc> listmh;
    MonHoc mh;
    ArrayList<HocTap> listht;
    HocTap ht;
    int kiemTra = -1;
    /**
     * Creates new form QuanLySinhVienGUI
     */
    private static QuanLySinhVienGUI instance;
    ArrayList<SinhVien> list;

    public QuanLySinhVienGUI() {
        initComponents();
        tabNavigate.setVisible(false);
        instance = this;
        QuanLySinhVien();
        QuanLyMonHoc();
        QuanLyHocTap();
    }

    public static QuanLySinhVienGUI getInstance() {
        return instance;
    }

    public void docSinhVienTuSQL() {
        list.clear();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM SinhVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSinhVien(rs.getString("MaSinhVien"));
                sv.setTenSinhVien(rs.getString("TenSinhVien"));
                sv.setQueQuan(rs.getString("QueQuan"));
                sv.setNgaySinh(rs.getString("NgaySinh"));
                sv.setGioiTinh(rs.getString("GioiTinh"));
                list.add(sv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void docMonHocTuSQL() {
        listmh.clear();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM MonHoc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMonHoc(rs.getString("MaMonHoc"));
                mh.setTenMonHoc(rs.getString("TenMonHoc"));
                mh.setSoTin(rs.getInt("SoTin"));
                listmh.add(mh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void docHocTapTuSQL() {
        listht.clear();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM HocTap";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocTap ht = new HocTap();
                ht.setMaSV(rs.getString("MaSV"));
                ht.setMaMH(rs.getString("MaMH"));
                ht.setTinChi(rs.getInt("TinChi"));
                ht.setDiemThi(rs.getDouble("DiemThi"));
                listht.add(ht);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void QuanLySinhVien() {
        list = new ArrayList();
        String[] columnsName = {"Mã sinh viên", "Tên sinh viên", "Quê quán", "Ngày sinh", "Giới tính"};
        tableModelSinhVien = new DefaultTableModel(columnsName, 0);
        docSinhVienTuSQL();
        hienThiLenBang();
    }

    public void hienThiLenBang() {
        docSinhVienTuSQL();
        tableModelSinhVien.setRowCount(0);
        for (SinhVien sv : list) {
            Object[] row = {sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getQueQuan(), sv.getNgaySinh(), sv.getGioiTinh()};
            tableModelSinhVien.addRow(row);
        }
        svtbDanhSach.setModel(tableModelSinhVien);
    }

    public void QuanLyMonHoc() {
        listmh = new ArrayList();
        String[] columnsName = {"Mã môn học", "Tên môn học", "Số Tín"};
        tableModelMonHoc = new DefaultTableModel(columnsName, 0);
        docMonHocTuSQL();
        hienThiLenBangMH();
    }

    public void hienThiLenBangMH() {
        docMonHocTuSQL();
        tableModelMonHoc.setRowCount(0);
        for (MonHoc mh : listmh) {
            Object[] row = {mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getSoTin()};
            tableModelMonHoc.addRow(row);
        }
        mhtbMonHoc.setModel(tableModelMonHoc);
    }

    public void QuanLyHocTap() {
        listht = new ArrayList();
        String[] columnsName = {"Mã môn học", "Số tín", "Điểm"};
        tableModelHocTap = new DefaultTableModel(columnsName, 0);
        hienThiLenBangHT();
    }

    public void hienThiLenBangHT() {
        String maSV = httxtMaSinhVien.getText().trim();
        docHocTapTuSQL();
        tableModelHocTap.setRowCount(0);
        for (HocTap ht : listht) {
            if (ht.getMaSV().equalsIgnoreCase(maSV)) {
                Object[] row = {ht.getMaMH(), ht.getTinChi(), ht.getDiemThi()};
                tableModelHocTap.addRow(row);
            }
        }

        htTbDiemThi.setModel(tableModelHocTap);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        htbtTimKiem1 = new javax.swing.JButton();
        htbtTimKiem3 = new javax.swing.JButton();
        tabNavigate = new javax.swing.JTabbedPane();
        tabQuanLySinhVien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        svtxtMaSinhVien = new javax.swing.JTextField();
        svtxtTenSinhVien = new javax.swing.JTextField();
        svtxtNgaySinh = new javax.swing.JTextField();
        svrbtNam = new javax.swing.JRadioButton();
        svrbtNu = new javax.swing.JRadioButton();
        svcbQueQuan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        svtbDanhSach = new javax.swing.JTable();
        svbtTimKiem = new javax.swing.JButton();
        svbtSua = new javax.swing.JButton();
        svbtXoa = new javax.swing.JButton();
        svbtThem = new javax.swing.JButton();
        tabQuanLyDiem = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        httxtMaSinhVien = new javax.swing.JTextField();
        htbtThem = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        htTbDiemThi = new javax.swing.JTable();
        httxtMaMon = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        httxtDiem = new javax.swing.JTextField();
        htbtTinhTB = new javax.swing.JButton();
        htbtTimKiem = new javax.swing.JButton();
        htbtPrint = new javax.swing.JButton();
        tabQuanLyMonHoc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mhcbSoTin = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mhtxtMaMonHoc = new javax.swing.JTextField();
        mhtxtTenMonHoc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        mhtbMonHoc = new javax.swing.JTable();
        mhbtTimKiem = new javax.swing.JButton();
        mhbtSua = new javax.swing.JButton();
        mhbtXoa = new javax.swing.JButton();
        mhbtThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemDangNhap = new javax.swing.JMenuItem();

        jLabel5.setText("Mã sinh viên");

        jLabel13.setText("jLabel13");

        htbtTimKiem1.setText("Tìm kiếm");
        htbtTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtTimKiem1ActionPerformed(evt);
            }
        });

        htbtTimKiem3.setText("Tìm kiếm");
        htbtTimKiem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtTimKiem3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabNavigate.setBackground(new java.awt.Color(153, 255, 255));
        tabNavigate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabNavigate.setOpaque(true);
        tabNavigate.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabNavigateComponentAdded(evt);
            }
        });

        tabQuanLySinhVien.setBackground(new java.awt.Color(204, 255, 204));
        tabQuanLySinhVien.setBorder(new javax.swing.border.MatteBorder(null));
        tabQuanLySinhVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/education.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");
        tabQuanLySinhVien.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel4.setText("Mã sinh viên");
        tabQuanLySinhVien.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 79, -1, -1));

        jLabel6.setText("Tên sinh viên");
        tabQuanLySinhVien.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 119, -1, -1));

        jLabel7.setText("Quê quán");
        tabQuanLySinhVien.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 159, -1, -1));

        jLabel8.setText("Ngày sinh");
        tabQuanLySinhVien.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 79, -1, -1));

        jLabel9.setText("Giới tính");
        tabQuanLySinhVien.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 119, -1, -1));
        tabQuanLySinhVien.add(svtxtMaSinhVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 76, 176, -1));
        tabQuanLySinhVien.add(svtxtTenSinhVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 116, 176, -1));

        svtxtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svtxtNgaySinhActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svtxtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 76, 176, -1));

        buttonGroup1.add(svrbtNam);
        svrbtNam.setText("Nam");
        svrbtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svrbtNamActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svrbtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 117, -1, -1));

        buttonGroup1.add(svrbtNu);
        svrbtNu.setText("Nữ");
        svrbtNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svrbtNuActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svrbtNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 117, -1, -1));

        svcbQueQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa-Vũng Tàu", "Bạc Liêu", "Bắc Kạn", "Bắc Giang", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ (TP)", "Đà Nẵng (TP)", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội (TP)", "Hà Tây", "Hà Tĩnh", "Hải Dương", "Hải Phòng (TP)", "Hòa Bình", "Hồ Chí Minh (TP)", "Hậu Giang", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lào Cai", "Lạng Sơn", "Lâm Đồng", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên – Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" }));
        svcbQueQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svcbQueQuanActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svcbQueQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 156, -1, -1));

        svtbDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Họ và tên", "Quê quán", "Ngày sinh", "Giới tính"
            }
        ));
        svtbDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svtbDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(svtbDanhSach);

        tabQuanLySinhVien.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 760, 247));

        svbtTimKiem.setBackground(new java.awt.Color(255, 255, 204));
        svbtTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        svbtTimKiem.setText("Tìm kiếm");
        svbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtTimKiemActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svbtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        svbtSua.setBackground(new java.awt.Color(255, 255, 204));
        svbtSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/repair.png"))); // NOI18N
        svbtSua.setText("Sửa");
        svbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtSuaActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svbtSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        svbtXoa.setBackground(new java.awt.Color(255, 255, 204));
        svbtXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        svbtXoa.setText("Xoá");
        svbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtXoaActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svbtXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, -1));

        svbtThem.setBackground(new java.awt.Color(255, 255, 204));
        svbtThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        svbtThem.setText("Thêm");
        svbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtThemActionPerformed(evt);
            }
        });
        tabQuanLySinhVien.add(svbtThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        tabNavigate.addTab("Quản lý sinh viên", tabQuanLySinhVien);

        tabQuanLyDiem.setBackground(new java.awt.Color(204, 255, 204));
        tabQuanLyDiem.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grade.png"))); // NOI18N
        jLabel3.setText("QUẢN LÝ ĐIỂM");

        jLabel14.setText("Mã sinh viên");

        httxtMaSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                httxtMaSinhVienActionPerformed(evt);
            }
        });

        htbtThem.setBackground(new java.awt.Color(255, 255, 204));
        htbtThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        htbtThem.setText("Thêm");
        htbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtThemActionPerformed(evt);
            }
        });

        jLabel16.setText("Mã môn học");

        htTbDiemThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Môn học", "Số tín", "Điểm"
            }
        ));
        jScrollPane3.setViewportView(htTbDiemThi);
        if (htTbDiemThi.getColumnModel().getColumnCount() > 0) {
            htTbDiemThi.getColumnModel().getColumn(1).setResizable(false);
            htTbDiemThi.getColumnModel().getColumn(1).setPreferredWidth(1);
            htTbDiemThi.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        httxtMaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                httxtMaMonActionPerformed(evt);
            }
        });

        jLabel18.setText("Điểm");

        htbtTinhTB.setBackground(new java.awt.Color(255, 255, 204));
        htbtTinhTB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calculation.png"))); // NOI18N
        htbtTinhTB.setText("Tính điểm TB");
        htbtTinhTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtTinhTBActionPerformed(evt);
            }
        });

        htbtTimKiem.setBackground(new java.awt.Color(255, 255, 204));
        htbtTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        htbtTimKiem.setText("Tìm kiếm");
        htbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtTimKiemActionPerformed(evt);
            }
        });

        htbtPrint.setBackground(new java.awt.Color(255, 255, 204));
        htbtPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        htbtPrint.setText("In bằng khen");
        htbtPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabQuanLyDiemLayout = new javax.swing.GroupLayout(tabQuanLyDiem);
        tabQuanLyDiem.setLayout(tabQuanLyDiemLayout);
        tabQuanLyDiemLayout.setHorizontalGroup(
            tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel16))
                    .addComponent(htbtThem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabQuanLyDiemLayout.createSequentialGroup()
                        .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(httxtMaMon)
                            .addComponent(httxtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(httxtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(htbtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(htbtTinhTB)
                        .addGap(49, 49, 49)))
                .addComponent(htbtPrint)
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(345, 345, 345))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        tabQuanLyDiemLayout.setVerticalGroup(
            tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanLyDiemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(httxtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(httxtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(httxtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(htbtThem)
                    .addComponent(htbtTinhTB)
                    .addComponent(htbtTimKiem)
                    .addComponent(htbtPrint))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabNavigate.addTab("Quản lý điểm", tabQuanLyDiem);

        tabQuanLyMonHoc.setBackground(new java.awt.Color(204, 255, 204));
        tabQuanLyMonHoc.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/subject.png"))); // NOI18N
        jLabel2.setText("QUẢN LÝ MÔN HỌC");

        jLabel10.setText("Mã môn học");

        mhcbSoTin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        mhcbSoTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhcbSoTinActionPerformed(evt);
            }
        });

        jLabel11.setText("Tên môn học");

        jLabel12.setText("Số tín");

        mhtbMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã môn học", "Tên môn học", "Số tín"
            }
        ));
        mhtbMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mhtbMonHocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mhtbMonHoc);

        mhbtTimKiem.setBackground(new java.awt.Color(255, 255, 204));
        mhbtTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        mhbtTimKiem.setText("Tìm kiếm");
        mhbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtTimKiemActionPerformed(evt);
            }
        });

        mhbtSua.setBackground(new java.awt.Color(255, 255, 204));
        mhbtSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/repair.png"))); // NOI18N
        mhbtSua.setText("Sửa");
        mhbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtSuaActionPerformed(evt);
            }
        });

        mhbtXoa.setBackground(new java.awt.Color(255, 255, 204));
        mhbtXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        mhbtXoa.setText("Xoá");
        mhbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtXoaActionPerformed(evt);
            }
        });

        mhbtThem.setBackground(new java.awt.Color(255, 255, 204));
        mhbtThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        mhbtThem.setText("Thêm");
        mhbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabQuanLyMonHocLayout = new javax.swing.GroupLayout(tabQuanLyMonHoc);
        tabQuanLyMonHoc.setLayout(tabQuanLyMonHocLayout);
        tabQuanLyMonHocLayout.setHorizontalGroup(
            tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyMonHocLayout.createSequentialGroup()
                .addGap(0, 631, Short.MAX_VALUE)
                .addComponent(mhbtXoa)
                .addGap(82, 82, 82))
            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mhtxtMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mhtxtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mhcbSoTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                                .addComponent(mhbtThem)
                                .addGap(87, 87, 87)
                                .addComponent(mhbtTimKiem)
                                .addGap(85, 85, 85)
                                .addComponent(mhbtSua))))
                    .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel2))
                    .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabQuanLyMonHocLayout.setVerticalGroup(
            tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(mhtxtMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mhtxtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(mhcbSoTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mhbtThem)
                    .addComponent(mhbtXoa)
                    .addComponent(mhbtSua)
                    .addComponent(mhbtTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        tabNavigate.addTab("Quản lý môn học", tabQuanLyMonHoc);

        getContentPane().add(tabNavigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,120));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 153));
        jLabel17.setText("HỆ THỐNG QUẢN LÝ SINH VIÊN ");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 153));
        jLabel19.setText("TRƯỜNG ĐẠI HỌC CÔNG NGHIỆP HÀ NỘI");

        jLabel20.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("Mời thầy / cô đăng nhập để sử dụng hệ thống");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel21)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 420, 330));

        jLabel15.setIcon(new javax.swing.ImageIcon("G:\\lap trinh java\\Java_BTL-main\\src\\images\\mainBackground.jpg")); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        jMenu1.setText("Chức năng");

        menuItemDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        menuItemDangNhap.setText("Đăng nhập");
        menuItemDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDangNhapActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemDangNhap);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void kiemTraDangNhap(boolean daDangNhap) {
        if (daDangNhap) {
            menuItemDangNhap.setText("Đăng xuất");
            menuItemDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
            tabNavigate.setVisible(true);
        } else {
            menuItemDangNhap.setText("Đăng nhập");
            menuItemDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png")));
            tabNavigate.setVisible(false);
        }
    }
    private void menuItemDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDangNhapActionPerformed
        if (menuItemDangNhap.getText().equals("Đăng nhập")) {
            DangNhapForm sv = new DangNhapForm();
            sv.setVisible(true);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                kiemTraDangNhap(false);
            }
        }
    }//GEN-LAST:event_menuItemDangNhapActionPerformed

    private void tabNavigateComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabNavigateComponentAdded

    }//GEN-LAST:event_tabNavigateComponentAdded

    private void svrbtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svrbtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svrbtNamActionPerformed

    private void svrbtNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svrbtNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svrbtNuActionPerformed

    private void mhcbSoTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhcbSoTinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mhcbSoTinActionPerformed

    private void httxtMaSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_httxtMaSinhVienActionPerformed

    }//GEN-LAST:event_httxtMaSinhVienActionPerformed

    private int searchMaSinhVien(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (ma.equalsIgnoreCase(list.get(i).getMaSinhVien())) {
                return i;
            }
        }
        return -1;
    }

    private void svbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtThemActionPerformed
        kiemTra = -1;
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        sv = new SinhVien();
        sv.setMaSinhVien(svtxtMaSinhVien.getText());
        sv.setTenSinhVien(svtxtTenSinhVien.getText());
        sv.setNgaySinh(svtxtNgaySinh.getText());
        sv.setQueQuan((String) svcbQueQuan.getSelectedItem());
        if (svrbtNam.isSelected()) {
            sv.setGioiTinh("Nam");
        }
        if (svrbtNu.isSelected()) {
            sv.setGioiTinh("Nữ");
        }
        if (svtxtMaSinhVien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
            return;
        }
        if (kiemTra > -1) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");
        } else {
            list.add(sv);
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "INSERT INTO SinhVien (MaSinhVien, TenSinhVien, QueQuan, NgaySinh, GioiTinh) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sv.getMaSinhVien());
                ps.setString(2, sv.getTenSinhVien());
                ps.setString(3, sv.getQueQuan());
                ps.setString(4, sv.getNgaySinh());
                ps.setString(5, sv.getGioiTinh());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi lưu sinh viên vào SQL: " + ex.getMessage());
            }
        }
        hienThiLenBang();
    }//GEN-LAST:event_svbtThemActionPerformed

    private void svcbQueQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svcbQueQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svcbQueQuanActionPerformed

    private void svbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtTimKiemActionPerformed
        kiemTra = -1;
        if (svtxtMaSinhVien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để tìm kiếm ");
            return;
        }
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        sv = list.get(kiemTra);
        if (kiemTra > -1) {
            JOptionPane.showMessageDialog(null, "Mã Sinh viên: " + sv.getMaSinhVien() + "\nHọ và tên: " + sv.getTenSinhVien() + "\nGiới tính: " + sv.getGioiTinh() + "\nNgày sinh: " + sv.getNgaySinh() + "\nQuê quán: " + sv.getQueQuan());
        }
    }//GEN-LAST:event_svbtTimKiemActionPerformed

    private void svbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtSuaActionPerformed
        kiemTra = -1;
        if (svtxtMaSinhVien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để sửa ");
            return;
        }
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        if (kiemTra > -1) {
            sv = list.get(kiemTra);
            sv.setMaSinhVien(svtxtMaSinhVien.getText());
            sv.setTenSinhVien(svtxtTenSinhVien.getText());
            sv.setNgaySinh(svtxtNgaySinh.getText());
            sv.setQueQuan((String) svcbQueQuan.getSelectedItem());
            if (svrbtNam.isSelected()) {
                sv.setGioiTinh("Nam");
            }
            if (svrbtNu.isSelected()) {
                sv.setGioiTinh("Nữ");
            }
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "UPDATE SinhVien SET tenSinhVien = ?, ngaySinh = ?, queQuan = ?, gioiTinh = ? WHERE maSinhVien = ?";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, sv.getTenSinhVien());
                ps.setString(2, sv.getNgaySinh());
                ps.setString(3, sv.getQueQuan());
                ps.setString(4, sv.getGioiTinh());
                ps.setString(5, sv.getMaSinhVien());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin sinh viên vào SQL: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
        }
        hienThiLenBang();
    }//GEN-LAST:event_svbtSuaActionPerformed

    private void svbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtXoaActionPerformed
        kiemTra = -1;
        if (svtxtMaSinhVien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để xoá ");
            return;
        }
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        if (kiemTra > -1) {
            sv = list.get(kiemTra);
            String maSV = sv.getMaSinhVien();

            try (Connection conn = DBConnection.getConnection()) {
                String sqlDeleteHocTap = "DELETE FROM HocTap WHERE MaSV = ?";
                PreparedStatement ps1 = conn.prepareStatement(sqlDeleteHocTap);
                ps1.setString(1, maSV);
                ps1.executeUpdate();

                String sqlDeleteSinhVien = "DELETE FROM SinhVien WHERE MaSinhVien = ?";
                PreparedStatement ps2 = conn.prepareStatement(sqlDeleteSinhVien);
                ps2.setString(1, maSV);
                ps2.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi xóa sinh viên trên SQL: " + ex.getMessage());
            }
            list.remove(sv);
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
        }
        hienThiLenBang();
    }//GEN-LAST:event_svbtXoaActionPerformed

    private void svtbDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svtbDanhSachMouseClicked
        int selectedRow = svtbDanhSach.getSelectedRow();
        if (selectedRow >= 0) {
            svtxtMaSinhVien.setText(svtbDanhSach.getValueAt(selectedRow, 0).toString());
            svtxtTenSinhVien.setText(svtbDanhSach.getValueAt(selectedRow, 1).toString());
            svtxtNgaySinh.setText(svtbDanhSach.getValueAt(selectedRow, 3).toString());
        }
    }//GEN-LAST:event_svtbDanhSachMouseClicked

    public int searchMaMonHoc(String ma) {
        for (int i = 0; i < listmh.size(); i++) {
            if (listmh.get(i).getMaMonHoc().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }


    private void mhbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtThemActionPerformed
        kiemTra = -1;
        kiemTra = searchMaMonHoc(mhtxtMaMonHoc.getText());
        mh = new MonHoc();
        mh.setMaMonHoc(mhtxtMaMonHoc.getText());
        mh.setTenMonHoc(mhtxtTenMonHoc.getText());
        mh.setSoTin(mhcbSoTin.getSelectedIndex() + 1);
        if (mhtxtMaMonHoc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn học");
            return;
        }
        if (kiemTra > -1) {
            JOptionPane.showMessageDialog(null, "Mã môn học đã tồn tại");
        } else {
            listmh.add(mh);
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "INSERT INTO MonHoc (MaMonHoc, TenMonHoc, SoTin) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, mh.getMaMonHoc());
                ps.setString(2, mh.getTenMonHoc());
                ps.setInt(3, mh.getSoTin());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi lưu môn học vào SQL: " + ex.getMessage());
            }
        }
        hienThiLenBangMH();
    }//GEN-LAST:event_mhbtThemActionPerformed

    private void mhbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtTimKiemActionPerformed
        if (mhtxtMaMonHoc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập mã môn học để tìm kiếm ");
            return;
        }
        kiemTra = searchMaMonHoc(mhtxtMaMonHoc.getText());
        if (kiemTra > -1) {
            mh = listmh.get(kiemTra);
            JOptionPane.showMessageDialog(null, "Mã môn học: " + mh.getMaMonHoc() + "\nTên môn học: " + mh.getTenMonHoc() + "\nSố tín: " + mh.getSoTin());
        } else {
            JOptionPane.showMessageDialog(null, "Mã môn học chưa tồn tại");
        }
    }//GEN-LAST:event_mhbtTimKiemActionPerformed

    private void mhbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtSuaActionPerformed
        String maMonHoc = mhtxtMaMonHoc.getText().trim();

        if (maMonHoc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn học để sửa.");
            return;
        }

        int viTri = searchMaMonHoc(maMonHoc);

        if (viTri < 0) {
            JOptionPane.showMessageDialog(null, "Mã môn học không tồn tại.");
            return;
        }

        mh = listmh.get(viTri);
        mh.setMaMonHoc(maMonHoc);
        mh.setTenMonHoc(mhtxtTenMonHoc.getText().trim());
        int soTin = mhcbSoTin.getSelectedIndex() + 1;
        mh.setSoTin(soTin);
        for (HocTap ht : listht) {
            if (ht.getMaMH().equals(maMonHoc)) {
                ht.setTinChi(soTin);
            }
        }
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE MonHoc SET tenMonHoc = ?, soTin = ? WHERE maMonHoc = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mh.getTenMonHoc());
            ps.setInt(2, mh.getSoTin());
            ps.setString(3, mh.getMaMonHoc());
            ps.executeUpdate();

            String sql2 = "UPDATE HocTap SET tinChi = ? WHERE maMH = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, mh.getSoTin());
            ps2.setString(2, mh.getMaMonHoc());
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa môn học thành công!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa môn học trong SQL: " + ex.getMessage());
        }

        hienThiLenBangMH();
    }//GEN-LAST:event_mhbtSuaActionPerformed

    private void mhbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtXoaActionPerformed
        kiemTra = -1;
        if (mhtxtMaMonHoc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập mã môn học để xoá ");
            return;
        }
        kiemTra = searchMaMonHoc(mhtxtMaMonHoc.getText());
        if (kiemTra > -1) {
            mh = listmh.get(kiemTra);
            String maMH = mh.getMaMonHoc();

            listmh.remove(mh);
            try (Connection conn = DBConnection.getConnection()) {
                String sqlDeleteHocTap = "DELETE FROM HocTap WHERE MaMH = ?";
                PreparedStatement ps1 = conn.prepareStatement(sqlDeleteHocTap);
                ps1.setString(1, maMH);
                ps1.executeUpdate();
                String sqlDeleteMonHoc = "DELETE FROM MonHoc WHERE MaMonHoc = ?";
                PreparedStatement ps2 = conn.prepareStatement(sqlDeleteMonHoc);
                ps2.setString(1, maMH);
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xoá thành công");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi xóa môn học trên SQL: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mã môn học không tồn tại");
            return;
        }
        hienThiLenBangMH();
    }//GEN-LAST:event_mhbtXoaActionPerformed

    private void mhtbMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mhtbMonHocMouseClicked
        int selectedRow = mhtbMonHoc.getSelectedRow();
        if (selectedRow >= 0) {
            mhtxtMaMonHoc.setText(mhtbMonHoc.getValueAt(selectedRow, 0).toString());
            mhtxtTenMonHoc.setText(mhtbMonHoc.getValueAt(selectedRow, 1).toString());
            int soTinChi = Integer.parseInt(mhtbMonHoc.getValueAt(selectedRow, 2).toString());
            mhcbSoTin.setSelectedIndex(soTinChi - 1);
        }
    }//GEN-LAST:event_mhtbMonHocMouseClicked

    private void htbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtThemActionPerformed
        double diemThi;
        String maSV = httxtMaSinhVien.getText().trim();
        String maMH = httxtMaMon.getText().trim();
        try {
            diemThi = Double.parseDouble(httxtDiem.getText());
            if (diemThi > 10 || diemThi < 0) {
                JOptionPane.showMessageDialog(null, "Điểm phải <= 10 và >=0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Điểm không hợp lệ. Vui lòng nhập số hợp lệ.");
            return;
        }

        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
            return;
        }
        if (maMH.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn học");
            return;
        }

        int kiemTraSV = searchMaSinhVien(maSV);
        int kiemTraMH = searchMaMonHoc(maMH);

        if (kiemTraSV == -1 || kiemTraMH == -1) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên hoặc mã môn học không tồn tại");
            return;
        }

        mh = listmh.get(kiemTraMH);
        int soTin = mh.getSoTin();
        for (HocTap ht : listht) {
            if (ht.getMaSV().equals(maSV) && ht.getMaMH().equals(maMH)) {
                JOptionPane.showMessageDialog(null, "Sinh viên này đã có điểm môn học này");
                return;
            }
        }
        int result = JOptionPane.showConfirmDialog(
                null,
                "Sau khi thêm sẽ không sửa được điểm, bạn có chắc chắn muốn thêm dữ liệu này ?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION) {
            ht = new HocTap();
            ht.setMaSV(maSV);
            ht.setMaMH(maMH);
            ht.setDiemThi(diemThi);
            ht.setTinChi(soTin);
            listht.add(ht);
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "INSERT INTO HocTap (MaSV, MaMH, TinChi, DiemThi) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ht.getMaSV());
                ps.setString(2, ht.getMaMH());
                ps.setInt(3, ht.getTinChi());
                ps.setDouble(4, ht.getDiemThi());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi lưu điểm vào SQL: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã hủy thao tác!");
            return;
        }

        hienThiLenBangHT();
    }//GEN-LAST:event_htbtThemActionPerformed


    private void httxtMaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_httxtMaMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_httxtMaMonActionPerformed

    private void htbtTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_htbtTimKiem1ActionPerformed

    private void htbtTimKiem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTimKiem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_htbtTimKiem3ActionPerformed

    private double tinhDiemTB(String ma) {
        double diemtb = 0;
        int tongTin = 0;
        for (HocTap ht : listht) {
            if (ma.equalsIgnoreCase(ht.getMaSV())) {
                diemtb = diemtb + ht.getDiemThi() * ht.getTinChi();
                tongTin = tongTin + ht.getTinChi();
            }
        }
        return diemtb / tongTin;
    }

    private String tinhHocLuc(double diemCuoi) {
        if (diemCuoi < 3.5 && diemCuoi >= 0) {
            return "Kém";
        } else if (diemCuoi < 5) {
            return "Yếu";
        } else if (diemCuoi < 6.5) {
            return "Trung bình";
        } else if (diemCuoi < 8) {
            return "Khá";
        } else if (diemCuoi <= 10) {
            return "Giỏi";
        } else {
            return null;
        }
    }

    private void htbtTinhTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTinhTBActionPerformed
        String maSV = httxtMaSinhVien.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
            return;
        }
        int kiemTraSV = searchMaSinhVien(maSV);
        if (kiemTraSV == -1) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
            return;
        }
        double diemCuoi = tinhDiemTB(httxtMaSinhVien.getText());
        String hocLuc = tinhHocLuc(diemCuoi);
        if (Double.isNaN(diemCuoi)) {
            JOptionPane.showMessageDialog(null, "Sinh viên này chưa có điểm");
            return;
        }
        String diemTBFormatted = String.format("%.2f", diemCuoi);
        JOptionPane.showMessageDialog(null, "Điểm trung bình của sinh viên này: " + diemTBFormatted + "\nHọc lực: " + hocLuc);
    }//GEN-LAST:event_htbtTinhTBActionPerformed

    private void htbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTimKiemActionPerformed
        String maSV = httxtMaSinhVien.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
            return;
        }
        int kiemTraSV = searchMaSinhVien(maSV);
        if (kiemTraSV == -1) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
        } else {
            JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
            hienThiLenBangHT();
        }
    }//GEN-LAST:event_htbtTimKiemActionPerformed

    private void svtxtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svtxtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svtxtNgaySinhActionPerformed

    private void htbtPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtPrintActionPerformed
        String maSV = httxtMaSinhVien.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
            return;
        }
        int kiemTraSV = searchMaSinhVien(maSV);
        if (kiemTraSV == -1) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
            return;
        }
        double diemCuoi = tinhDiemTB(httxtMaSinhVien.getText());
        if (Double.isNaN(diemCuoi)) {
            JOptionPane.showMessageDialog(null, "Sinh viên này chưa có điểm");
            return;
        }
        String hocLuc = tinhHocLuc(diemCuoi);
        String diemTBFormatted = String.format("%.2f", diemCuoi);
        int index = searchMaSinhVien(httxtMaSinhVien.getText());
        sv = list.get(index);
        if (hocLuc.equals("Khá") || hocLuc.equals("Giỏi")) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("BangKhen.txt"));
                writer.write("==== BẰNG KHEN SINH VIÊN ====\n");
                writer.write("Mã sinh viên: " + sv.getMaSinhVien() + "\n");
                writer.write("Tên sinh viên: " + sv.getTenSinhVien() + "\n");
                writer.write("Quê quán: " + sv.getQueQuan() + "\n");
                writer.write("Điểm trung bình: " + diemTBFormatted + "\n");
                writer.write("Học lực: " + hocLuc + "\n");
                writer.write("==============================\n");
                writer.close();

                JOptionPane.showMessageDialog(null, "Đã lưu bằng khen vào file BangKhen.txt");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Lỗi ghi file: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa đủ điều kiện in bằng");
        }
    }//GEN-LAST:event_htbtPrintActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVienGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable htTbDiemThi;
    private javax.swing.JButton htbtPrint;
    private javax.swing.JButton htbtThem;
    private javax.swing.JButton htbtTimKiem;
    private javax.swing.JButton htbtTimKiem1;
    private javax.swing.JButton htbtTimKiem3;
    private javax.swing.JButton htbtTinhTB;
    private javax.swing.JTextField httxtDiem;
    private javax.swing.JTextField httxtMaMon;
    private javax.swing.JTextField httxtMaSinhVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JMenuItem menuItemDangNhap;
    private javax.swing.JButton mhbtSua;
    private javax.swing.JButton mhbtThem;
    private javax.swing.JButton mhbtTimKiem;
    private javax.swing.JButton mhbtXoa;
    private javax.swing.JComboBox<String> mhcbSoTin;
    private javax.swing.JTable mhtbMonHoc;
    private javax.swing.JTextField mhtxtMaMonHoc;
    private javax.swing.JTextField mhtxtTenMonHoc;
    private javax.swing.JButton svbtSua;
    private javax.swing.JButton svbtThem;
    private javax.swing.JButton svbtTimKiem;
    private javax.swing.JButton svbtXoa;
    private javax.swing.JComboBox<String> svcbQueQuan;
    private javax.swing.JRadioButton svrbtNam;
    private javax.swing.JRadioButton svrbtNu;
    private javax.swing.JTable svtbDanhSach;
    private javax.swing.JTextField svtxtMaSinhVien;
    private javax.swing.JTextField svtxtNgaySinh;
    private javax.swing.JTextField svtxtTenSinhVien;
    private javax.swing.JTabbedPane tabNavigate;
    private javax.swing.JPanel tabQuanLyDiem;
    private javax.swing.JPanel tabQuanLyMonHoc;
    private javax.swing.JPanel tabQuanLySinhVien;
    // End of variables declaration//GEN-END:variables
}
