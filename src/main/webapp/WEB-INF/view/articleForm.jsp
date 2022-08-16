<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8"); // 자바 소스 코드사용
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script>
	function backToList(frm) {
		frm.action="${contextPath}/board/listArticles";
		frm.submit();
	}
</script>
<style>
.class-caption {
	width: 100px;
}

.class-content {
	width: 500px;
}

@font-face {
	font-family: 'LeeSeoyun';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2202-2@1.0/LeeSeoyun.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'LeeSeoyun';
}

input:focus { background-color: #c0d9fc; }
textarea:focus { background-color: #c0d9fc; }


</style>
</head>
<body>
	<h1 style="text-align: center; color:#c0d9fc;">새 글 쓰기</h1>
	<form name="articleForm" method="post" action="${contextPath}/board/addArticle">
		<table boarder="0" align="center">
			<tbody>
				<tr>
					<td align="right" class="class-caption">글제목:</td>
					<td colspan="2">
						<input type="text" maxlength="100" name="title" class="class-content" />
					</td>
				</tr>
				<tr>
					<td align="right" valign="top" class="class-caption"><br>글내용:</td>
					<td colspan="2">
						<textarea name="content" rows="10" maxlength="2000" class="class-content" ></textarea>
					</td>
				</tr>
				<tr>
					<td align="right"></td>
					<td colspan="2">
						<input type="submit" value="글쓰기" />
						<input type="button" value="목록보기" onclick = "backToList(articleForm)" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>