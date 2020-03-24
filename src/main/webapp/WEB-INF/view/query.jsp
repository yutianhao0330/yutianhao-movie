<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/css/bootstrap.css">
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/WdatePicker.js"></script>
<body>
	<form action="/movie/list" method="post">
		<table class="table">
			<tr>
				<td>
					影片名称:
						<input type="text" name="name" value="${query.name}">
					上映时间:
						<input type="text" name="startTime" onclick="WdatePicker()" value="${query.startTime}">-
						<input type="text" name="endTime" onclick="WdatePicker()" value="${query.endTime}">
				</td>
			</tr>
			<tr>
				<td>
					导演:
						<input type="text" name="director" value="${query.director}">
					价格:
						<input type="text" name="lowerPrice" value="${query.lowerPrice}">-
						<input type="text" name="upperPrice" value="${query.upperPrice}">
				</td>
			</tr>
			<tr>
				<td>
					电影年代:
						<input type="text" name="legend" value="${query.legend}">
					电影时长:
						<input type="text" name="lowerLength" value="${query.lowerLength}">-
						<input type="text" name="upperLength" value="${query.upperLength}">
				</td>
			</tr>
			<tr>
				<td colspan="100">
					<input type="submit" value="查询电影" class="btn btn-info">
					<input type="button" value="重置查询" onclick="clearQuery()">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function clearQuery(){
		$(":text").val("");
	}
</script>
</html>