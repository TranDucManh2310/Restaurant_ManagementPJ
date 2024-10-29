package DAO;

import DTO.ThongTinDatBanDTO;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class ThongTinDatBanDAO {
    private static ThongTinDatBanDAO instance;

    public static ThongTinDatBanDAO getInstance() {
        if (instance == null) {
            instance = new ThongTinDatBanDAO();
        }
        return instance;
    }

    private ThongTinDatBanDAO() {

    }
    
    public boolean insertInforOrderTable(int idTable, Timestamp date, String name, String phone) {
        String query = "{CALL USP_InsertInforOrderTable(?, ?, ?, ?)}";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, idTable, date, name, phone);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ThongTinDatBanDTO getInforOrderTable(int idTable) {
        ThongTinDatBanDTO thongTinDatBanDTO = null;
        String query = "SELECT * FROM THONGTINDATBAN WHERE MABAN = ? AND DAXOA = 0";
        ResultSet resultSet = null;
        try {
            resultSet = DataProvider.getInstance().executeQuery(query, new Object[]{idTable});
            while (resultSet.next()) {
                thongTinDatBanDTO = new ThongTinDatBanDTO(resultSet);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thongTinDatBanDTO;
    }

    public boolean removeInforOrderTable(int id) {
        String query = "UPDATE THONGTINDATBAN SET DAXOA = 1 WHERE MATTDB = ?";
        try {
            int result = DataProvider.getInstance().executeUpdate(query, id);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
