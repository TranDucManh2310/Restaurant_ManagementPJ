package DTO;
import java.sql.*;

public class PhieuNhapDTO {
    private int mapn;
    private int mancc;
    private Date ngaynhap;
    private boolean daxoa;

    public PhieuNhapDTO(int mapn, int mancc, Date ngaynhap, boolean daxoa) {
        this.mapn = mapn;
        this.mancc = mancc;
        this.ngaynhap = ngaynhap;
        this.daxoa = daxoa;
    }
    
    public PhieuNhapDTO(ResultSet rs) throws SQLException{
        this.mapn = rs.getInt("MAPN");
        this.mancc = rs.getInt("MANCC");
        this.ngaynhap = rs.getDate("NGAYNHAP");
        this.daxoa = rs.getBoolean("DAXOA");
    }
    
    public PhieuNhapDTO(){
        
    }

    public int getMapn() {
        return mapn;
    }

    public void setMapn(int mapn) {
        this.mapn = mapn;
    }

    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
}
