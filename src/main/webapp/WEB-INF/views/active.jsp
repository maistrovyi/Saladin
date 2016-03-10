<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Active Queue | lifecell</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/active_style.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<form:form id="content">
    <h2>Description:</h2>
    <h3><p>All active queue:</p></h3>
    <table id="th">
            <tr>
                <th>QUEUID</th>
                <th>OBJECTID</th>
                <th>OBJECTTYPE</th>
                <th>STATUS</th>
                <th>STARDATE</th>
                <th>FINISHDATE</th>
                <th>USERNAME</th>
                <th>MESSAGE</th>
            </tr>
        <c:forEach items="${activeQueueList}" var="queue">
            <tr>
                <td>${queue.queueId}</td>
                <td>${queue.targetObject}</td>
                <td>${queue.objectType}</td>
                <td>${queue.status}</td>
                <td>${queue.startDate}</td>
                <td>${queue.finishDate}</td>
                <td>${queue.userName}</td>
                <td>${queue.message}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>