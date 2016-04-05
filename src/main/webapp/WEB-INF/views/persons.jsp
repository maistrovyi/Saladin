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
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<form:form id="content">
    <p>All persons:</p>
    <p>To change user role, you must select an item from the list and click on the "SAVE" button.</p>
    <p>Types of roles:</p>
    <ul>
        <li>"read" - (default user) - Only read Queue;</li>
        <li>"write" - (confirmed user) - Read and edit Queue;</li>
        <li>"admin" - (administrator) - Manage Saladin;</li>
    </ul>
    <c:if test="${fn:length(allPersonsList) > 0}">
        <table id="th">
            <tr align="center">
                <th>Login name</th>
                <th>First name</th>
                <th>Second name</th>
                <th>Creation date</th>
                <th>Roles</th>
                <th>Save changes</th>
                <th>Password</th>
                <th>Person</th>
            </tr>
            <c:forEach items="${allPersonsList}" var="person" varStatus="loop">
                <tr align="center">
                    <form method="post" action="persons">
                        <td>${person.loginName}</td>
                        <td>${person.firstName}</td>
                        <td>${person.secondName}</td>
                        <td>${person.creationDate}</td>
                        <td>
                            <input type="hidden" name="editedPersonLoginName" value="${person.loginName}"/>
                            <select id="select" name="editedPersonRightValue">
                                <option value="${person.role}">${person.role}</option>
                                <c:forEach items="${person.getTypes()}" var="role" varStatus="loop">
                                    <option value="${role}">${role}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <p><input id="button_persons" type="submit" value="SAVE" class="button"/></p>
                    </form>
                    </td>
                    <td>
                        <form method="post" action="reset">
                            <input type="hidden" name="resetPersonLoginName" value="${person.loginName}"/>
                            <p><input id="button_reset_persons" type="submit" value="RESET" class="button"/></p>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="remove">
                            <input type="hidden" name="removedPersonLoginName" value="${person.loginName}"/>
                            <p><input id="button_remove_persons" type="submit" value="DELETE" class="button"/></p>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form:form>
</body>
</html>