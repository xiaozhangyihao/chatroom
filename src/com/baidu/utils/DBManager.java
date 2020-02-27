package com.baidu.utils;



import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBManager {
    static Connection conn = null;
        @Test
        public static Connection getConnection(){
            ResourceBundle br = ResourceBundle.getBundle("db");
            try {
                Class.forName((String) br.getObject("DRIVER"));
                conn = DriverManager.getConnection((String) br.getObject("URL"), (String)br.getObject("UNAME"),(String) br.getObject("PWD"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
}
