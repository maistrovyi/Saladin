<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>All persons | Saladin</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/active_style.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<form:form id="content">
    <p>
    <p>All persons:</p></p>

    <c:if test="${fn:length(allPersonsList) > 0}">
        <table id="th">
            <tr>
                <th>Login name</th>
                <th>First name</th>
                <th>Second name</th>
                <th>Creation Date</th>
                <th>Privileges</th>
                <th>ASD</th>
            </tr>
            <c:forEach items="${allPersonsList}" var="person" varStatus="loop">
                <tr>
                    <form method="post" action="persons">
                        <c:out value="${person}"/>
                        <td>${person.loginName}</td>
                        <td>${person.firstName}</td>
                        <td>${person.secondName}</td>
                        <td>${person.creationDate}</td>
                        <td><input id="button_check_stock_m" type="text" name="person" value="${person.rights}"/></td>
                        <td>
                            <p><input type="submit" value="SAVE" class="button"/></p>
                    </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form:form>
</body>
</html>