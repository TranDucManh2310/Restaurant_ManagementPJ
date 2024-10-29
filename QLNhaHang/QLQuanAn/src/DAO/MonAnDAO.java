package DAO;

import DTO.MonAnDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MonAnDAO {

    private static MonAnDAO instance;

    public static MonAnDAO getInstance() {
        if (instance == null) {
            instance = new MonAnDAO();
        }
        return instance;
    }

    public MonAnDAO() {
    }

    public ArrayList<MonAnDTO> layDSMon() {
        ArrayList<MonAnDTO> list = new ArrayList<>();
        String query = "SELECT * FROM MONAN WHERE DAXOA = 0";
        try {
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MonAnDTO k = new MonAnDTO(rs);
                k.setMamonan(rs.getInt("MAMONAN"));
                k.setMaloaimonan(rs.getInt("MALOAIMONAN"));
                k.setTenmonan(rs.getString("TENMONAN"));
                k.setDvt(rs.getString("DVT"));
                k.setDongia(rs.getDouble("DONGIA"));
                k.setHinhanh(rs.getString("HINHANH"));
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

    public ArrayList<MonAnDTO> layDSMonDcTK(String tenMon) {
        ArrayList<MonAnDTO> list = new ArrayList<>();
        String query = "EXEC GetMonAnByLoaiMonAn ?";
        try {
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, tenMon); // Gán giá trị cho tham số tenMon
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MonAnDTO k = new MonAnDTO(rs);
                k.setMamonan(rs.getInt("MAMONAN"));
                k.setMaloaimonan(rs.getInt("MALOAIMONAN"));
                k.setTenmonan(rs.getString("TENMONAN"));
                k.setDvt(rs.getString("DVT"));
                k.setDongia(rs.getDouble("DONGIA"));
                k.setHinhanh(rs.getString("HINHANH"));
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
     public String layTenLoaiTheoMaMon(int maMon) {
        try {
            String query = "EXEC USP_LayTenLoaiTheoMaMon ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maMon);
            ResultSet rs = pstmt.executeQuery(); // Thực hiện truy vấn SELECT

            String tenLoai = null;
            if (rs.next()) {
                tenLoai = rs.getString("TENLOAIMONAN"); // Lấy giá trị tên loại từ ResultSet
            }

            rs.close();
            pstmt.close();
            con.close();

            return tenLoai; // Trả về tên loại
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean xoaMonAn(int maLoai) {
        try {
            String query = "EXEC USP_XoaMonAn ?";
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

    public boolean themMonAn(int maLoai, String tenMon, String unit, double gia, String images) {
        try {
            String query = "EXEC USP_ThemMonAn ?, ?, ?, ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maLoai);
            pstmt.setString(2, tenMon);
            pstmt.setString(3, unit);
            pstmt.setDouble(4, gia);
            pstmt.setString(5, images);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            con.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhatMonAn(int maLoai, int maMon, String tenMon, String unit, double gia, String images) {
        try {
            String query = "EXEC USP_CapNhatMonAn ?, ?, ?, ?, ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maLoai);
            pstmt.setInt(2, maMon);
            pstmt.setString(3, tenMon);
            pstmt.setString(4, unit);
            pstmt.setDouble(5, gia);
            pstmt.setString(6, images);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            con.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public MonAnDTO getDishById(int id) {
        MonAnDTO monAnDTO = null;
        String query = "{CALL USP_GetDishById(?)}";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{id});
            while (resultSet.next()) {
                monAnDTO = new MonAnDTO(resultSet);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monAnDTO;
    }
    
    public ArrayList<MonAnDTO> getDishs() {
        ArrayList<MonAnDTO> monAnDTOs = new ArrayList<>();
        String query = "SELECT * FROM MONAN";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query);
            while (resultSet.next()) {
                monAnDTOs.add(new MonAnDTO(resultSet));
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
        return monAnDTOs;
    }
    
    public ArrayList<MonAnDTO> searchDishByKeyWord(String keyWord) {
        ArrayList<MonAnDTO> monAnDTOs = new ArrayList<>();
        String query = "{CALL USP_SearchDishByKeyWord(?)}";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{keyWord});
            while (resultSet.next()) {
                monAnDTOs.add(new MonAnDTO(resultSet));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return monAnDTOs;
    }
    
    public ArrayList<MonAnDTO> searchDishByKeyWordAndCategory(String keyWord, String category) {
        ArrayList<MonAnDTO> monAnDTOs = new ArrayList<>();
        String query = "{CALL USP_SearchDishByKeyWordAndCategory(?, ?)}";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{keyWord, category});
            while (resultSet.next()) {
                monAnDTOs.add(new MonAnDTO(resultSet));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return monAnDTOs;
    }
}
