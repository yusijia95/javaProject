package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0_Util {
    public static ComboPooledDataSource database = new ComboPooledDataSource("src/c3p0-config.xml");

    public static Connection getConnection() throws SQLException {
        return database.getConnection();
    }
}
