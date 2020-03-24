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
<body>
	<table class="table">
		<tr>
			<td colspan="100">
				<input type="button" class="btn btn-info" value="查询影片"  onclick="query()">
				<input type="button" class="btn btn-success" value="添加影片">
				<input type="button" class="btn btn-danger" value="删除影片" onclick="del()">
				<form id="queryForm" action="/movie/list" method="post">
					<input type="hidden" name="name" value="${query.name}">
					<input type="hidden" name="director" value="${query.director}">
					<input type="hidden" name="legend" value="${query.legend}">
					<input type="hidden" name="startTime" value="${query.startTime}">
					<input type="hidden" name="endTime" value="${query.endTime}">
					<input type="hidden" name="lowerPrice" value="${query.lowerPrice}">
					<input type="hidden" name="upperPrice" value="${query.upperPrice}">
					<input type="hidden" name="lowerLength" value="${query.lowerLength}">
					<input type="hidden" name="upperLength" value="${query.upperLength}">
					<input type="hidden" name="pageNum" value="${pageNum}">
					<input type="hidden" name="pageSize" value="${pageSize}">
					<input type="hidden" name="condition" value="${condition}">
					<input type="hidden" name="order" value="${order}">
				</form>
			</td>
		</tr>
		<tr>
			<th>
				<input type="checkbox" id="selectAll">
			</th>
			<th>影片名</th>
			<th>导演</th>
			<th>票价</th>
			<th>
				上映时间
				<input type="button" value="^" onclick="orderMovie('showDate')">
			</th>
			<th>
				时长
				<input type="button" value="^" onclick="orderMovie('timeLength')">
			</th>
			<th>类型</th>
			<th>
				年代
				<input type="button" value="^" onclick="orderMovie('legend')">
			</th>
			<th>区域</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.movieList}" var="movie">
			<tr>
				<td>
					<input type="checkbox" value="${movie.id}" class="movie">
				</td>
				<td>${movie.name}</td>
				<td>${movie.director}</td>
				<td>${movie.price}</td>
				<td>
					<fmt:formatDate value="${movie.showDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${movie.timeLength}</td>
				<td>${movie.typeName}</td>
				<td>${movie.legend}</td>
				<td>${movie.area}</td>
				<td>
					<c:if test="${movie.state==1}">正在热映</c:if>
					<c:if test="${movie.state==0}">已经下架</c:if>
				</td>
				<td>
					<input type="button" value="详情">
					<input type="button" value="编辑">
					<c:if test="${movie.state==1}">
						<input type="button" value="下架"  onclick="convertState(${movie.id})">
					</c:if>
					<c:if test="${movie.state==0}">
						<input type="button" value="上架" onclick="convertState(${movie.id})">
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="100">
				第${page.pageNum}/${page.pages}页，共${page.total}条
				<input type="button" value="首页" class="btn btn-info" onclick="page(1)">
				<input type="button" value="上一页" class="btn btn-info" onclick="page(${page.prePage})">
				<input type="button" value="下一页" class="btn btn-info" onclick="page(${page.nextPage})">
				<input type="button" value="尾页" class="btn btn-info" onclick="page(${page.pages})">
				前往
				<input type="text" id="pageNum" value="${pageNum}">
				页
				<select id="pageSize">
					<option value="3" 
						<c:if test="${pageSize==3}">selected="selected"</c:if>
					>3条/页</option>
					<option value="5"
						<c:if test="${pageSize==5}">selected="selected"</c:if>
					>5条/页</option>
					<option value="8"
						<c:if test="${pageSize==8}">selected="selected"</c:if>
					>8条/页</option>
				</select>
				<input type="button" value="前往"  class="btn btn-info" onclick="page(0)">
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function page(pageNum){
		if(pageNum){
			$(":hidden[name='pageNum']").val(pageNum);
		}else{
			var num = $("#pageNum").val();
			if(!isNaN(num)){
				$(":hidden[name='pageNum']").val(num);
			}else{
				$(":hidden[name='pageNum']").val(1);
			}
		}
		$(":hidden[name='pageSize']").val($("#pageSize").val());
		$("#queryForm").submit();
	}
	function convertState(id){
		$.ajax({
			url:"/movie/convert",
			data:{"id":id},
			success:function(success){
				if(success){
					location.reload();
				}else{
					alert("设置失败!");
				}
			}
		})
	}
	$("#selectAll").click(function(){
		$(":checkbox.movie").prop("checked",this.checked);
	})
	function del(){
		if($(":checkbox.movie:checked").length==0){
			alert("请选择要删除的电影!");
			return;
		}
		if(confirm("确定要删除选中的电影吗？")){
			var ids = $(":checkbox.movie:checked").map(function(){
				return $(this).val();
			}).get().join();
			$.ajax({
				url:"/movie/delete",
				data:{"ids":ids},
				success:function(success){
					if(success){
						location.reload();
					}else{
						alert("删除失败!");
					}
				}
			})
		}
	}
	function query(){
		var data = $("#queryForm").serialize();
		location.href='/movie/query?'+data;
	}
	function orderMovie(condition){
		$(":hidden[name='condition']").val(condition);
		if($(":hidden[name='order']").val()=='asc'){
			$(":hidden[name='order']").val("desc");
		}else if($(":hidden[name='order']").val()=='desc'){
			$(":hidden[name='order']").val("asc");
		} 
		page(1);
	}
</script>
</html>