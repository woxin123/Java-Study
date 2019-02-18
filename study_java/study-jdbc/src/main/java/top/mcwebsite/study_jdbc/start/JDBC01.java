package top.mcwebsite.study_jdbc.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mengchen
 * @time 18-9-29 下午5:35
 */
public class JDBC01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
                    "mengchen0705");
            // 关闭自动提交
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT INTO t_user VALUES (1, 'aa');");

            conn.commit();


        } catch (Exception e) {
            conn.rollback();
        }
    }
}
