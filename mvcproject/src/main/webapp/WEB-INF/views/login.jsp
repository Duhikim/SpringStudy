<%--
  Created by IntelliJ IDEA.
  User: Kim Duhi
  Date: 11-25(월)
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<%--<form:form modelAttribute="user">--%>
<%--  이메일: <form:input path = "email" /><br>--%>
<%--  비밀번호: <form:password path = "passworld" /><br>--%>
<%--  <input type="Submit" value="로그인" />--%>
<%--</form:form>--%>
<form action="/user/login" method="post">
    이메일 : <input type="text" name="email" /><br>
    비밀번호 : <input type="password" name="password" /><br>
    <button type="submit">로그인</button>
</form>

<h2> ${message} </h2>
</body>
</html>
