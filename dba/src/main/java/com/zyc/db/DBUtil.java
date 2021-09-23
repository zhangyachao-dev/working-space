package com.zyc.db;

import cn.hutool.core.io.IoUtil;
import cn.hutool.log.Log;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

public class DBUtil {

    private static final Log log = Log.get("DBUtil");

    private static final String driver = "db.driver";

    private static final String url = "db.url";

    private static final String name = "db.name";

    private static final String password = "db.passwd";

    private static DBType defDbType = DBType.MYSQL;
    public static Connection getConn(DBType dbType){
        if(Objects.isNull(dbType)){
            dbType = defDbType;
        }
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(dbType.getName() + ".properties");
        Properties properties = new Properties();
        try {
            properties.load(resource);
            Class.forName(properties.getProperty(driver));
            return DriverManager.getConnection(properties.getProperty(url),properties.getProperty(name),properties.getProperty(password));
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    public static void close(Object... objsToClose) {
        for (Object obj : objsToClose) {
            if(null != obj){
                if (obj instanceof AutoCloseable) {
                    IoUtil.close((AutoCloseable) obj);
                } else {
                    log.warn("Object {} not a ResultSet or Statement or PreparedStatement or Connection!", obj.getClass().getName());
                }
            }
        }
    }

}
