<%--
  Created by IntelliJ IDEA.
  User: 陈锴鹏
  Date: 2018/6/11
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
</head>
<body>
<form action="payment/test">
    <input type="text" name="body"><br>
    <input type="submit" value="购买">
</form>
</body>
</html>
