package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVienDAO {

    private static NhanVienDAO instance;

    public static NhanVienDAO getInstance() {
        if (instance == null) {
            instance = new NhanVienDAO();
        }
        return instance;
    }

    public NhanVienDAO() {
    }

    public List<NhanVienDTO> layDSNV() throws SQLException {
        List<NhanVienDTO> listNV = new ArrayList<>();

        String query = "USP_GetListEmployee";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setManhanvien(rs.getString("MANHANVIEN"));
                nv.setHoten(rs.getString("HOTEN"));
                nv.setPhai(rs.getString("PHAI"));
                nv.setNgaysinh(rs.getDate("NGAYSINH"));
                nv.setDiachi(rs.getString("DIACHI"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgayvaolam(rs.getDate("NGAYVAOLAM"));
                nv.setLuongcoban(rs.getDouble("LUONGCOBAN"));
                nv.setDaxoa(rs.getBoolean("DAXOA"));
                listNV.add(nv);
            }
        }
        return listNV;
    }

    public NhanVienDTO GetEmployeeByStaffID(String manv) {
        String query = "EXEC USP_GetEmployeeByStaffID ?";
        Object[] paramaters = {manv};

        try {
            ResultSet result = DataProvider.getInstance().executeQuery(query, paramaters);
            if (result.next()) {
                return new NhanVienDTO(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themNV(String manv, String tennv, String gioitinh, Date ngaysinh, String diachi, String sdt, Date ngayvaolam, double luongcoban) {
        String query = "EXEC USP_InsertEmployee ?, ?, ?, ?, ?, ?, ?, ?";
        Object[] parameters = {manv, tennv, gioitinh, ngaysinh, diachi, sdt, ngayvaolam, luongcoban};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaNV(String manv) {
        String query = "EXEC USP_DeleteEmployee ?";
        Object[] parameters = {manv};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaNV(String manv, String tennv, String gioitinh, Date ngaysinh, String diachi, String sdt, Date ngayvaolam, double luongcoban) {
        String query = "EXEC USP_UpdateEmployee ?, ?, ?, ?, ?, ?, ?, ?";
        Object[] parameters = {manv, tennv, gioitinh, ngaysinh, diachi, sdt, ngayvaolam, luongcoban};
        try {
            int result = DataProvider.getInstance().executeNonQuery(query, parameters);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<NhanVienDTO> timNVTheoTen(String tennv) throws SQLException {
        List<NhanVienDTO> listNV = new ArrayList<>();
        String query = "EXEC USP_SearchEmployeeByName ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            // Đặt giá trị cho tham số
            pstmt.setString(1, tennv);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setManhanvien(rs.getString("MANHANVIEN"));
                    nv.setHoten(rs.getString("HOTEN"));
                    nv.setPhai(rs.getString("PHAI"));
                    nv.setNgaysinh(rs.getDate("NGAYSINH"));
                    nv.setDiachi(rs.getString("DIACHI"));
                    nv.setSdt(rs.getString("SDT"));
                    nv.setNgayvaolam(rs.getDate("NGAYVAOLAM"));
                    nv.setLuongcoban(rs.getDouble("LUONGCOBAN"));
                    nv.setDaxoa(rs.getBoolean("DAXOA"));
                    listNV.add(nv);
                }
            }
        }
        return listNV;
    }
    
    public List<NhanVienDTO> timNVTheoLuong(double luong) throws SQLException {
        List<NhanVienDTO> listNV = new ArrayList<>();
        String query = "EXEC USP_SearchEmployeeBySalary ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            // Đặt giá trị cho tham số
            pstmt.setDouble(1, luong);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setManhanvien(rs.getString("MANHANVIEN"));
                    nv.setHoten(rs.getString("HOTEN"));
                    nv.setPhai(rs.getString("PHAI"));
                    nv.setNgaysinh(rs.getDate("NGAYSINH"));
                    nv.setDiachi(rs.getString("DIACHI"));
                    nv.setSdt(rs.getString("SDT"));
                    nv.setNgayvaolam(rs.getDate("NGAYVAOLAM"));
                    nv.setLuongcoban(rs.getDouble("LUONGCOBAN"));
                    nv.setDaxoa(rs.getBoolean("DAXOA"));
                    listNV.add(nv);
                }
            }
        }
        return listNV;
    }
    
    public List<NhanVienDTO> timNVTheoGioiTinh(String gioitinh) throws SQLException {
        List<NhanVienDTO> listNV = new ArrayList<>();
        String query = "EXEC USP_SearchEmployeeBySex ?";
        DataProvider dataProvider = DataProvider.getInstance();
        try (Connection con = dataProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            // Đặt giá trị cho tham số
            pstmt.setString(1, gioitinh);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setManhanvien(rs.getString("MANHANVIEN"));
                    nv.setHoten(rs.getString("HOTEN"));
                    nv.setPhai(rs.getString("PHAI"));
                    nv.setNgaysinh(rs.getDate("NGAYSINH"));
                    nv.setDiachi(rs.getString("DIACHI"));
                    nv.setSdt(rs.getString("SDT"));
                    nv.setNgayvaolam(rs.getDate("NGAYVAOLAM"));
                    nv.setLuongcoban(rs.getDouble("LUONGCOBAN"));
                    nv.setDaxoa(rs.getBoolean("DAXOA"));
                    listNV.add(nv);
                }
            }
        }
        return listNV;
    }
}
