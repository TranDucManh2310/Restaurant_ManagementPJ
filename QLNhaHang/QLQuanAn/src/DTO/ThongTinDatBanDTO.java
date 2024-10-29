package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ThongTinDatBanDTO {
    private int mattdb;
    private int maban;
    private Timestamp ngaydat;
    private String hotenkh;
    private String sdt;
    private boolean daxoa;

    public int getMattdb() {
        return mattdb;
    }

    public void setMattdb(int mattdb) {
        this.mattdb = mattdb;
    }

    public int getMaban() {
        return maban;
    }

    public void setMaban(int maban) {
        this.maban = maban;
    }

    public Timestamp getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Timestamp ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getHotenkh() {
        return hotenkh;
    }

    public void setHotenkh(String hotenkh) {
        this.hotenkh = hotenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isDaxoa() {
        return daxoa;
    }

    public void setDaxoa(boolean daxoa) {
        this.daxoa = daxoa;
    }

    public ThongTinDatBanDTO(int mattdb, int maban, Timestamp ngaydat, String hotenkh, String sdt, boolean daxoa) {
        this.mattdb = mattdb;
        this.maban = maban;
        this.ngaydat = ngaydat;
        this.hotenkh = hotenkh;
        this.sdt = sdt;
        this.daxoa = daxoa;
    }
    
    public ThongTinDatBanDTO(ResultSet rs) throws SQLException {
        this.mattdb = rs.getInt("MATTDB");
        this.maban = rs.getInt("MABAN");
        this.ngaydat = rs.getTimestamp("NGAYDAT");
        this.hotenkh = rs.getString("HOTENKH");
        this.sdt = rs.getString("SDT");
        this.daxoa = rs.getBoolean("DAXOA");
    }
}
