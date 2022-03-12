<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        首页
    </title>
</head>
<body>
<button id="btn">按钮</button>
</body>
</html>
<script type="text/javascript" src="./jquery-3.4.1.min.js"></script>
<script>
    var btn=document.getElementById("btn");
    btn.onclick=function () {
        $.ajax({
            url:"get",
            type:"GET",
            success:function (data) {
                window.location.href="teacher.jsp"
            }
        })
    }
</script>