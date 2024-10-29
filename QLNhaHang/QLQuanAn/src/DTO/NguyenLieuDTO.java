package DTO;
import java.sql.*;

public class NguyenLieuDTO {
    private int manguyenlieu;
    private int mancc;
    private String tennguyenlieu;
    private int soluong;
    private boolean daxoa;

    public NguyenLieuDTO(int manguyenlieu, int mancc, String tennguyenlieu, int soluong, boolean daxoa) {
        this.manguyenlieu = manguyenlieu;
        this.mancc = mancc;
        this.tennguyenlieu = tennguyenlieu;
        this.soluong = soluong;
        this.daxoa = daxoa;
    }
    
    public NguyenLieuDTO(){
        
    }

    public int getManguyenlieu() {
        return manguyenlieu;
    }

    public void setManguyenlieu(int manguyenlieu) {
        this.manguyenlieu = manguyenlieu;
    }

    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }

    public NguyenLieuDTO(ResultSet rs) throws SQLException{
        this.manguyenlieu = rs.getInt("MANGUYENLIEU");
        this.mancc = rs.getInt("MANCC");
        this.tennguyenlieu = rs.getString("TENNGUYENLIEU");
        this.soluong = rs.getInt("SOLUONG");
        this.daxoa = rs.getBoolean("DAXOA");
    }
    
}
