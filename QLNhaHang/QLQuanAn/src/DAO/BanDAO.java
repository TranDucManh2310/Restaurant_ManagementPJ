package DAO;

import DTO.BanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BanDAO {

    private static BanDAO instance;

    public static BanDAO getInstance() {
        if (instance == null) {
            instance = new BanDAO();
        }
        return instance;
    }

    public BanDAO() {
    }
    public ArrayList<BanDTO> layDSBan() {
        ArrayList<BanDTO> list = new ArrayList<>();
        String query = "SELECT * FROM BAN WHERE DAXOA = 0";
        try {
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                BanDTO k = new BanDTO(rs);
                k.setMaban(rs.getInt("MABAN"));
                k.setSoluongnguoi(rs.getInt("SOLUONGNGUOI"));
                k.setTrangthai(rs.getString("TRANGTHAI"));
                k.setDaxoa(rs.getBoolean("DAXOA"));
                list.add(k);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public BanDTO layTTTheoMaBan(int maBan) {
        BanDTO ban = null;
        try {
            String query = "EXEC USP_layTTTheoMaBan ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maBan);
            ResultSet rs = pstmt.executeQuery(); // Thực hiện truy vấn SELECT

            if (rs.next()) {
                ban = new BanDTO(rs); // Sử dụng constructor của BanDTO với ResultSet
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban;
    }

    public boolean xoaBan(int maBan) {
        try {
            String query = "EXEC USP_XoaBan ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maBan);
            int rowsAffected = pstmt.executeUpdate(); // Thực hiện truy vấn UPDATE

            pstmt.close();
            con.close();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean themBan(int soLuongNguoi, String trangThai) {
        try {
            String query = "EXEC USP_ThemBan ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, soLuongNguoi);
            pstmt.setString(2, trangThai);
            int rowsAffected = pstmt.executeUpdate(); 
            if (rowsAffected > 0) {
                return true;
            }
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhatBan(int maBan, int soLuong, String trangThai) {
        try {
            String query = "EXEC USP_CapNhatBan ?, ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maBan);
            pstmt.setInt(2, soLuong);
            pstmt.setString(3, trangThai);
            int rowsAffected = pstmt.executeUpdate(); // Thực hiện truy vấn UPDATE

            pstmt.close();
            con.close();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateTableStatus(int tableId, String status) {
        String query = "{CALL USP_UpdateTableStatus(?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, tableId, status);
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
    
    public ArrayList<BanDTO> getTables() {
        ArrayList<BanDTO> banDTOs = new ArrayList<>();
        String query = "SELECT * FROM Ban";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query);
            while (resultSet.next()) {
                banDTOs.add(new BanDTO(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return banDTOs;
    }
    
    public BanDTO getTableById(int id) {
        BanDTO banDTO = null;
        String query = "{CALL USP_GetTableById(?)}";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{id});
            while (resultSet.next()) {
                banDTO = new BanDTO(resultSet);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return banDTO;
    }
}
