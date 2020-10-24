package dao;

import domain.Book;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDao {
    //添加
    public static Boolean add(final User user) throws Exception {
        JDBCTemplate<Boolean> t = new Transaction<Boolean>() {
            @Override
            protected Boolean doTransaction(Connection conn) throws Exception {
                PreparedStatement ps = conn
                        .prepareStatement("insert into users(usr_name,pwd,tk,phone_num,TokenCreatedTime) values(?,?,?,?,?)");
                ps.setString(1, user.usr_name);
                ps.setString(2, user.pwd);
                ps.setString(3, user.tk);
                ps.setString(4, user.phone_num);
                ps.setLong(5, user.tct);
                return ps.execute();
            }
        };
        return t.execute();
    }
    //获取
    public static User get(final String usr_name) throws Exception {
        JDBCTemplate<User> q = new Query<User>() {
            @Override
            protected User doQuery(Connection conn) throws Exception {
                PreparedStatement ps = conn
                        .prepareStatement("select * from users where usr_name=?");
                ps.setString(1, usr_name);
                ps.execute();
                ResultSet rs = ps.getResultSet();
                User user = null;
                if (rs.next()) {
                    user = new User();
                    user.usr_name = rs.getString("usr_name");
                    user.pwd = rs.getString("pwd");
                    user.tk = rs.getString("tk");
                    user.phone_num = rs.getString("phone_num");
                    user.tct=rs.getLong("TokenCreatedTime");
                }
                return user;
            }
        };
        return q.execute();
    }


    // 修改
    public static Boolean update(final User user, final String old_usr_name)
            throws Exception {
        JDBCTemplate<Boolean> t = new Transaction<Boolean>() {
            @Override
            protected Boolean doTransaction(Connection conn) throws Exception {
                PreparedStatement ps = conn
                        .prepareStatement("update users set usr_name=?,pwd=?,tk=?,phone_num=?,TokenCreatedTime=? where usr_name=?");
                ps.setString(1, user.usr_name);
                ps.setString(2, user.pwd);
                ps.setString(3, user.tk);
                ps.setString(4, user.phone_num);
                ps.setLong(5,user.tct);
                ps.setString(6, old_usr_name);
                return ps.execute();
            }
        };
        return t.execute();
    }

    // 删除
    public static Boolean delete(final String usr_name) throws Exception {
        JDBCTemplate<Boolean> t = new Transaction<Boolean>() {
            @Override
            protected Boolean doTransaction(Connection conn) throws Exception {
                PreparedStatement ps = conn
                        .prepareStatement("delete from users where usr_name=?");
                ps.setString(1, usr_name);
                return ps.execute();
            }
        };
        return t.execute();
    }
}
