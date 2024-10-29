package DAO;

import DTO.TaiKhoanDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {

    private static TaiKhoanDAO instance;

    public static TaiKhoanDAO getInstance() {
        if (instance == null) {
            instance = new TaiKhoanDAO();
        }
        return instance;
    }

    private TaiKhoanDAO() {
    }

    public boolean Login(String tendangnhap, String matkhau) {
        String query = "SELECT * FROM TAIKHOAN WHERE BINARY_CHECKSUM(TENDANGNHAP) = BINARY_CHECKSUM(?) AND BINARY_CHECKSUM(MATKHAU) = BINARY_CHECKSUM(?)";
        String hashedPassword = hashWithMD5(matkhau);
        Object[] parameters = {tendangnhap, hashedPassword};
        try {
            ResultSet result = DataProvider.getInstance().executeQuery(query, parameters);
            return result.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String hashWithMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public TaiKhoanDTO layTKTheoTen(String tendangnhap) throws SQLException {
        String query = "EXEC USP_layTKtheoTenDN ?";
        DataProvider dataProvider = DataProvider.getInstance();
        TaiKhoanDTO acc = null;
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {
            pstmt.setString(1, tendangnhap);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    acc = new TaiKhoanDTO();
                    acc.setTendangnhap(rs.getString("TENDANGNHAP"));
                    acc.setManhanvien(rs.getString("MANHANVIEN"));
                    acc.setTenhienthi(rs.getString("TENHIENTHI"));
                    acc.setMatkhau(rs.getString("MATKHAU"));
                    acc.setTrangthai(rs.getString("TRANGTHAI"));
                    acc.setDaxoa(rs.getBoolean("DAXOA"));
                }
            } catch (Exception e) {
            }
        }
        return acc;
    }

    public boolean ThayDoiMK(String tendangnhap, String matkhaucu, String matkhaumoi) {
        String query = "{call USP_ChangePassword(?, ?, ?)}";
        Object[] parameters = {tendangnhap, matkhaucu, matkhaumoi};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<TaiKhoanDTO> layDSTK() throws SQLException {
        List<TaiKhoanDTO> listacc = new ArrayList<>();

        String query = "USP_GetListAccount";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                TaiKhoanDTO acc = new TaiKhoanDTO();
                acc.setTendangnhap(rs.getString("TENDANGNHAP"));
                acc.setManhanvien(rs.getString("MANHANVIEN"));
                acc.setTenhienthi(rs.getString("TENHIENTHI"));
                acc.setMatkhau(rs.getString("MATKHAU"));
                acc.setTrangthai(rs.getString("TRANGTHAI"));
                acc.setDaxoa(rs.getBoolean("DAXOA"));
                listacc.add(acc);
            }
        }
        return listacc;
    }

    public List<String> layDSMaNhanVien() {
        List<String> listMaNhanVien = new ArrayList<>();

        String query = "{call USP_GetListEmployeeByID}";
        try (Connection conn = DataProvider.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNhanVien = rs.getString("MANHANVIEN");
                listMaNhanVien.add(maNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaNhanVien;
    }

    public List<String> layDSTenNhanVien() {
        List<String> listMaNhanVien = new ArrayList<>();

        String query = "{call USP_GetListNameEmployee}";
        try (Connection conn = DataProvider.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNhanVien = rs.getString("TENHIENTHI");
                listMaNhanVien.add(maNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaNhanVien;
    }

    public List<String> layDSTrangThai() {
        List<String> listMaNhanVien = new ArrayList<>();

        String query = "{call USP_GetListStatus}";
        try (Connection conn = DataProvider.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNhanVien = rs.getString("TRANGTHAI");
                listMaNhanVien.add(maNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaNhanVien;
    }

    public boolean ResetPassWord(String tendangnhap) {
        String query = "EXEC USP_ResetPassWord ?";
        Object[] parameters = {tendangnhap};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themTK(String tendangnhap, String manhanvien, String tenhienthi, String trangthai) {
        String query = "EXEC USP_InsertAccount ?, ?, ?, ?";
        Object[] parameters = {tendangnhap, manhanvien, tenhienthi, trangthai};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public TaiKhoanDTO layDSTKtheoMaNV(String manhanvien) {
        String query = "EXEC USP_GetAccountByStaffID ?";
        Object[] paramaters = {manhanvien};

        try {
            ResultSet result = DataProvider.getInstance().executeQuery(query, paramaters);
            if (result.next()) {
                return new TaiKhoanDTO(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteTK(String tendangnhap) {
        String query = "EXEC USP_DeleteAccount ?";
        Object[] parameters = {tendangnhap};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaTK(String tendangnhap, String trangthai) {
        String query = "EXEC USP_UpdateAccount ?";
        Object[] parameters = {tendangnhap};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
