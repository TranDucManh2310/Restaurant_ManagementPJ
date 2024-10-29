package DAO;

import DTO.NguyenLieuDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

public class NguyenLieuDAO {

    private static NguyenLieuDAO instance;

    public static NguyenLieuDAO getInstance() {
        if (instance == null) {
            instance = new NguyenLieuDAO();
        }
        return instance;
    }

    public NguyenLieuDAO() {
    }

    public ArrayList<NguyenLieuDTO> layDSNLieu() {
        ArrayList<NguyenLieuDTO> list = new ArrayList<>();
        String query = "SELECT * FROM NGUYENLIEU WHERE DAXOA = 0";
        try {
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                NguyenLieuDTO k = new NguyenLieuDTO(rs);
                k.setManguyenlieu(rs.getInt("MANGUYENLIEU"));
                k.setTennguyenlieu(rs.getString("TENNGUYENLIEU"));
                k.setSoluong(rs.getInt("SOLUONG"));
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

    public boolean xoaNgLieu(int nglieu) {
        try {
            String query = "EXEC USP_XoaNgLieu ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, nglieu);
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

    public boolean themNgLieu(String TENNL) {
        try {
            String query = "EXEC USP_ThemNgLieu ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, TENNL);
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

    public boolean capNhatNgLieu(int manl, String TENNL) {
        try {
            String query = "EXEC USP_CapNhatNgLieu ?, ?";
            Connection con = DataProvider.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, manl);
            pstmt.setString(2, TENNL);
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

    public List<NguyenLieuDTO> layDSNguyenLieuTheoMaNCC(int mancc) throws SQLException {
        List<NguyenLieuDTO> listNL = new ArrayList<>();

        String query = "EXEC USP_layDSNguyenLieuTheoMaNCC ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, mancc);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    NguyenLieuDTO nl = new NguyenLieuDTO();
                    nl.setManguyenlieu(rs.getInt("MANGUYENLIEU"));
                    nl.setMancc(rs.getInt("MANCC"));
                    nl.setTennguyenlieu(rs.getString("TENNGUYENLIEU"));
                    nl.setSoluong(rs.getInt("SOLUONG"));
                    nl.setDaxoa(rs.getBoolean("DAXOA"));

                    listNL.add(nl);
                }
            }
        }
        return listNL;
    }

    public int layMaNLTheoTen(String tenNL) {
        int maNCC = -1;
        try {
            String query = "SELECT MANGUYENLIEU FROM NGUYENLIEU WHERE TENNGUYENLIEU = ?";
            DataProvider dataProvider = DataProvider.getInstance();
            try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, tenNL);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        maNCC = rs.getInt("MANGUYENLIEU");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maNCC;
    }
}
