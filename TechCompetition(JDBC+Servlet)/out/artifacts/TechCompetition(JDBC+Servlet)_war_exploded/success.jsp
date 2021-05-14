<%@ page import="TechComp.TechCompUserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 24257
  Date: 5/10/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.html" %>
<html>
<head>
    <title>life.jsp</title>
</head>
<body>

<%!
    int a = 10;
    int b = 20;
%>
<h1>Success</h1><br>

username =<%=session.getAttribute("info1")%><br>
password =<%=session.getAttribute("info2")%><br>


<a href="CSS+HTML.html"><input type="submit" id="GoBack" value="goBack" onclick="button1()"></a>

<SCRIPT LANGUAGE="JavaScript">
    function button1() {
        console.log("Going Back");
        alert("Going Back");
        <%
        if (!session.isNew()) {
          session.removeAttribute("info1");
          session.removeAttribute("info2");
          session.invalidate();
          session = request.getSession();
          }
        %>
    }
</SCRIPT>

</body>
</html>

<%!
    public void abc() {
        System.out.println("printing abc method");
    }
%>

<%abc(); %>

<%!
    private int initVar = 0;
    private int serviceVar = 0;
    private int destroyVar = 0;
%>

<%!
    public void jspInit() {
        initVar++;
        System.out.println("jspInit(): initiated" + initVar + "times");
    }

    public void jspDestroy() {
        destroyVar++;
        System.out.println("jspDestroy(): JSP was destroyed" + destroyVar + "time");
    }
%>

<%
    serviceVar++;
    System.out.println("_jspService(): is called" + serviceVar + "times");

    String content1 = "初始化次数 : " + initVar;
    String content2 = "响应客户请求次数 : " + serviceVar;
    String content3 = "销毁次数 : " + destroyVar;
%>
