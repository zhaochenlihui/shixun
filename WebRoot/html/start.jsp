<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>

<head>
    <title>start</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/start_css.css">
</head>
<frameset rows="20%,80%" frameborder="0">
    <frame src="html/header.html" noresize scrolling="no"></frame>
    <frameset cols="20%,*">
        <frame src="html/nav_bar.html"></frame>
        <frame src="html/content.html" noresize name="content"></frame>
    </frameset>
</frameset>
</html>
