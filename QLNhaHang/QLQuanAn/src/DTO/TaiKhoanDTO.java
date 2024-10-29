package DTO;
import java.sql.*;

public class TaiKhoanDTO {
    private String tendangnhap;
    private String manhanvien;
    private String tenhienthi;
    private String matkhau;
    private String trangthai;
    private boolean daxoa;

    public TaiKhoanDTO(){}
    
    public TaiKhoanDTO(ResultSet rs) throws SQLException{
        this.tendangnhap = rs.getString("TENDANGNHAP");
        this.manhanvien = rs.getString("MANHANVIEN");
        this.tenhienthi = rs.getString("TENHIENTHI");
        this.matkhau = rs.getString("MATKHAU");
        this.trangthai = rs.getString("TRANGTHAI");
        this.daxoa = rs.getBoolean("DAXOA");       
    }

    public TaiKhoanDTO(String tendangnhap, String manhanvien, String tenhienthi, String matkhau, String trangthai, boolean daxoa) {
        this.tendangnhap = tendangnhap;
        this.manhanvien = manhanvien;
        this.tenhienthi = tenhienthi;
        this.matkhau = matkhau;
        this.trangthai = trangthai;
        this.daxoa = daxoa;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTenhienthi() {
        return tenhienthi;
    }

    public void setTenhienthi(String tenhienthi) {
        this.tenhienthi = tenhienthi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
    
}
