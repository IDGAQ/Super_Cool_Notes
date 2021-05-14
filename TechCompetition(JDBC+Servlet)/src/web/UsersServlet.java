package web;

import TechComp.TechCompDaoImpl;
import javafx.application.Application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

public class UsersServlet extends HttpServlet {
    String theUsername;
    String thePassword;
    String theMajor;


    public UsersServlet() {
        System.out.println("TestServlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initiatng...");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying...");
    }

    @Override //get
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        theUsername = req.getParameter("username");
        thePassword = req.getParameter("password");
        theMajor = req.getParameter("major");
        System.out.println(theUsername + "," + thePassword + "," + theMajor);
    }

    @Override //post
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TechCompDaoImpl myDao = new TechCompDaoImpl();

        // 处理乱码
        req.setCharacterEncoding("utf-8");

        // 后端统一用String格式接受前端input
        //front -> back req.getParameter()
        doGet(req, resp);

        String act = req.getParameter("submit");

        HttpSession session = req.getSession();
        //ServletContext application = req.getServletContext();
        System.out.println("Checkpoint:" + theUsername);
        // session.setAttr("info1", username) and ("info2",password)
        session.setAttribute("info1", theUsername);
        session.setAttribute("info2", thePassword);

        if (act == null) {
            //no button has been selected
        } else if (act.equals("Login")) {
            //delete button was pressed
            boolean result = myDao.check(theUsername, thePassword);
            if (result) {
                req.getRequestDispatcher("/success.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/fail.jsp").forward(req, resp);
            }
        } else if (act.equals("Register")) {
            //update button was pressed
            boolean result = myDao.add(theUsername, thePassword, theMajor);
            if (result) {
                //resp.sendRedirect("/success.jsp");
                req.getRequestDispatcher("/success.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/fail.jsp").forward(req, resp);
            }

        } else {
            //someone has altered the HTML and sent a different value!
            System.out.println("Error Detected");
        }


    }
}
