package DAO;

import DTO.LoaiMonAnDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiMonAnDAO {

    private static LoaiMonAnDAO instance;

    public static LoaiMonAnDAO getInstance() {
        if (instance == null) {
            instance = new LoaiMonAnDAO();
        }
        return instance;
    }

    public LoaiMonAnDAO() {
    }

    public ArrayList<LoaiMonAnDTO> layDSLoaiMonAn() {
        ArrayList<LoaiMonAnDTO> list = new ArrayList<>();
        String query = "SELECT * FROM LOAIMONAN WHERE DAXOA = 0";
        try {
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LoaiMonAnDTO k = new LoaiMonAnDTO(rs);
                k.setMaloaimonan(rs.getInt("MALOAIMONAN"));
                k.setTenloaimonan(rs.getString("TENLOAIMONAN"));
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

    public int layMaTheoTenDcChon(String tenLoai) {
        int maLoai = -1;
        try {
            String query = "EXEC USP_GetMaLoaiMonAnByTenLoai ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, tenLoai);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                maLoai = rs.getInt(1);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maLoai;
    }

    public boolean xoaLoaiMonAn(int maLoai) {
        try {
            String query = "EXEC USP_XoaLoaiMonAn ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maLoai);
            int result = pstmt.executeUpdate();

            pstmt.close();
            con.close();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean themLoaiMonAn(String tenLoai) {
        try {
            String query = "EXEC USP_ThemLoaiMonAn ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, tenLoai);
            int result = pstmt.executeUpdate();

            pstmt.close();
            con.close();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean suaLoaiMonAn(int maLoai, String tenLoai) {
        try {
            String query = "EXEC USP_SuaLoaiMonAn ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maLoai);
            pstmt.setString(2, tenLoai);

            int result = pstmt.executeUpdate();

            pstmt.close();
            con.close();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<LoaiMonAnDTO> timLMATheoTen(String tenLMA) throws SQLException {
        List<LoaiMonAnDTO> listLMA = new ArrayList<>();
        String query = "EXEC USP_SearchLMAByName ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            // Đặt giá trị cho tham số
            pstmt.setString(1, tenLMA);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LoaiMonAnDTO lma = new LoaiMonAnDTO();
                    lma.setMaloaimonan(rs.getInt("MALOAIMONAN"));
                    lma.setTenloaimonan(rs.getString("TENLOAIMONAN"));   
                    lma.setDaxoa(rs.getBoolean("DAXOA"));
                    listLMA.add(lma);
                }
            }
        }
        return listLMA;
    }
    
    public ArrayList<LoaiMonAnDTO> getDishCategory() {
        ArrayList<LoaiMonAnDTO> loaiMonAnDTOs = new ArrayList<>();
        String query = "SELECT * FROM LOAIMONAN";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query);
            while (resultSet.next()) {
                loaiMonAnDTOs.add(new LoaiMonAnDTO(resultSet));
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
        return loaiMonAnDTOs;
    }
}
