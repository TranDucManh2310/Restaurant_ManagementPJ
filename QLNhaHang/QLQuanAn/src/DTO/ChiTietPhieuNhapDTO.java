package DTO;

import java.sql.*;

public class ChiTietPhieuNhapDTO {

    private int mactpn;
    private int mapn;
    private int manguyenlieu;
    private double dongianhap;
    private int soluongnhap;

    public ChiTietPhieuNhapDTO(int mactpn, int mapn, int manguyenlieu, double dongianhap, int soluongnhap) {
        this.mactpn = mactpn;
        this.mapn = mapn;
        this.manguyenlieu = manguyenlieu;
        this.dongianhap = dongianhap;
        this.soluongnhap = soluongnhap;
    }

    public ChiTietPhieuNhapDTO(int manguyenlieu, double dongianhap, int soluongnhap) {
        this.manguyenlieu = manguyenlieu;
        this.dongianhap = dongianhap;
        this.soluongnhap = soluongnhap;
    }

    public ChiTietPhieuNhapDTO(ResultSet rs) throws SQLException {
        this.mactpn = rs.getInt("MACTPN");
        this.mapn = rs.getInt("MAPN");
        this.manguyenlieu = rs.getInt("MANGUYENLIEU");
        this.dongianhap = rs.getDouble("DONGIANHAP");
        this.soluongnhap = rs.getInt("SOLUONGNHAP");
    }
    
    public ChiTietPhieuNhapDTO(){
        
    }

    public int getMactpn() {
        return mactpn;
    }

    public void setMactpn(int mactpn) {
        this.mactpn = mactpn;
    }

    public int getMapn() {
        return mapn;
    }

    public void setMapn(int mapn) {
        this.mapn = mapn;
    }

    public int getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(int manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public double getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(double dongianhap) {
        this.dongianhap = dongianhap;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }
}
