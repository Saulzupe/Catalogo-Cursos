package org.szunigap.webapp.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
  /*  private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";*/

    public static Connection getConnection() throws SQLException, NamingException {
        Context initContext = null;
        DataSource ds = null;

            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/tareaDB");
            return ds.getConnection();

       // return DriverManager.getConnection(url,username,password);
    }
}
