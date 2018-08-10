<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parcours</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body style="font-family: courier">
	<div id="main_div">
		<div id="header_div">
			<h1>Welcome ${MySessionVariable}!</h1>
		</div>

		<div id="content_div" align="center">
		
				<table>
					<thead>
						<tr>
							<th colspan="3">Competences
								<hr>
							</th>

						</tr>
					</thead>
					<tbody>
					
					<c:set  var="competNumber" value="0" />
					<c:forEach items="${listeDesCompets}" var="varCompetence">
							<c:if test="${competNumber == 0}" >
							<tr>
							</c:if>
							
								<td>
									<form action="quizz" method="get">
									<input type="submit" style="width:150px" name="competence" value="${varCompetence.getIdCompetence()}"/>
									</form>
									<c:set  var="competNumber" value="${competNumber+1}" />
								</td>
								
							<c:if test="${competNumber == 3}">
							</tr>
							<c:set  var="competNumber" value="0" />
							</c:if>
					</c:forEach>
					
					<c:if test="${competNumber!=0 }">
							</tr>
							<c:set  var="competNumber" value="0" />
					</c:if>
						
						<tr>
							<td colspan="3"><hr></td>
						</tr>

					</tbody>
				</table>
			
		</div>
		
		
<%-- 		<div style="display: none">${MySessionVariableParcours}</div> --%>
		<c:set var="footerText" value="session Parcours" />
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
