package TechComp;

public class main {
    public static void main(String[] args) {
        TechCompDaoImpl myDao = new TechCompDaoImpl();

        String myUsername;
        String myPassword;
        String myMajor;

        myUsername = "admin007";
        myPassword = "Qweqwe1234";
        myMajor = "Others";

        //myDao.check(myUsername,myPassword);
        myDao.add(myUsername,myPassword,myMajor);
    }
}
