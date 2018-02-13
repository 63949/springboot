<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%--添加jstl支持--%>
<%--https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_navbar&stacked=h  代码模板拷贝过来--%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>LMS</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">LMS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">所有书</a></li>
            <li><a href="#">新书</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <table CLASS="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>购买日期</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${allbooks}" var="book" begin="0" end="${fn:length(allbooks)}" >
        <%--<c:forEach var="book" items='allbooks'>--%>
        <tr>
            ${book}
            <td>${book.id}</td>
            <td>${book.book_name}</td>
            <td>${book.author}</td>
            <td>${book.purchaseDate}</td>
        </tr>
        </c:forEach>
       <%-- ${allbooks[0].author}--%>






        </tbody>
    </table>
</div>

</body>
</html>
