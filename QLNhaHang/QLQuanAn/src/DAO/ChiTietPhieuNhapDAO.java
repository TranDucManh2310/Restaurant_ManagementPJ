package DAO;

import DTO.ChiTietPhieuNhapDTO;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChiTietPhieuNhapDAO {

    private static ChiTietPhieuNhapDAO instance;

    public static ChiTietPhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietPhieuNhapDAO();
        }
        return instance;
    }

    private ChiTietPhieuNhapDAO() {
    }

    // Phương thức để lưu thông tin chi tiết phiếu nhập vào bảng CHITIETPHIEUNHAP
    public void luuChiTietPhieuNhap(int maPhieuNhap, List<ChiTietPhieuNhapDTO> danhSachChiTiet) {
        String query = "INSERT INTO CHITIETPHIEUNHAP (MAPN, MANGUYENLIEU, DONGIANHAP, SOLUONGNHAP) VALUES (?, ?, ?, ?)";
        DataProvider dataProvider = DataProvider.getInstance();
        try (java.sql.Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            for (ChiTietPhieuNhapDTO chiTiet : danhSachChiTiet) {
                pstmt.setInt(1, maPhieuNhap);
                pstmt.setInt(2, chiTiet.getManguyenlieu());
                pstmt.setDouble(3, chiTiet.getDongianhap());
                pstmt.setInt(4, chiTiet.getSoluongnhap());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<ChiTietPhieuNhapDTO> layDSPNtheoMaPN(int mapn) throws SQLException {
        List<ChiTietPhieuNhapDTO> list = new ArrayList<>();

        String query = "EXEC USP_layDSCTPNtheoMa ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (java.sql.Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {
            pstmt.setInt(1, mapn);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
                    ctpn.setMactpn(rs.getInt("MACTPN"));
                    ctpn.setMapn(rs.getInt("MAPN"));
                    ctpn.setManguyenlieu(rs.getInt("MANGUYENLIEU"));
                    ctpn.setDongianhap(rs.getDouble("DONGIANHAP"));
                    ctpn.setSoluongnhap(rs.getInt("SOLUONGNHAP"));
                    list.add(ctpn);
                }
            }
        }
        return list;
    }
}
