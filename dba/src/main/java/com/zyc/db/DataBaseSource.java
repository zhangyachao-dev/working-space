package com.zyc.db;

import java.sql.*;

public class DataBaseSource {

    private Connection conn;
    private PreparedStatement prepareStatement;

    public ResultSet query(DBType dbType,String sql) throws SQLException {
        conn = DBUtil.getConn(dbType);
        prepareStatement = conn.prepareStatement(sql);
        return prepareStatement.executeQuery();
    }

    public void close(ResultSet resultSet){
        DBUtil.close(conn,prepareStatement,resultSet);
    }

}
