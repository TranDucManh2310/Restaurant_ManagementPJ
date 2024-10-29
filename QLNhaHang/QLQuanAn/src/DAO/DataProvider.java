package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProvider {

    private static DataProvider instance;
  String conStr = "jdbc:sqlserver://localhost:1433;databaseName=QL_QUANAN_JAVA;encrypt=true;trustServerCertificate=true";

    String userName = "sa";
    String password = "123";

    public static DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }

    public DataProvider() {
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(conStr, userName, password);
    }

    public int executeUpdate(String query, Object... parameters) {
        int rowsAffected = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            setParameters(preparedStatement, parameters);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public ResultSet executeQuery(String query, Object[] parameters) throws SQLException {
        Connection con = DriverManager.getConnection(conStr, userName, password);
        PreparedStatement pstmt = con.prepareStatement(query);

        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
        }

        return pstmt.executeQuery();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection con = DriverManager.getConnection(conStr, userName, password);
        PreparedStatement pstmt = con.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public int executeNonQuery(String query, Object[] parameters) throws SQLException {
        Connection con = DriverManager.getConnection(conStr, userName, password);
        PreparedStatement pstmt = con.prepareStatement(query);

        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
        }

        return pstmt.executeUpdate();
    }

    public Object executeScalar(String query, Object[] parameters) throws SQLException {
        Connection con = DriverManager.getConnection(conStr, userName, password);
        PreparedStatement pstmt = con.prepareStatement(query);

        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
        }

        ResultSet rs = pstmt.executeQuery();

        Object result = null;
        if (rs.next()) {
            result = rs.getObject(1);
        }

        return result;
    }

    private void setParameters(PreparedStatement statement, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
