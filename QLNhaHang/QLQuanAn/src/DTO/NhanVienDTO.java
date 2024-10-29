package DTO;

import java.sql.*;
import java.util.Date;

public class NhanVienDTO {
    private String manhanvien;
    private String hoten;
    private String phai;
    private Date ngaysinh;
    private String diachi;
    private String sdt;
    private Date ngayvaolam;
    private Double luongcoban;
    private boolean daxoa;

    public NhanVienDTO(ResultSet rs) throws SQLException{
        this.manhanvien = rs.getString("MANHANVIEN");
        this.hoten = rs.getString("HOTEN");
        this.phai = rs.getString("PHAI");
        this.ngaysinh = rs.getDate("NGAYSINH");
        this.diachi = rs.getString("DIACHI");
        this.sdt = rs.getString("SDT");
        this.ngayvaolam = rs.getDate("NGAYVAOLAM");
        this.luongcoban = rs.getDouble("LUONGCOBAN");
        this.daxoa = rs.getBoolean("DAXOA");
    }
    
    public NhanVienDTO(){}
    
    public NhanVienDTO(String manhanvien, String hoten, String phai, Date ngaysinh, String diachi, String sdt, Date ngayvaolam, Double luongcoban, boolean daxoa) {
        this.manhanvien = manhanvien;
        this.hoten = hoten;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngayvaolam = ngayvaolam;
        this.luongcoban = luongcoban;
        this.daxoa = daxoa;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayvaolam() {
        return ngayvaolam;
    }

    public void setNgayvaolam(Date ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    public Double getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(Double luongcoban) {
        this.luongcoban = luongcoban;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
    
}
