<%@ page import="java.util.List" %>
<%@ page import="com.example.Theacher.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 13447
  Date: 2022/3/12
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师展示页面</title>
    <style>
        td{
            text-align: center;
        }
    </style>
    <%
        String path=request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>"/>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
    <%
        List<Teacher> teacherList= (List<Teacher>) request.getServletContext().getAttribute("teacherList");
        for (Teacher teacher:teacherList) {
    %>
    <tr>
        <td>
            <%=teacher.getId()%>
        </td>
        <td>
            <%=teacher.getName()%>
        </td>
        <td>
            <button>删除</button>
        </td>
    </tr>
    <%
        }
    %>
</table>
<button><a href="add.jsp">添加</a></button>
</body>
</html>
<script src="jquery-3.4.1.min.js" type="text/javascript"></script>
<script>
    var dels=document.getElementsByTagName("button");
    dels[0].onclick=function () {
        $.ajax({
            url:"reo",
            type:"post",
            contentType: "application/json;charset=utf-8",
            data:JSON.stringify({id:0}),
            success:function (data) {
                console.log("连接成功")
                window.location.href="teacher.jsp"
            }
        })
    }
</script>