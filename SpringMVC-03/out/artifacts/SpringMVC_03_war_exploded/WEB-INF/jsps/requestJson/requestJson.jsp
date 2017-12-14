<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>

    <script type="text/javascript">
        /*请求json，返回json*/
        function requestJson(){
            //表单提交  对应表单标签from的id属性值
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath }/requestJsonAndResponsJson.do",
                contentType:"application/json;charset=UTF-8",
                data:'{"name":"zhangsan","price":"666"}',
                success:function(data){
                    alert(data.name+":"+data.price);
                }

            })
        }
        /*请求对象，返回json*/
        function requestPojo(){
            //表单提交  对应表单标签from的id属性值
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath }/requestPojoAndResponsJson.do?name=战胜你&price=99.9",
                /*data:'',*/
                dataType:'json',
                success:function(data){
                    alert(data.name+":"+data.price);
                }

            })
        }
    </script>
</head>
    <body>
        <input type="button" value="请求json,返回json" onclick="requestJson()" />
        <input type="button" value="请求Pojo,返回json" onclick="requestPojo()" />
    </body>
</html>