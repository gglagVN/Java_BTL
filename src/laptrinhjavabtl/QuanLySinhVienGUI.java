/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laptrinhjavabtl;



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
    
    public void QuanLySinhVien(){
        list = new ArrayList();
        String[] columnsName = {"Mã sinh viên","Tên sinh viên","Quê quán","Ngày sinh","Giới tính"};
        tableModelSinhVien = new DefaultTableModel(columnsName,0);
        docSinhVienTuSQL();
        hienThiLenBang();
    }
    
    public void hienThiLenBang(){
        tableModelSinhVien.setRowCount(0);
        for (SinhVien sv : list) {
            Object[] row = {sv.getMaSinhVien(),sv.getTenSinhVien(),sv.getQueQuan(),sv.getNgaySinh(),sv.getGioiTinh()};
            tableModelSinhVien.addRow(row);
        }
        svtbDanhSach.setModel(tableModelSinhVien);
    }
    
    public void QuanLyMonHoc(){
        listmh = new ArrayList();
        String[] columnsName = {"Mã môn học","Tên môn học","Số Tín"};
        tableModelMonHoc = new DefaultTableModel(columnsName,0);
        docMonHocTuSQL();
        hienThiLenBangMH();
    }
    public void hienThiLenBangMH(){
        tableModelMonHoc.setRowCount(0);
        for (MonHoc mh : listmh) {
            Object[] row = {mh.getMaMonHoc(),mh.getTenMonHoc(),mh.getSoTin()};
            tableModelMonHoc.addRow(row);
        }
        mhtbMonHoc.setModel(tableModelMonHoc);
    }
    
    public void QuanLyHocTap(){
        listht = new ArrayList();
        String[] columnsName = {"Mã môn học","Số tín","Điểm"};
        tableModelHocTap = new DefaultTableModel(columnsName,0);
        docHocTapTuSQL();
        hienThiLenBangHT();
    }
    
