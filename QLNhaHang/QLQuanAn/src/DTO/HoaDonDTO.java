package DTO;
import java.sql.*;

public class HoaDonDTO {
    private int mahoadon;
    private int maban;
    private String manhanvien;
    private Timestamp ngayvao;
    private Timestamp ngayra;
    private int giamgia;
    private double thanhtien;
    private boolean daxoa;

    public HoaDonDTO(int mahoadon, int maban, String manhanvien, Timestamp ngayvao, Timestamp ngayra, int giamgia, double thanhtien, boolean daxoa) {
        this.mahoadon = mahoadon;
        this.maban = maban;
        this.manhanvien = manhanvien;
        this.ngayvao = ngayvao;
        this.ngayra = ngayra;
        this.giamgia = giamgia;
        this.thanhtien = thanhtien;
        this.daxoa = daxoa;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getMaban() {
        return maban;
    }

    public void setMaban(int maban) {
        this.maban = maban;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public Timestamp getNgayvao() {
        return ngayvao;
    }

    public void setNgayvao(Timestamp ngayvao) {
        this.ngayvao = ngayvao;
    }

    public Timestamp getNgayra() {
        return ngayra;
    }

    public void setNgayra(Timestamp ngayra) {
        this.ngayra = ngayra;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
    
    public HoaDonDTO(ResultSet rs) throws SQLException{
        this.mahoadon = rs.getInt("MAHOADON");
        this.maban = rs.getInt("MABAN");
        this.manhanvien = rs.getString("MANHANVIEN");
        this.ngayvao = rs.getTimestamp("NGAYVAO");
        this.ngayra = rs.getTimestamp("NGAYRA");
        this.giamgia = rs.getInt("GIAMGIA");
        this.thanhtien = rs.getDouble("THANHTIEN");
        this.daxoa = rs.getBoolean("DAXOA");
    }
    
    public HoaDonDTO(){}
}
