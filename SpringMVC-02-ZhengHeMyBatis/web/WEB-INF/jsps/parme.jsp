<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>参数传递的测试页面</title>
</head>
    <body>
        <form action="${pageContext.request.contextPath}/tranInt.do">
            <input type="text" name="id" id="id"/>
            <input type="submit" value="提交"/>
        </form>

        <form action="${pageContext.request.contextPath}/tranString.do">
            <input type="text" name="username" id="username"/><br>
            <input type="password" name="password" id="password"/><br>
            <input type="submit" value="提交string"/>
        </form>

    </body>
</html>