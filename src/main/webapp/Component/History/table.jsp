<%@ page import="Controller.Wifi_History.Wifi_History_Service" %>
<%@ page import="Controller.Wifi_History.Wifi_History_Entity" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table>
    <tr>
        <th>ID</th>
        <th>X 좌표</th>
        <th>Y 좌표</th>
        <th>작업일자</th>
        <th>비고</th>
    </tr>
    <%
        Class.forName("org.sqlite.JDBC");
        Wifi_History_Service w = new Wifi_History_Service();
        String id = request.getParameter("id");
        if(id != null){
            w.deleteHistory(id);
        }

        List<Wifi_History_Entity> list = w.getHistory();
        for(Wifi_History_Entity x : list){
            out.write("<tr>");
            out.write("<td>"+x.id+"</td>");
            out.write("<td>"+x.LAT+"</td>");
            out.write("<td>"+x.LNT+"</td>");
            out.write("<td>"+x.DATE+"</td>");
            out.write("<td>");
            out.write("<button id="+ x.id+" class=btn_history_delete>"+"히스토리 삭제"+"</button>");
            out.write("</td>");
            out.write("</tr>");
        }

    %>
</table>