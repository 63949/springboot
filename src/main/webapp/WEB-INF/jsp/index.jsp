<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <script src="/jquery-dateFormat.min.js"></script>
    <script type="text/javascript">
          /* $().ready(function () {
               $(".mydd").each(function (index) {
                   // console.log(index+ ": " + $( this ).text());
                  $(".mydd")[index].innerHTML = $.format.date(Date.parse($( this ).text()), 'yyyy-MM-dd');
               });
           });*/
    </script>

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">LMS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">所有书</a></li>
            <li><a href="newBook">新书</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <c:choose>
        <c:when test="${mode == 'BOOK_VIEW'}">
            <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>书名</th>
                <th>作者</th>
                <th>购买日期</th>
                <th>编辑</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${allbooks}" var="book" begin="0" end="${fn:length(allbooks)}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.book_name}</td>
                    <td>${book.author}</td>
                    <td class="mydd">${book.purchaseDate}</td>
                    <td><a href="/updateBook?id=${book.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
                </tr>

            </c:forEach>
            </tbody>
            </table>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${mode=='BOOK_EDIT' || mode=='BOOK_NEW'}">
            <form action="/save" method="post">
                <input type="hidden" value="${b.id}" name="id" id="id">
                <div class="form-group">
                    <label for="book_name">书名:</label>
                    <input type="text" class="form-control" id="book_name" value="${b.book_name}" name="book_name">
                </div>
                <div class="form-group">
                    <label for="author">作者:</label>
                    <input type="text" class="form-control" id="author" value="${b.author}"  name="author">
                </div>
                <div class="form-group">
                    <label for="purchaseDate">购买日期:</label>
                  <%--  <input type="date" class="form-control" id="purchaseDate" value="${b.purchaseDate}"  name="purchaseDate">--%>
                    <input type="date" class="form-control" id="purchaseDate" value="2011-11-12"  name="purchaseDate">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </c:when>
    </c:choose>


</div>

</body>
</html>