public void hienThiLenBangHT() {
    String maSV = httxtMaSinhVien.getText().trim();

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
        htbtTimKiem = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        htTbDiemThi = new javax.swing.JTable();
        httxtMaMon = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        httxtDiem = new javax.swing.JTextField();
        htbtTinhTB = new javax.swing.JButton();
        htbtHienThi = new javax.swing.JButton();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemQuanLySV = new javax.swing.JMenuItem();

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel4.setText("Mã sinh viên");

        jLabel6.setText("Tên sinh viên");

        jLabel7.setText("Quê quán");

        jLabel8.setText("Ngày sinh");

        jLabel9.setText("Giới tính");

        svtxtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svtxtNgaySinhActionPerformed(evt);
            }
        });

        buttonGroup1.add(svrbtNam);
        svrbtNam.setText("Nam");
        svrbtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svrbtNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(svrbtNu);
        svrbtNu.setText("Nữ");
        svrbtNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svrbtNuActionPerformed(evt);
            }
        });

        svcbQueQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa-Vũng Tàu", "Bạc Liêu", "Bắc Kạn", "Bắc Giang", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ (TP)", "Đà Nẵng (TP)", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội (TP)", "Hà Tây", "Hà Tĩnh", "Hải Dương", "Hải Phòng (TP)", "Hòa Bình", "Hồ Chí Minh (TP)", "Hậu Giang", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lào Cai", "Lạng Sơn", "Lâm Đồng", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên – Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" }));
        svcbQueQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svcbQueQuanActionPerformed(evt);
            }
        });

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

        svbtTimKiem.setText("Tìm kiếm");
        svbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtTimKiemActionPerformed(evt);
            }
        });

        svbtSua.setText("Sửa");
        svbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtSuaActionPerformed(evt);
            }
        });

        svbtXoa.setText("Xoá");
        svbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtXoaActionPerformed(evt);
            }
        });

        svbtThem.setText("Thêm");
        svbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabQuanLySinhVienLayout = new javax.swing.GroupLayout(tabQuanLySinhVien);
        tabQuanLySinhVien.setLayout(tabQuanLySinhVienLayout);
        tabQuanLySinhVienLayout.setHorizontalGroup(
            tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(svcbQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(svbtXoa)
                                .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                                    .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(svtxtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(svtxtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(114, 114, 114)
                                    .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                    .addGap(18, 18, 18)
                                    .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(svtxtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                                            .addComponent(svrbtNam)
                                            .addGap(40, 40, 40)
                                            .addComponent(svrbtNu)))))))
                    .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1))
                    .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(svbtThem)
                        .addGap(109, 109, 109)
                        .addComponent(svbtTimKiem)
                        .addGap(76, 76, 76)
                        .addComponent(svbtSua))
                    .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        tabQuanLySinhVienLayout.setVerticalGroup(
            tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanLySinhVienLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(svtxtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(svtxtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svtxtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(svrbtNam)
                    .addComponent(svrbtNu))
                .addGap(18, 18, 18)
                .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(svcbQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabQuanLySinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(svbtSua)
                    .addComponent(svbtXoa)
                    .addComponent(svbtTimKiem)
                    .addComponent(svbtThem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabNavigate.addTab("Quản lý sinh viên", tabQuanLySinhVien);

        tabQuanLyDiem.setBackground(new java.awt.Color(204, 255, 204));
        tabQuanLyDiem.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("QUẢN LÝ ĐIỂM");

        jLabel14.setText("Mã sinh viên");

        httxtMaSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                httxtMaSinhVienActionPerformed(evt);
            }
        });

        htbtTimKiem.setText("Thêm");
        htbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtTimKiemActionPerformed(evt);
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

        htbtTinhTB.setText("Tính điểm TB");
        htbtTinhTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtTinhTBActionPerformed(evt);
            }
        });

        htbtHienThi.setText("Hiển thị");
        htbtHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htbtHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabQuanLyDiemLayout = new javax.swing.GroupLayout(tabQuanLyDiem);
        tabQuanLyDiem.setLayout(tabQuanLyDiemLayout);
        tabQuanLyDiemLayout.setHorizontalGroup(
            tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanLyDiemLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(htbtTimKiem)
                .addGap(87, 87, 87)
                .addComponent(htbtHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(htbtTinhTB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabQuanLyDiemLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel3))
                    .addGroup(tabQuanLyDiemLayout.createSequentialGroup()
                        .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabQuanLyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(httxtMaMon)
                            .addComponent(httxtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(httxtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(251, 251, 251))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanLyDiemLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
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
                    .addComponent(htbtTimKiem)
                    .addComponent(htbtTinhTB)
                    .addComponent(htbtHienThi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabNavigate.addTab("Quản lý điểm", tabQuanLyDiem);

        tabQuanLyMonHoc.setBackground(new java.awt.Color(204, 255, 204));
        tabQuanLyMonHoc.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
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

        mhbtTimKiem.setText("Tìm kiếm");
        mhbtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtTimKiemActionPerformed(evt);
            }
        });

        mhbtSua.setText("Sửa");
        mhbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtSuaActionPerformed(evt);
            }
        });

        mhbtXoa.setText("Xoá");
        mhbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mhbtXoaActionPerformed(evt);
            }
        });

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
                .addGap(0, 102, Short.MAX_VALUE)
                .addComponent(mhbtThem)
                .addGap(73, 73, 73)
                .addComponent(mhbtTimKiem)
                .addGap(161, 161, 161)
                .addComponent(mhbtSua)
                .addGap(93, 93, 93)
                .addComponent(mhbtXoa)
                .addGap(140, 140, 140))
            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel2))
                            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mhtxtMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mhtxtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mhcbSoTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabQuanLyMonHocLayout.setVerticalGroup(
            tabQuanLyMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanLyMonHocLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        tabNavigate.addTab("Quản lý môn học", tabQuanLyMonHoc);

        jMenu1.setText("Chức năng");

        menuItemQuanLySV.setText("Đăng nhập");
        menuItemQuanLySV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLySVActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemQuanLySV);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabNavigate, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabNavigate, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void menuItemQuanLySVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLySVActionPerformed
        DangNhapForm sv = new DangNhapForm();
        sv.setVisible(true);
    }//GEN-LAST:event_menuItemQuanLySVActionPerformed

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
    return -1; // không tìm thấy
    }
    
    private void svbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtThemActionPerformed
        kiemTra = -1;
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        sv = new SinhVien();
        sv.setMaSinhVien(svtxtMaSinhVien.getText());
        sv.setTenSinhVien(svtxtTenSinhVien.getText());
        sv.setNgaySinh(svtxtNgaySinh.getText());
        sv.setQueQuan((String)svcbQueQuan.getSelectedItem());
        if(svrbtNam.isSelected())
            sv.setGioiTinh("Nam");
        if(svrbtNu.isSelected())
            sv.setGioiTinh("Nữ");
        if (svtxtMaSinhVien.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
        return;
        }
        if(kiemTra > -1)
        {
            JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");
        }
        else
        {
            list.add(sv);
        }
        try (Connection conn = DBConnection.getConnection()) {
    String sql = "INSERT INTO SinhVien (MaSinhVien, TenSinhVien, QueQuan, NgaySinh, GioiTinh) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, sv.getMaSinhVien());
    ps.setString(2, sv.getTenSinhVien());
    ps.setString(3, sv.getQueQuan());
    ps.setString(4, sv.getNgaySinh());
    ps.setString(5, sv.getGioiTinh());
    ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi lưu sinh viên vào SQL: " + ex.getMessage());
    }   
        hienThiLenBang();
    }//GEN-LAST:event_svbtThemActionPerformed

    private void svcbQueQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svcbQueQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svcbQueQuanActionPerformed

    private void svbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtTimKiemActionPerformed
        kiemTra = -1;
        if (svtxtMaSinhVien.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để tìm kiếm ");
            return;
        }
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        sv = list.get(kiemTra);
        if (kiemTra > -1)
        {
            JOptionPane.showMessageDialog(null, "Mã Sinh viên: " + sv.getMaSinhVien() + "\nHọ và tên: " + sv.getTenSinhVien() + "\nGiới tính: " + sv.getGioiTinh() + "\nNgày sinh: " + sv.getNgaySinh() + "\nQuê quán: " + sv.getQueQuan());
        }
    }//GEN-LAST:event_svbtTimKiemActionPerformed

    private void svbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtSuaActionPerformed
        kiemTra = -1;
        if (svtxtMaSinhVien.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để Xoá ");
            return;
        }
        kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
        sv = list.get(kiemTra);
        if (kiemTra > -1)
        {
            sv.setMaSinhVien(svtxtMaSinhVien.getText());
            sv.setTenSinhVien(svtxtTenSinhVien.getText());
            sv.setNgaySinh(svtxtNgaySinh.getText());
            sv.setQueQuan((String)svcbQueQuan.getSelectedItem());
        if(svrbtNam.isSelected())
            sv.setGioiTinh("Nam");
        if(svrbtNu.isSelected())
            sv.setGioiTinh("Nữ");
        }
        hienThiLenBang();
    }//GEN-LAST:event_svbtSuaActionPerformed

    private void svbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtXoaActionPerformed
        kiemTra = -1;
    if (svtxtMaSinhVien.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để Xoá ");
        return;
    }
    kiemTra = searchMaSinhVien(svtxtMaSinhVien.getText());
    sv = list.get(kiemTra);
    if (kiemTra > -1) {
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
    }
    hienThiLenBang();
    }//GEN-LAST:event_svbtXoaActionPerformed

    private void svtbDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svtbDanhSachMouseClicked
        int selectedRow = svtbDanhSach.getSelectedRow();
        if(selectedRow>=0){
            svtxtMaSinhVien.setText(svtbDanhSach.getValueAt(selectedRow, 0).toString());
            svtxtTenSinhVien.setText(svtbDanhSach.getValueAt(selectedRow, 1).toString());
            svtxtNgaySinh.setText(svtbDanhSach.getValueAt(selectedRow, 2).toString());
        }
    }//GEN-LAST:event_svtbDanhSachMouseClicked
    
