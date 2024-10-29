package DTO;
import java.sql.*;

public class CongThucDTO {
    private int macongthuc;
    private int mamonan;
    private int manguyenlieu;
    private int soluong;
    private String donvi;
    private String tenmonan;
    private String tennguyenlieu;

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public CongThucDTO(int macongthuc, int mamonan, int manguyenlieu, int soluong, String donvi) {
        this.macongthuc = macongthuc;
        this.mamonan = mamonan;
        this.manguyenlieu = manguyenlieu;
        this.soluong = soluong;
        this.donvi = donvi;
    }
    
    public CongThucDTO(ResultSet rs) throws SQLException{
        this.macongthuc = rs.getInt("MACONGTHUC");
        this.mamonan = rs.getInt("MAMONAN");
        this.manguyenlieu = rs.getInt("MANGUYENLIEU");
        this.soluong = rs.getInt("SOLUONG");
        this.donvi = rs.getString("DONVI");
    }

    public int getMacongthuc() {
        return macongthuc;
    }

    public void setMacongthuc(int macongthuc) {
        this.macongthuc = macongthuc;
    }

    public int getMamonan() {
        return mamonan;
    }

    public void setMamonan(int mamonan) {
        this.mamonan = mamonan;
    }

    public int getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(int manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
}
