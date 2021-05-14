package TechComp;

import java.util.*;

public interface TechCompDao {

    /**
     * login -> check all userinfo in MySQL, if contain, execute and retun true
     * @param username
     * @return
     */
    public boolean check(String username,String password);

    /**
     * register -> check first, if doesn't contain, execute and return true
     * @param username
     * @param password
     * @return
     */
    public boolean add(String username, String password,String major);
}
