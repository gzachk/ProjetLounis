<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${errorCode} | Lounis Dynamic</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body style="font-family: courier">
	<div id="main_div">
		<div id="header_div">
			<h1>&#9760; error.${errorCode} &#9760;</h1>
		</div>

		<div id="content_div" align="center" style="background-color: Lightpink " >
			<h1>&#9760; Sad Panda Is Sad &#9760;</h1>

			<form action="accueil">
				<input type="submit" value="Make Panda Happy" >
			</form>
		</div>

		<c:set var="footerText" value="&#9760;&#9760;&#9760;" />
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>