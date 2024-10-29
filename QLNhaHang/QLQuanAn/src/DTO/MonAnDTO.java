package DTO;
import java.sql.*;

public class MonAnDTO {
    private int mamonan;
    private int maloaimonan;
    private String tenmonan;
    private String dvt;
    private double dongia;
    private String hinhanh;
    private boolean daxoa;

    public MonAnDTO(int mamonan, int maloaimonan, String tenmonan, String dvt, double dongia, String hinhanh, boolean daxoa) {
        this.mamonan = mamonan;
        this.maloaimonan = maloaimonan;
        this.tenmonan = tenmonan;
        this.dvt = dvt;
        this.dongia = dongia;
        this.hinhanh = hinhanh;
        this.daxoa = daxoa;
    }

    
    public MonAnDTO(ResultSet rs) throws SQLException{
        this.mamonan = rs.getInt("MAMONAN");
        this.maloaimonan = rs.getInt("MALOAIMONAN");
        this.tenmonan = rs.getString("TENMONAN");
        this.dvt = rs.getString("DVT");
        this.dongia = rs.getDouble("DONGIA");
        this.hinhanh = rs.getString("HINHANH");
        this.daxoa = rs.getBoolean("DAXOA");
    }

    public int getMamonan() {
        return mamonan;
    }

    public void setMamonan(int mamonan) {
        this.mamonan = mamonan;
    }

    public int getMaloaimonan() {
        return maloaimonan;
    }

    public void setMaloaimonan(int maloaimonan) {
        this.maloaimonan = maloaimonan;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
}
