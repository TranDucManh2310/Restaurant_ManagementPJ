package DAO;

import DTO.CongThucDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CongThucDAO {
     private static CongThucDAO instance;

    public static CongThucDAO getInstance() {
        if (instance == null) {
            instance = new CongThucDAO();
        }
        return instance;
    }

    public CongThucDAO() {
    }
    
    public ArrayList<CongThucDTO> layDSCThuc() {
        ArrayList<CongThucDTO> list = new ArrayList<>();
        String query = "SELECT CONGTHUC.*, MONAN.TENMONAN, NGUYENLIEU.TENNGUYENLIEU FROM CONGTHUC, MONAN, NGUYENLIEU WHERE  CONGTHUC.MAMONAN = MONAN.MAMONAN AND CONGTHUC.MANGUYENLIEU = NGUYENLIEU.MANGUYENLIEU";
        try {
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CongThucDTO k = new CongThucDTO(rs);
                k.setMamonan(rs.getInt("MAMONAN"));
                k.setMacongthuc(rs.getInt("MACONGTHUC"));
                k.setManguyenlieu(rs.getInt("MANGUYENLIEU"));
                k.setSoluong(rs.getInt("SOLUONG"));
                k.setDonvi(rs.getString("DONVI"));
                k.setTenmonan(rs.getString("TENMONAN"));
                k.setTennguyenlieu(rs.getString("TENNGUYENLIEU"));
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

    public int layMaMonAn(String tenMon) {
        int maMon = -1; // Khởi tạo mã món với giá trị mặc định

        try {
            String query = "EXEC USP_LayMaMon ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, tenMon);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                maMon = rs.getInt(1); // Lấy giá trị cột đầu tiên từ kết quả truy vấn
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maMon;
    }

    public int layMaNguyenLieu(String tenNgLieu) {
        int maNgLieu = -1; // Khởi tạo mã món với giá trị mặc định

        try {
            String query = "EXEC USP_LayMaNguyenLieu ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, tenNgLieu);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                maNgLieu = rs.getInt(1); // Lấy giá trị cột đầu tiên từ kết quả truy vấn
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maNgLieu;
    }

    public boolean themCThuc(int maMon, int maNgLieu, int sl, String donVi) {
        try {
            String query = "EXEC USP_ThemCongThuc ?, ?, ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maMon); 
            pstmt.setInt(2, maNgLieu); 
            pstmt.setInt(3, sl); 
            pstmt.setString(4, donVi);
            int rowsAffected = pstmt.executeUpdate(); 

            pstmt.close();
            con.close();

            if (rowsAffected > 0) {
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaCThuc(int maMon, int maNgLieu, int sl, String donVi) {
        try {
            String query = "EXEC USP_SuaCongThuc ?, ?, ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maMon); 
            pstmt.setInt(2, maNgLieu); 
            pstmt.setInt(3, sl); 
            pstmt.setString(4, donVi);
            int rowsAffected = pstmt.executeUpdate(); 

            pstmt.close();
            con.close();

            if (rowsAffected > 0) {
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaCThuc(int maMon) {
        try {
            String query = "EXEC USP_XoaCongThuc ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maMon); 
            int rowsAffected = pstmt.executeUpdate();

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
}
