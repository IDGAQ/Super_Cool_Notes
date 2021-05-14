package TechComp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TechCompDaoImpl extends BaseDao {
    /**
     * login -> check all userinfo in MySQL, if contain, execute and retun true
     *
     * @param username
     * @return
     */
    public boolean check(String username, String password) {
        // connect
        Connection connection = Connect();
        PreparedStatement pps = null;
        ResultSet resultSet = null;

        try {
            String newRetrieve = "select username,password from user where username = ? and password = ?";
            pps = connection.prepareStatement(newRetrieve);
            pps.setString(1, username);
            pps.setString(2, password);
            resultSet = pps.executeQuery();

            if (resultSet.first()) {
                System.out.println("Username & Password Matches! Login Successful!");
                return true;
            }

        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // disconnect
            DisConnect(connection, pps, resultSet);
        }
        return false;
    }

    /**
     * register -> check first, if doesn't contain, execute and return true
     *
     * @param username
     * @param password
     * @return
     */
    public boolean add(String username, String password, String major) {
        // connect
        Connection connection = Connect();
        PreparedStatement pps = null;
        ResultSet resultSet = null;

        try {
            String newRetrieve = " INSERT INTO user VALUES (?, ?, ?)";
            pps = connection.prepareStatement(newRetrieve);
            pps.setString(1, username);
            pps.setString(2, password);
            pps.setString(3, major);
            int ans = pps.executeUpdate();

            // give user hint
            if (ans <= 0) {
            } else {
                System.out.println("Awesome! Done!");
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // disconnect
            DisConnect(connection, pps, resultSet);
        }
        System.out.println("Username Exists! Try Another One!");
        return false;
    }
}
