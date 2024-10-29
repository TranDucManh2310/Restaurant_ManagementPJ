
package view.manageform;

import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.DataProvider;
import DAO.HoaDonDAO;
import DAO.MonAnDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.MonAnDTO;
import DTO.NumToVND;
import DTO.Utils;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class XuatHoaDon extends javax.swing.JFrame {

    private int idTable = -1;
    private Home home;
    private double totalTemp = 0;
    private double totalVAT = 0;
    private double total = 0;
    private int billId = -1;

    public XuatHoaDon(int idTable, Home home) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.idTable = idTable;
        this.home = home;

        jButtonExport.setEnabled(false);

        loadInfor();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTable = new javax.swing.JTextField();
        jButtonExport = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTotalMoneyTemp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldVAT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTotalMoney = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÔNG TIN TẠM TÍNH");

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setForeground(new java.awt.Color(0, 3, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/table.png"))); // NOI18N
        jLabel2.setText("Bàn:");

        jTextFieldTable.setEditable(false);
        jTextFieldTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButtonExport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/receipt.png"))); // NOI18N
        jButtonExport.setText("Xuất");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icons8-cancel-32.png"))); // NOI18N
        jButtonCancel.setText("Hủy");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/money.png"))); // NOI18N
        jLabel6.setText("Tổng tiền tạm tính:");

        jTextFieldTotalMoneyTemp.setEditable(false);
        jTextFieldTotalMoneyTemp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldTotalMoneyTemp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/vat.png"))); // NOI18N
        jLabel7.setText("VAT:");

        jTextFieldVAT.setEditable(false);
        jTextFieldVAT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldVAT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/pay.png"))); // NOI18N
        jLabel8.setText("Tổng tiền:");

        jTextFieldTotalMoney.setEditable(false);
        jTextFieldTotalMoney.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldTotalMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExport)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTotalMoney)
                            .addComponent(jTextFieldVAT)
                            .addComponent(jTextFieldTable)
                            .addComponent(jTextFieldTotalMoneyTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotalMoneyTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancel))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(219, 219, 219))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        try {
            closeForm();
        } catch (SQLException ex) {
            Logger.getLogger(XuatHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            closeForm();
        } catch (SQLException ex) {
            Logger.getLogger(XuatHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        exportBill();
    }//GEN-LAST:event_jButtonExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldTable;
    private javax.swing.JTextField jTextFieldTotalMoney;
    private javax.swing.JTextField jTextFieldTotalMoneyTemp;
    private javax.swing.JTextField jTextFieldVAT;
    // End of variables declaration//GEN-END:variables

    private void loadInfor() {
        if (idTable != -1) {
            jTextFieldTable.setText(Integer.toString(idTable));

            HoaDonDTO hoaDonDTO = HoaDonDAO.getInstance().getBillByTableId(idTable);
            if (hoaDonDTO != null) {

                billId = hoaDonDTO.getMahoadon();
                totalTemp = 0;

                ArrayList<ChiTietHoaDonDTO> chiTietHoaDonDTOs = ChiTietHoaDonDAO.getInstance().getBillDetailsByBillId(hoaDonDTO.getMahoadon());

                if (chiTietHoaDonDTOs.size() > 0) {
                    jButtonExport.setEnabled(true);
                    
                    for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDonDTOs) {
                        MonAnDTO monAnDTO = MonAnDAO.getInstance().getDishById(chiTietHoaDonDTO.getMamonan());

                        if (monAnDTO != null) {
                            totalTemp += monAnDTO.getDongia() * chiTietHoaDonDTO.getSoluong();
                        }
                    }
                }

                totalVAT = calculateVAT(totalTemp);
                total = totalTemp + totalVAT;

                jTextFieldTotalMoneyTemp.setText(Utils.VNDCurrencyFormat(totalTemp));
                jTextFieldVAT.setText(Utils.VNDCurrencyFormat(totalVAT));
                jTextFieldTotalMoney.setText(Utils.VNDCurrencyFormat(total));
            }
        }
    }

    private double calculateVAT(double totalMoney) {
        return totalMoney * 0.1;
    }

   private void exportBill() {
        try {
            HoaDonDAO.getInstance().updatePaymentInvoices(billId, Timestamp.valueOf(LocalDateTime.now()), total);

            Hashtable<String, Object> map = new Hashtable<>();

            // Sử dụng ClassLoader để tải tài nguyên từ JAR
            InputStream inputStream = getClass().getResourceAsStream("/view/report/rptHoaDon.jrxml");
            if (inputStream == null) {
                throw new FileNotFoundException("File not found in classpath: /view/report/rptHoaDon.jrxml");
            }

            // Tải và biên dịch báo cáo từ InputStream
            JasperReport report = JasperCompileManager.compileReport(inputStream);

            // Đóng InputStream sau khi sử dụng
            inputStream.close();

            map.put("BangChu", NumToVND.num2String((long) total) + " đồng.");
            map.put("MAHD", billId);
            map.put("TongTienTruocThue", totalTemp);
            map.put("VAT", totalVAT);

            JasperPrint p = JasperFillManager.fillReport(report, map, new DataProvider().getConnection());
            JasperViewer.viewReport(p, false);

            HoaDonDAO.getInstance().removeBillByBillId(billId);
            BanDAO.getInstance().updateTableStatus(idTable, "Trống");

            closeForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeForm() throws SQLException {
        dispose();
        home.reload();
        home.loadDateTK();
        home.loadFirstPage();
        home.loadDataChange_NV();
        home.loadFirstPage_NV();
    }
}
