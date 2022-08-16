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
<title>글 목록</title>
<style>
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

.cls1 {
	text-decoration: none;
}

.cls2 {
	text-align: center;
	font-size: 30px;
	display: block;
}

a:hover {
	color: #153acf;
}

button:hover{
	background-color: #c0d9fc;
}

/* width */
::-webkit-scrollbar {
	width: 25px;
}

/* Track */
::-webkit-scrollbar-track {
	box-shadow: inset 0 0 3px #c0d9fc;
	border-radius: 5px;
}

/* Handle */
::-webkit-scrollbar-thumb {
	background: #c0d9fc;;
	border-radius: 5px;
}
</style>
</head>
<body>
	<h1 style="text-align: center; color: #c0d9fc;">글 목록</h1>
	<br><br>
	<table align="center" border="1" width="80%">
		<thead>
			<tr height="10" align="center" bgcolor="#c0d9fc">
				<th>글 번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${articleList == null}">
				<tbody>
					<tr height="10">
						<td colspan="4">
							<p align="center">
								<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
							</p>
						</td>
					</tr>
				</tbody>
			</c:when>
			<c:otherwise>
				<!-- core 라이브러리 -->
				<tbody>
					<c:forEach var="article" items="${articleList}"
						varStatus="articleNum">
						<tr align="center">
							<td width="5%">${articleNum.count}</td>
							<td width="10%">${article.writeId}</td>
							<td align="left" width="35%"><span
								style="padding-right: 30px"></span> <a class="cls1"
								href="${contextPath}/board/viewArticle?articleno=${article.articleNo}">
									${article.title} </a></td>
							<td width="10%">${article.writeDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<a class="cls1" href="${contextPath}/board/newArticle">
		<center>
			<button>
				<span class="clas2">글쓰기</span>
			</button>
		</center>
	</a>
</body>
</html>