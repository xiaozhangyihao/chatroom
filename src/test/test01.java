package test;

import com.baidu.bean.User;
import com.baidu.dao.impl.UserDaoImpl;
import org.junit.Test;
import com.baidu.utils.DBManager;
import java.sql.Connection;

public class test01 {
    public static void main(String[] args) {
//        Connection conn =  DBManager.getConnection();
//        System.out.println(conn);
        String st = "AËµ:°¡°¡°¡°¡";
        String[] s = st.split("Ëµ:");
        System.out.println(s[0]);
    }
    @Test
    public void test01(){
        System.out.println("hello");
        User u = new User();
        u.setUname("AA");
        u.setUpwd("123456");
        UserDaoImpl userDao = new UserDaoImpl();
        User  u1  = userDao.Login(u);
        System.out.println(u1);
    }
}
