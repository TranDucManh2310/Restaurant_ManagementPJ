package view.manageform;

import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DTO.BanDTO;
import DTO.ChiTietHoaDonDTO;
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
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GopBan extends javax.swing.JFrame {

    Home home;
    private ArrayList<Integer> tableIdTransfer = new ArrayList<>();
    private int tableIdSelected = -1;
    private JPanel tableSelected = null;
    private int newTableId = -1;
    private int oldTableId = -1;
    private int indexSelected = -1;
    
    public GopBan(int tableId, Home home) {
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
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldOldArea = new javax.swing.JTextField();
        jTextFieldOldId = new javax.swing.JTextField();
        jTextFieldOldName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanelTables = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelTransfer = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jLabelCombine = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTables = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/t1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Gộp bàn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 6, 59, 32));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 6, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/checklist.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Thông tin bàn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tên khu vực");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mã bàn");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tên bàn");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jTextFieldOldArea.setEditable(false);
        jTextFieldOldArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldOldArea.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldOldArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 160, 30));

        jTextFieldOldId.setEditable(false);
        jTextFieldOldId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldOldId.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldOldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, 30));

        jTextFieldOldName.setEditable(false);
        jTextFieldOldName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldOldName.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldOldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 46, 610, 130));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/list_3176366.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Danh sách bàn có thể gộp");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTables.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Sảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 36), new java.awt.Color(51, 51, 51))); // NOI18N

        javax.swing.GroupLayout jPanelTablesLayout = new javax.swing.GroupLayout(jPanelTables);
        jPanelTables.setLayout(jPanelTablesLayout);
        jPanelTablesLayout.setHorizontalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanelTablesLayout.setVerticalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 192, 610, 420));

        jLabelTransfer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/right.png"))); // NOI18N
        jLabelTransfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTransferMouseClicked(evt);
            }
        });

        jLabelBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/left.png"))); // NOI18N
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });

        jLabelCombine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCombine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/ok.png"))); // NOI18N
        jLabelCombine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCombineMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCombine, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabelTransfer)
                .addGap(27, 27, 27)
                .addComponent(jLabelBack)
                .addGap(27, 27, 27)
                .addComponent(jLabelCombine)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 137, 110, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/l1.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Danh sách sẽ gộp");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListTables.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListTables.setForeground(new java.awt.Color(0, 0, 0));
        jListTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListTables);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 46, 390, 566));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        closeForm();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabelTransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTransferMouseClicked
        transferTable();
    }//GEN-LAST:event_jLabelTransferMouseClicked

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        backTable();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jLabelCombineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCombineMouseClicked
        combineTable();
    }//GEN-LAST:event_jLabelCombineMouseClicked

    private void jListTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTablesMouseClicked
        selectTableToBack();
    }//GEN-LAST:event_jListTablesMouseClicked

    //<editor-fold defaultstate="collapsed" desc="Giao diện (Không code được trong này)">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelCombine;
    private javax.swing.JLabel jLabelTransfer;
    private javax.swing.JList<String> jListTables;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelTables;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldOldArea;
    private javax.swing.JTextField jTextFieldOldId;
    private javax.swing.JTextField jTextFieldOldName;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    private void load() {
        jLabelTransfer.setEnabled(false);
        jLabelCombine.setEnabled(false);
        jLabelBack.setEnabled(false);
        jListTables.removeAll();
        loadOldTable();

        ArrayList<BanDTO> banDTOs = BanDAO.getInstance().getTables();
        int size = banDTOs.size();

        for (int i = 0; i < size; i++) {
            if (banDTOs.get(i).getTrangthai().equals("Trống") || banDTOs.get(i).getTrangthai().equals("Đã đặt") || banDTOs.get(i).getMaban() == oldTableId) {
                banDTOs.remove(i);
                size = banDTOs.size();
                i--;
            }
        }

        loadTable(banDTOs);
    }
    
    private void loadOldTable() {
        if (oldTableId != -1) {
            BanDTO banDTO = BanDAO.getInstance().getTableById(oldTableId);
            if (banDTO != null) {
                jTextFieldOldId.setText(banDTO.getMaban() + "");
                jTextFieldOldName.setText("Bàn " + banDTO.getMaban());
                jTextFieldOldArea.setText("Sãnh chính");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể lấy thông tin bàn cũ!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void deleteTab(JPanel jPanelTable) {
        jPanelTable.removeAll();
    }
    
    private void loadTable(ArrayList<BanDTO> banDTOs) {
        jPanelTables.setLayout(new GridLayout(3, 0));
        deleteTab(jPanelTables);

        JPanel jPanelRow = null;

        for (int i = 0; i < banDTOs.size(); i++) {
            // tạo 1 dòng trong danh sách bàn khi bắt đầu or sẽ tạo 1 dòng mới khi dòng cũ đã có 7 bàn
            if (i % 6 == 0) {
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

            Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            jLabelIcon.setIcon(new ImageIcon(image));

            jPanelTable.add(jLabelIcon, BorderLayout.CENTER);

            // đặt kích thước bàn
            jPanelTable.setPreferredSize(new Dimension(80, 80)); // Sử dụng setPreferredSize thay cho setSize

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
                    jLabelTransfer.setEnabled(true);

                    // bỏ chọn item trên jListTable
                    jListTables.removeSelectionInterval(indexSelected, indexSelected);
                    indexSelected = -1;
                    jLabelBack.setEnabled(false);
                }

            });

            // add bàn vào dòng
            jPanelRow.add(jPanelTable);

        }

        jPanelTables.revalidate(); // Cập nhật bố cục
        jPanelTables.repaint();    // Vẽ lại
    }
    
    private void checkCombine() {
        if (tableIdTransfer.size() > 0) {
            jLabelCombine.setEnabled(true);
        } else {
            jLabelCombine.setEnabled(false);
        }
    }
    
    private void transferTable() {
        if (newTableId != -1) {
            jListTables.removeAll();
            tableIdTransfer.add(newTableId);

            // bỏ sự lựa chọn trên jPanelTables
            tableIdSelected = -1;
            tableSelected = null;
            loadTableAndListTable();

            newTableId = -1;
            jLabelTransfer.setEnabled(false);

            checkCombine();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn bàn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadTableAndListTable() {
        Collections.sort(tableIdTransfer);

        ArrayList<BanDTO> banDTOs = BanDAO.getInstance().getTables();
        int size = banDTOs.size();

        for (int i = 0; i < size; i++) {
            if (banDTOs.get(i).getTrangthai().equals("Trống") || banDTOs.get(i).getTrangthai().equals("Đã đặt") || banDTOs.get(i).getMaban() == oldTableId) {
                banDTOs.remove(i);
                size = banDTOs.size();
                i--;
            }
        }

        DefaultListModel defaultListModelTables = new DefaultListModel();

        for (Integer tableId : tableIdTransfer) {
            for (int i = 0; i < size; i++) {
                if (banDTOs.get(i).getMaban() == tableId) {
                    banDTOs.remove(i);
                    size = banDTOs.size();
                    i--;
                }
            }
            defaultListModelTables.addElement("Bàn " + tableId);
        }

        jListTables.setModel(defaultListModelTables);
        loadTable(banDTOs);
    }
    
    private void backTable() {
        if (indexSelected >= 0) {
            jListTables.removeAll();
            tableIdTransfer.remove(indexSelected);

            // bỏ sự lựa chọn trên jPanelTables
            tableIdSelected = -1;
            tableSelected = null;
            loadTableAndListTable();

            indexSelected = -1;
            jLabelBack.setEnabled(false);

            checkCombine();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn bàn!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean combine(int transferTableId, int destinationTableId) {
        try {
            HoaDonDTO hoaDonDestination = HoaDonDAO.getInstance().getBillByTableId(destinationTableId);
            if (hoaDonDestination == null) {
                throw new Exception("Không thế lấy hóa đơn bàn " + destinationTableId);
            }
            ArrayList<ChiTietHoaDonDTO> chiTietHoaDonDestination = ChiTietHoaDonDAO.getInstance().getBillDetailsByBillId(hoaDonDestination.getMahoadon());

            HoaDonDTO hoaDonTransfer = HoaDonDAO.getInstance().getBillByTableId(transferTableId);
            if (hoaDonTransfer == null) {
                throw new Exception("Không thế lấy hóa đơn bàn " + transferTableId);
            }
            ArrayList<ChiTietHoaDonDTO> chiTietHoaDonTransfer = ChiTietHoaDonDAO.getInstance().getBillDetailsByBillId(hoaDonTransfer.getMahoadon());

            // x: chi tiết của hóa đơn bị xóa
            // y: chi tiết của hóa đơn được cập nhật chi tiết hoặc thêm chi tiết
            for (ChiTietHoaDonDTO x : chiTietHoaDonTransfer) {
                int check = 0;
                int billId = 0;
                int dishId = 0;
                int count = 0;
                int temp = 0;

                for (ChiTietHoaDonDTO y : chiTietHoaDonDestination) {
                    if (x.getMamonan() == y.getMamonan()) {
                        check = 1;
                        temp = y.getSoluong();
                    }
                    billId = y.getMahoadon();
                }

                dishId = x.getMamonan();
                count = x.getSoluong();

                if (check == 0) {
                    if (!(ChiTietHoaDonDAO.getInstance().insertBillDetails(dishId, billId, count))) {
                        throw new Exception("Có lỗi trong quá trình sửa hóa đơn!");
                    }
                } else {
                    int sumCount = temp + count;
                    if (!(ChiTietHoaDonDAO.getInstance().updateDishCountInBillDetail(billId, dishId, sumCount))) {
                        throw new Exception("Có lỗi trong quá trình sửa hóa đơn!");
                    }
                }

                if (!(HoaDonDAO.getInstance().removeBillByBillId(x.getMahoadon()))) {
                    throw new Exception("Có lỗi trong quá trình xóa hóa đơn!");
                }

                if (!(BanDAO.getInstance().updateTableStatus(transferTableId, "Trống"))) {
                    throw new Exception("Có lỗi trong quá trình cập nhật trạng thái bàn!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void combineTable() {
        int size = tableIdTransfer.size();
        int flag = 0;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (!combine(tableIdTransfer.get(i), oldTableId)) {
                    flag = 1;
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Danh sách gộp bàn trống!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (flag == 0) {
            JOptionPane.showMessageDialog(this, "Gộp bàn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng thử lại!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        closeForm();
    }
    
    private void selectTableToBack() {
        int index = jListTables.getSelectedIndex();
        if (index >= 0) {
            jLabelBack.setEnabled(true);
            indexSelected = index;

            // bỏ chọn item trên jListTable
            if (tableSelected != null) {
                tableSelected.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "Bàn" + tableIdSelected, TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
            }
            newTableId = -1;
            jLabelTransfer.setEnabled(false);
        }
    }
    
    private void closeForm() {
        home.setVisible(true);
        home.reload();
        this.dispose();
    }
}
