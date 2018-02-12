<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form>
    <p>
        <input type="text" name="user-query" placeholder="Поиск по сайту">
        Ограничить количество результатов <input type="number" name="limit" value="0">
        Пропустить первые <input type="number" name="offset" value="0"> результатов
        Количество результатов на странице
    </p>
    Сортировка
    <p>
        <label>
            <select name="sort" size="3">
                <option disabled>Выберите сортировку</option>
                <option value="NAMEASC">По названию(возрастание)</option>
                <option selected value="NAMEASC">По названию(убывание)</option>
                <option value="COSTASC">По цене(возрастание)</option>
                <option value="COSTDESC">По цене(убывание)</option>
            </select>
        </label>
    </p>
    <p>
        <b>Сколько показать результатов на странице?</b>
    <p><label>
        <input name="pagination" type="radio" value="10">
    </label> 10</p>
    <p><label>
        <input name="pagination" type="radio" value="20">
    </label> 20</p>
    <p><label>
        <input name="pagination" type="radio" value="50" checked>
    </label> 50</p>
    </p>
    <input type="submit" value="Найти">

    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Name</th><th>Cost</th><th>Producer</th>
            <c:forEach var="product" items="${requestScope.products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.cost}</td>
                    <td>${product.producer}</td>
                </tr>
            </c:forEach>
    </table>
</form>

<c:if test="${currentPage != 1}">
    <td><a href="${pageContext.request.contextPath}/search?page=${currentPage - 1}">Previous</a></td>
</c:if>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="${pageContext.request.contextPath}/search?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<c:if test="${currentPage lt numberOfPages}">
    <td><a href="${pageContext.request.contextPath}/search?page=${currentPage + 1}">Next</a></td>
</c:if>
</body>
</html>
