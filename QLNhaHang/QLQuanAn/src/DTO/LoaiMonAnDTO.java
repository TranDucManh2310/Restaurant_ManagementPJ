package DTO;
import java.sql.*;

public class LoaiMonAnDTO {
    private int maloaimonan;
    private String tenloaimonan;
    private boolean daxoa;
    
    public LoaiMonAnDTO(){}

    public LoaiMonAnDTO(int maloaimonan, String tenloaimonan, boolean daxoa) {
        this.maloaimonan = maloaimonan;
        this.tenloaimonan = tenloaimonan;
        this.daxoa = daxoa;
    }
    
    public LoaiMonAnDTO(ResultSet rs) throws SQLException{
        this.maloaimonan = rs.getInt("MALOAIMONAN");
        this.tenloaimonan = rs.getString("TENLOAIMONAN");
        this.daxoa = rs.getBoolean("DAXOA");
    }

    public int getMaloaimonan() {
        return maloaimonan;
    }

    public void setMaloaimonan(int maloaimonan) {
        this.maloaimonan = maloaimonan;
    }

    public String getTenloaimonan() {
        return tenloaimonan;
    }

    public void setTenloaimonan(String tenloaimonan) {
        this.tenloaimonan = tenloaimonan;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }
    
}
