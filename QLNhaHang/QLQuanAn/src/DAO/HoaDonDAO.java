package DAO;

import DTO.HoaDonDTO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class HoaDonDAO {

    private static HoaDonDAO instance;

    public static HoaDonDAO getInstance() {
        if (instance == null) {
            instance = new HoaDonDAO();
        }
        return instance;
    }

    private HoaDonDAO() {
    }

    public List<HoaDonDTO> layTKDSHD(java.util.Date ngaybatdau, java.util.Date ngayketthuc) throws SQLException {
        List<HoaDonDTO> listHD = new ArrayList<>();
        String query = "EXEC USP_GetListBillByDateOut ?, ?";
        try (Connection con = DataProvider.getInstance().getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            // Chuyển đổi ngày bắt đầu và ngày kết thúc sang java.sql.Date
            java.sql.Date startDate = new java.sql.Date(ngaybatdau.getTime());
            java.sql.Date endDate = new java.sql.Date(ngayketthuc.getTime());

            pstmt.setDate(1, startDate);
            pstmt.setDate(2, endDate);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMahoadon(rs.getInt("MAHOADON"));
                    hd.setMaban(rs.getInt("MABAN"));
                    hd.setManhanvien(rs.getString("MANHANVIEN"));
                    hd.setNgayvao(rs.getTimestamp("NGAYVAO"));
                    hd.setNgayra(rs.getTimestamp("NGAYRA"));
                    hd.setGiamgia(rs.getInt("GIAMGIA"));
                    hd.setThanhtien(rs.getDouble("THANHTIEN"));
                    hd.setDaxoa(rs.getBoolean("DAXOA"));

                    listHD.add(hd);
                }
            }
        }
        return listHD;
    }

    public List<HoaDonDTO> layTKDSHDtheoTenNV(java.util.Date dateNgayBatDau, java.util.Date dateNgayKetThuc, String manv) throws SQLException {
        List<HoaDonDTO> listHD = new ArrayList<>();
        String query = "EXEC USP_GetListBillByDateOutAndStaff ?, ?, ?";
        try (Connection con = DataProvider.getInstance().getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            // Chuyển đổi ngày bắt đầu và ngày kết thúc sang java.sql.Date
            java.sql.Date startDate = new java.sql.Date(dateNgayBatDau.getTime());
            java.sql.Date endDate = new java.sql.Date(dateNgayKetThuc.getTime());

            pstmt.setDate(1, startDate);
            pstmt.setDate(2, endDate);
            pstmt.setString(3, manv);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMahoadon(rs.getInt("MAHOADON"));
                    hd.setMaban(rs.getInt("MABAN"));
                    hd.setManhanvien(rs.getString("MANHANVIEN"));
                    hd.setNgayvao(rs.getTimestamp("NGAYVAO"));
                    hd.setNgayra(rs.getTimestamp("NGAYRA"));
                    hd.setGiamgia(rs.getInt("GIAMGIA"));
                    hd.setThanhtien(rs.getDouble("THANHTIEN"));
                    hd.setDaxoa(rs.getBoolean("DAXOA"));

                    listHD.add(hd);
                }
            }
        }
        return listHD;
    }

    public boolean createBill(int tableId, String staffId, Timestamp dateIn, Timestamp dateOut, int discount, double total) {
        String query = "{CALL USP_CreateBill(?, ?, ?, ?, ?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, tableId, staffId, dateIn, dateOut, discount, total);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public HoaDonDTO getBillByTableId(int tableId) {
        HoaDonDTO hoaDonDTO = null;
        String query = "SELECT * FROM HOADON WHERE MABAN = ? AND NGAYRA IS NULL AND DAXOA = 0";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{tableId});
            while (resultSet.next()) {
                hoaDonDTO = new HoaDonDTO(resultSet);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonDTO;
    }

    public boolean removeBillByBillId(int billId) {
        String query = "UPDATE HOADON SET DAXOA = 1 WHERE MAHOADON = ?";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, billId);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTableIdForBill(int billId, int tableId) {
        String query = "{CALL USP_UpdateTableIdForBill(?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, billId, tableId);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updatePaymentInvoices(int tableId, Timestamp dateOut, double total) {
        String query = "UPDATE HOADON SET NGAYRA = ?, THANHTIEN = ? WHERE MAHOADON = ?";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, dateOut, total, tableId);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
