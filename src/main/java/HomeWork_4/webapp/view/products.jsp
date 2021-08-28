<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<body>
<h1>Product LIST</h1>

<ul>
    <c:forEach var="item" items="${products}">
        <li> Number: ${item.id} Title: ${item.title} Cost: ${item.cost}</li>
    </c:forEach>
</ul>



</body>
</html>