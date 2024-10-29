package view.manageform;

import DAO.BanDAO;
import DAO.HoaDonDAO;
import DTO.BanDTO;
import DTO.HoaDonDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ChuyenBan extends javax.swing.JFrame {

    Home home;
    private int tableIdSelected = -1;
    private JPanel tableSelected = null;
    private int newTableId = -1;
    private int oldTableId = -1;

    public ChuyenBan(int tableId, Home home) {
        initComponents();

        this.home = home;
        this.oldTableId = tableId;
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldOldId = new javax.swing.JTextField();
        jTextFieldOldName = new javax.swing.JTextField();
        jSpinnerOldNumberSeats = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldNewId = new javax.swing.JTextField();
        jTextFieldNewName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldNewNumberSeats = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldNewSatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanelTables = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(1244, 702));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/t1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Chuyển bàn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 10, 80, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 2, 40, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/checklist.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Thông tin bàn cũ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã bàn");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 55, 70, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tên bàn");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Số khách");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jTextFieldOldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldOldId.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextFieldOldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 240, 30));

        jTextFieldOldName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldOldName.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextFieldOldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 240, 30));

        jSpinnerOldNumberSeats.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jSpinnerOldNumberSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 360, 220));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/listadd.png"))); // NOI18N
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 41, 38));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Thông tin bàn mới");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 4, 200, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Mã bàn");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Tên bàn");

        jTextFieldNewId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNewId.setForeground(new java.awt.Color(51, 51, 51));

        jTextFieldNewName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNewName.setForeground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Số chỗ ngồi");

        jTextFieldNewNumberSeats.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNewNumberSeats.setForeground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Trạng thái");

        jTextFieldNewSatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNewSatus.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNewSatus))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNewNumberSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNewName)
                            .addComponent(jTextFieldNewId))))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNewId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNewName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNewNumberSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNewSatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 360, 320));

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Chuyển bàn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 630, 140, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Danh sách bàn");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTables.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Sảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 36), new java.awt.Color(51, 51, 51))); // NOI18N

        javax.swing.GroupLayout jPanelTablesLayout = new javax.swing.GroupLayout(jPanelTables);
        jPanelTables.setLayout(jPanelTablesLayout);
        jPanelTablesLayout.setHorizontalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanelTablesLayout.setVerticalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 850, 620));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/m1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 60, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         closeForm();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switchTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Giao diện (Không code được trong này)"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTables;
    private javax.swing.JSpinner jSpinnerOldNumberSeats;
    private javax.swing.JTextField jTextFieldNewId;
    private javax.swing.JTextField jTextFieldNewName;
    private javax.swing.JTextField jTextFieldNewNumberSeats;
    private javax.swing.JTextField jTextFieldNewSatus;
    private javax.swing.JTextField jTextFieldOldId;
    private javax.swing.JTextField jTextFieldOldName;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    private void load() {
        settingSppiner(jSpinnerOldNumberSeats);
        loadTable();
        loadOldTable();
    }

    private void loadOldTable() {
        if (oldTableId != -1) {
            BanDTO banDTO = BanDAO.getInstance().getTableById(oldTableId);
            if (banDTO != null) {
                jTextFieldOldId.setText(banDTO.getMaban() + "");
                jTextFieldOldName.setText("Bàn " + banDTO.getMaban());
                jSpinnerOldNumberSeats.setValue(banDTO.getSoluongnguoi());
            } else {
                JOptionPane.showMessageDialog(this, "Không thể lấy thông tin bàn cũ!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void settingSppiner(JSpinner jSpinner) {
        jSpinner.setValue(1);
        // Tạo một SpinnerModel tùy chỉnh để không cho phép số âm
        SpinnerNumberModel spinnerNumberModel = (SpinnerNumberModel) jSpinner.getModel();
        spinnerNumberModel.setMinimum(0);
    }

    private void deleteTab(JPanel jPanelTable) {
        jPanelTable.removeAll();
    }

    private void loadTable() {
        jPanelTables.setLayout(new GridLayout(3, 0));
        deleteTab(jPanelTables);
        ArrayList<BanDTO> banDTOs = BanDAO.getInstance().getTables();

        int size = banDTOs.size();

        for (int i = 0; i < size; i++) {
            if (banDTOs.get(i).getTrangthai().equals("Có người") || banDTOs.get(i).getTrangthai().equals("Đã đặt") || banDTOs.get(i).getMaban() == oldTableId) {
                banDTOs.remove(i);
                size = banDTOs.size();
                i--;
            }
        }

        JPanel jPanelRow = null;

        for (int i = 0; i < banDTOs.size(); i++) {
            // tạo 1 dòng trong danh sách bàn khi bắt đầu or sẽ tạo 1 dòng mới khi dòng cũ đã có 7 bàn
            if (i % 7 == 0) {
                jPanelRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
                // add dòng vào danh sách bàn
                jPanelTables.add(jPanelRow);
            }

            // Tạo bàn
            BanDTO tableChooserBanDTO = banDTOs.get(i);

            JPanel jPanelTable = new JPanel(new BorderLayout());

            if (tableChooserBanDTO.getMaban() == tableIdSelected) {
                jPanelTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.RED), "Bàn " + tableChooserBanDTO.getMaban(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
                tableSelected = jPanelTable;
                tableIdSelected = tableChooserBanDTO.getMaban();
            } else {
                jPanelTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "Bàn " + tableChooserBanDTO.getMaban(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
            }

            // gán icon cho bàn
            JLabel jLabelIcon = new JLabel();

            ImageIcon icon;
            if (tableChooserBanDTO.getTrangthai().equals("Có người")) {
                icon = new ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-table-50.png"));
            } else if (tableChooserBanDTO.getTrangthai().equals("Trống")) {
                icon = new ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-table-nobody-50.png"));
            } else if (tableChooserBanDTO.getTrangthai().equals("Đã đặt")) {
                icon = new ImageIcon(getClass().getResource("/view/icon/icons8-restaurant-table-haveorder-50.png"));
            } else {
                continue;
            }

            Image image = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            jLabelIcon.setIcon(new ImageIcon(image));

            jPanelTable.add(jLabelIcon, BorderLayout.CENTER);

            // đặt kích thước bàn
            jPanelTable.setPreferredSize(new Dimension(100, 100)); // Sử dụng setPreferredSize thay cho setSize

            // bắt sự kiện click cho từng bàn
            jPanelTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (tableSelected != null) {
                        tableSelected.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "Bàn " + tableIdSelected, TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
                    }

                    jPanelTable.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.RED), "Bàn " + tableChooserBanDTO.getMaban(), TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));

                    tableSelected = jPanelTable;
                    tableIdSelected = tableChooserBanDTO.getMaban();

                    newTableId = tableChooserBanDTO.getMaban();
                    loadNewTable();
                }

            });

            // add bàn vào dòng
            jPanelRow.add(jPanelTable);

        }

        jPanelTables.revalidate(); // Cập nhật bố cục
        jPanelTables.repaint();    // Vẽ lại
    }

    private void loadNewTable() {
        if (newTableId != -1) {
            BanDTO banDTO = BanDAO.getInstance().getTableById(newTableId);
            if (banDTO != null) {
                jTextFieldNewId.setText(banDTO.getMaban() + "");
                jTextFieldNewName.setText("Bàn " + banDTO.getMaban());
                jTextFieldNewNumberSeats.setText(banDTO.getSoluongnguoi() + "");
                jTextFieldNewSatus.setText(banDTO.getTrangthai());
            } else {
                JOptionPane.showMessageDialog(this, "Không thể lấy thông tin bàn mới!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void switchTable() {
        if (oldTableId == -1) {
            JOptionPane.showMessageDialog(this, "Không có thông tin bàn cũ!!!\nVui lòng kiểm tra lại!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newTableId == -1) {
            JOptionPane.showMessageDialog(this, "Không có thông tin bàn mới!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        HoaDonDTO hoaDonNew = HoaDonDAO.getInstance().getBillByTableId(newTableId);
        if (hoaDonNew == null) {
            HoaDonDTO hoaDonOld = HoaDonDAO.getInstance().getBillByTableId(oldTableId);
            if (hoaDonOld != null) {
                if (HoaDonDAO.getInstance().updateTableIdForBill(hoaDonOld.getMahoadon(), newTableId)) {
                    BanDAO.getInstance().updateTableStatus(newTableId, "Có người");
                    BanDAO.getInstance().updateTableStatus(oldTableId, "Trống");
                    JOptionPane.showMessageDialog(this, "Chuyển thàn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    closeForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Chuyển bàn không thành công!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bàn cũ chưa có hóa đơn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bàn mới đã tồn tại hóa đơn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void closeForm() {
        home.setVisible(true);
        home.reload();
        this.dispose();
    }
}
