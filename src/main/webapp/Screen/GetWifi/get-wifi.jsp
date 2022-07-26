<%@ page import="Controller.Wifi.Wifi_Service" %>
<%@ page import="Controller.Api_Service" %>
<%@ page import="Controller.Db_Handler" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../Style/style.css" type="text/css" media="screen" />
    <title>WIFI | 가져오기</title>
</head>
<body>
    <div style="display: flex; justify-content: center; align-items: center; flex-direction: column">
    <%
        Class.forName("org.sqlite.JDBC");
        Wifi_Service w = new Wifi_Service();
        w.createWifi();
        out.write("<h1>"+ Api_Service.totalPage+" 개 의 정보를 정상적으로 저장 하였습니다.." +"</h1>");
    %>
        <div>
            <a href="../../index.jsp"> 🏠 으로가기</a>
        </div>
    </div>
</body>
</html>
