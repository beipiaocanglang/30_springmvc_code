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
        function submitImgSize1Upload() {

            var option = {
                type:"POST",
                url:"${pageContext.request.contextPath}/ajaxUploadPic.do",
                dataType:"text",
                data:{
                    fileName:"imgSize1File"/*取值是input标签的name值*/
                },
                success:function (data) {
                    alert(data);
                }
            };

            //表单提交  对应表单标签from的id属性值
            $("#itemForm").ajaxSubmit(option);

        }
	</script>
</head>
<body>
<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
<form id="itemForm"	action="${pageContext.request.contextPath }/updateitem.do" method="post">
	<input type="hidden" name="id" value="${item.id }" /> 修改商品信息：
	<table width="100%" border=1>
		<tr>
			<td>商品图片</td>
			<td>
				<p><label></label>
					<img id='imgSize1ImgSrc' src='${picPath }${item.pic }'  height="100" width="100" />
					<input type='file' id='imgSize1File' name='imgSize1File' class="file" onchange='submitImgSize1Upload()' />
					<span class="pos" id="imgSize1FileSpan">请上传图片的大小不超过3MB</span>
					<input type='hidden' id='imgSize1' name='pic' value='' reg="^.+$" tip="亲！您忘记上传图片了。" />
				</p>
			</td>
		</tr>
	</table>
</form>
</body>

</html>