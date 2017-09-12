<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h3>测试下载Excel功能</h3>
<form action="/db/log/insert" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="导入科目数据"/>
</form>
</body>
</html>