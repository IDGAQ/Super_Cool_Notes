package TechComp;

import java.sql.*;

public class BaseDao {

    /**
     * 连接上后，返回Connection Variable,方便后续使用
     * @return
     */
    public Connection Connect() {

        try {
            // drive
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connect
            String userName = "root";
            String passWord = "Luwanli123";
            String url = "jdbc:mysql://localhost:3306/techcompetition?serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(url, userName, passWord);
            //System.out.println("Connected");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param connection
     * @param statement
     * @param resultset
     */
    public void DisConnect(Connection connection,Statement statement, ResultSet resultset){
        //connection
        try {
            if(connection != null) {connection.close();}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //statement
        try {
            if(statement != null) {statement.close();}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //resultSet
        try {
            if(resultset != null) {resultset.close();}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