// ----------------------------- MON HOC
    private int searchMaMonHoc(String ma) {
    for (int i = 0; i < listmh.size(); i++) {
        if (ma.equalsIgnoreCase(listmh.get(i).getMaMonHoc())) {
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
        mh.setSoTin(mhcbSoTin.getSelectedIndex()+1);
        if (mhtxtMaMonHoc.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn học");
        return;
        }
        if(kiemTra > -1)
        {
            JOptionPane.showMessageDialog(null, "Mã môn học đã tồn tại");
        }
        else
        {
            listmh.add(mh);
            try (Connection conn = DBConnection.getConnection()) {
    String sql = "INSERT INTO MonHoc (MaMonHoc, TenMonHoc, SoTin) VALUES (?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, mh.getMaMonHoc());
    ps.setString(2, mh.getTenMonHoc());
    ps.setInt(3, mh.getSoTin());
    ps.executeUpdate();
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Lỗi lưu môn học vào SQL: " + ex.getMessage());
}
        }
        hienThiLenBangMH();
    }//GEN-LAST:event_mhbtThemActionPerformed

    private void mhbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtTimKiemActionPerformed
        kiemTra = -1;
        if (mhtxtMaMonHoc.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nhập mã Môn học để tìm kiếm ");
            return;
        }
        kiemTra = searchMaMonHoc(mhtxtMaMonHoc.getText());
        mh = listmh.get(kiemTra);
        if (kiemTra > -1)
        {
            JOptionPane.showMessageDialog(null, "Mã môn học: " + mh.getMaMonHoc() + "\nTên môn học: " + mh.getTenMonHoc() + "\nSố tín " + mh.getSoTin());
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Mã môn học chưa tồn tại");
        }
    }//GEN-LAST:event_mhbtTimKiemActionPerformed

    private void mhbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtSuaActionPerformed
        kiemTra = -1;
        if (mhtxtMaMonHoc.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nhập mã sinh viên để Xoá ");
            return;
        }
        kiemTra = searchMaMonHoc(mhtxtMaMonHoc.getText());
        mh = listmh.get(kiemTra);
        if (kiemTra > -1)
        {
            mh.setMaMonHoc(mhtxtMaMonHoc.getText());
            mh.setTenMonHoc(mhtxtTenMonHoc.getText());
            mh.setSoTin(mhcbSoTin.getSelectedIndex()+1);
        }
        hienThiLenBangMH();
    }//GEN-LAST:event_mhbtSuaActionPerformed

    private void mhbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mhbtXoaActionPerformed
        kiemTra = -1;
    if (mhtxtMaMonHoc.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Nhập mã môn học để Xoá ");
        return;
    }
    kiemTra = searchMaMonHoc(mhtxtMaMonHoc.getText());
    mh = listmh.get(kiemTra);
    if (kiemTra > -1) {
        String maMH = mh.getMaMonHoc();
        try (Connection conn = DBConnection.getConnection()) {
            String sqlDeleteHocTap = "DELETE FROM HocTap WHERE MaMH = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeleteHocTap);
            ps1.setString(1, maMH);
            ps1.executeUpdate();
            String sqlDeleteMonHoc = "DELETE FROM MonHoc WHERE MaMonHoc = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlDeleteMonHoc);
            ps2.setString(1, maMH);
            ps2.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi xóa môn học trên SQL: " + ex.getMessage());
        }
        listmh.remove(mh);
    }
    hienThiLenBangMH();
    }//GEN-LAST:event_mhbtXoaActionPerformed

    private void mhtbMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mhtbMonHocMouseClicked
        int selectedRow = mhtbMonHoc.getSelectedRow();
        if(selectedRow>=0){
            mhtxtMaMonHoc.setText(mhtbMonHoc.getValueAt(selectedRow, 0).toString());
            mhtxtTenMonHoc.setText(mhtbMonHoc.getValueAt(selectedRow, 1).toString());
            mhcbSoTin.setSelectedIndex((int)mhtbMonHoc.getValueAt(selectedRow, 1)-1);
        }
    }//GEN-LAST:event_mhtbMonHocMouseClicked

    private void htbtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTimKiemActionPerformed
