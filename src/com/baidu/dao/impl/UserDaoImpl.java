package com.baidu.dao.impl;

import com.baidu.bean.User;
import com.baidu.dao.UserDao;
import com.baidu.utils.DBManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User Login(User user) {
        Connection  conn = DBManager.getConnection();
        User user1 =null;
        String sql = "select * from customer where uname = ? and upwd = ?";
        QueryRunner qr = new QueryRunner();
        try {
            user1 =  qr.query(conn,sql,new BeanHandler<>(User.class),user.getUname(),user.getUpwd());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ÓÃ»§µÇÂ¼Ê§°Ü");
        }
        return user1;
    }
}
