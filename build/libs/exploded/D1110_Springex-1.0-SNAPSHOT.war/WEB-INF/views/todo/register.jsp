<%--
  Created by IntelliJ IDEA.
  User: ict05-03
  Date: 2022-11-14
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>D1114 register view</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <div>
            Title : <input type="text" name="title"/> <!--name = fild 값과 맞춰주면 편리-->
        </div>
        <div>
            DueDate : <input type="date" name="dueDate" value="2022-11-14"/>
        </div>
        <div>
            Writer : <input type="text" name="writer"/>
        </div>
        <div>
            Finished : <input type="checkbox" name="finished"/>
        </div>
        <div>
            <button type="submit">register</button>
        </div>
    </form>
</body>
</html>
