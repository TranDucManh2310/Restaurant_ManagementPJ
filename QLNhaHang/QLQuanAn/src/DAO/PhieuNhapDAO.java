package DAO;

import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhieuNhapDAO {

    private static PhieuNhapDAO instance;

    public static PhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new PhieuNhapDAO();
        }
        return instance;
    }

    public PhieuNhapDAO() {
    }

    // Phương thức để tạo phiếu nhập mới trong bảng PHIEUNHAP
    public int taoPhieuNhap(int maNCC, Date ngayNhap) {
        int maPhieuNhap = -1;
        try {
            String query = "INSERT INTO PHIEUNHAP (MANCC, NGAYNHAP, DAXOA) VALUES (?, ?, 0)";
            DataProvider dataProvider = DataProvider.getInstance();
            try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, maNCC);
                pstmt.setDate(2, new java.sql.Date(ngayNhap.getTime()));
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    maPhieuNhap = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maPhieuNhap;
    }

    public List<PhieuNhapDTO> layDSPN() throws SQLException {
        List<PhieuNhapDTO> list = new ArrayList<>();

        String query = "EXEC USP_layDSPN";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO();
                pn.setMapn(rs.getInt("MAPN"));
                pn.setMancc(rs.getInt("MANCC"));
                pn.setNgaynhap(rs.getDate("NGAYNHAP"));
                pn.setDaxoa(rs.getBoolean("DAXOA"));
                list.add(pn);
            }
        }
        return list;
    }

    public List<PhieuNhapDTO> timDSPNTheoNgay(Date ngay) throws SQLException {
        List<PhieuNhapDTO> list = new ArrayList<>();

        String query = "EXEC USP_layDSPNtheoNgayNhap ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {
            java.sql.Date startDate = new java.sql.Date(ngay.getTime());
            pstmt.setDate(1, startDate);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PhieuNhapDTO pn = new PhieuNhapDTO();
                    pn.setMapn(rs.getInt("MAPN"));
                    pn.setMancc(rs.getInt("MANCC"));
                    pn.setNgaynhap(rs.getDate("NGAYNHAP"));
                    pn.setDaxoa(rs.getBoolean("DAXOA"));
                    list.add(pn);
                }
            }
        }
        return list;
    }
    
    public List<PhieuNhapDTO> timDSPNTheoMa(int mapn) throws SQLException {
        List<PhieuNhapDTO> list = new ArrayList<>();

        String query = "EXEC USP_layDSPNtheoMa ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {
            pstmt.setInt(1, mapn);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PhieuNhapDTO pn = new PhieuNhapDTO();
                    pn.setMapn(rs.getInt("MAPN"));
                    pn.setMancc(rs.getInt("MANCC"));
                    pn.setNgaynhap(rs.getDate("NGAYNHAP"));
                    pn.setDaxoa(rs.getBoolean("DAXOA"));
                    list.add(pn);
                }
            }
        }
        return list;
    }
}