String maSV = httxtMaSinhVien.getText().trim();
String maMH = httxtMaMon.getText().trim();
String diemThi = httxtDiem.getText().trim();

if (maSV.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên");
    return;
}
if (maMH.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn học");
    return;
}
if (diemThi.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Vui lòng nhập điểm");
    return;
}

int kiemTraSV = searchMaSinhVien(maSV);
int kiemTraMH = searchMaMonHoc(maMH);

if (kiemTraSV == -1 || kiemTraMH == -1) {
    JOptionPane.showMessageDialog(null, "Mã sinh viên hoặc mã môn học không tồn tại");
    return;
}

MonHoc mh = listmh.get(kiemTraMH);
int soTin = mh.getSoTin();

for (HocTap ht : listht) {
    if (ht.getMaSV().equals(maSV) && ht.getMaMH().equals(maMH)) {
        JOptionPane.showMessageDialog(null, "Sinh viên này đã có điểm môn học này");
        return;
    }
}

try {
    double diem = Double.parseDouble(diemThi);

    HocTap ht = new HocTap();
    ht.setMaSV(maSV);
    ht.setMaMH(maMH);
    ht.setDiemThi(diem);
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
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Lỗi lưu điểm vào SQL: " + ex.getMessage());
}
    hienThiLenBangHT(); 
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Điểm phải là số hợp lệ (ví dụ: 7.5)");
}
    }//GEN-LAST:event_htbtTimKiemActionPerformed

    
    private void httxtMaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_httxtMaMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_httxtMaMonActionPerformed

    private void htbtTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_htbtTimKiem1ActionPerformed

    private void htbtTimKiem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTimKiem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_htbtTimKiem3ActionPerformed

    private void htbtTinhTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtTinhTBActionPerformed
        String ma = httxtMaSinhVien.getText();
        double diemtb = 0;
        int tongTin = 0;
        for (HocTap ht : listht) {
            if(ma.equalsIgnoreCase(ht.getMaSV()))
            {
                diemtb = diemtb + ht.getDiemThi()*ht.getTinChi();
                tongTin = tongTin + ht.getTinChi();
            }        
        }
        String diemTBFormatted = String.format("%.2f", diemtb / tongTin);
        JOptionPane.showMessageDialog(null, "Điểm trung bình của sinh viên này: " + diemTBFormatted);
    }//GEN-LAST:event_htbtTinhTBActionPerformed

    private void htbtHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htbtHienThiActionPerformed
        int kiemTraSV = searchMaSinhVien(httxtMaSinhVien.getText());
        if (kiemTraSV == -1) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
        }
        else
        hienThiLenBangHT();      
    }//GEN-LAST:event_htbtHienThiActionPerformed

    private void svtxtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svtxtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svtxtNgaySinhActionPerformed
    public void kiemTraDangNhap(boolean check)
    {
        tabNavigate.setVisible(check);
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
    private javax.swing.JButton htbtHienThi;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JMenuItem menuItemQuanLySV;
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
