package view.manageform;

import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.LoaiMonAnDAO;
import DAO.MonAnDAO;
import DAO.ThongTinDatBanDAO;
import DTO.BanDTO;
import DTO.CenterTableCellRenderer;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.LoaiMonAnDTO;
import DTO.MonAnDTO;
import DTO.RightTableCellRenderer;
import DTO.ThongTinDatBanDTO;
import DTO.Utils;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ChonMonAn extends javax.swing.JFrame {

    Home home;

    DefaultTableModel defaultTableModelDishChoose;
    DefaultTableModel defaultTableModelDishUpdate;
    DefaultComboBoxModel defaultComboBoxModelDishCategory;
    private int tableId;
    private String staffId;
    private int dishIdSelected = -1;
    private int billId = -1;
    private int dishIdUpdate = -1;

    public ChonMonAn(int tableId, String staffId, Home home) {
        initComponents();
        this.home = home;
        this.tableId = tableId;
        this.staffId = staffId;
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxDishCategory = new javax.swing.JComboBox<>();
        jLabelSearch = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDishChoose = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextFieldDishName = new javax.swing.JTextField();
        jLabelImage = new javax.swing.JLabel();
        jSpinnerCountAdd = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextFieldSubmitOrder = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButtonSubmit = new javax.swing.JButton();
        jButtonDeleteBill = new javax.swing.JButton();
        jButtonAddDish = new javax.swing.JButton();
        jButtonCreateBill = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldDishNameUpdate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSpinnerCountUpdate = new javax.swing.JSpinner();
        jButtonUpdate = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDishUpdate = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/t1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 37, 41));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Chọn món ăn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 6, 108, 28));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nhà hàng Baretie");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(384, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Danh sách món ăn");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Tìm kiếm");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 41, 84, -1));

        jTextFieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldSearch.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 38, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Loại món");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 41, 90, -1));

        jComboBoxDishCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxDishCategory.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxDishCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(jComboBoxDishCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 38, 190, -1));

        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sb.png"))); // NOI18N
        jPanel5.add(jLabelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 30, 30));

        jTableDishChoose.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableDishChoose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên món", "DVT", "Đơn giá", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDishChoose.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableDishChoose.setRowHeight(80);
        jTableDishChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDishChooseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDishChoose);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 660, 500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 690, 660));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(660, 656));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Nhà hàng");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 246, 40));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTextFieldDishName.setEditable(false);
        jTextFieldDishName.setBackground(new java.awt.Color(51, 204, 255));
        jTextFieldDishName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldDishName.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDishName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDishName.setText("Tên món ăn");

        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/f.jpg"))); // NOI18N
        jLabelImage.setPreferredSize(new java.awt.Dimension(240, 175));

        jSpinnerCountAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/add.png"))); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jTextFieldSubmitOrder.setEditable(false);
        jTextFieldSubmitOrder.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldSubmitOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldSubmitOrder.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldSubmitOrder.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSubmitOrder.setText("Xác nhận đặt bàn");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/s1.png"))); // NOI18N

        jButtonSubmit.setBackground(new java.awt.Color(0, 204, 102));
        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSubmit.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSubmit.setText("Xác nhận");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jButtonDeleteBill.setBackground(new java.awt.Color(255, 102, 102));
        jButtonDeleteBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDeleteBill.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDeleteBill.setText("Hủy");
        jButtonDeleteBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDeleteBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTextFieldSubmitOrder))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTextFieldSubmitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        jButtonAddDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAddDish.setText("Thêm món ăn");
        jButtonAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldDishName)
            .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddDish, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jSpinnerCountAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTextFieldDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinnerCountAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddDish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 240, 560));

        jButtonCreateBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCreateBill.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCreateBill.setText("Tạo phiếu");
        jButtonCreateBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCreateBillMouseClicked(evt);
            }
        });
        jPanel2.add(jButtonCreateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 230, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 246, 660));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Bàn đã đặt");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 40));

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Cập nhật số lượng");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/up.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldDishNameUpdate.setEditable(false);
        jTextFieldDishNameUpdate.setBackground(new java.awt.Color(255, 255, 153));
        jTextFieldDishNameUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldDishNameUpdate.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDishNameUpdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDishNameUpdate.setText("Tên món");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Số lượng");

        jSpinnerCountUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(0, 153, 255));
        jButtonUpdate.setText("Cập nhật");
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonRemove.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRemove.setForeground(new java.awt.Color(153, 0, 51));
        jButtonRemove.setText("Xóa");
        jButtonRemove.setEnabled(false);
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jTableDishUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTableDishUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableDishUpdate.setForeground(new java.awt.Color(0, 0, 0));
        jTableDishUpdate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên món", "Đơn giá", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDishUpdate.setGridColor(new java.awt.Color(255, 204, 153));
        jTableDishUpdate.setRowHeight(40);
        jTableDishUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDishUpdateMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDishUpdate);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(40, 40, 40)
                        .addComponent(jSpinnerCountUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDishNameUpdate)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDishNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jSpinnerCountUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 510, 590));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, 520, 660));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 10, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        closeForm();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTableDishChooseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDishChooseMouseClicked
        bindindDish();
    }//GEN-LAST:event_jTableDishChooseMouseClicked

    private void jTableDishUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDishUpdateMouseClicked
        bindindDishUpdate();
    }//GEN-LAST:event_jTableDishUpdateMouseClicked

    private void jButtonCreateBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateBillMouseClicked
        createBill();
    }//GEN-LAST:event_jButtonCreateBillMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        updateDish();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        removeDish();
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteBillActionPerformed
        deleteBill();
    }//GEN-LAST:event_jButtonDeleteBillActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        submitBill();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButtonAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDishActionPerformed
        addDish();
    }//GEN-LAST:event_jButtonAddDishActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Giao diện (Không code được trong này)">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddDish;
    private javax.swing.JButton jButtonCreateBill;
    private javax.swing.JButton jButtonDeleteBill;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxDishCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerCountAdd;
    private javax.swing.JSpinner jSpinnerCountUpdate;
    private javax.swing.JTable jTableDishChoose;
    private javax.swing.JTable jTableDishUpdate;
    private javax.swing.JTextField jTextFieldDishName;
    private javax.swing.JTextField jTextFieldDishNameUpdate;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSubmitOrder;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    private void settingSppiner(JSpinner jSpinner) {
        jSpinner.setValue(1);
        // Tạo một SpinnerModel tùy chỉnh để không cho phép số âm
        SpinnerNumberModel spinnerNumberModel = (SpinnerNumberModel) jSpinner.getModel();
        spinnerNumberModel.setMinimum(1);
    }

    private void settingJTableBillDetails() {
        jTableDishUpdate.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int[] columnWidths = {60, 210, 140, 60}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableDishUpdate.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        jTableDishUpdate.getColumnModel().getColumn(0).setCellRenderer(new CenterTableCellRenderer());
        jTableDishUpdate.getColumnModel().getColumn(3).setCellRenderer(new CenterTableCellRenderer());
        jTableDishUpdate.getColumnModel().getColumn(2).setCellRenderer(new RightTableCellRenderer());
    }

    private void settingJTableDish() {
        jTableDishChoose.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int[] columnWidths = {60, 230, 80, 115, 150}; // Chiều rộng mong muốn cho từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableDishChoose.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        jTableDishChoose.getColumnModel().getColumn(0).setCellRenderer(new CenterTableCellRenderer());
        jTableDishChoose.getColumnModel().getColumn(2).setCellRenderer(new CenterTableCellRenderer());
        jTableDishChoose.getColumnModel().getColumn(3).setCellRenderer(new RightTableCellRenderer());
    }

    public class ImageTableCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof ImageIcon) {
                // Đặt hình ảnh vào JLabel
                ImageIcon imageIcon = (ImageIcon) value;
                label.setIcon(imageIcon);
                // Đặt văn bản của JLabel thành null để không hiển thị văn bản
                label.setText(null);
                // Đảm bảo hình ảnh nằm giữa ô
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
            }
            return label;
        }
    }

    private void loadDish() {
        defaultTableModelDishChoose.setRowCount(0);

        ArrayList<MonAnDTO> monAnDTOs = MonAnDAO.getInstance().getDishs();

        // Thiết lập TableCellRenderer mới cho cột chứa hình ảnh
        jTableDishChoose.getColumnModel().getColumn(4).setCellRenderer(new ImageTableCellRenderer());

        for (MonAnDTO monAnDTO : monAnDTOs) {
            String duongDanHinhAnh = monAnDTO.getHinhanh(); // Lấy đường dẫn hình ảnh từ danh sách món ăn

            ImageIcon imageIcon;
            if (duongDanHinhAnh != null && !duongDanHinhAnh.isEmpty()) {
                imageIcon = new ImageIcon(getClass().getResource("/view/Images/" + duongDanHinhAnh));
            } else {
                imageIcon = new ImageIcon(getClass().getResource("/view/icon/food.jpg"));
            }
            Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);
            defaultTableModelDishChoose.addRow(new Object[]{monAnDTO.getMamonan(), monAnDTO.getTenmonan(), monAnDTO.getDvt(), Utils.VNDCurrencyFormat(monAnDTO.getDongia()), scaledImageIcon});
        }
    }

    private void loadComboboxDishCategory() {
        defaultComboBoxModelDishCategory.removeAllElements();
        defaultComboBoxModelDishCategory.addElement("Tất cả");
        ArrayList<LoaiMonAnDTO> loaiMonAnDTOs = LoaiMonAnDAO.getInstance().getDishCategory();

        for (LoaiMonAnDTO loaiMonAnDTO : loaiMonAnDTOs) {
            defaultComboBoxModelDishCategory.addElement(loaiMonAnDTO.getTenloaimonan());
        }
    }

    private void loadBillDetails() {
        defaultTableModelDishUpdate.setRowCount(0);
        ArrayList<ChiTietHoaDonDTO> chiTietHoaDonDTOs = ChiTietHoaDonDAO.getInstance().getBillDetailsByBillId(billId);
        for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDonDTOs) {
            MonAnDTO monAnDTO = MonAnDAO.getInstance().getDishById(chiTietHoaDonDTO.getMamonan());
            defaultTableModelDishUpdate.addRow(new Object[]{monAnDTO.getMamonan(), monAnDTO.getTenmonan(), Utils.VNDCurrencyFormat(monAnDTO.getDongia()), chiTietHoaDonDTO.getSoluong()});
        }
    }

    private void checkBill() {
        BanDTO banDTO = BanDAO.getInstance().getTableById(tableId);

        if (banDTO != null) {
            if (banDTO.getTrangthai().equals("Trống") || banDTO.getTrangthai().equals("Đã đặt")) {
                jButtonCreateBill.setEnabled(true);
                jSpinnerCountAdd.setEnabled(false);
                jButtonAddDish.setEnabled(false);
                jButtonSubmit.setEnabled(false);
                jSpinnerCountUpdate.setEnabled(false);
                jButtonUpdate.setEnabled(false);
                jButtonRemove.setEnabled(false);
                jButtonDeleteBill.setEnabled(false);
            } else if (banDTO.getTrangthai().equals("Có người")) {
                // lấy mã hóa đơn trong trường hợp bàn đã có hóa đơn
                HoaDonDTO hoaDonDTO = HoaDonDAO.getInstance().getBillByTableId(tableId);
                if (hoaDonDTO != null) {
                    billId = hoaDonDTO.getMahoadon();
                    loadBillDetails();
                } else {
                    JOptionPane.showMessageDialog(this, "Không tồn tại hóa đơn cho bàn này!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }

                jButtonCreateBill.setEnabled(false);
                jSpinnerCountAdd.setEnabled(true);
                jButtonAddDish.setEnabled(true);
                jButtonSubmit.setEnabled(true);
                jSpinnerCountUpdate.setEnabled(true);
                jButtonUpdate.setEnabled(true);
                jButtonRemove.setEnabled(true);
                jButtonDeleteBill.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không thể lấy thông tin bàn này!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchDish() {
        String keyWord = jTextFieldSearch.getText().toString().trim();
        String category = jComboBoxDishCategory.getSelectedItem().toString().trim();
        if (category.equals("Tất cả")) {
            searchDishByKeyWord(keyWord);
        } else {
            searchDishByKeyWordAndCategory(keyWord, category);
        }
    }

    private void searchDishByKeyWord(String keyWord) {
        ArrayList<MonAnDTO> monAnDTOs = MonAnDAO.getInstance().searchDishByKeyWord(keyWord);
        loadDishForSearch(monAnDTOs);
    }

    private void searchDishByKeyWordAndCategory(String keyWord, String category) {
        ArrayList<MonAnDTO> monAnDTOs = MonAnDAO.getInstance().searchDishByKeyWordAndCategory(keyWord, category);
        loadDishForSearch(monAnDTOs);
    }

    private void loadDishForSearch(ArrayList<MonAnDTO> monAnDTOs) {
        defaultTableModelDishChoose.setRowCount(0);
        // Thiết lập TableCellRenderer mới cho cột chứa hình ảnh
        jTableDishChoose.getColumnModel().getColumn(4).setCellRenderer(new ImageTableCellRenderer());

        for (MonAnDTO monAnDTO : monAnDTOs) {
            String duongDanHinhAnh = monAnDTO.getHinhanh(); // Lấy đường dẫn hình ảnh từ danh sách món ăn

            ImageIcon imageIcon;
            if (duongDanHinhAnh != null && !duongDanHinhAnh.isEmpty()) {
                imageIcon = new ImageIcon(getClass().getResource("/view/Images/" + duongDanHinhAnh));
            } else {
                imageIcon = new ImageIcon(getClass().getResource("/view/icon/food.jpg"));
            }
            Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);
            defaultTableModelDishChoose.addRow(new Object[]{monAnDTO.getMamonan(), monAnDTO.getTenmonan(), monAnDTO.getDvt(), Utils.VNDCurrencyFormat(monAnDTO.getDongia()), scaledImageIcon});
        }
    }

    private void load() {
        defaultTableModelDishChoose = (DefaultTableModel) jTableDishChoose.getModel();
        defaultTableModelDishUpdate = (DefaultTableModel) jTableDishUpdate.getModel();
        defaultComboBoxModelDishCategory = (DefaultComboBoxModel) jComboBoxDishCategory.getModel();

        // chỉ cho phép spinner số lượng nhập được số dương
        settingSppiner(jSpinnerCountAdd);
        settingSppiner(jSpinnerCountUpdate);
        settingJTableBillDetails();
        settingJTableDish();

        loadDish();

        Home.loadFontTable(jTableDishUpdate);
        Home.loadFontTable(jTableDishChoose);

        loadComboboxDishCategory();

        checkBill();

        // bắt sự kiện khi thay đổi nội dung trong ô tìm kiếm
        jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchDish();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchDish();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchDish();
            }
        });

        // bắt sự kiện khi thay đổi lựa chọn combobox
        jComboBoxDishCategory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                searchDish();
            }
        });
    }

    private void bindindDish() {
        int indexRow = jTableDishChoose.getSelectedRow();

        if (indexRow >= 0) {
            MonAnDTO monAnDTO = MonAnDAO.getInstance().getDishById(Integer.parseInt(defaultTableModelDishChoose.getValueAt(indexRow, 0).toString()));
            if (monAnDTO != null) {
                dishIdSelected = monAnDTO.getMamonan();

                jTextFieldDishName.setText(monAnDTO.getTenmonan());
                String duongDanHinhAnh = monAnDTO.getHinhanh(); // Lấy đường dẫn hình ảnh từ danh sách món ăn

                ImageIcon imageIcon;
                if (duongDanHinhAnh != null && !duongDanHinhAnh.isEmpty()) {
                    imageIcon = new ImageIcon(getClass().getResource("/view/Images/" + duongDanHinhAnh));
                } else {
                    imageIcon = new ImageIcon(getClass().getResource("/view/icon/food.jpg"));
                }
                Image image = imageIcon.getImage().getScaledInstance(243, 175, Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(image);
                jLabelImage.setIcon(scaledImageIcon);
            } else {
                JOptionPane.showMessageDialog(this, "Errol: Không tìm thấy món ăn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void bindindDishUpdate() {
        int indexRow = jTableDishUpdate.getSelectedRow();

        if (indexRow >= 0) {
            dishIdUpdate = Integer.parseInt(defaultTableModelDishUpdate.getValueAt(indexRow, 0).toString());
            jTextFieldDishNameUpdate.setText(defaultTableModelDishUpdate.getValueAt(indexRow, 1).toString());
            jSpinnerCountUpdate.setValue(Integer.parseInt(defaultTableModelDishUpdate.getValueAt(indexRow, 3).toString()));
        }
    }

    private void closeForm() {
        home.setVisible(true);
        home.reload();
        this.dispose();
    }

    private void createBill() {
        // đổi kiểu dữ liệu ngayvao, ngayra HoaDonDTO thành kiểu Timestamp
        if (HoaDonDAO.getInstance().createBill(tableId, staffId, Timestamp.valueOf(LocalDateTime.now()), null, 0, 0)) {
            BanDTO banDTO = BanDAO.getInstance().getTableById(tableId);

            if (banDTO != null) {
                if (banDTO.getTrangthai().equals("Đã đặt")) {
                    ThongTinDatBanDTO thongTinDatBanDTO = ThongTinDatBanDAO.getInstance().getInforOrderTable(banDTO.getMaban());
                    if (thongTinDatBanDTO != null) {
                        if (!ThongTinDatBanDAO.getInstance().removeInforOrderTable(thongTinDatBanDTO.getMattdb())) {
                            JOptionPane.showMessageDialog(this, "Không thể hủy thông tin đặt bàn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thể lấy thông tin đặt bàn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không thể lấy thông tin bàn này!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // cập nhật trạng thái bàn thành Có người
            if (BanDAO.getInstance().updateTableStatus(tableId, "Có người")) {
                // lấy mã hóa đơn sau khi tạo hóa đơn
                HoaDonDTO hoaDonDTO = HoaDonDAO.getInstance().getBillByTableId(tableId);
                if (hoaDonDTO != null) {
                    billId = hoaDonDTO.getMahoadon();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể lấy hóa đơn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                jButtonCreateBill.setEnabled(false);
                jSpinnerCountAdd.setEnabled(true);
                jButtonAddDish.setEnabled(true);
                jButtonSubmit.setEnabled(true);
                jSpinnerCountUpdate.setEnabled(true);
                jButtonUpdate.setEnabled(true);
                jButtonRemove.setEnabled(true);
                jButtonDeleteBill.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật trạng thái bàn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkDish(int idDish) {
        ArrayList<ChiTietHoaDonDTO> chiTietHoaDonDTOs = ChiTietHoaDonDAO.getInstance().getBillDetailsByBillId(billId);
        for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDonDTOs) {
            if (chiTietHoaDonDTO.getMamonan() == idDish) {
                return false;
            }
        }
        return true;
    }

    private void addDish() {
        try {
            if (dishIdSelected >= 0) {
                if (checkDish(dishIdSelected)) {
                    MonAnDTO monAnDTO = MonAnDAO.getInstance().getDishById(dishIdSelected);
                    if (monAnDTO != null) {
                        if (billId >= 0) {
                            int count = Integer.parseInt(jSpinnerCountAdd.getValue().toString());
                            if (ChiTietHoaDonDAO.getInstance().insertBillDetails(monAnDTO.getMamonan(), billId, count)) {
                                loadBillDetails();
//                                dishIdSelected = -1;
//                                jTextFieldDishName.setText("Tên món ăn");
//
//                                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/view/icon/f.jpg"));
//                                Image image = imageIcon.getImage();
//                                ImageIcon scaledImageIcon = new ImageIcon(image);
//                                jLabelImage.setIcon(scaledImageIcon);
                            } else {
                                throw new Exception("Lỗi thêm món ăn!!!");
                            }
                        } else {
                            throw new Exception("Không tìm thấy hóa đơn cho bàn này!!!");
                        }
                    } else {
                        throw new Exception("Không tìm thấy món ăn!!!");
                    }
                } else {
                    throw new Exception("Món ăn đã tồn tại trong hóa đơn!!!");
                }
            } else {
                throw new Exception("Bạn chưa chọn món ăn!!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDish() {
        if (dishIdUpdate >= 0) {
            int count = Integer.parseInt(jSpinnerCountUpdate.getValue().toString());
            if (ChiTietHoaDonDAO.getInstance().updateDishCountInBillDetail(billId, dishIdUpdate, count)) {
                loadBillDetails();
                dishIdUpdate = -1;
                jTextFieldDishNameUpdate.setText("Tên món ăn");
                jSpinnerCountUpdate.setValue(1);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật số lượng món ăn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn món ăn để cập nhật!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeDish() {
        if (dishIdUpdate >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa món ăn này?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                if (ChiTietHoaDonDAO.getInstance().removeDishFromBillDetail(billId, dishIdUpdate)) {
                    loadBillDetails();
                    dishIdUpdate = -1;
                    jTextFieldDishNameUpdate.setText("Tên món ăn");
                    jSpinnerCountUpdate.setValue(1);
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa món ăn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn món ăn để xóa!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBill() {
        if (JOptionPane.showConfirmDialog(this, "Xác nhận hủy hóa đơn?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
            if (HoaDonDAO.getInstance().removeBillByBillId(billId)) {
                if (BanDAO.getInstance().updateTableStatus(tableId, "Trống")) {
                    jButtonCreateBill.setEnabled(true);
                    jSpinnerCountAdd.setEnabled(false);
                    jButtonAddDish.setEnabled(false);
                    jButtonSubmit.setEnabled(false);
                    jSpinnerCountUpdate.setEnabled(false);
                    jButtonUpdate.setEnabled(false);
                    jButtonRemove.setEnabled(false);
                    jButtonDeleteBill.setEnabled(false);

                    defaultTableModelDishUpdate.setRowCount(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái bàn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void submitBill() {
        JOptionPane.showMessageDialog(this, "Đặt món thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        closeForm();
    }
}
