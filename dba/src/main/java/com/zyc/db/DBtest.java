package com.zyc.db;

import cn.hutool.log.Log;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBtest {
    private static final Log log = Log.get("DBtest");

    private static String select_emp = "SELECT * from EMP";

    private static String select_dept = "SELECT * FROM DEPT";

    private static String select_um_users = "SELECT * FROM um_users";



    public static void main(String[] args) {
        DBtest dBtest = new DBtest();
        //dBtest.analysisQueryResult(DBType.ORACLE,select_emp);
        //System.out.println("==================================================");
        //dBtest.analysisQueryResult(DBType.ORACLE,select_dept);
        System.out.println("==================================================");
        dBtest.analysisQueryResult(DBType.MYSQL,select_um_users);
    }

    private void analysisQueryResult(DBType dbType, String sql){
        DataBaseSource dataBaseSource = new DataBaseSource();
        try {
            ResultSet res = dataBaseSource.query(dbType, sql);
            ResultSetMetaData metaData = res.getMetaData();
            while (res.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(res.getObject(i));
                    System.out.print("  ");
                }
                System.out.println();
                System.out.println();
            }
            dataBaseSource.close(res);
        } catch (Exception e) {
            log.error(e);
        }
    }

}
