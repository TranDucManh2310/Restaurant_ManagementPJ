package DAO;

import DTO.ChiTietHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {

    private static ChiTietHoaDonDAO instance;

    public static ChiTietHoaDonDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietHoaDonDAO();
        }
        return instance;
    }

    private ChiTietHoaDonDAO() {
    }

    public List<ChiTietHoaDonDTO> layTKDSCTHD(int mahd) throws SQLException {
        List<ChiTietHoaDonDTO> listCTHD = new ArrayList<>();
        String query = "EXEC USP_GetBillInfoByBill ?";
        try (Connection con = DataProvider.getInstance().getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, mahd);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                    cthd.setMacthd(rs.getInt("MACHITIETHD"));
                    cthd.setMamonan(rs.getInt("MAMONAN"));
                    cthd.setMahoadon(rs.getInt("MAHOADON"));
                    cthd.setSoluong(rs.getInt("SOLUONG"));

                    listCTHD.add(cthd);
                }
            }
        }
        return listCTHD;
    }

    public boolean insertBillDetails(int dishId, int billId, int count) {
        String query = "{CALL USP_InsertBillDetails(?, ?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, dishId, billId, count);
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

    public ArrayList<ChiTietHoaDonDTO> getBillDetailsByBillId(int billId) {
        ArrayList<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<>();
        String query = "SELECT * FROM CHITIETHOADON WHERE MAHOADON = ?";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{billId});
            while (resultSet.next()) {
                chiTietHoaDonDTOs.add(new ChiTietHoaDonDTO(resultSet));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietHoaDonDTOs;
    }

    public boolean updateDishCountInBillDetail(int billId, int dishId, int count) {
        String query = "{CALL USP_UpdateDishCountInBillDetail(?, ?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, new Object[]{billId, dishId, count});
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
    
    public boolean removeDishFromBillDetail(int billId, int dishId) {
        String query = "{CALL USP_RemoveDishFromBillDetail(?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, billId, dishId);
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
