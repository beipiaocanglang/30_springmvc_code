<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>参数传递的测试页面</title>
</head>
    <body>
        <%--传递基本类型--%>
        <form action="${pageContext.request.contextPath}/tranInt.do">
            <input type="text" name="id" id="id"/>
            <input type="submit" value="提交"/>
        </form>

        <%--传递string类型--%>
        <form action="${pageContext.request.contextPath}/tranString.do">
            <input type="text" name="username" id="username"/><br>
            <input type="password" name="password" id="password"/><br>
            <input type="submit" value="提交string"/>
        </form>

        <%--传递包装类类型--%>
        <form action="${pageContext.request.contextPath}/tranVo.do">
            <input type="text" name="items.name" id="name"/><br>
            <input type="text" name="items.price" id="price"/><br>
            <input type="submit" value="传递包装类"/>
        </form>

        <%--传递数组类型--%>
        <form action="${pageContext.request.contextPath}/tranArray.do">
            <input type="checkbox" name="ids" value="1"/><br>
            <input type="checkbox" name="ids" value="2"/><br>
            <input type="submit" value="传递数组"/>
        </form>

        <%--传递list集合类型--%>
        <form action="${pageContext.request.contextPath}/tranList.do" method="post">
            <input type="text" name="itemsList[0].name"/><br>
            <input type="text" name="itemsList[0].price"/><br>
            <input type="text" name="itemsList[1].name"/><br>
            <input type="text" name="itemsList[1].price"/><br>
            <input type="submit" value="传递list集合"/>
        </form>
    </body>
</html>