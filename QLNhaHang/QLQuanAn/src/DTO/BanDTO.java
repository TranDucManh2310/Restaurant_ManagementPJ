package DTO;
import java.sql.*;

public class BanDTO {
    private int maban;
    private int soluongnguoi;
    private String trangthai;
    private boolean daxoa;

    public BanDTO(int maban, int soluongnguoi, String trangthai, boolean daxoa) {
        this.maban = maban;
        this.soluongnguoi = soluongnguoi;
        this.trangthai = trangthai;
        this.daxoa = daxoa;
    }
    
    public BanDTO(ResultSet rs) throws SQLException{
        try {
            this.maban = rs.getInt("MABAN");
            this.soluongnguoi = rs.getInt("SOLUONGNGUOI");
            this.trangthai = rs.getString("TRANGTHAI");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getMaban() {
        return maban;
    }

    public void setMaban(int maban) {
        this.maban = maban;
    }

    public int getSoluongnguoi() {
        return soluongnguoi;
    }

    public void setSoluongnguoi(int soluongnguoi) {
        this.soluongnguoi = soluongnguoi;
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
